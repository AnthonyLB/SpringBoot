package poe.spring.form;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class TrajetForm {
	
	@NotNull
	private String villeDepart;
	@NotNull
	private String villeArrivee;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDepart;
	@NotNull
	private long prix;
	@NotNull
	private int nombreDePlace;
	
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
}
