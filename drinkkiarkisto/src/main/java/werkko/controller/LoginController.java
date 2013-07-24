/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lehtimik
 */
@Controller
public class LoginController {
    
     @RequestMapping("login")
    public String viewLoginPage() {
        return "login";
    }
      @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            HttpSession session) {
   
        if (!"secret".equals(password)) {
            return "redirect:login";
        }
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        return "redirect:haku";
    }
      
      @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }

}
