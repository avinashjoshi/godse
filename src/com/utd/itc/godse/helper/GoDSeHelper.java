/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utd.itc.godse.helper;

import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.data.docs.DocumentListFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import com.utd.itc.godse.bean.GoDSeDataStore;
import com.utd.itc.godse.bean.GoDSeDocumentListEntry;
import com.utd.itc.godse.dao.GoDSeDAO;
import com.utd.itc.godse.dao.GoDSeDAOImpl;
import com.utd.itc.godse.resource.Messages;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author GoDSe
 */
public class GoDSeHelper {

    private static GoDSeDAO godseDao = new GoDSeDAOImpl();

    public static String login(String email, String password) {
        String result = "success";

        try {
            godseDao.login(email, password);
        } catch (AuthenticationException authEx) {
            result = Messages.LOGIN_CREDENTIALS_FAILED;
        } catch (Exception ex) {
            result = Messages.EXCEPTION_OCCURED;
        }
        return result;
    }

    public static void prepareItems() {
        
        try {
            GoDSeDataStore.documentList.clear();
            DocumentListFeed allFeeds = godseDao.getAllFeeds();
            for (int i = 0; i < allFeeds.getEntries().size(); i++) {
                GoDSeDocumentListEntry entry = new GoDSeDocumentListEntry();
                entry.setEntry(allFeeds.getEntries().get(i));
                entry.setAclFeeds(godseDao.getAclFeed(entry.getEntry()));
                GoDSeDataStore.documentList.add(entry);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void downloadDocument(DocumentListEntry entry, String filePath,
            String format) {
        try {
            godseDao.downloadDocument(entry, filePath, format);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDocumentData(String filePath) {
        String docData = "";
        try {
            docData = godseDao.getDocumentContent(filePath);
        } catch (Exception ex) {
            ex.printStackTrace();
            return docData;
        }
        return docData;
    }

    public static void createNewDocument(String title, String type, String filePath, String content) {

        try {
            godseDao.createNew(title, type, filePath, content);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void updateDocument(DocumentListEntry entry, String title, String filePath) {

        try {
            godseDao.updateDocument(entry, title, filePath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteDocument(DocumentListEntry entry) {

        try {
            godseDao.deleteDocument(entry);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
