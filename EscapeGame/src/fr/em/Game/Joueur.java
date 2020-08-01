package fr.em.Game;

import java.util.Random;
import java.util.Scanner;

import fr.em.Game.Game;

public class Joueur extends Game {

	private int[] proposition = new int[getSize()];
	String prop;
	String combSecrete;
	private int[] numSecret = new int[getSize()];
	private Random rand = new Random();
	boolean isNumber;

	Scanner input = new Scanner(System.in);

	public int[] joueurProposition() {

		
			try {
				do {

				System.out.print("proposition joueur: ");

				if(input.hasNextInt()) {
				try {
					prop = input.next();
				if (prop.length() < 4) {
					throw new ArrayIndexOutOfBoundsException();
				}
				}catch(Exception e) {
					System.out.println("Erreur saisi nbChoix !!!");
					System.out.println("Saisir uniquement des chiffres  SVP...");
				}	
					if (prop.length() == 4) {
						isNumber = true;
					}	
					} else {
						System.out.println("Erreur de saisi!!!! ");
						//System.out.print("Entrer un numero de 4 chiffres : ");
						isNumber = false;
						input.next();
					}
					
				} while (!(isNumber));
					
				for (int i = 0; i < prop.length(); i++) {

					proposition[i] = Integer.parseInt(String.valueOf(prop.charAt(i)));

					if (proposition.length < 4) {
						System.out.println("saisire un numèro de 4 chiffres SVP!!!!!! ");
					}
				}
				}catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Saisir un numero Max de 4 chiffres SVP ??????");

					}catch(NumberFormatException e) {
						System.out.println("Saisir un numero Max de 4 chiffres et pas de caracrtère SVP ??????");
					}

		//	} while (!(isNumber));
			
		
			return proposition;
	}

			/*	System.out.println("Votre proposition est: " + prop);

				for (int i = 0; i < prop.length(); i++) {

					proposition[i] = Integer.parseInt(String.valueOf(prop.charAt(i)));
					
					}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Saisir un numero Max de 4 chiffres SVP ??????");

			}catch(NumberFormatException e) {
				System.out.println("Saisir un numero Max de 4 chiffres et pas de caracrtère SVP ??????");
			}
		} while (prop.length() != 4);

		return proposition;

	}*/

	public int[] joueurCombinaisonSecrete() {

		System.out.print("Saisir votre combinaison secrète....");
		try {
			combSecrete = input.nextLine();

			System.out.println("Voici la combinaison secrète de joueur : " + combSecrete);

			String str = String.valueOf(combSecrete);
			for (int i = 0; i < str.length(); i++) {

				numSecret[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
			}
		} catch (Exception e) {
			System.out.println("Saisir un numero de 4 chiffres SVP");
		}
		return numSecret;
	}

	public int[] getProposition() {
		return proposition;
	}

	public void setProposition(int[] proposition) {
		this.proposition = proposition;
	}

}