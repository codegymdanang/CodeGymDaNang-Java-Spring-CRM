package com.smartdev.crm.service.helper;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverDateTime {
    public static Timestamp convertDateToTimestamp(String date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFormat = null;
        try {
            dateFormat = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp timestamp1 = new Timestamp(dateFormat.getTime());
        return timestamp1;
    }

}
