/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.data;

import java.util.ArrayList;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author lehtimik
 */
public class DrinkkiLomake {

    @NotBlank
    @Length(min = 2, max = 15)
    String drinkki_name;
    @NotBlank
    @Length(min = 2, max = 15)
    String tyyppi_name;
    @NotBlank
    @Length(min = 2, max = 15)
    String ainesosa_name;
   @NotNull 
    Integer maara;
    
    String ainesosa2;
    
    Integer maara2;
    
    String ainesosa3;
   
    Integer maara3;
   
    String ainesosa4;
   
    Integer maara4;
    
   
    String ainesosa5;
   
    Integer maara5;
    String errorViesti;
    Drinkki luotavaDrinkki;

    public DrinkkiLomake() {
        this.errorViesti = "";

        this.tutkiVirheita();

    }

    public void luoDrinkki() {
        
        Tyyppi uusiTyyppi = new Tyyppi();
        uusiTyyppi.setTyyppi_name(tyyppi_name);
        ArrayList<Tyyppi> tyyppi = new ArrayList<Tyyppi>();
        tyyppi.add(uusiTyyppi);
        
        Ainesosa paa_ainesosa = new Ainesosa();
        paa_ainesosa.setAinesosa_name(ainesosa_name);
        
        DrinkkiAinesosa drinkkiainesosa = new DrinkkiAinesosa();
        drinkkiainesosa.setMaara(maara);
        drinkkiainesosa.setAinesosa(paa_ainesosa);
        
        ArrayList<DrinkkiAinesosa> drinkkiainesosat = new ArrayList<DrinkkiAinesosa>();
        drinkkiainesosat.add(drinkkiainesosa);
        
        

       if(ainesosa2!=null){
           Ainesosa a2 = new Ainesosa();
        a2.setAinesosa_name(ainesosa2);
         DrinkkiAinesosa drinkkiainesosa2 = new DrinkkiAinesosa();
        drinkkiainesosa2.setMaara(maara2);
        drinkkiainesosa2.setAinesosa(a2);
         drinkkiainesosat.add(drinkkiainesosa2);
       }
       
       if(!ainesosa3.isEmpty()){
           Ainesosa a3 = new Ainesosa();
        a3.setAinesosa_name(ainesosa3);
         DrinkkiAinesosa drinkkiainesosa3 = new DrinkkiAinesosa();
        drinkkiainesosa3.setMaara(maara3);
        drinkkiainesosa3.setAinesosa(a3);
         drinkkiainesosat.add(drinkkiainesosa3);
       }
       if(!ainesosa4.isEmpty()){
           Ainesosa a4 = new Ainesosa();
        a4.setAinesosa_name(ainesosa4);
         DrinkkiAinesosa drinkkiainesosa4 = new DrinkkiAinesosa();
        drinkkiainesosa4.setMaara(maara4);
        drinkkiainesosa4.setAinesosa(a4);
         drinkkiainesosat.add(drinkkiainesosa4);
       }
       if(!ainesosa5.isEmpty()){
           Ainesosa a5 = new Ainesosa();
        a5.setAinesosa_name(ainesosa5);
         DrinkkiAinesosa drinkkiainesosa5 = new DrinkkiAinesosa();
        drinkkiainesosa5.setMaara(maara5);
        drinkkiainesosa5.setAinesosa(a5);
         drinkkiainesosat.add(drinkkiainesosa5);
       }



        Drinkki gt = new Drinkki();
        gt.setTyypit(tyyppi);
        gt.setDrinkki_name(drinkki_name);
        gt.setDrinkkiAinesosa(drinkkiainesosat);
                this.setLuotavaDrinkki(gt);
    }

    public String getDrinkki_name() {
        return drinkki_name;
    }

    public String getTyyppi_name() {
        return tyyppi_name;
    }

    public void setLuotavaDrinkki(Drinkki luotavaDrinkki) {
        this.luotavaDrinkki = luotavaDrinkki;
    }

    public Drinkki getLuotavaDrinkki() {
        return luotavaDrinkki;
    }

    public String getAinesosa_name() {
        return ainesosa_name;
    }

    public Integer getMaara() {
        return maara;
    }

    public String getAinesosa2() {
        return ainesosa2;
    }

    public Integer getMaara2() {
        return maara2;
    }

    public String getAinesosa3() {
        return ainesosa3;
    }

    public Integer getMaara3() {
        return maara3;
    }

    public String getAinesosa4() {
        return ainesosa4;
    }

    public Integer getMaara4() {
        return maara4;
    }

    public String getAinesosa5() {
        return ainesosa5;
    }

    public Integer getMaara5() {
        return maara5;
    }

    public void setDrinkki_name(String drinkki_name) {
        this.drinkki_name = drinkki_name;
    }

    public void setTyyppi_name(String tyyppi_name) {
        this.tyyppi_name = tyyppi_name;
    }

    public void setAinesosa_name(String ainesosa_name) {
        this.ainesosa_name = ainesosa_name;
    }

    public void setMaara(Integer maara) {
        this.maara = maara;
    }

    public void setAinesosa2(String ainesosa2) {
        this.ainesosa2 = ainesosa2;
    }

    public void setMaara2(Integer maara2) {
        this.maara2 = maara2;
    }

    public void setAinesosa3(String ainesosa3) {
        this.ainesosa3 = ainesosa3;
    }

    public void setMaara3(Integer maara3) {
        this.maara3 = maara3;
    }

    public void setAinesosa4(String ainesosa4) {
        this.ainesosa4 = ainesosa4;
    }

    public void setMaara4(Integer maara4) {
        this.maara4 = maara4;
    }

    public void setAinesosa5(String ainesosa5) {
        this.ainesosa5 = ainesosa5;
    }

    public void setMaara5(Integer maara5) {
        this.maara5 = maara5;
    }

    public boolean onkoMaaraAinesosaOK(String ainesosa, Integer maara) {
        if (ainesosa == null && maara == null) {
            return true;
        }
        if (ainesosa != null && maara != null) {
            return true;
        }
        return false;
    }

    public void setErrorViesti(String errorViesti) {
        this.errorViesti = errorViesti;
    }

    public String getErrorViesti() {
        return errorViesti;
    }

    public void tutkiVirheita() {
        
        
        if (onkoMaaraAinesosaOK(ainesosa2, maara2)==false) {
            setErrorViesti("Tarkista ainesosa 2 ja m‰‰r‰");
            return;
        }
        if (onkoMaaraAinesosaOK(ainesosa3, maara3)==false) {
            setErrorViesti("Tarkista ainesosa 3 ja m‰‰r‰");
            return;
        }
        if (onkoMaaraAinesosaOK(ainesosa4, maara4)==false) {
            setErrorViesti("Tarkista ainesosa 4 ja m‰‰r‰");
            return;
        }
        if (onkoMaaraAinesosaOK(ainesosa5, maara5)==false) {
            setErrorViesti("Tarkista ainesosa 5 ja m‰‰r‰");

        }
    }
}
