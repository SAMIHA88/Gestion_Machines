package entities;

import java.util.Date;

public class Machine {

	private int id;
	private String reference;
	private String marque;
	private double prix;
	private Date dateAchat;
	private Salle salle;
	private static int comp;

	public Machine(String reference, String marque, double prix, Date dateAchat, Salle salle) {
		this.reference = reference;
		this.marque = marque;
		this.prix = prix;
		this.dateAchat = dateAchat;
		this.salle = salle;
	}
	
	

	public Machine(int id, String reference, String marque, double prix, Date dateAchat, Salle salle) {
		this.id = id;
		this.reference = reference;
		this.marque = marque;
		this.prix = prix;
		this.dateAchat = dateAchat;
		this.salle = salle;
	}



	public String getReference() {
		return reference;
	}



	public void setReference(String reference) {
		this.reference = reference;
	}



	public String getMarque() {
		return marque;
	}



	public void setMarque(String marque) {
		this.marque = marque;
	}



	public double getPrix() {
		return prix;
	}



	public void setPrix(double prix) {
		this.prix = prix;
	}



	public Date getDateAchat() {
		return dateAchat;
	}



	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Salle getSalle() {
		return salle;
	}



	public void setSalle(Salle salle) {
		this.salle = salle;
	}



	public int getId() {
		return id;
	}



	@Override
	public String toString() {
		return "Machine [id=" + id + ", reference=" + reference + ", marque=" + marque + ", prix=" + prix
				+ ", dateAchat=" + dateAchat + "]";
	}
	
	
}
