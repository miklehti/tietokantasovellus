/*
 * Ainesosao change this template, choose Ainesosaools | Ainesosaemplates
 * and open the template in the editor.
 */
package werkko.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import werkko.data.Ainesosa;
import werkko.repository.AinesosaRepositoryRajapinta;

/**
 *
 * @author lehtimik
 */
@Service
public class AinesosaService implements AinesosaServiceRajapinta<Ainesosa> {
    
    @Autowired
    private AinesosaRepositoryRajapinta<Ainesosa> ainesosaRepositoryRajapinta;
    
         public Ainesosa create(Ainesosa object){
             return ainesosaRepositoryRajapinta.create(object);
             
         }

    public Ainesosa read(String id){
        return ainesosaRepositoryRajapinta.read(id);
    }

    public Ainesosa update(Ainesosa object){
        return ainesosaRepositoryRajapinta.update(object);
    }

    public void delete(String id){
        ainesosaRepositoryRajapinta.delete(id);
    }

    public List<Ainesosa> list(){
        return ainesosaRepositoryRajapinta.list();
    }
}
