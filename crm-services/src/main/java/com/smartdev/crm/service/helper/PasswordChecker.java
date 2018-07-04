package com.smartdev.crm.service.helper;

public class PasswordChecker {


    public static boolean isBlank(String password,String confirmPassword){
        return (isNull(password,confirmPassword)||isEmpty(password,confirmPassword));
    }

    public static boolean isNull(String password,String confirmPassword){
        return (password==null && confirmPassword==null);
    }

    public static boolean isEmpty(String password,String confirmPassword){
        password = password.trim();
        confirmPassword = confirmPassword.trim();
        return (password.equalsIgnoreCase("") && confirmPassword.equalsIgnoreCase(""));
    }
    public static boolean isMatch(String password,String confirmPassword){
        password = password.trim();
        confirmPassword = confirmPassword.trim();
        return (password.equals(confirmPassword));
    }

    public static boolean isGreaterThan6Chars(String password,String confirmPassword){
        return password.length()>=6||confirmPassword.length()>=6;
    }


}
