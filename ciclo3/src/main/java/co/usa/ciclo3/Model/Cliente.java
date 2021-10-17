
package co.usa.ciclo3.Model;

/**
 * @author Rocket
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.aspectj.bridge.Message;


@Entity
@Table(name = "client")
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="cliente")
    @JsonIgnoreProperties("client")
    private List<Mensaje>message;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="cliente")
    @JsonIgnoreProperties("client")
    private List<Reservacion>reservations;

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Mensaje> getMensaje() {
        return message;
    }

    public void setMensaje(List<Mensaje> mensaje) {
        this.message = mensaje;
    }

    public List<Reservacion> getReservacion() {
        return reservations;
    }

    public void setReservacion(List<Reservacion> reservacion) {
        this.reservations = reservacion;
    }
  
    
}
