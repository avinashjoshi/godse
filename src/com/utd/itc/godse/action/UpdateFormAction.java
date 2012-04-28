/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utd.itc.godse.action;

import com.utd.itc.godse.bean.GoDSeDataStore;
import com.utd.itc.godse.bean.GoDSeDocumentListEntry;
import com.utd.itc.godse.helper.GoDSeHelper;
import com.utd.itc.godse.view.HomeForm;
import com.utd.itc.godse.view.UpdateForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author sandeepshenoy
 */
public class UpdateFormAction implements ActionListener, Runnable{

    public HomeForm homeForm;
    private final String format = "txt";
    
    public UpdateFormAction(HomeForm mForm)
    {
        this.homeForm = mForm;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String inputKey = JOptionPane.showInputDialog("Enter your key: ", "key");
        if(!"".equalsIgnoreCase(inputKey))
            new Thread(this).start();
    }

    @Override
    public void run() {
        GoDSeDocumentListEntry entry = GoDSeDataStore.documentList.get(homeForm.getDocList().getSelectedIndex());
        String filePath = System.getProperty("user.home") + File.separator + entry.getEntry().getTitle().getPlainText() + "." + format;
        GoDSeHelper.downloadDocument(entry.getEntry(), filePath, format);
        
        //System.out.println("Entry : " + entry.getEntry());
        //System.out.println("AclFeed : " + entry.getAclFeed());
        UpdateForm updateForm = new UpdateForm(filePath,entry.getEntry(),entry.getAclFeed());
        updateForm.setVisible(true);
    }
    
}
