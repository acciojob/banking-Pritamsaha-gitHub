package com.driver;

import java.util.Arrays;
import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId=tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        if(isValid(tradeLicenseId)==false){
            if (isAchiveable(tradeLicenseId)==true){

            }else{
                throw new Exception("Valid License can not be generated");
            }
        }
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

    }
    public boolean isValid(String id){
        if(id.length()<=1) return false;
        for(int i=1;i<id.length();i++){
            if(id.charAt(i-1)==id.charAt(i)) return true;
        }
        return false;
    }
    public boolean isAchiveable(String id){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<id.length();i++){
                map.put(id.charAt(i),map.getOrDefault(id.charAt(i),0)+1);
                if(map.get(id.charAt(i))==2) return true;
        }
        return false;
    }
    public String makevalidId(String id){
        char[]ch=id.toCharArray();
        Arrays.sort(ch);
        String validId="";
        for(int i=0;i<ch.length;i++){
            validId +=ch[i];
        }
        return validId;
    }
}
