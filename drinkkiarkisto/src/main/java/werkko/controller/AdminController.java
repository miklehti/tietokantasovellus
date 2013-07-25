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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lehtimik
 */
@Controller
public class AdminController {

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String adminView(ModelMap model) {
        return "admin";

    }

    @RequestMapping(value = "hae-admin", method = RequestMethod.POST)
    public String haeAdminDrinkkejaAdmin(
            @RequestParam(value = "hae-admin", required = false) String hae,
            HttpSession session) {

        session.getAttribute("password");
        if (!"secret".equals(session.getAttribute("password"))) {
            return "redirect:login";
        } else {
            String sana = "Haun tulokset:";
            HashMap<String, String> osoitteita = new HashMap<String, String>();


            osoitteita.put("admin_Blue Moon", "http://localhost:8080/drinkkiarkisto/app/GinTonic/drinkki");
            osoitteita.put("admin_Valkovenäläinen", "http://localhost:8080/drinkkiarkisto/app/MustaRyssa/drinkki");


            session.setAttribute("sana", sana);

            session.setAttribute("osoitteita", osoitteita);
            return "redirect:admin";
        }
    }

    @RequestMapping(value = "hae-ehdotuksia-admin", method = RequestMethod.POST)
    public String haeEhdotuksiaAdmin(
            @RequestParam(value = "hae-ehdotuksia-admin", required = false) String hae,
            HttpSession session) {

        session.getAttribute("password");
        if (!"secret".equals(session.getAttribute("password"))) {
            return "redirect:login";
        } else {
            String sana = "Ehdotuksia:";
            HashMap<String, String> ehdotuksia = new HashMap<String, String>();


            ehdotuksia.put("admin_ehd_Blue Moon", "http://localhost:8080/drinkkiarkisto/app/Moon/ehdotus");
            ehdotuksia.put("admin_ehd_Valkovenäläinen", "http://localhost:8080/drinkkiarkisto/app/valkovenalainen/ehdotus");


            session.setAttribute("sana", sana);

            session.setAttribute("ehdotuksia", ehdotuksia);
            return "redirect:admin";
        }
    }

    @RequestMapping(value = "hae-tyyppi-admin", method = RequestMethod.POST)
    public String haeTyyppiAdmin(
            @RequestParam(value = "hae-tyyppi-admin", required = false) String hae,
            HttpSession session) {

        session.getAttribute("password");
        if (!"secret".equals(session.getAttribute("password"))) {
            return "redirect:login";
        } else {
            String sana = "Tyypin mukaan tulleita tuloksia:";
            HashMap<String, String> osoitteita = new HashMap<String, String>();


            osoitteita.put("admin_alkucocktail12", "http://localhost:8080/drinkkiarkisto/app/GinTonic/drinkki");
            osoitteita.put("admin_alkucocktail13", "http://localhost:8080/drinkkiarkisto/app/MustaRyssa/drinkki");


            session.setAttribute("sana", sana);

            session.setAttribute("osoitteita", osoitteita);
            return "redirect:admin";
        }
    }

    @RequestMapping(value = "hae-aakkoset-admin", method = RequestMethod.POST)
    public String haeAakkosissaAdmin(
            @RequestParam(value = "hae-aakkoset-admin", required = false) String hae,
            HttpSession session) {

        session.getAttribute("password");
        if (!"secret".equals(session.getAttribute("password"))) {
            return "redirect:login";
        } else {
            String sana = "Aakkosissa drinkkejä:";
            HashMap<String, String> osoitteita = new HashMap<String, String>();


            osoitteita.put("admin_aakkonen1", "http://localhost:8080/drinkkiarkisto/app/GinTonic/drinkki");
            osoitteita.put("admin_aakkonen2", "http://localhost:8080/drinkkiarkisto/app/MustaRyssa/drinkki");


            session.setAttribute("sana", sana);

            session.setAttribute("osoitteita", osoitteita);
            return "redirect:admin";
        }
    }

    @RequestMapping(value = "luo-drinkki", method = RequestMethod.POST)
    public String luoDrinkki(
            @RequestParam(value = "luo-drinkki", required = false) String hae,
            HttpSession session) {

        session.getAttribute("password");
        if (!"secret".equals(session.getAttribute("password"))) {
            return "redirect:login";
        } else {

            return "redirect:admin";
        }


    }

    @RequestMapping(value = "hae-kayttaja", method = RequestMethod.POST)
    public String haeKayttaja(
            @RequestParam(value = "hae-kayttaja", required = false) String hae,
            HttpSession session) {

        session.getAttribute("password");
        if (!"secret".equals(session.getAttribute("password"))) {
            return "redirect:login";
        } else {
            String sana = "Käyttäjiä:";
            HashMap<String, String> kayttajia = new HashMap<String, String>();


            kayttajia.put("Pekka", "http://localhost:8080/drinkkiarkisto/app/Pekka/kayttaja");
            kayttajia.put("Mikko", "http://localhost:8080/drinkkiarkisto/app/Mikko/kayttaja");


            session.setAttribute("sana", sana);

            session.setAttribute("kayttajia", kayttajia);
            return "redirect:admin";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "{ehdotusName}/ehdotus")
    public String readEhdotus(Model model, @PathVariable String ehdotusName, HttpSession session) {
        session.getAttribute("password");
        if (!"secret".equals(session.getAttribute("password"))) {
            return "redirect:login";
        } else {
            String sana = "Ainesosat:";
            ArrayList<String> ainesosa = new ArrayList<String>();
            ainesosa.add("4 cl Vodka_ehdotus");
            ainesosa.add("8 cl spriteä");
            model.addAttribute("sana", sana);
            model.addAttribute("ainesosa", ainesosa);
            return "ehdotus";
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "{kayttajaName}/kayttaja")
    public String readKayttaja(Model model, @PathVariable String kayttajaName, HttpSession session) {
        session.getAttribute("password");
        if (!"secret".equals(session.getAttribute("password"))) {
            return "redirect:login";
        } else {
            String sana = "Käyttäjän tiedot:";
            ArrayList<String> kayttajat = new ArrayList<String>();
            kayttajat.add("Pekka");
            kayttajat.add("salasana");
            model.addAttribute("sana", sana);
            model.addAttribute("kayttajat", kayttajat);
            return "kayttaja";
        }
    }
}
