package javateca.service.impl;



import javateca.model.*;
import javateca.service.*;
import javateca.repository.*;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;



public class BibliotecaImpl implements Biblioteca
{

	private Database database;

	public BibliotecaImpl(Database database)
	{
		this.database = database;
	}

	public void addAngajatSauStagiar(Angajat angajat) throws SQLException
	{
		database.addAngajatSauStagiar(angajat);
	}

	public void addCarte(Carte carte) throws SQLException
	{
		database.addCarte(carte);
	}

	public void addCategorie(Categorie categorie) throws SQLException
	{
		database.addCategorie(categorie);
	}

	public void addClient(Client client) throws SQLException
	{
		database.addClient(client);
	}

	public Carte findCarte(String nume) throws SQLException
	{
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
		database.addImprumut(new Imprumut(carte, client));
	}

	public void returneazaCarte(String carte, String client) throws SQLException
	{
		database.removeImprumut(carte, client);
	}

	public List<Carte> getCartiDinCategorie(String categorie) throws SQLException
	{
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

	public List<Angajat> getAngajatSauStagiarDinDepartament(String departament) throws SQLException
	{
		List<Angajat> angajati = database.getAngajatSauStagiar();

		List<Angajat> result = new ArrayList<Angajat>();

		for (Angajat angajat : angajati)
		{
			if (angajat.getDepartament() == departament)
			{
				result.add(angajat);
			}
		}

		return result;
	}

	public List<Angajat> getAngajatSauStagiarDinSediu(String sediu) throws SQLException
	{
		List<Angajat> angajati = database.getAngajatSauStagiar();

		List<Angajat> result = new ArrayList<Angajat>();

		for (Angajat angajat : angajati)
		{
			if (angajat.getSediu() == sediu)
			{
				result.add(angajat);
			}
		}

		return result;
	}

}
