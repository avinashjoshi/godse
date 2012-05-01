/*
 * Collaborators:
 * Avinash Joshi <axj107420@utdallas.edu>
 * Sandeep Shenoy <sxs115220@utdallas.edu>
 * Shishir Krishnaprasad <sxk116430@utdallas.edu>
 * 
 * (c) 2012 GODSe
 */
package com.utd.itc.godse.dao;

import com.google.gdata.client.GoogleAuthTokenFactory;
import com.google.gdata.client.GoogleService;
import com.google.gdata.client.docs.DocsService;
import com.google.gdata.data.MediaContent;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.acl.AclFeed;
import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.data.docs.DocumentListFeed;
import com.google.gdata.data.media.MediaSource;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import com.utd.itc.godse.helper.ReadWriteHelper;
import com.utd.itc.godse.resource.URLManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class GoDSeDAOImpl implements GoDSeDAO {

    private DocsService service;
    private GoogleService documentsService;
    private static final String appName = "CS6377_EncGDocs";
    private GoogleAuthTokenFactory.UserToken token;

    public GoDSeDAOImpl() {
        service = new DocsService(appName);
        documentsService = new GoogleService("writely", appName);
    }

    @Override
    public void login(String email, String password) throws AuthenticationException {
        service.setUserCredentials(email, password);
        documentsService.setUserCredentials(email, password);
        token = (GoogleAuthTokenFactory.UserToken) service.getAuthTokenFactory().getAuthToken();
    }

    @Override
    public DocumentListFeed getAllDocuments() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DocumentListEntry createNew(String title, String type, String filePath, String content) throws MalformedURLException, IOException, ServiceException {

        //System.out.println("Title, Type, FilePath : " + title + " -- " + type +  " -- " + filePath);
        File file = new File(filePath);
        String mimeType = DocumentListEntry.MediaType.fromFileName(file.getName()).getMimeType();
        DocumentListEntry entry = new DocumentListEntry();
        entry.setFile(file, mimeType);
        entry.setTitle(new PlainTextConstruct(title));
        service.setUserToken(token.getValue());
        return service.insert(new URL(URLManager.Exact_Title_Search), entry);


    }

    @Override
    public DocumentListEntry updateDocument(DocumentListEntry entry, String title, String filePath) throws MalformedURLException, IOException, ServiceException, URISyntaxException {
        File file = new File(filePath);
        String mimeType = DocumentListEntry.MediaType.fromFileName(file.getName()).getMimeType();
        deleteDocument(entry);
        DocumentListEntry nEntry = new DocumentListEntry();
        nEntry.setFile(file, mimeType);
        nEntry.setTitle(new PlainTextConstruct(title));
        service.setUserToken(token.getValue());

        return service.insert(new URL(URLManager.Exact_Title_Search), nEntry);

    }

    @Override
    public void deleteDocument(DocumentListEntry entry) throws MalformedURLException, IOException, ServiceException {
        service.delete(new URL(entry.getEditLink().getHref() + "?delete=true"), entry.getEtag());
    }

    @Override
    public void download(String url, String filePath) throws MalformedURLException, IOException, ServiceException {
        MediaContent mc = new MediaContent();
        mc.setUri(url);
        MediaSource source = service.getMedia(mc);
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            is = source.getInputStream();
            ReadWriteHelper.performWrite(filePath, is);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void downloadDocument(DocumentListEntry entry, String filePath, String format) throws MalformedURLException, IOException, ServiceException {
        String url = ((MediaContent) entry.getContent()).getUri() + "&exportFormat=" + format;
        // System.out.println("Downloading Document!! : " + url + " -- " + filePath);
        download(url, filePath);
    }

    @Override
    public AclFeed getAclFeed(DocumentListEntry entry) throws MalformedURLException, IOException, ServiceException {
        return service.getFeed(new URL(entry.getAclFeedLink().getHref()), AclFeed.class);
    }

    @Override
    public DocumentListFeed getAllFeeds() throws MalformedURLException, IOException, ServiceException {
        service.setUserToken(token.getValue());
        return service.getFeed(new URL(URLManager.Get_All_Documents), DocumentListFeed.class);
    }

    @Override
    public String getDocumentContent(String file) {

        String docData = ReadWriteHelper.performRead(file);
        return docData;
    }
}
