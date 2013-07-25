/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import werkko.Services.LoginService;
import werkko.Services.UserLoginService;
import werkko.data.UserLogin;

/**
 *
 * @author lehtimik
 */
@Controller
public class LoginController {
    
    @Autowired
    private LoginService loginservice;
    
    @PostConstruct
    private void init() {
        UserLogin userlogin = new UserLogin();
        userlogin.setAuthority("admin");
        userlogin.setName("Mikko");
        userlogin.setPassword("secret");
        loginservice.create(userlogin);
    }
    
    @RequestMapping(value="login", method = RequestMethod.GET)
	public String login(ModelMap model) {
 
		return "login";
 
	}
      @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            HttpSession session) {
   
       
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        return "redirect:haku";
    }
      
    @RequestMapping(value="logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
 
		return "login";
 
	}

}
