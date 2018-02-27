package poe.spring.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.domain.Trajet;
import poe.spring.repository.TrajetRepository;

@Service
public class TrajetManagerService {

	@Autowired
	private TrajetRepository trajetRepository;
	
	public Trajet save(String villeDepart, String villeArrivee, Date dateDepart, long prix, int nombreDePlace) {
		Trajet trajet = new Trajet();
		trajet.setDateDepart(dateDepart);
		trajet.setNombreDePlace(nombreDePlace);
		trajet.setPrix(prix);
		trajet.setVilleArrivee(villeArrivee);
		trajet.setVilleDepart(villeDepart);
		System.out.println("###################");
		trajetRepository.save(trajet);
		return trajet;
	}
}
