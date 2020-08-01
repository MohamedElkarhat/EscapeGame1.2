package fr.em.Game;

import java.util.Random;

//import fr.em.Game.Game;

public class IAOrdinateur extends Game implements IOrdi {

	private int[] numOrdi = new int[getSize()];
	private Random rand = new Random();
	int[] min = { 0, 0, 0, 0 }; // contient la valeur minimal de chaque chiffre
	int[] max = { 9, 9, 9, 9 }; // contient la valeur maximum de chaque chiffre
	int combSecrete;
	String[] reponse = new String[getSize()];

	public int[] ordiCombinaisonSecrete() {

		 combSecrete = rand.nextInt(9000) + 1000;

		System.out.println("Voici la combinaison secrète orinateur : " + combSecrete);

		String str = String.valueOf(combSecrete);
		for (int i = 0; i < str.length(); i++) {

			numOrdi[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
		}
		return numOrdi;
	}

	private int[] proposition = new int[getSize()];

	

	public int[] ordiProposition() {

		for (int i = 0; i < 4; i++) {
			proposition[i] = (int) rand.nextInt(max[i] - min[i] + 1) + min[i];
		}

		return proposition;
	}

	public int[] generateNewProp(int[] secretCombination, int[] firstProposition) {
		Random rdProp2 = new Random();

		for (int i = 0; i < secretCombination.length; i++) {

			if (secretCombination[i] < firstProposition[i]) {
				max[i] = firstProposition[i];
				proposition[i] = rdProp2.nextInt(this.max[i]);
				reponse[i] = "-";
			} else if (secretCombination[i] > firstProposition[i]) {
				min[i] = firstProposition[i];
				proposition[i] = rdProp2.nextInt((max[i] - min[i]) + 1) + (min[i] + 1);
				reponse[i] = "+";
			} else {
				reponse[i] = "=";
			}
		}
		return proposition;
	}

	public int[] getNumOrdi() {
		return numOrdi;
	}

	public void setNumOrdi(int[] numOrdi) {
		this.numOrdi = numOrdi;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}
	public int getCombSecrete() {
		return combSecrete;
	}

	public void setCombSecrete(int combSecrete) {
		this.combSecrete = combSecrete;
	}

}
