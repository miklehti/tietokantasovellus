/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import werkko.data.Ainesosa;
import werkko.data.DrinkkiAinesosa;
import werkko.repository.AinesosaRepositoryRajapinta;
import werkko.repository.DrinkkiAinesosaRepositoryRajapinta;

/**
 *
 * @author lehtimik
 */
@Service
public class DrinkkiAinesosaService implements DrinkkiAinesosaServiceRajapinta<DrinkkiAinesosa> {
    
     @Autowired
    private DrinkkiAinesosaRepositoryRajapinta<DrinkkiAinesosa> drinkkiAinesosaRepositoryRajapinta;

    public DrinkkiAinesosa create(DrinkkiAinesosa object) {
        return drinkkiAinesosaRepositoryRajapinta.create(object);
    }

    public DrinkkiAinesosa read(String id) {
        return drinkkiAinesosaRepositoryRajapinta.read(id);
    }

    public DrinkkiAinesosa update(DrinkkiAinesosa object) {
        return drinkkiAinesosaRepositoryRajapinta.update(object);
    }

    public void delete(String id) {
        drinkkiAinesosaRepositoryRajapinta.delete(id); ;
    }

    public List<DrinkkiAinesosa> list() {
        return drinkkiAinesosaRepositoryRajapinta.list();
    }
}
