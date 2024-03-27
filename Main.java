import javateca.*;

import java.util.*;



public class Main
{

	public static void main(String[] args)
	{
		Database database = new Database();

		database.addCategorie(new Categorie("Stiinta"));
		database.addCategorie(new Categorie("Aventura"));

		database.addCarte(new Carte("Decul albastru? DC?", "Stiinta"));
		database.addCarte(new Carte("Facultate frate", "Aventura"));
		database.addCarte(new Carte("Nu inversa polaritatea ca explodeaza", "Stiinta"));

		database.addAngajat(new Stagiar("Florescu", "Finante", "Piata Romana", "Bogdan"));
		database.addAngajat(new Angajat("Bogdan", "Resurse umane", "Calea Victoriei"));
		database.addAngajat(new Angajat("Ilie", "Relatii cu clientii", "Piata Universitatii"));

		database.addClient(new Client("Florescu"));
		database.addClient(new Client("Bogdan"));
		database.addClient(new Client("Ilie"));

		System.out.println(database.findCarte("Facultate frate").getCategorie());

		database.imprumutaCarte(new Carte("Decul albastru? DC?", "Stiinta"), new Client("Florescu"));

		database.returneazaCarte(new Carte("Facultate frate", "Aventura"), new Client("Bogdan"));

		System.out.println("");

		TreeSet<Carte> carti = database.cartiDinCategorie(new Categorie("Stiinta"));

		for (Carte carte : carti)
		{
			System.out.println(carte.getNume());
		}

		System.out.println("");

		TreeSet<Angajat> angajati = database.angajatiDinDepartament(new Departament("Relatii cu clientii"));

		for (Angajat angajat : angajati)
		{
			System.out.println(angajat.getNume());
		}

		System.out.println("");

		angajati = database.angajatiDinSediu(new Sediu("Calea Victoriei"));

		for (Angajat angajat : angajati)
		{
			System.out.println(angajat.getNume());
		}
	}

}
