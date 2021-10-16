package co.usa.ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rocket
 */

@RestController
@RequestMapping("/api/Skate")
public class SkateWeb {
    @GetMapping("/holaMundo")
    public String saludar(){
        return "Hola Mundo Colombia";
    }
    
    @Autowired
    private ServicioSkate servicio;
    @GetMapping("/all")
    public List <Skate> getSkate(){
        return servicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Skate> getSkate(@PathVariable("id") int idSkate){
        return servicio.getSkate(idSkate);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate save(@RequestBody Skate skate){
        return servicio.save(skate);
    }
}
