/*
 * Collaborators:
 * Avinash Joshi <axj107420@utdallas.edu>
 * Sandeep Shenoy <sxs115220@utdallas.edu>
 * Shishir Krishnaprasad <sxk116430@utdallas.edu>
 * 
 * (c) 2012 GODSe
 */
package com.utd.itc.godse.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoDSeDataStore implements Serializable{
    
    public static List<GoDSeDocumentListEntry> documentList = Collections.synchronizedList(new ArrayList<GoDSeDocumentListEntry>());
    
}
