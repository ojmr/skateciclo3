
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "skate")
public class Skate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer idSkate;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name ="id")
    @JsonIgnoreProperties("category")
    private Categoria categoria;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="skate")
    @JsonIgnoreProperties("skate")
    private List<Mensaje> message;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="skate")
    @JsonIgnoreProperties("skate")
    private List<Reservacion> reservations;

    public Integer getIdSkate() {
        return idSkate;
    }

    public void setIdSkate(Integer idSkate) {
        this.idSkate = idSkate;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return categoria;
    }

    public void setCategory(Categoria category) {
        this.categoria = category;
    }

    public List<Mensaje> getMessage() {
        return message;
    }

    public void setMessage(List<Mensaje> message) {
        this.message = message;
    }

    public List<Reservacion> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservacion> reservations) {
        this.reservations = reservations;
    }
    
    
    
}
