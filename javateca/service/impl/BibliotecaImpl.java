package javateca.service.impl;



import javateca.model.*;
import javateca.service.*;
import javateca.repository.*;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;



public class BibliotecaImpl implements Biblioteca
{

	private Database database;

	public BibliotecaImpl(Database database)
	{
		this.database = database;
	}

	public void addAngajatSauStagiar(Angajat angajat) throws SQLException
	{
		database.addLog(new Log("addAngajatSauStagiar"));
		database.addAngajatSauStagiar(angajat);
	}

	public void addCarte(Carte carte) throws SQLException
	{
		database.addLog(new Log("addCarte"));
		database.addCarte(carte);
	}

	public void addCategorie(Categorie categorie) throws SQLException
	{
		database.addLog(new Log("addCategorie"));
		database.addCategorie(categorie);
	}

	public void addClient(Client client) throws SQLException
	{
		database.addLog(new Log("addClient"));
		database.addClient(client);
	}

	public Carte findCarte(String nume) throws SQLException
	{
		database.addLog(new Log("findCarte"));

		List<Carte> carti = database.getCarte();

		for (Carte carte : carti)
		{
			if (carte.getNume() == nume)
			{
				return carte;
			}
		}

		return null;
	}

	public void imprumutaCarte(String carte, String client) throws SQLException
	{
		database.addLog(new Log("imprumutaCarte"));
		database.addImprumut(new Imprumut(carte, client));
	}

	public void returneazaCarte(String carte, String client) throws SQLException
	{
		database.addLog(new Log("returneazaCarte"));
		database.removeImprumut(carte, client);
	}

	public List<Carte> getCartiDinCategorie(String categorie) throws SQLException
	{
		database.addLog(new Log("getCartiDinCategorie"));

		List<Carte> carti = database.getCarte();

		List<Carte> result = new ArrayList<Carte>();

		for (Carte carte : carti)
		{
			if (carte.getCategorie() == categorie)
			{
				result.add(carte);
			}
		}

		return result;
	}

	public Set<Angajat> getAngajatSauStagiarDinDepartament(String departament) throws SQLException
	{
		database.addLog(new Log("getAngajatSauStagiarDinDepartament"));

		List<Angajat> angajati = database.getAngajatSauStagiar();

		Set<Angajat> result = new TreeSet<Angajat>();

		for (Angajat angajat : angajati)
		{
			if (angajat.getDepartament() == departament)
			{
				result.add(angajat);
			}
		}

		return result;
	}

	public Set<Angajat> getAngajatSauStagiarDinSediu(String sediu) throws SQLException
	{
		database.addLog(new Log("getAngajatSauStagiarDinSediu"));

		List<Angajat> angajati = database.getAngajatSauStagiar();

		Set<Angajat> result = new TreeSet<Angajat>();

		for (Angajat angajat : angajati)
		{
			if (angajat.getSediu() == sediu)
			{
				result.add(angajat);
			}
		}

		return result;
	}

	public List<Log> getLog() throws SQLException
	{
		database.addLog(new Log("getLog"));
		return database.getLog();
	}

}
