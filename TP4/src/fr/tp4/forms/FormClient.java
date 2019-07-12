package fr.tp4.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.tp4.beans.Client;

public final class FormClient {
	public static final String CHAMP_NOM = "nomClient";
	public static final String CHAMP_PRENOM = "prenomClient";
	public static final String CHAMP_ADRESSE = "adresseClient";
	public static final String CHAMP_TELEPHONE = "telephoneClient";
	public static final String CHAMP_EMAIL = "emailClient";

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Client creationClient(HttpServletRequest request) {
		String nom = getValeurChamp(request, CHAMP_NOM);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);
		String adresse = getValeurChamp(request, CHAMP_ADRESSE);
		String telephone = getValeurChamp(request, CHAMP_TELEPHONE);
		String email = getValeurChamp(request, CHAMP_EMAIL);

		Client client = new Client();

		try {
			validationNom(nom);
		} catch (Exception e) {
			setErreur(CHAMP_NOM, e.getMessage());
		}
		client.setNom(nom);

		try {
			validationPrenom(prenom);
		} catch (Exception e) {
			setErreur(CHAMP_PRENOM, e.getMessage());
		}
		client.setPrenom(prenom);

		try {
			validationAdresse(adresse);
		} catch (Exception e) {
			setErreur(CHAMP_ADRESSE, e.getMessage());
		}
		client.setAdresse(adresse);

		try {
			validationTelephone(telephone);
		} catch (Exception e) {
			setErreur(CHAMP_TELEPHONE, e.getMessage());
		}
		client.setTelephone(telephone);

		try {
			validationEmail(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		client.setEmail(email);

		if (erreurs.isEmpty()) {
			resultat = "Succès de Création du Client.";
		} else {
			resultat = "Le formulaire comporte des erreurs.";
		}

		return client;
	}

	private void validationNom(String nom) throws Exception {
		if (nom == null || nom.length() < 2) {
			throw new Exception("Le nom du client doit contenir au moins 2 caractères.");
		}
	}

	private void validationPrenom(String prenom) throws Exception {
		if (prenom != null && prenom.length() < 2) {
			throw new Exception("Le prénom du client doit contenir au moins 2 caractères.");
		}
	}

	private void validationAdresse(String adresse) throws Exception {
		if (adresse == null || adresse.length() < 10) {
			throw new Exception("L'adresse du client doit contenir au moins 10 caractères.");
		}
	}

	private void validationEmail(String email) throws Exception {
		if (email != null) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new Exception("Merci de saisir une adresse mail valide.");
			}
		}
	}

	private boolean estUnEntier(String telephone) {
		try {
			Integer.parseInt(telephone);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	private void validationTelephone(String telephone) throws Exception {
		if (telephone == null || telephone.length() < 4 || !estUnEntier(telephone)) {
			throw new Exception("Le numéro de téléphone client doit contenir des numéros et au minimum 4.");
		}
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur.trim();
		}
	}

}
