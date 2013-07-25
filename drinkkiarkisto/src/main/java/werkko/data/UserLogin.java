/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author lehtimik
 */
@Entity
@Table(name = "Login")
public class UserLogin implements Login, Serializable {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "authority")
    private String authority;

       public UserLogin() {
        this.id = UUID.randomUUID().toString();
       
       
    }
    public String getAuthority() {
        return authority;
    }

    public String getId() {
        return id;
    }

    public  String getName() {
        return name;
    }

    public  String getPassword() {
        return password;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
