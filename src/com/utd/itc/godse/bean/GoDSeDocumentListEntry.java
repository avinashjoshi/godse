/*
 * Collaborators:
 * Avinash Joshi <axj107420@utdallas.edu>
 * Sandeep Shenoy <sxs115220@utdallas.edu>
 * Shishir Krishnaprasad <sxk116430@utdallas.edu>
 * 
 * (c) 2012 GODSe
 */
package com.utd.itc.godse.bean;

import com.google.gdata.data.acl.AclFeed;
import com.google.gdata.data.docs.DocumentListEntry;

public class GoDSeDocumentListEntry extends com.google.gdata.data.docs.DocumentListEntry {

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
