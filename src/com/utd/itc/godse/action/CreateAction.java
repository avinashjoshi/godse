/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utd.itc.godse.action;

import com.utd.itc.godse.crypto.Crypto;
import com.utd.itc.godse.helper.GoDSeHelper;
import com.utd.itc.godse.helper.ReadWriteHelper;
import com.utd.itc.godse.resource.Messages;
import com.utd.itc.godse.view.CreateForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
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
        
        if(createForm.validateForm() == -1)
        {
            createForm.showErrorMessage(Messages.CHANGED_KEY_NOT_EQUAL);
        }
        else if(createForm.validateForm() == -2)
        {
            createForm.showErrorMessage(Messages.CHANGED_KEY_NOT_PROVIDED);
        }
        else if(createForm.validateForm() == -3)
        {
            createForm.showErrorMessage(Messages.FILENAME_NOT_PROVIDED);
        }
        else if(createForm.validateForm() == -4)
        {
            createForm.showErrorMessage(Messages.EMPTY_TEXT_PROVIDED);
        }
        else{
            createForm.hideErrorMessage();
            new Thread(this).start();
        }
       
    }

    @Override
    public void run() {
        try {
            String fileName = this.createForm.getFileName().getText();
            String filePath = System.getProperty("user.home") + File.separator + fileName + "." + format;
            String content = this.createForm.getDocData().getText();
            String key = this.createForm.getKey().getText();
            ArrayList<String> encryptedContents = Crypto.doEncryptDecrypt(content, key, 'E');
            
            ReadWriteHelper.performWrite(filePath, new ByteArrayInputStream(encryptedContents.get(1).getBytes()));
            
            GoDSeHelper.createNewDocument(fileName, type, filePath, encryptedContents.get(1));
           
            File f = new File(filePath);
            f.delete();
            
            this.createForm.dispose();
        } catch (Exception ex) {
             createForm.showErrorMessage(Messages.EXCEPTION_OCCURED);
        }
    }
    
}
