package com.smartdev.util;

import com.smartdev.user.entity.CustomerCampaign;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.Base64Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {
    public List<CustomerCampaign> read(String path) {
        FileInputStream excelFile = null;
        List<CustomerCampaign> customerCampaigns = new ArrayList<>();
        try {
            excelFile = new FileInputStream(path);
            Sheet sheet;
            Iterator<Row> iterator;
            try (Workbook workbook = new XSSFWorkbook(excelFile)) {
                sheet = workbook.getSheetAt(0);
            }
            iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                if (currentRow.getRowNum() == 0) {
                    continue;
                }
                Iterator<Cell> cellIterator = currentRow.iterator();
                CustomerCampaign customerCampaign = new CustomerCampaign();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        switch (currentCell.getColumnIndex()) {
                            case 0:
                                customerCampaign.setName(currentCell.getStringCellValue());
                                break;
                            case 3:
                                customerCampaign.setMail(currentCell.getStringCellValue());
                                break;
                            case 4:
                                customerCampaign.setFacebook(currentCell.getStringCellValue());
                                break;
                            case 5:
                                if(currentCell.getStringCellValue().equalsIgnoreCase("odc"))
                                    customerCampaign.setProductType(1);
                                else if (currentCell.getStringCellValue().equalsIgnoreCase("outsource"))
                                    customerCampaign.setProductType(2);
                                break;
                            case 6:
                                customerCampaign.setCompany(currentCell.getStringCellValue());
                        }
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        switch (currentCell.getColumnIndex()) {
                            case 1:
                                customerCampaign.setAge((int)currentCell.getNumericCellValue());
                                break;
                            case 2:
                                customerCampaign.setPhone((int)currentCell.getNumericCellValue());
                                break;
                        }
                    }
                }
                customerCampaign.setStatusId(1);
                customerCampaigns.add(customerCampaign);
                System.out.println();
            }
        } catch (IOException ex) {

        } finally {
            try {
                excelFile.close();
                for (CustomerCampaign customerCampaign : customerCampaigns) {
                    System.out.println(customerCampaign.getName());
                    System.out.println(customerCampaign.getAge());
                    System.out.println(customerCampaign.getPhone());
                    System.out.println(customerCampaign.getMail());
                    System.out.println(customerCampaign.getFacebook());
                    System.out.println(customerCampaign.getProductType());
                    System.out.println(customerCampaign.getCompany());
                    System.out.println("--------");
                }
            } catch (IOException e) {

            }
        }
        return customerCampaigns;
    }

    public void writeExcel(String base64) {
        base64 = subStringAfterWord(base64, "base64");
        byte[] data = Base64Utils.decodeFromString(base64);
        FileOutputStream fos = null;
        ClassLoader classLoader = getClass().getClassLoader();
        System.out.println(classLoader.getResource(".").getFile() + "/Workbook1.xlsx");
        File file = new File(classLoader.getResource(".").getFile() + "/Workbook1.xlsx");
        try {
            file.createNewFile();
            fos = new FileOutputStream(file);
            fos.write(data);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
            }
        }
    }

    private String subStringAfterWord(String text,String word) {
        return text.substring(text.indexOf(word) + 7, text.length());
    }
}
