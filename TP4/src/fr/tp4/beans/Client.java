package fr.tp4.beans;

public class Client {
	/* Propriétés du bean */
	private static int id = 0;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Client() {
		this.id++;
	}

	public String getNom() {
		return nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}
}