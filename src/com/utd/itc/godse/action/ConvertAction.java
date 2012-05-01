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
import com.utd.itc.godse.bean.GoDSeDataStore;
import com.utd.itc.godse.crypto.Crypto;
import com.utd.itc.godse.helper.GoDSeHelper;
import com.utd.itc.godse.helper.ReadWriteHelper;
import com.utd.itc.godse.view.ReadForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConvertAction implements ActionListener, Runnable {

    private int selectedIndex;
    private String currKey;
    private String filePath;
    private ReadForm readForm;

    public ConvertAction(ReadForm rForm, int sIndex, String key, String fPath) {
        readForm = rForm;
        selectedIndex = sIndex;
        currKey = key;
        filePath = fPath;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        currKey = JOptionPane.showInputDialog("Enter your key: ", "password_goes_here");

        if (!"".equalsIgnoreCase(currKey)) {
            new Thread(this).start();
        }
    }

    @Override
    public void run() {
        try {
            //System.out.println("uri: " + ((MediaContent)gEntry.getContent()).getUri());
            //Write new Contents to a file
            /*
             * String fileName = gEntry.getTitle().getPlainText(); String
             * filePath = System.getProperty("user.home") + File.separator +
             * fileName + "." + format; String content =
             * updateForm.getDocData().getText().trim();
             */
            DocumentListEntry entry = GoDSeDataStore.documentList.get(selectedIndex).getEntry();
            String fileName = entry.getTitle().getPlainText();
            String content = readForm.getDocData().getText();

            ArrayList<String> encryptedContents = Crypto.doEncryptDecrypt(content, currKey, 'E');
            // System.out.println("Name,Path, Content : " +fileName + " -- " +  filePath + " -- " + content);
            ReadWriteHelper.performWrite(filePath, new ByteArrayInputStream(encryptedContents.get(1).getBytes()));

            //Call updateDocument
            GoDSeHelper.updateDocument(entry, fileName, filePath);
            //Delete file

            File f = new File(filePath);
            f.delete();

            //Close window
            this.readForm.dispose();
        } catch (Exception ex) {
            //readForm.showErrorMessage(Messages.EXCEPTION_OCCURED);
        }
    }
}
