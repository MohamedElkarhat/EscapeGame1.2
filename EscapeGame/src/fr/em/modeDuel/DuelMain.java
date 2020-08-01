package fr.em.modeDuel;

import fr.em.Game.Game;
import fr.em.Game.IAOrdinateur;
import fr.em.Game.Joueur;

public class DuelMain extends Game {

	int[] cmbOrdi = new int[getSize()];
	int[] cmbJouer = new int[getSize()];
	int[] propOrdi = new int[getSize()];
	int[] propJoeur = new int[getSize()];
	int[] proposition = new int[getSize()];
	int[] max = new int[] { 9, 9, 9, 9 };
	int[] min = new int[] { 0, 0, 0, 0 };

	boolean resultatReponse = false;

	String[] reponse = new String[getSize()];
	int count = 0;

	public void afficherReponsetDuel() {

		System.out.println("Règles du jeu :");
		System.out.println(
				"Vous jouez à tour de rôle avec l'IA, le premier à découvrir la combinaison de l'autre remporte la partie. ");
		System.out.println("N'oubliez pas, vous n'avez que 4 essais !" + "\n");
		IAOrdinateur ordi = new IAOrdinateur();
		Joueur jou = new Joueur();
		cmbOrdi = ordi.ordiCombinaisonSecrete();
		cmbJouer = jou.joueurCombinaisonSecrete();

		do {

			propJoeur = jou.joueurProposition();

			int i, j;

			for (i = 0; i < cmbOrdi.length; i++) {
			}
			for (j = 0; j < propJoeur.length; j++) {
			}
			for (int k = 0; k < reponse.length; k++) {
			}
			count++;

			System.out.print("Rèponse : ");
			if (cmbOrdi[0] < propJoeur[0]) {
				reponse[0] = "-";
				System.out.print(reponse[0]);
			} else if (cmbOrdi[0] > propJoeur[0]) {
				reponse[0] = "+";
				System.out.print(reponse[0]);
			} else {
				reponse[0] = "=";
				System.out.print(reponse[0]);
			}
			if (cmbOrdi[1] < propJoeur[1]) {

				reponse[1] = "-";
				System.out.print(reponse[1]);

			} else if (cmbOrdi[1] > propJoeur[1]) {

				reponse[1] = "+";
				System.out.print(reponse[1]);

			} else {
				reponse[1] = "=";
				System.out.print(reponse[1]);
			}
			if (cmbOrdi[2] < propJoeur[2]) {

				reponse[2] = "-";
				System.out.print(reponse[2]);

			} else if (cmbOrdi[2] > propJoeur[2]) {

				reponse[2] = "+";
				System.out.print(reponse[2]);

			} else {
				reponse[2] = "=";
				System.out.print(reponse[2]);
			}
			if (cmbOrdi[3] < propJoeur[3]) {

				reponse[3] = "-";
				System.out.println(reponse[3]);

			} else if (cmbOrdi[3] > propJoeur[3]) {

				reponse[3] = "+";
				System.out.println(reponse[3]);

			} else {
				reponse[3] = "=";
				System.out.println(reponse[3]);
			}

			resultatReponse = ResultGame(reponse);
			if (resultatReponse == true) {
				System.out.println("Bravo ! Vous avez trouvé la combinaison de l'IA et vous remportez la partie ! ");

				break;
			} else {
				System.out.println("Désole Joueur c'est pas la bonne réponse !!!!!!" + "\n");
			}

			if (count <= 1) {
				propOrdi = ordi.ordiProposition();
				System.out.print("Proposition de l'IA : ");
				for (int l = 0; l < propOrdi.length; l++) {
					System.out.print(propOrdi[l]);
				}
				System.out.println();

			} else {
				propOrdi = ordi.generateNewProp(cmbJouer, propOrdi);
				System.out.print("Proposition IA ");
				for (int l = 0; l < propOrdi.length; l++) {
					System.out.print(propOrdi[l]);
				}
				System.out.println();
			}
			reponse = compare(cmbJouer, propOrdi);
			System.out.print("Réponse : ");
			putReponse(reponse);
			resultatReponse = ResultGame(reponse);
			if (resultatReponse == true) {
				System.out.println("Bravo !!!L'IA à découvert votre combinaison ");
				break;
			} else {
				System.out.println("L'IA n'as pas trouvé votre combinaison..." + "\n");
			}
			count++;

		} while (!resultatReponse && count < 8);

		if (count == 8 || resultatReponse != true) {
			System.out.println("La combinaison de l'IA était : ");

			putResultCombi(cmbOrdi);
			System.out.println("Le nombre d'essais est 4, Désolé vous l'avez dépassé et vous avez perdu! ");
		}

		System.out.println("Fin de la partie.");
	}

	public void putResultCombi(int[] tableau) {
		System.out.print("CombSecrete  : ");
		for (int i = 0; i < tableau.length; i++) {
			System.out.print(tableau[i]);
		}
		System.out.print("\n");
	}

	public String[] compare(int[] combination, int[] proposition) {
		int i = 0;
		do {
			if (combination[i] < proposition[i]) {
				reponse[i] = "-";
			} else if (combination[i] > proposition[i]) {
				reponse[i] = "+";
			} else {
				reponse[i] = "=";
			}

			i++;
		} while (i < 4);
		return reponse;
	}

	public void putReponse(String[] tableau) {
		for (int i = 0; i < tableau.length; i++) {
			System.out.print(tableau[i]);

		}
		System.out.println("\n");
	}

	public boolean ResultGame(String[] response) {
		boolean reultat = true;

		for (int i = 0; i < response.length; i++) {
			if (response[i].equals("+") || response[i].equals("-")) {
				reultat = false;
			}
		}
		return reultat;
	}

/*	public static void main(String[] args) {

		DuelMain duel = new DuelMain();
		duel.afficherReponsetDuel();

	}*/

}