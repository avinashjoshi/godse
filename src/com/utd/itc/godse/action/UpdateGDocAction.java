/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utd.itc.godse.action;

import com.google.gdata.data.MediaContent;
import com.google.gdata.data.docs.DocumentListEntry;
import com.utd.itc.godse.helper.GoDSeHelper;
import com.utd.itc.godse.helper.ReadWriteHelper;
import com.utd.itc.godse.view.UpdateForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;

/**
 *
 * @author sandeepshenoy
 */
public class UpdateGDocAction implements ActionListener, Runnable{

    private UpdateForm updateForm;
    private DocumentListEntry gEntry;
    private final String format = "txt";
    
    public UpdateGDocAction(UpdateForm uForm, DocumentListEntry gEnt)
    {
        updateForm = uForm;
        gEntry = gEnt;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        new Thread(this).start();
    }

    @Override
    public void run() {
        
        //System.out.println("uri: " + ((MediaContent)gEntry.getContent()).getUri());
        //Write new Contents to a file
        String fileName = gEntry.getTitle().getPlainText();
        String filePath = System.getProperty("user.home") + File.separator + fileName + "." + format;
        String content = updateForm.getDocData().getText().trim();
       // System.out.println("Name,Path, Content : " +fileName + " -- " +  filePath + " -- " + content);
        ReadWriteHelper.performWrite(filePath, new ByteArrayInputStream(content.getBytes()));
        
        //Call updateDocument
        GoDSeHelper.updateDocument(gEntry, fileName, filePath);
        //Delete file
        
        File f = new File(filePath);
        f.delete();
        
        //Close window
        this.updateForm.dispose();
        
    }
    
}
