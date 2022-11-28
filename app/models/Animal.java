package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Animal extends Model{

	public String nome;
	public Integer peso;
	public Date dataNascimento;
	@Override
	public String toString() {
		return nome;
	}

	@ManyToOne
	public TipoAnimal tipoAnimal;
	public void remove(long id) {
	}
    public void delete(long id) {
    }
	
}