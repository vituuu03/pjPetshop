package controllers;
import play.*;
import play.mvc.*;
import models.TipoAnimal;
import java.util.*;

import models.*;
public class Animais extends Controller{
    public static void form(){
        List <TipoAnimal> tpAnimais = TipoAnimal.findAll();
        render(tpAnimais);
    }

    public static void salvar(Animal a) {
			a.save();
            listar();
	}
    
    public static void remover (long id){
        Animal animalDelete = Animal.findById(id);
        animalDelete.delete();
       listar();
        
    }
    public static void listar (){
        List <Animal> animaisList = Animal.findAll();
        render(animaisList);
  
        String termo = params.get("termo");
		
		List<Animal> animaisList = Collections.EMPTY_LIST;
		if (termo == null || termo.isEmpty()) {
			animaisList = Animal.findAll();
		} else {
			animaisList = Animal.find("(lower(nome) like ?1 OR tipoAnimal like ?2)",
					"%" + termo.toLowerCase() + "%",
					"%" + termo.toLowerCase() + "%").fetch();
		}
		render(animaisList, termo);
  
  
  
    }
    public static void detalhar(Long id) {
		Animal a = Animal.findById(id);
		render(a);
	}

    public static void editar(Long id) {
		List<TipoAnimal> tipos = TipoAnimal.findAll();
		Animal animal = Animal.findById(id);
		renderTemplate("Animais/form.html", animal, tipos);
	}

}