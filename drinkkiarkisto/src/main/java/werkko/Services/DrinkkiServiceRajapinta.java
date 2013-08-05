/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.Services;

import java.util.HashMap;
import java.util.List;
import werkko.data.Drinkki;

/**
 *
 * @author lehtimik
 */
public interface DrinkkiServiceRajapinta<T> {
         T create(T object);

    T read(String id);

    T update(T object);

    void delete(String id);

    List<T> list();
    String luoUusiDrinkki(Drinkki drinkki);
    HashMap<String, String> etsiDrinkkeja(String hakukriteeri);
}
