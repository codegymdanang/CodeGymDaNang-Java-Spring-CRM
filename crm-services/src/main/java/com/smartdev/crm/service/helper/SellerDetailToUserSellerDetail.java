package com.smartdev.crm.service.helper;

import com.smartdev.user.entity.SellerDetail;
import com.smartdev.user.model.UserSellerDetails;
import org.springframework.stereotype.Component;

@Component
public class SellerDetailToUserSellerDetail {
    public static UserSellerDetails convertToUserSellerDetail(SellerDetail sellerDetail){
        UserSellerDetails userSellerDetails = new UserSellerDetails();
        if(sellerDetail!=null){
            userSellerDetails.setUsername(sellerDetail.getUserName());
            userSellerDetails.setName(sellerDetail.getName());
            userSellerDetails.setAge(sellerDetail.getAge());
            userSellerDetails.setPhone(sellerDetail.getPhone());
            userSellerDetails.setMail(sellerDetail.getMail());
            return userSellerDetails;
        }
        return userSellerDetails;
    }
}
