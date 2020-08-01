package fr.em.modeDefenseur;

import java.util.Random;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.em.Game.Game;
import fr.em.Game.IAOrdinateur;

import fr.em.Game.Joueur;



public class DefenseurMain extends Game {

	private static final Logger LOG = LogManager.getLogger(DefenseurMain.class);

	int[] combSecrete = new int[getSize()]; // contient la combinaison secrete
	int[] proposition = new int[getSize()]; // contient la proposition de IAOrdinateur
	int[] resulta = new int[getSize()]; // contient le resultat finale
	int[] min = { 0, 0, 0, 0 }; // contient la valeur minimal de chaque chiffre
	int[] max = { 9, 9, 9, 9 }; // contient la valeur maximum de chaque chiffre

	boolean[] chiffreTrouve = new boolean[getSize()]; // contient le statut de chaque chiffre trouvé ou non.

	String reponse;
	int count = 0;

	public DefenseurMain() {

	}

	IAOrdinateur ordi = new IAOrdinateur();
	Joueur jou = new Joueur();
	Random random = new Random();
	Scanner sc;

	public void afficherResultatDefenseur() throws Exception {
		LOG.trace("Debut method Afficher Resultat Defenseur!!!!!!");

		System.out.println("Règles du jeu :");
		System.out.println("Vous définissez une combinaison à 4 chiffres. ");
		System.out.println("L'IA à 4 essais pour décovurir votre combinaison" + "\n");

		combSecrete = jou.joueurCombinaisonSecrete();//definireUneCombinaison();
		//proposition = ordi.GenererNumeroAleatoir();//propositionAleatoir();

		while (chiffreTrouve[0] == false || chiffreTrouve[1] == false || chiffreTrouve[2] == false
				|| chiffreTrouve[3] == false) {

			count++;
			if (count > 4) {
				System.out.println("Dèsolé IA, vous avez fait 4 essai et vous avez perdu!!");
				LOG.debug("Vous avez PERDU !!!!!!   ");
				break;
			}
			try {
				for (int i = 0; i < 4; i++) {
					if (chiffreTrouve[i] == false) {
						proposition[i] = (int) random.nextInt(max[i] - min[i] + 1) + min[i];
					}

				}

			} catch (ArrayIndexOutOfBoundsException e) {
			//	System.out.println(" Saisir un numero maximum de 4 chiffres SVP!!!! ");
				//LOG.error("Erreur de Saisie!!!!");

			} catch (NumberFormatException e) {
			//	System.out.println(" Saisir un numeros de 4 chiffres et pas des caractères SVP!!!! ");
			//	LOG.error("Erreur de Saisie!!!!");
			} catch (IllegalArgumentException e) {
			//	System.out.println(" Saisir un numeros de 4 chiffres et pas des caractères SVP!!!! ");
				//LOG.error("Erreur de Saisie!!!!");
			}
			System.out.println("Proposition IA " + proposition[0] + "" + proposition[1] + "" + proposition[2] + ""
					+ proposition[3]);

			System.out.print("-> Réponse Joueur:");

			sc = new Scanner(System.in);
			try {
				reponse = sc.nextLine();

			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("saisir des caractères : +-=");
			} catch (Exception e) {
				System.out.println("saisir des caractères : '+''-''='");
			}
			LOG.info("REPONSE !!!!!!!!" + reponse);
			for (int i = 0; i < reponse.length(); i++) {

			}

			// test de la reponse saisie pour 4 chiffres,
			// plus grand (+), plus petit (-) Ok (=).
			for (int i = 0; i < 4; i++) {

				// si la proposition est petite on met la valeur "+"
				if (reponse.substring(i, i + 1).equals("+")) {
					min[i] = proposition[i] + 1;
				}
				// si la proposition est grande on met la valeur "-"
				if (reponse.substring(i, i + 1).equals("-")) {
					max[i] = proposition[i] - 1;
				}
				// si la proposition est égale a la combinaison secrete
				if (reponse.substring(i, i + 1).equals("=")) {
					resulta[i] = proposition[i];
					chiffreTrouve[i] = true;

					// on fixe les min et max pour ne pas génerer des aleatoires inutile
					min[i] = proposition[i];
					max[i] = proposition[i];
				}
			}
			if (chiffreTrouve[0] == true && chiffreTrouve[1] == true && chiffreTrouve[2] == true
					&& chiffreTrouve[3] == true) {
				System.out.println(" Bravo l'IA vous avez trouvé la combinaison : " + resulta[0] + "" + resulta[1] + ""
						+ resulta[2] + "" + resulta[3] + " en  " + count + " essais");
				System.out.println("Vous voulez rejouer ? ");
				System.out.println("SVP Choisissez le numéro : ");

			}

		}

	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	/*public static void main(String[] str) {

		DefenseurMain cont = new DefenseurMain();
		try {
			cont.afficherResultatDefenseur();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

}
