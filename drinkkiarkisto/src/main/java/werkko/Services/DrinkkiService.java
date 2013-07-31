/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.Services;

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
public class DrinkkiService implements DrinkkiServiceRajapinta<Drinkki>{

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
}
