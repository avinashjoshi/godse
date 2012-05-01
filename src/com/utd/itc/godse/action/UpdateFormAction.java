/*
 * Collaborators:
 * Avinash Joshi <axj107420@utdallas.edu>
 * Sandeep Shenoy <sxs115220@utdallas.edu>
 * Shishir Krishnaprasad <sxk116430@utdallas.edu>
 * 
 * (c) 2012 GODSe
 */
package com.utd.itc.godse.action;

import com.utd.itc.godse.bean.GoDSeDataStore;
import com.utd.itc.godse.bean.GoDSeDocumentListEntry;
import com.utd.itc.godse.crypto.Crypto;
import com.utd.itc.godse.helper.GoDSeHelper;
import com.utd.itc.godse.resource.Messages;
import com.utd.itc.godse.view.HomeForm;
import com.utd.itc.godse.view.ReadForm;
import com.utd.itc.godse.view.UpdateForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UpdateFormAction implements ActionListener, Runnable {

    public HomeForm homeForm;
    public ReadForm readForm;
    private final String format = "txt";
    private String currKey;
    private int selectedIndex;

    public UpdateFormAction(HomeForm mForm) {
        this.homeForm = mForm;
        //selectedIndex = homeForm.getDocList().getSelectedIndex();
        //System.out.println("Selected Index: "+ selectedIndex);
    }

    public UpdateFormAction(ReadForm rForm, String cKey, int sIndex) {
        readForm = rForm;
        currKey = cKey;
        selectedIndex = sIndex;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (homeForm != null) {
            if (!homeForm.validateChoice()) {
                homeForm.showErrorMessage(Messages.NOT_SELECTED);
            } else {
                if (readForm == null) {
                    selectedIndex = homeForm.getDocList().getSelectedIndex();
                    currKey = JOptionPane.showInputDialog("Enter your key: ", "");
                }

                if (currKey != null) {
                    new Thread(this).start();
                }
            }
        } else if (readForm != null) {
            new Thread(this).start();
        }

    }

    @Override
    public void run() {

        GoDSeDocumentListEntry entry = GoDSeDataStore.documentList.get(selectedIndex);
        String filePath = System.getProperty("user.home") + File.separator + entry.getEntry().getTitle().getPlainText() + "." + format;
        GoDSeHelper.downloadDocument(entry.getEntry(), filePath, format);
        String documentData = GoDSeHelper.getDocumentData(filePath);
        ArrayList<String> decryptedContent = Crypto.doEncryptDecrypt(documentData.substring(1), currKey, 'D');
        if ("FAILED".equalsIgnoreCase(decryptedContent.get(0))) {
            homeForm.showErrorMessage(decryptedContent.get(1));
            UpdateForm updateForm = new UpdateForm(filePath, entry.getEntry(), entry.getAclFeed(), currKey, documentData);
            updateForm.setVisible(true);
        } else {
            UpdateForm updateForm = new UpdateForm(filePath, entry.getEntry(), entry.getAclFeed(), currKey, decryptedContent.get(1));
            updateForm.setVisible(true);
        }

        if (readForm != null) {
            readForm.dispose();
        }
    }
}
