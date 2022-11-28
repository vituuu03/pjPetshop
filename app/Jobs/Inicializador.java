package Jobs;
import models.TipoAnimal;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

	@Override
	public void doJob() throws Exception {
		 if (TipoAnimal.count() == 0) {
			 TipoAnimal ta1 = new TipoAnimal();
			 ta1.nome = "Cachorro";
			 ta1.save();
			 
			 TipoAnimal ta2 = new TipoAnimal();
			 ta2.nome = "Gato";
			 ta2.save();
			 
			 TipoAnimal ta3 = new TipoAnimal();
			 ta3.nome = "Hamster";
			 ta3.save();
			 
			 TipoAnimal ta4 = new TipoAnimal();
			 ta4.nome = "Periquito";
			 ta4.save();
			 
			 TipoAnimal ta5 = new TipoAnimal();
			 ta5.nome = "Cobra";
			 ta5.save();

			 TipoAnimal ta6 = new TipoAnimal();
			 ta6.nome = "GADO MANSO";
			 ta6.save();
		 }
	}
}
