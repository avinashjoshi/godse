/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utd.itc.godse.action;

import com.google.gdata.data.docs.DocumentListEntry;
import com.utd.itc.godse.crypto.Crypto;
import com.utd.itc.godse.helper.GoDSeHelper;
import com.utd.itc.godse.helper.ReadWriteHelper;
import com.utd.itc.godse.view.UpdateForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sandeepshenoy
 */
public class UpdateGDocAction implements ActionListener, Runnable{

    private UpdateForm updateForm;
    private DocumentListEntry gEntry;
    private final String format = "txt";
    private String currKey;
    
    public UpdateGDocAction(UpdateForm uForm, DocumentListEntry gEnt,String cKey)
    {
        updateForm = uForm;
        gEntry = gEnt;
        currKey = cKey;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            //System.out.println("uri: " + ((MediaContent)gEntry.getContent()).getUri());
            //Write new Contents to a file
            String fileName = gEntry.getTitle().getPlainText();
            String filePath = System.getProperty("user.home") + File.separator + fileName + "." + format;
            String content = updateForm.getDocData().getText().trim();
            
            String encryptedContents = Crypto.doEncryptDecrypt(content, currKey, 'E');
           // System.out.println("Name,Path, Content : " +fileName + " -- " +  filePath + " -- " + content);
            ReadWriteHelper.performWrite(filePath, new ByteArrayInputStream(encryptedContents.getBytes()));
            
            //Call updateDocument
            GoDSeHelper.updateDocument(gEntry, fileName, filePath);
            //Delete file
            
            File f = new File(filePath);
            f.delete();
            
            //Close window
            this.updateForm.dispose();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UpdateGDocAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UpdateGDocAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
