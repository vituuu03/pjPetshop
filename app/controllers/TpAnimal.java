package controllers;
import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
public class TpAnimal extends Controller{
    public static void TipoAnimalForm(){
        render();
    }

    public static void salvar(TipoAnimal a) {
			a.save();
         
	}

    public static List<TipoAnimal> findAll(List<TipoAnimal> tipos) {
        return null;
    }
    

}