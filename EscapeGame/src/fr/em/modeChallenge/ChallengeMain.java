package fr.em.modeChallenge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.em.Game.Game;
import fr.em.Game.IAOrdinateur;
import fr.em.Game.Joueur;


public class ChallengeMain extends Game {

	private static final Logger LOG = LogManager.getLogger(ChallengeMain.class);
	int[] numAleatoir;
	int[] numJoueur;
	int count;
	boolean num = true;

	IAOrdinateur ordi = new IAOrdinateur();
	//Joueur1 jou = new Joueur1();
	Joueur jou = new Joueur();
			
	//Joueur jou = new Joueur();

	// Constructeur de default
	public ChallengeMain() {
		int[] numAleatoir = new int[getSize()];
		int[] numJoueur = new int[getSize()];
		int count = 0;
	}

	// Method afficher le resultat de la combinaison secrete.
	public void afficherResultatChallenger() {

		System.out.println("Règle du jeu : ");
		System.out.println("L'IA définit une combinaison de 4 chiffres  ");
		System.out.println("vous avez 4 essais pour trouver cette combinaison !");

		numAleatoir = ordi.ordiCombinaisonSecrete() ;//GenererNumeroAleatoir();
		do {
			count++;
			if (count > 4) {
				break;
			}
			for (int i = 0; i < numAleatoir.length; i++) {
			}
			try {
				try {

					do {

						numJoueur = jou. joueurProposition() ;//ProposerUnNumero();
						for (int i = 0; i < numJoueur.length; i++) {

							int[] proposition = null;
							proposition[i] = Integer.parseInt(String.valueOf(numJoueur[i]));
						}

						if (numJoueur.length < 4) {

						}
					} while (num);
				} catch (Exception e) {
					// System.out.println("Saisire un numèro de 4 chiffres SVP ");
				}

				for (int i = 0; i < numJoueur.length; i++) {
				}
				if (numAleatoir[0] == numJoueur[0]) {
					System.out.print("-> Réponse:" + " =");
				} else if (numAleatoir[0] < (numJoueur[0])) {
					System.out.print("-> Réponse:" + " -");
				} else {
					System.out.print("-> Réponse:" + " +");
				}

				if (numAleatoir[1] == numJoueur[1]) {
					System.out.print("=");
				} else if ((numAleatoir[1] < numJoueur[1])) {
					System.out.print("-");
				} else {
					System.out.print("+");
				}

				if (numAleatoir[2] == numJoueur[2]) {
					System.out.print("=");
				} else if ((numAleatoir[2] < numJoueur[2])) {
					System.out.print("-");
				} else {
					System.out.print("+");
				}

				if (numAleatoir[3] == numJoueur[3]) {
					System.out.println("=");
				} else if ((numAleatoir[3] < numJoueur[3])) {
					System.out.println("-");
				} else {
					System.out.println("+");
				}
				if (numJoueur.length < 4) {
					throw new IllegalArgumentException("Saisire un numèro de 4 chiffres SVP ");

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(" Saisir un numero maximum de 4 chiffres SVP!!!! ");
				LOG.error("Error de saisi !!!!!! ");
			} catch (NumberFormatException e) {
				System.out.println(" Saisir un numero de 4 chiffres et pas des caractères SVP!!!! ");
				LOG.error("Error de saisi !!!!!! ");
			} catch (IllegalArgumentException e) {
				System.out.println(" Saisir un numero de 4 chiffres SVP!!!! ");
				LOG.error("Error de saisi !!!!!! ");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} while (numAleatoir[0] != numJoueur[0] || numAleatoir[1] != numJoueur[1] || numAleatoir[2] != numJoueur[2]
				|| numAleatoir[3] != numJoueur[3]);
		if (count > 4) {
			System.out.println("Le nombre d'essais est 4, Désolé vous l'avez dépassé et vous avez perdu! ");
		} else {
			System.out.println("Bravo joueur vous avez gagné, vous avez trouvez la combinaison secrète :"
					+ ordi.getCombSecrete() + " en " + count + " essai(s) ");
			System.out.println("Vous voulez rejouer ? ");
			System.out.println("SVP Choisissez le numéro: ");

		}
	}

	/*public static void main(String args[]) {
		ChallengeMain challenge = new ChallengeMain();
		challenge.afficherResultatChallenger();
	}
*/
}
