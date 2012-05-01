/*
 * Collaborators:
 * Avinash Joshi <axj107420@utdallas.edu>
 * Sandeep Shenoy <sxs115220@utdallas.edu>
 * Shishir Krishnaprasad <sxk116430@utdallas.edu>
 * 
 * (c) 2012 GODSe
 */
package com.utd.itc.godse.dao;

import com.google.gdata.data.acl.AclFeed;
import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.data.docs.DocumentListFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public interface GoDSeDAO {

    public void login(String email, String password) throws AuthenticationException;

    public DocumentListFeed getAllDocuments();

    public DocumentListEntry createNew(String title, String type, String filePath, String content) throws MalformedURLException, IOException, ServiceException;

    public DocumentListEntry updateDocument(DocumentListEntry entry, String title, String filePath) throws MalformedURLException, IOException, ServiceException, URISyntaxException;

    public void deleteDocument(DocumentListEntry entry) throws MalformedURLException, IOException, ServiceException;

    public void download(String url, String filePath) throws MalformedURLException, IOException, ServiceException;

    public void downloadDocument(DocumentListEntry entry, String filePath, String format) throws MalformedURLException, IOException, ServiceException;

    public AclFeed getAclFeed(DocumentListEntry entry) throws MalformedURLException, IOException, ServiceException;

    public DocumentListFeed getAllFeeds() throws MalformedURLException, IOException, ServiceException;

    public String getDocumentContent(String file);
}
