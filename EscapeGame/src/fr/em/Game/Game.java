package fr.em.Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import fr.em.modeChallenge.ChallengeMain;
import fr.em.modeDefenseur.DefenseurMain;
import fr.em.modeDuel.DuelMain;

public class Game {

	private static final Logger LOG = Logger.getLogger(Game.class);
	InputStream input;

	private int size; // Taille de la combinaison //

	int nbEssaysMax; // nombre d'essais maximum //

	String modeDeveloppeur; // mode développeur (activé ou non) //
	static boolean modeDev = false;

	/**
	 * Constructeurs
	 */
	public Game() {
		try {
			input = new FileInputStream("config.properties");
			Properties prop = new Properties();

			// load propoerties file //

			prop.load(input);
			setSize(Integer.parseInt(prop.getProperty("size")));
			nbEssaysMax = Integer.parseInt(prop.getProperty("nombre.essai"));
			if (modeDev) {
				modeDeveloppeur = "active";
			} else {
				modeDeveloppeur = (prop.getProperty("mode.developpeur"));
			}
		} catch (IOException ex) {
			LOG.error("Problème de téléchargement du fichier de configuration");
		}
	}

	public static void main(String args[]) {

		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "log4j.xml";
		DOMConfigurator.configure(log4jConfigFile);

		LOG.debug("this is a debug log message");
		LOG.info("this is a information log message");
		LOG.warn("this is a warning log message");

		int nbChoix = 0;
		int nbMode = 0;

		LOG.info("Debut de jeu!!!!");
		do {
			System.out.println("Bienvenue dans le jeux Escape Game, vous pouvez choisir :");
			System.out.println("le Numéro 1 pour le mode Challenger");
			System.out.println("le numéro 2 pour le mode Defenseur");
			System.out.println("le numéro 3 pour le mode Duel");
			System.out.print("Choisissez un numéro SVP : ");

			Scanner scMode = new Scanner(System.in);
			Scanner scChoix = new Scanner(System.in);

			try {

				nbMode = scMode.nextInt();
			} catch (Exception e) {
				System.out.println("Error de saisi.....");
				System.out.println("Saisir uniquement des chiffres SVP...");
			}

			switch (nbMode) {

			case 1:
				System.out.println("Vous avez choisi le mode Challenger. ");
				LOG.info("Vous avez choisi le mode Challenger. ");
				ChallengeMain challenge = new ChallengeMain();
				challenge.afficherResultatChallenger();
				break;
			case 2:
				LOG.info("Vous avez choisi le mode Defenseur. ");
				System.out.println("Vous avez choisi le mode Defenseur.");
				DefenseurMain defenseur = new DefenseurMain();
				try {
					defenseur.afficherResultatDefenseur();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				break;
			case 3:
				LOG.info("Vous avez choisi le mode Duel. ");
				System.out.println("Vous avez choisi le mode Duel.");
				DuelMain duel = new DuelMain();
				duel.afficherReponsetDuel();

				break;

			case 4:
				System.out.println("Ce mode de jeu n'existe pas!!!.");
				System.out.println(" Choisir le numéro 1 ou le numéro 2 ou le numéro 3");
				break;

			default:
				System.out.println(" Choisir le numéro 1 ou le numéro 2 ou le numéro 3 ");
				break;
			}
			do {
				System.out.println("1 : Recommencer");
				System.out.println("2 : Retour au menu principal ");
				System.out.println("3 : Fermer l'application ");
				try {
					nbChoix = scChoix.nextInt();
				} catch (Exception e) {
					System.out.println("Erreur saisi nbChoix !!!");
					System.out.println("Saisir uniquement des chiffres nbChoix SVP...");
				}

				switch (nbChoix) {
				case 1:
					if (nbMode == 1) {

						System.out.println("Vous avez choisi le mode Challenger. ");
						LOG.info("Vous avez choisi le mode Challenger. ");
						ChallengeMain challenge = new ChallengeMain();
						challenge.afficherResultatChallenger();
						break;

					}
					if (nbMode == 2) {
						LOG.info("Vous avez choisi le mode Defenseur. ");
						System.out.println("Vous avez choisi le mode Defenseur.");
						DefenseurMain defenseur = new DefenseurMain();
						try {
							defenseur.afficherResultatDefenseur();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						break;
					}
					if (nbMode == 3) {
						LOG.info("Vous avez choisi le mode Duel. ");
						System.out.println("Vous avez choisi le mode Duel.");
						DuelMain duel = new DuelMain();
						duel.afficherReponsetDuel();

						break;

					}

					
				case 2:
					System.out.println("Retour au menu principal..." + "\n");
					LOG.trace("Retour au menu principal");
					break;
				case 3:
					System.out.println("Merci d'avoir joué avec nous. Au revoir...");
					scChoix.close();
					scMode.close();

					break;
				default:
					System.out.println("Veuillez saisir une valeur correcte...");
					nbChoix = 2;
				}
			} while (nbChoix == 1);
			
		} while (nbChoix == 2);

		LOG.info("Fermeture de l'application");

	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
