/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utd.itc.godse.action;

import com.google.gdata.data.MediaContent;
import com.google.gdata.data.docs.DocumentListEntry;
import com.utd.itc.godse.bean.GoDSeDataStore;
import com.utd.itc.godse.bean.GoDSeDocumentListEntry;
import com.utd.itc.godse.helper.GoDSeHelper;
import com.utd.itc.godse.view.HomeForm;
import com.utd.itc.godse.view.ReadForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author GoDSe
 */
public class ReadAction implements ActionListener, Runnable{

    public HomeForm homeForm;
    private final String format = "txt";
    private String currKey = "";
    
    public ReadAction(HomeForm mForm)
    {
        this.homeForm = mForm;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        currKey = JOptionPane.showInputDialog("Enter your key: ", "password_goes_here");
        
        if(!"".equalsIgnoreCase(currKey))
            new Thread(this).start();
    }

    @Override
    public void run() {
        int sIndex = homeForm.getDocList().getSelectedIndex();
        GoDSeDocumentListEntry entry = GoDSeDataStore.documentList.get(sIndex);
        String filePath = System.getProperty("user.home") + File.separator + entry.getEntry().getTitle().getPlainText() + "." + format;
        GoDSeHelper.downloadDocument(entry.getEntry(), filePath, format);
        ReadForm readForm = new ReadForm(filePath, currKey,sIndex);
        readForm.setVisible(true);
    }
    
}
