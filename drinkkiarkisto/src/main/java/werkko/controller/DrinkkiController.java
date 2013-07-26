/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.controller;

import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
public class DrinkkiController {

    @Autowired
    private LoginService loginservice;

    @PostConstruct
    private void init() {
        UserLogin userlogin = new UserLogin();
        userlogin.setAuthority("admin");
        userlogin.setName("mikko");
        userlogin.setPassword("secret");
        userlogin.setEmail("mikko@mikko");
        loginservice.create(userlogin);

        UserLogin userlogin2 = new UserLogin();
        userlogin2.setAuthority("user");
        userlogin2.setName("pekka");
        userlogin2.setPassword("secret");
        userlogin.setEmail("pekka@pekka");
        loginservice.create(userlogin2);
    }

    public boolean onkoIstuntoVoimassa(HttpSession session) {
        String passwordKannassa = loginservice.getUserlogin().getPassword();
        String passwordSessiossa = (String) session.getAttribute("password");
        String usernameKannassa = loginservice.getUserlogin().getName();
        String usernameSessiossa = (String) session.getAttribute("username");
        if (passwordKannassa.equals(passwordSessiossa) && usernameKannassa.equals(usernameSessiossa)) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(ModelMap model) {

        return "login";

    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            HttpSession session) {

        String viesti = loginservice.loginOK(username, password);

        if (viesti.equals("ok")) {
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            return "redirect:haku";
        } else {
            session.setAttribute("nameError", viesti);
            return "login";
        }

    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(ModelMap model, HttpSession session) {
        session.invalidate();
        loginservice.setUserlogin(null);
        return "login";

    }

    @RequestMapping("haku")
    public String viewHakuPage(Model model, HttpSession session) {


        if (onkoIstuntoVoimassa(session) == false) {
            return "login";
        } else {
            if (loginservice.getUserlogin().getAuthority().equals("admin")) {
                HashMap<String, String> yllapitolinkki = new HashMap<String, String>();
                yllapitolinkki.put("Ylläpito", "http://localhost:8080/drinkkiarkisto/app/admin");
                model.addAttribute("yllapitolinkki", yllapitolinkki);

            }
            String username = (String) session.getAttribute("username");
            String usernameKanta = loginservice.getUserlogin().getName();
            String passwordKanta = loginservice.getUserlogin().getPassword();
            String authorityKanta = loginservice.getUserlogin().getAuthority();
            String idKanta = loginservice.getUserlogin().getId();
            String statusKanta = loginservice.getUserlogin().getStatus();
                 String emailKanta = loginservice.getUserlogin().getEmail();
            model.addAttribute("username_sessio", username);
            model.addAttribute("usernameKanta", usernameKanta);
            model.addAttribute("authorityKanta", authorityKanta);
            model.addAttribute("idKanta", idKanta);
            model.addAttribute("statusKanta", statusKanta);
            model.addAttribute("passwordKanta", passwordKanta);
            model.addAttribute("emailKanta", emailKanta);

            return "haku";
        }

    }

    @RequestMapping(value = "hae", method = RequestMethod.POST)
    public String haeDrinkkeja(
            @RequestParam(value = "hae", required = false) String hae,
            HttpSession session) {

        if (onkoIstuntoVoimassa(session) == false) {
            return "redirect:login";
        } else {
            String sana = "Haun tulokset:";
            HashMap<String, String> osoitteita = new HashMap<String, String>();


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
        if (onkoIstuntoVoimassa(session) == false) {
            return "login";
        } else {
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
        if (onkoIstuntoVoimassa(session) == false) {
            return "login";
        } else {
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

        if (!password.equals(password2)) {
            String nameError = "Antamasi salasanat eivät ole samoja";
            session.setAttribute("nameError", nameError);
            return "redirect:add-user";
        }
        UserLogin userlogin = new UserLogin();
        userlogin.setAuthority("user");
        userlogin.setName(username);
        userlogin.setPassword(password);
        userlogin.setEmail(email);
        UserLogin uusiKayttaja = (UserLogin) loginservice.create(userlogin);
        if (uusiKayttaja.getStatus().equals("ok")) {
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            loginservice.setUserlogin(uusiKayttaja);
            return "redirect:haku";
        } else {
            session.setAttribute("nameError", uusiKayttaja.getStatus());
            return "redirect:add-user";
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
        if (onkoIstuntoVoimassa(session) == false) {
            return "redirect:login";
        } else {
            //tähän tallennus ja kiitos viesti
            return "redirect:ehdota";
        }

    }

    @RequestMapping(value = "hae-aakkoset", method = RequestMethod.POST)
    public String haeAakkosissa(
            @RequestParam(value = "hae-aakkoset", required = false) String hae,
            HttpSession session) {

        if (onkoIstuntoVoimassa(session) == false) {
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
    public String haeTyyppi(
            @RequestParam(value = "hae-tyyppi", required = false) String hae,
            HttpSession session) {

        if (onkoIstuntoVoimassa(session) == false) {
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

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String adminView(ModelMap model, HttpSession session) {
        if (onkoIstuntoVoimassa(session) == false) {
            return "login";
        } else {
            return "admin";
        }

    }

    @RequestMapping(value = "hae-admin", method = RequestMethod.POST)
    public String haeAdminDrinkkejaAdmin(
            @RequestParam(value = "hae-admin", required = false) String hae,
            HttpSession session) {

        if (onkoIstuntoVoimassa(session) == false) {
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

        if (onkoIstuntoVoimassa(session) == false) {
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

        if (onkoIstuntoVoimassa(session) == false) {
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

        if (onkoIstuntoVoimassa(session) == false) {
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

        if (onkoIstuntoVoimassa(session) == false) {
            return "redirect:login";
        } else {


            return "redirect:admin";
        }


    }

    @RequestMapping(value = "hae-kayttaja", method = RequestMethod.POST)
    public String haeKayttaja(
            @RequestParam(value = "hae-kayttaja", required = false) String hae,
            HttpSession session) {

        if (onkoIstuntoVoimassa(session) == false) {
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
        if (onkoIstuntoVoimassa(session) == false) {
            return "login";
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
        if (onkoIstuntoVoimassa(session) == false) {
            return "login";
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
