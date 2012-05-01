/*
 * Collaborators:
 * Avinash Joshi <axj107420@utdallas.edu>
 * Sandeep Shenoy <sxs115220@utdallas.edu>
 * Shishir Krishnaprasad <sxk116430@utdallas.edu>
 * 
 * (c) 2012 GODSe
 */
package com.utd.itc.godse.action;

import com.google.gdata.data.docs.DocumentListEntry;
import com.utd.itc.godse.crypto.Crypto;
import com.utd.itc.godse.helper.GoDSeHelper;
import com.utd.itc.godse.helper.ReadWriteHelper;
import com.utd.itc.godse.resource.Messages;
import com.utd.itc.godse.view.UpdateForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;

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
        if(updateForm.validateForm() == -1)
        {
            updateForm.showErrorMessage(Messages.CHANGED_KEY_NOT_EQUAL);
        }
        else if(updateForm.validateForm() == -2)
        {
            updateForm.showErrorMessage(Messages.CHANGED_KEY_NOT_PROVIDED);
        }
        else if(updateForm.validateForm() == -3)
        {
            updateForm.showErrorMessage(Messages.EMPTY_TEXT_PROVIDED);
        }
        else{
            updateForm.hideErrorMessage();
            if(updateForm.getChangeKey().isSelected())
            {
                currKey = updateForm.getKey().getText();
            }
            new Thread(this).start();
        }
    }

    @Override
    public void run() {
        try {
            //System.out.println("uri: " + ((MediaContent)gEntry.getContent()).getUri());
            //Write new Contents to a file
            String fileName = gEntry.getTitle().getPlainText();
            String filePath = System.getProperty("user.home") + File.separator + fileName + "." + format;
            String content = updateForm.getDocData().getText().trim();
            
            ArrayList<String> encryptedContents = Crypto.doEncryptDecrypt(content, currKey, 'E');
           // System.out.println("Name,Path, Content : " +fileName + " -- " +  filePath + " -- " + content);
            ReadWriteHelper.performWrite(filePath, new ByteArrayInputStream(encryptedContents.get(1).getBytes()));
            
            //Call updateDocument
            GoDSeHelper.updateDocument(gEntry, fileName, filePath);
            //Delete file
            
            File f = new File(filePath);
            f.delete();
            
            //Close window
            this.updateForm.dispose();
        }  catch (Exception ex) {
            updateForm.showErrorMessage(Messages.EXCEPTION_OCCURED);
        }
        
    }
    
}
