import javateca.model.*;
import javateca.repository.*;
import javateca.repository.impl.*;
import javateca.service.*;
import javateca.service.impl.*;

import java.sql.*;
import java.util.List;



public class Main
{

	public static void main(String[] args)
	{
		try
		{
			Database database;

			database = DatabaseImpl.getInstance();

			{
				List<Angajat> angajati = database.getAngajatSauStagiar();
				List<Carte> carti = database.getCarte();
				List<Categorie> categorii = database.getCategorie();
				List<Client> client = database.getClient();
				List<Departament> departamente = database.getDepartament();
				List<Imprumut> imprumuturi = database.getImprumut();
				List<Sediu> sedii = database.getSediu();
			}

			Biblioteca biblioteca = new BibliotecaImpl(database);

			biblioteca.addAngajatSauStagiar(new Stagiar("Stefanescu Darius", "HR", "Piata Romana", "Popescu Paul"));
			biblioteca.addCarte(new Carte("Nano-biology", "Stiinta"));
			biblioteca.addCategorie(new Categorie("Arta"));
			biblioteca.addClient(new Client("Prala Tudor"));
			Carte carte = biblioteca.findCarte("Nano-biology");
			biblioteca.imprumutaCarte("Nano-biology", "Prala Tudor");
			biblioteca.returneazaCarte("Nano-biology", "Prala Tudor");
			List<Carte> cartiDinCategorie = biblioteca.getCartiDinCategorie("Stiinta");
			List<Angajat> angajatiSauStagiariDinDepartament = biblioteca.getAngajatSauStagiarDinDepartament("HR");
			List<Angajat> angajatiSauStagiariDinSediu = biblioteca.getAngajatSauStagiarDinSediu("Piata Romana");
		}
		catch (SQLException exception)
		{
			System.out.println(exception.getMessage());
			return;
		}
	}

}
