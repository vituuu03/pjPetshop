package controllers;
import play.*;
import play.mvc.*;
import models.Animal;
import java.util.*;

import models.*;
public class TpAnimal extends Controller{
    public static void TipoAnimalForm(){
        render();
    }

    public static void salvar(TipoAnimal a) {
			a.save();
         
	}

    public static void listar (){
        String termo = params.get("termo");
		
		List<TipoAnimal> tpsAnimal = Collections.EMPTY_LIST;
		if (termo == null || termo.isEmpty()) {
			tpsAnimal = TipoAnimal.findAll();
		} else {
			tpsAnimal = TipoAnimal.find("(lower(nome) like ?1 OR descricao like ?2)",
					"%" + termo.toLowerCase() + "%",
					"%" + termo.toLowerCase() + "%").fetch();
		}
		render(tpsAnimal, termo);
  
  
  
    }
    
    public static void editar(Long id) {
		TipoAnimal tpsAnimal = TipoAnimal.findById(id);
		renderTemplate("TpAnimal/TipoAnimalForm.html", tpsAnimal);
	}

    public static void remover (long id){
        TipoAnimal tpAnimalDelete = TipoAnimal.findById(id);
        tpAnimalDelete.delete();
       listar();
        
    }
    
    public static void detalharTipo(Long id) {
		TipoAnimal a = TipoAnimal.findById(id);
		
        boolean achouIgual = false;
			List<Animal> animaisTp = Animal.findAll();
			for (int i = 0; i < animaisTp.size(); i++) {
				Animal aniTp = animaisTp.get(i);
				// Se já estiver cadastrado, não é possível salvar
				if (Animal.tipoAnimal.equals(aniTp.tipoAnimal.equals(a.nome))) {
					achouIgual = true;
					
                    String termo = params.get("termo");
		
                    List<TipoAnimal> tpsAnimal = Collections.EMPTY_LIST;
                    if (termo == null || termo.isEmpty()) {
                        tpsAnimal = TipoAnimal.findAll();
                    } else {
                        tpsAnimal = TipoAnimal.find("(lower(nome) like ?1 OR descricao like ?2)",
                                "%" + termo.toLowerCase() + "%",
                                "%" + termo.toLowerCase() + "%").fetch();
                    }
                    
                    render(a, tpsAnimal);
				}
                
            }
        
        
        
        
	}

}