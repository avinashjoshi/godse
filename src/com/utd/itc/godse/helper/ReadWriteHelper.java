/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utd.itc.godse.helper;

import java.io.*;

/**
 *
 * @author GoDSe
 */
public class ReadWriteHelper {

    public static String performRead(String filePath) {
        byte[] dData = new byte[1024];
        byte[] bTemp = null;
        int bytesRead = 0,k = 0;
        File docFile = null;
        FileInputStream fis = null;
        StringBuffer docData = new StringBuffer();
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        try {

            docFile = new File(filePath);
            fis = new FileInputStream(docFile);
            
            while ((bytesRead = fis.read(dData)) != -1) {
                //docData.append(Byte.toString((byte) bytesRead));
                k+= bytesRead;
            }
            //System.out.println("k: " + k);
            fis.close();
            
            InputStream is = new ByteArrayInputStream(dData);
            bTemp = new byte[k+1];

            is.read(bTemp, 0, k);
            docFile.delete();
        } catch (Exception exep) {
            return docData.toString();
        }
        
        
        
        //return docData.toString();
        return new String(bTemp);
    }

    public static boolean performWrite(String filePath, InputStream in) {

        //System.out.println("File Name : " + filePath);

        OutputStream fout = null;
        try {

            fout = new FileOutputStream(new File(filePath));
            int c;
            while ((c = in.read()) != -1) {
                fout.write(c);
            }
            fout.flush();
            fout.close();

        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return true;
    }
}
