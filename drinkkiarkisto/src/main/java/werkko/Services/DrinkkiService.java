/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.Services;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import werkko.data.Drinkki;

import werkko.repository.DrinkkiRepositoryRajapinta;

/**
 *
 * @author lehtimik
 */
@Service
public class DrinkkiService implements DrinkkiServiceRajapinta<Drinkki> {

    @Autowired
    private DrinkkiRepositoryRajapinta<Drinkki> drinkkiAinesosaRepositoryRajapinta;

    public Drinkki create(Drinkki object) {
        return drinkkiAinesosaRepositoryRajapinta.create(object);
    }

    public Drinkki read(String id) {
        return drinkkiAinesosaRepositoryRajapinta.read(id);
    }

    public Drinkki update(Drinkki object) {
        return drinkkiAinesosaRepositoryRajapinta.update(object);
    }

    public void delete(String id) {
        drinkkiAinesosaRepositoryRajapinta.delete(id);

    }

    public List<Drinkki> list() {
        return drinkkiAinesosaRepositoryRajapinta.list();
    }

    public String luoUusiDrinkki(Drinkki drinkki) {
        Drinkki loytyyko = read(drinkki.getDrinkki_id());
        if (loytyyko == null) {
            create(drinkki);
            return "ok";
        }
        return "Antamasi drinkki on jo olemassa!";
    }

    public HashMap<String, String> etsiDrinkkeja(String hakukriteeri) {
        HashMap<String, String> drinkkeja = new HashMap<String, String>();
        List<Drinkki> lista = this.list();
        for (int i = 0; i < lista.size(); i++) {
            String tutkittava = lista.get(i).getDrinkki_name().toLowerCase();
            
            if (tutkittava.contains(hakukriteeri.toLowerCase()))
            {
                String osoite = lista.get(i).getDrinkki_name().trim();
                String uusiOsoite = osoite.replace(" ", "");
                drinkkeja.put(lista.get(i).getDrinkki_name(), "http://localhost:8080/drinkkiarkisto/app/" + uusiOsoite + "/drinkki");
            }
        }
        return drinkkeja;
    }
}
