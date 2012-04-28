/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utd.itc.godse.action;

import com.utd.itc.godse.helper.GoDSeHelper;
import com.utd.itc.godse.resource.Messages;
import com.utd.itc.godse.view.HomeForm;
import com.utd.itc.godse.view.LoginForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author GoDSe
 */
public class LoginAction implements ActionListener, Runnable {

    public LoginForm loginForm;
    
    public LoginAction(LoginForm lgForm)
    {
        this.loginForm = lgForm;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(loginForm.validateInput())
            new Thread(this).start();
        else
            loginForm.showErrorMessage(Messages.LOGIN_CREDENTIALS_NEEDED);
    }

    @Override
    public void run() {
        
        String userName = this.loginForm.getUserName();
        String password = this.loginForm.getPassword();
        
        String email = userName;
        if(userName.lastIndexOf("@") == -1)
		email+="@gmail.com";
        
        //System.out.println("Logging in with: " + email + " - " + password);
        String message = GoDSeHelper.login(email, password);
        
        //System.out.println("LOGIN CALL DONE!! " + message);
        if("success".equalsIgnoreCase(message))
        {
            this.loginForm.setVisible(false);
            GoDSeHelper.prepareItems();
            HomeForm hForm = new HomeForm();
            hForm.setVisible(true);
        }
        else
        {
            loginForm.showErrorMessage(Messages.LOGIN_CREDENTIALS_FAILED);
        }
    }
    
}
