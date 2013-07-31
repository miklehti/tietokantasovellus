/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import werkko.data.Tyyppi;
import werkko.repository.TyyppiRepositoryRajapinta;

/**
 *
 * @author lehtimik
 */
@Service
public class TyyppiService implements TyyppiServiceRajapinta<Tyyppi> {
    @Autowired
        private TyyppiRepositoryRajapinta<Tyyppi> drinkkiAinesosaRepositoryRajapinta;

    public Tyyppi create(Tyyppi object) {
        return drinkkiAinesosaRepositoryRajapinta.create(object);
    }

    public Tyyppi read(String id) {
        return drinkkiAinesosaRepositoryRajapinta.read(id);
    }

    public Tyyppi update(Tyyppi object) {
        return drinkkiAinesosaRepositoryRajapinta.update(object);
    }

    public void delete(String id) {
        drinkkiAinesosaRepositoryRajapinta.delete(id);
     
    }

    public List<Tyyppi> list() {
       return drinkkiAinesosaRepositoryRajapinta.list();
    }
}
