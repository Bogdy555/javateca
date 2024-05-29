import javateca.model.*;
import javateca.repository.*;
import javateca.repository.impl.*;

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
		}
		catch (SQLException exception)
		{
			System.out.println(exception.getMessage());
			return;
		}
	}

}
