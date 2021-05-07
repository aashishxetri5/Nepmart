/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.nepmart.utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import javax.servlet.http.Part;

/**
 *
 * @author Aashish Katwal
 */
public class Helper {

    public void imageUpload(Part part, String path) {
        System.out.println("== " + path);
        try {
            FileOutputStream fos = new FileOutputStream(path);
            InputStream is = part.getInputStream();

            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String passwordEncryption(String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return encryptedPassword;
    }

    public String passwordDecryption(String encryptedPassword) {
        return new String(Base64.getMimeDecoder().decode(encryptedPassword));

    }

    public String get10Words(String prodDesc) {
        String[] desc = prodDesc.split(" ");
        if (desc.length > 10) {
            String temp = "";
            for (int i = 0; i <= 9; i++) {
                temp = temp + desc[i] + " ";
            }
            return temp;
        } else {
            return prodDesc;
        }
    }

    public int getDiscountedPrice(int price, int discount) {
        int sellingPrice = (int) (price - (price * discount / 100));
        return sellingPrice;

    }
}
