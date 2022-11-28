package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class TipoAnimal extends Model{
    public String nome;
	public String descricao;
	
    @Override
	public String toString() {
		return nome;
	}

}