package com.smartdev.controller.manager;

import com.smartdev.crm.service.CampaignService;
import com.smartdev.crm.service.CustomerCompaignService;
import com.smartdev.crm.service.helper.ConverDateTime;
import com.smartdev.user.entity.Campaign;
import com.smartdev.user.entity.CustomerCampaign;
import com.smartdev.user.model.CompainError;
import com.smartdev.user.model.CompainVO;
import com.smartdev.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manager_crm")
public class CampainController {

    @Autowired
    CustomerCompaignService customerCompaignService;

    @Autowired
    CampaignService campaignService;

    @RequestMapping(value = "/campain", method = RequestMethod.GET)
    public String getCampain(){
        return "campain";
    }
    @RequestMapping(value = "/campain-manager", method = RequestMethod.GET)
    public String getCampainManager(){
        return "campain-manager";
    }
    @RequestMapping(value = "/campain-customer", method = RequestMethod.GET)
    public String getCampainCustomer(){
        return "campain-customer";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CompainError handleUpload(@RequestBody @Valid CompainVO compainVO, BindingResult result) {
        CompainError error = new CompainError();
        if(result.hasErrors()) {
            for (Object object : result.getAllErrors()) {
                if(object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;
                    switch (fieldError.getField()) {
                        case "compain":
                            error.setNameError(fieldError.getDefaultMessage());
                            break;
                        case "description":
                            error.setDescriptionError(fieldError.getDefaultMessage());
                            break;
                        case "from":
                            error.setFromError(fieldError.getDefaultMessage());
                            break;
                        case "to":
                            error.setToError(fieldError.getDefaultMessage());
                            break;
                        case "file":
                            error.setFileError(fieldError.getDefaultMessage());
                            break;
                    }
                }
            }
            return error;
        }
        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource(".").getFile() + "/Workbook1.xlsx";
        ExcelUtil excelUtil = new ExcelUtil();
        String base64 = compainVO.getFile();
        excelUtil.writeExcel(base64);
        Campaign campaign = new Campaign();
        campaign.setName(compainVO.getCompain());
        campaign.setDescription(compainVO.getDescription());
        Timestamp from = ConverDateTime.convertDateToTimestamp(compainVO.getFrom());
        Timestamp to = ConverDateTime.convertDateToTimestamp(compainVO.getTo());
        campaign.setDateStart(from);
        campaign.setDateEnd(to);
        campaignService.save(campaign);
        customerCompaignService.save(excelUtil.read(path),campaign);
        List<CustomerCampaign> customerCampaigns = excelUtil.read(path);
        error.setCustomerCampaigns(customerCampaigns);
        customerCompaignService.save(customerCampaigns);
        return error;
    }

}
