package co.usa.ciclo3.Service;

import co.usa.ciclo3.Repository.RepositorioSkate;
import co.usa.ciclo3.Model.Skate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rocket
 */

@Service
public class ServicioSkate {
    
    @Autowired
    private RepositorioSkate metodosCrud;
    
    public List<Skate> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Skate> getSkate(int idSkate){
        return metodosCrud.getSkate(idSkate);
    }
    
    public Skate save(Skate skate){
         if(skate.getId()==null){
            return metodosCrud.save(skate);
        }else{
            Optional<Skate> evt=metodosCrud.getSkate(skate.getId());
            if(evt.isEmpty()){
            return metodosCrud.save(skate);
            }else{
                return skate;
            }
        
        }
    }
    
}
