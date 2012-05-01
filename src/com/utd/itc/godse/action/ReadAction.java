/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utd.itc.godse.action;

import com.google.gdata.data.MediaContent;
import com.google.gdata.data.docs.DocumentListEntry;
import com.utd.itc.godse.bean.GoDSeDataStore;
import com.utd.itc.godse.bean.GoDSeDocumentListEntry;
import com.utd.itc.godse.crypto.Crypto;
import com.utd.itc.godse.helper.GoDSeHelper;
import com.utd.itc.godse.resource.Messages;
import com.utd.itc.godse.view.HomeForm;
import com.utd.itc.godse.view.ReadForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author GoDSe
 */
public class ReadAction implements ActionListener, Runnable {

    public HomeForm homeForm;
    private final String format = "txt";
    private String currKey = "";

    public ReadAction(HomeForm mForm) {
        this.homeForm = mForm;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (!homeForm.validateChoice()) {
            homeForm.showErrorMessage(Messages.NOT_SELECTED);
        } else {
            currKey = JOptionPane.showInputDialog("Enter your key: ", "");
            /*if ("".equalsIgnoreCase(currKey)) {
                homeForm.showErrorMessage(Messages.KEY_NOT_PROVIDED);
            }*/
            //if (!"".equalsIgnoreCase(currKey) && currKey != null) {
            if (currKey != null) {
                new Thread(this).start();
            }
            
        }
    }

    @Override
    public void run() {
        int sIndex = homeForm.getDocList().getSelectedIndex();
        GoDSeDocumentListEntry entry = GoDSeDataStore.documentList.get(sIndex);
        String filePath = System.getProperty("user.home") + File.separator + entry.getEntry().getTitle().getPlainText() + "." + format;
        GoDSeHelper.downloadDocument(entry.getEntry(), filePath, format);
        String documentData = GoDSeHelper.getDocumentData(filePath);
        //Remove a white-space @ the beginning of the data!!
        ArrayList<String> decryptedContent = Crypto.doEncryptDecrypt(documentData.substring(1), currKey, 'D');
        if ("FAILED".equalsIgnoreCase(decryptedContent.get(0))) {
            homeForm.showErrorMessage(decryptedContent.get(1));
            ReadForm readForm = new ReadForm(filePath, currKey, sIndex, documentData,false);
            readForm.setVisible(true);
        }else{
            ReadForm readForm = new ReadForm(filePath, currKey, sIndex, decryptedContent.get(1),true);
            readForm.setVisible(true);
        }
    }
}
