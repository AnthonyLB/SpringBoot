package poe.spring.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trajet {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	private String villeDepart;	
	private String villeArrivee;	
	private Date dateDepart;	
	private long prix;
	private int nombreDePlace;
	@ManyToOne
	private User user;
	
	public String getVilleDepart() {
		return villeDepart;
	}
	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}
	public String getVilleArrivee() {
		return villeArrivee;
	}
	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public long getPrix() {
		return prix;
	}
	public void setPrix(long prix) {
		this.prix = prix;
	}
	public int getNombreDePlace() {
		return nombreDePlace;
	}
	public void setNombreDePlace(int nombreDePlace) {
		this.nombreDePlace = nombreDePlace;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}	
}
