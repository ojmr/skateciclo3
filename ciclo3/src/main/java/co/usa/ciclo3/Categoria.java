package co.usa.ciclo3;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

//si sirve
@Entity
@Table(name = "category")
public class Categoria implements Serializable{
     @Id
     @GeneratedValue
     private Integer id;
     private String name;
     private String description;
     
     @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="category")
     @JsonIgnoreProperties("category")
     private List<Skate> skate;

    public Integer getIdcategory() {
        return id;
    }

    public void setIdcategory(Integer idcategory) {
        this.id = idcategory;
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