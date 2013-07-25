/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.controller;

import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lehtimik
 */
@Controller
public class UserController {
    
     @RequestMapping("haku")
    public String viewHakuPage(Model model, HttpSession session) {
        
       session.getAttribute("password");
        if (! "secret".equals(session.getAttribute("password"))) {
            return "redirect:login";                 
        }else{
            model.addAttribute("username", session.getAttribute("username"));
                 return "haku";
        }
   
    }
     
     @RequestMapping(value = "hae", method = RequestMethod.POST)
    public String haeDrinkkeja(
            @RequestParam(value = "hae", required = false) String hae,
            HttpSession session) {
   
        session.getAttribute("password");
        if (! "secret".equals(session.getAttribute("password"))) {
            return "redirect:login";                 
        }else{
            String sana = "Haun tulokset:";
            HashMap<String,String> osoitteita = new HashMap<String,String>();
            
           
               osoitteita.put("Gin Tonic", "http://localhost:8080/drinkkiarkisto/app/GinTonic/drinkki"); 
               osoitteita.put("Musta Ryssä", "http://localhost:8080/drinkkiarkisto/app/MustaRyssa/drinkki");
               
               
        session.setAttribute("sana", sana);
    
        session.setAttribute("osoitteita", osoitteita);
        return "redirect:haku";
        }
     }

        
        @RequestMapping(method = RequestMethod.GET, value = "{drinkName}/drinkki")
    public String read(Model model, @PathVariable String drinkName, HttpSession session) {
             session.getAttribute("password");
        if (! "secret".equals(session.getAttribute("password"))) {
            return "redirect:login";                 
        }else{
            String sana = "Ainesosat:";
            ArrayList<String> ainesosa = new ArrayList<String>();
            ainesosa.add("4 cl Gin");
            ainesosa.add("8 cl Tonic-vettä");
        model.addAttribute("sana", sana);
        model.addAttribute("ainesosa", ainesosa);
        return "drinkki";   
    }
    }
        
     @RequestMapping("rekisteroidy")
    public String viewRekisteroidy() {
        return "rekisteroidy";
    }
     
          @RequestMapping("ehdota")
    public String viewEhdota(Model model, HttpSession session) {
              if (! "secret".equals(session.getAttribute("password"))) {
            return "redirect:login";                 
        }else{
        return "ehdota";
              }
    }
     
      @RequestMapping(value = "add-user", method = RequestMethod.POST)
    public String lisaaKayttajia(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "password2", required = true) String password2,
            HttpSession session) {
          if (! "secret".equals(session.getAttribute("password"))) {
            return "redirect:login";                 
        }else{
   
          String password3 = "secret";
       session.setAttribute("username", username);
        session.setAttribute("password", password3);
        return "redirect:haku";
          }
     }
      
      @RequestMapping(value = "ehdota-drinkkia", method = RequestMethod.POST)
    public String ehdotaDrinkkia(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "tyyppi", required = false) String tyyppi,
            @RequestParam(value = "ainesosa1", required = true) String ainesosa1,
            @RequestParam(value = "maara1", required = true) String maara1,
            @RequestParam(value = "ainesosa2", required = false) String ainesosa2,
            @RequestParam(value = "maara2", required = false) String maara2,
            @RequestParam(value = "ainesosa3", required = false) String ainesosa3,
            @RequestParam(value = "maara3", required = false) String maara3,
            @RequestParam(value = "ainesosa4", required = false) String ainesosa4,
            @RequestParam(value = "maara4", required = false) String maara4,
            @RequestParam(value = "ainesosa5", required = false) String ainesosa5,
            @RequestParam(value = "maara5", required = false) String maara5,
            HttpSession session) {
   if (! "secret".equals(session.getAttribute("password"))) {
            return "redirect:login";                 
        }else{
       //tähän tallennus ja kiitos viesti
        return "redirect:ehdota";
   }
 
     }
       @RequestMapping(value = "hae-aakkoset", method = RequestMethod.POST)
    public String haeAakkosissaAdmin(
            @RequestParam(value = "hae-aakkoset", required = false) String hae,
            HttpSession session) {

        session.getAttribute("password");
        if (!"secret".equals(session.getAttribute("password"))) {
            return "redirect:login";
        } else {
            String sana = "Aakkosissa drinkkejä:";
            HashMap<String, String> osoitteita = new HashMap<String, String>();


            osoitteita.put("haku_aakkonen1", "http://localhost:8080/drinkkiarkisto/app/GinTonic/drinkki");
            osoitteita.put("haku_aakkonen2", "http://localhost:8080/drinkkiarkisto/app/MustaRyssa/drinkki");


            session.setAttribute("sana", sana);

            session.setAttribute("osoitteita", osoitteita);
            return "redirect:haku";
        }
    }
       
        @RequestMapping(value = "hae-tyyppi", method = RequestMethod.POST)
    public String haeTyyppiAdmin(
            @RequestParam(value = "hae-tyyppi", required = false) String hae,
            HttpSession session) {

        session.getAttribute("password");
        if (!"secret".equals(session.getAttribute("password"))) {
            return "redirect:login";
        } else {
            String sana = "Tyypin mukaan tulleita tuloksia:";
            HashMap<String, String> osoitteita = new HashMap<String, String>();


            osoitteita.put("haku_alkucocktail12", "http://localhost:8080/drinkkiarkisto/app/GinTonic/drinkki");
            osoitteita.put("haku    _alkucocktail13", "http://localhost:8080/drinkkiarkisto/app/MustaRyssa/drinkki");


            session.setAttribute("sana", sana);

            session.setAttribute("osoitteita", osoitteita);
            return "redirect:haku";
        }
    }
    }


