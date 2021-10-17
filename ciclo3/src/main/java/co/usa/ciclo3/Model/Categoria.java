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
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//nuevo cambios nuevos cambios
@Entity
@Table(name = "category")
public class Categoria implements Serializable{
     @Id
     @GeneratedValue
     private Integer id;
     private String name;
     private String description;
     
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="categoria")
    @JsonIgnoreProperties("category")
    private List<Skate> skate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Skate> getSkate() {
        return skate;
    }

    public void setSkate(List<Skate> skate) {
        this.skate = skate;
    }
   

}