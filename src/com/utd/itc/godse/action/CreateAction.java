/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utd.itc.godse.action;

import com.utd.itc.godse.crypto.Crypto;
import com.utd.itc.godse.helper.GoDSeHelper;
import com.utd.itc.godse.helper.ReadWriteHelper;
import com.utd.itc.godse.view.CreateForm;
import com.utd.itc.godse.view.HomeForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GoDSe
 */
public class CreateAction implements ActionListener, Runnable{

    public CreateForm createForm;
    private final String format = "txt";
    private final String type = "document";
    
    public CreateAction(CreateForm cForm)
    {
        this.createForm = cForm;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        new Thread(this).start();
       
    }

    @Override
    public void run() {
        try {
            String fileName = this.createForm.getFileName().getText();
            String filePath = System.getProperty("user.home") + File.separator + fileName + "." + format;
            String content = this.createForm.getDocData().getText();
            String key = this.createForm.getKey().getText();
            System.out.println("E Key Used: " + key);
            String encryptedContents = Crypto.doEncryptDecrypt(content, key, 'E');
            
            ReadWriteHelper.performWrite(filePath, new ByteArrayInputStream(encryptedContents.getBytes()));
            
            GoDSeHelper.createNewDocument(fileName, type, filePath, encryptedContents);
            System.out.println("Encrypted Contents: "+ encryptedContents);
            File f = new File(filePath);
            f.delete();
            
            this.createForm.dispose();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CreateAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CreateAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
