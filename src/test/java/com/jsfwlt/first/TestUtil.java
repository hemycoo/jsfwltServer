package com.jsfwlt.first;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestUtil {
    public static String readJsonFile(String filePath){
        StringBuilder strb = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");
            BufferedReader in  = new BufferedReader(inputStreamReader);

            String str;
            while ((str = in.readLine()) != null) {
                strb.append(str);  //new String(str,"UTF-8")
            }
            in.close();
        }catch (IOException e){
            System.out.println("json转换String出错");
        }
        return strb.toString();
    }
}
