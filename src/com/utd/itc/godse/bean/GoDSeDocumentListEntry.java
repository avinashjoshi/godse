/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utd.itc.godse.bean;

import com.google.gdata.data.acl.AclFeed;
import com.google.gdata.data.docs.DocumentListEntry;

/**
 *
 * @author GoDSe
 */
public class GoDSeDocumentListEntry extends com.google.gdata.data.docs.DocumentListEntry{
    
    private com.google.gdata.data.docs.DocumentListEntry entry;
    private AclFeed aclFeeds;

    public AclFeed getAclFeeds() {
        return aclFeeds;
    }

    public void setAclFeeds(AclFeed aclFeeds) {
        this.aclFeeds = aclFeeds;
    }

    public DocumentListEntry getEntry() {
        return entry;
    }

    public void setEntry(DocumentListEntry entry) {
        this.entry = entry;
    }
    
    
}
