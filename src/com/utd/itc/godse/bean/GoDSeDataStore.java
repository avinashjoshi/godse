/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utd.itc.godse.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author GoDSe
 */
public class GoDSeDataStore implements Serializable{
    
    public static List<GoDSeDocumentListEntry> documentList = Collections.synchronizedList(new ArrayList<GoDSeDocumentListEntry>());
    
}
