/* 
 * GODSe (Google Docs Secure) GODSe is a Java based desktop application 
 * that securely encrypts text before uploading to google docs server. 
 * The encryption algorithm used is AES in CTR mode. 
 * We also ensure the integrity/authenticity of message by 
 * calculating HMAC of the plain text that was to be encrypted. 
 * Transmitting HMAC is clear text is vulnerable to attacks. 
 * So we calculate HMAC of the plaintext and append the same to the plaintext. 
 * Now this whole "appended" message is encrypted.
 * 
 * 
 * Collaborators:
 * Avinash Joshi <axj107420@utdallas.edu>
 * Sandeep Shenoy <sxs115220@utdallas.edu>
 * Shishir Krishnaprasad <sxk116430@utdallas.edu>
 * 
 * (c) 2012 GODSe
 * 
 */
package com.utd.itc.godse;

import com.utd.itc.godse.view.LoginForm;

public class GoDSeApp {
    
    public static void main(String args[]) {
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }
}
