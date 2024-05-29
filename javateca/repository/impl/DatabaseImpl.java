package javateca.repository.impl;



import javateca.model.*;
import javateca.repository.*;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;



public class DatabaseImpl implements Database
{

	private static Database instance;

	private Connection connection;

	private DatabaseImpl() throws SQLException
	{
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javateca", "postgres", "GitHub_Bogdy555");

		try { connection.prepareStatement("DROP TABLE LOG;").executeUpdate(); } catch (SQLException exception) { }
		try { connection.prepareStatement("DROP TABLE DEPARTAMENT;").executeUpdate(); } catch (SQLException exception) { }
		try { connection.prepareStatement("DROP TABLE SEDIU;").executeUpdate(); } catch (SQLException exception) { }
		try { connection.prepareStatement("DROP TABLE ANGAJAT_SAU_STAGIAR;").executeUpdate(); } catch (SQLException exception) { }
		try { connection.prepareStatement("DROP TABLE CATEGORIE;").executeUpdate(); } catch (SQLException exception) { }
		try { connection.prepareStatement("DROP TABLE CARTE;").executeUpdate(); } catch (SQLException exception) { }
		try { connection.prepareStatement("DROP TABLE CLIENT;").executeUpdate(); } catch (SQLException exception) { }
		try { connection.prepareStatement("DROP TABLE IMPRUMUT;").executeUpdate(); } catch (SQLException exception) { }

		connection.prepareStatement("CREATE TABLE LOG (NUME VARCHAR(100), MOMENT TIMESTAMP DEFAULT CURRENT_TIMESTAMP);").executeUpdate();
		connection.prepareStatement("CREATE TABLE DEPARTAMENT (NUME VARCHAR(100));").executeUpdate();
		connection.prepareStatement("CREATE TABLE SEDIU (ADRESA VARCHAR(100));").executeUpdate();
		connection.prepareStatement("CREATE TABLE ANGAJAT_SAU_STAGIAR (NUME VARCHAR(100), DEPARTAMENT VARCHAR(100), SEDIU VARCHAR(100), MENTOR VARCHAR(100));").executeUpdate();
		connection.prepareStatement("CREATE TABLE CATEGORIE (NUME VARCHAR(100));").executeUpdate();
		connection.prepareStatement("CREATE TABLE CARTE (NUME VARCHAR(100), CATEGORIE VARCHAR(100));").executeUpdate();
		connection.prepareStatement("CREATE TABLE CLIENT (NUME VARCHAR(100));").executeUpdate();
		connection.prepareStatement("CREATE TABLE IMPRUMUT (CARTE VARCHAR(100), CLIENT VARCHAR(100));").executeUpdate();

		addDepartament(new Departament("HR"));
		addDepartament(new Departament("IT"));
		addDepartament(new Departament("MARKETING"));

		addSediu(new Sediu("Piata Romana"));
		addSediu(new Sediu("Piata Universitatii"));
		addSediu(new Sediu("Piata Unirii"));

		addAngajatSauStagiar(new Angajat("Florescu Bogdan", "IT", "Piata Romana"));
		addAngajatSauStagiar(new Angajat("Popescu Paul", "HR", "Piata Universitatii"));
		addAngajatSauStagiar(new Angajat("Georgescu Marius", "MARKETING", "Piata Unirii"));

		addAngajatSauStagiar(new Stagiar("Florescu Paul", "IT", "Piata Romana", "Florescu Bogdan"));
		addAngajatSauStagiar(new Stagiar("Popescu Marius", "HR", "Piata Universitatii", "Popescu Paul"));
		addAngajatSauStagiar(new Stagiar("Georgescu Bogdan", "MARKETING", "Piata Unirii", "Georgescu Marius"));

		addCategorie(new Categorie("Aventura"));
		addCategorie(new Categorie("Stiinta"));
		addCategorie(new Categorie("Poezie"));

		addCarte(new Carte("La plimbare", "Aventura"));
		addCarte(new Carte("PBR", "Stiinta"));
		addCarte(new Carte("Oh vai", "Poezie"));

		addClient(new Client("Telespan Valentin"));
		addClient(new Client("Eftimie Mihail"));
		addClient(new Client("Petrescu Daniel"));

		addImprumut(new Imprumut("PBR", "Telespan Valentin"));
	}

	public static Database getInstance() throws SQLException
	{
		if (instance == null)
		{
			try
			{
				instance = new DatabaseImpl();
			}
			catch (SQLException exception)
			{
				throw exception;
			}
		}

		return instance;
	}

	public List<Angajat> getAngajatSauStagiar() throws SQLException
	{
		ResultSet queryResult = connection.createStatement().executeQuery("SELECT * FROM ANGAJAT_SAU_STAGIAR");

		List<Angajat> result = new ArrayList<Angajat>();

		while (queryResult.next())
		{
			String mentor = queryResult.getString("MENTOR");

			if (mentor == null)
			{
				result.add(new Angajat(queryResult.getString("NUME"), queryResult.getString("DEPARTAMENT"), queryResult.getString("SEDIU")));
			}
			else
			{
				result.add(new Stagiar(queryResult.getString("NUME"), queryResult.getString("DEPARTAMENT"), queryResult.getString("SEDIU"), mentor));
			}
		}

		return result;
	}

	public List<Carte> getCarte() throws SQLException
	{
		ResultSet queryResult = connection.createStatement().executeQuery("SELECT * FROM CARTE");

		List<Carte> result = new ArrayList<Carte>();

		while (queryResult.next())
		{
			result.add(new Carte(queryResult.getString("NUME"), queryResult.getString("CATEGORIE")));
		}

		return result;
	}

	public List<Categorie> getCategorie() throws SQLException
	{
		ResultSet queryResult = connection.createStatement().executeQuery("SELECT * FROM CATEGORIE");

		List<Categorie> result = new ArrayList<Categorie>();

		while (queryResult.next())
		{
			result.add(new Categorie(queryResult.getString("NUME")));
		}

		return result;
	}

	public List<Client> getClient() throws SQLException
	{
		ResultSet queryResult = connection.createStatement().executeQuery("SELECT * FROM CLIENT");

		List<Client> result = new ArrayList<Client>();

		while (queryResult.next())
		{
			result.add(new Client(queryResult.getString("NUME")));
		}

		return result;
	}

	public List<Departament> getDepartament() throws SQLException
	{
		ResultSet queryResult = connection.createStatement().executeQuery("SELECT * FROM DEPARTAMENT");

		List<Departament> result = new ArrayList<Departament>();

		while (queryResult.next())
		{
			result.add(new Departament(queryResult.getString("NUME")));
		}

		return result;
	}

	public List<Imprumut> getImprumut() throws SQLException
	{
		ResultSet queryResult = connection.createStatement().executeQuery("SELECT * FROM IMPRUMUT");

		List<Imprumut> result = new ArrayList<Imprumut>();

		while (queryResult.next())
		{
			result.add(new Imprumut(queryResult.getString("CARTE"), queryResult.getString("CLIENT")));
		}

		return result;
	}

	public List<Log> getLog() throws SQLException
	{
		ResultSet queryResult = connection.createStatement().executeQuery("SELECT * FROM LOG");

		List<Log> result = new ArrayList<Log>();

		while (queryResult.next())
		{
			result.add(new Log(queryResult.getString("NUME")));
		}

		return result;
	}

	public List<Sediu> getSediu() throws SQLException
	{
		ResultSet queryResult = connection.createStatement().executeQuery("SELECT * FROM SEDIU");

		List<Sediu> result = new ArrayList<Sediu>();

		while (queryResult.next())
		{
			result.add(new Sediu(queryResult.getString("ADRESA")));
		}

		return result;
	}

	public void addAngajatSauStagiar(Angajat angajat) throws SQLException
	{
		if (angajat instanceof Stagiar)
		{
			Stagiar stagiar = (Stagiar)(angajat);

			connection.prepareStatement("INSERT INTO ANGAJAT_SAU_STAGIAR (NUME, DEPARTAMENT, SEDIU, MENTOR) VALUES (\'" + stagiar.getNume() + "\', \'" + stagiar.getDepartament() + "\', \'" + stagiar.getSediu() + "\', \'" + stagiar.getMentor() + "\')").executeUpdate();
		}
		else
		{
			connection.prepareStatement("INSERT INTO ANGAJAT_SAU_STAGIAR (NUME, DEPARTAMENT, SEDIU, MENTOR) VALUES (\'" + angajat.getNume() + "\', \'" + angajat.getDepartament() + "\', \'" + angajat.getSediu() + "\', NULL)").executeUpdate();
		}
	}

	public void addCarte(Carte carte) throws SQLException
	{
		connection.prepareStatement("INSERT INTO CARTE (NUME, CATEGORIE) VALUES (\'" + carte.getNume() + "\', \'" + carte.getCategorie() + "\')").executeUpdate();
	}

	public void addCategorie(Categorie categorie) throws SQLException
	{
		connection.prepareStatement("INSERT INTO CATEGORIE (NUME) VALUES (\'" + categorie.getNume() + "\')").executeUpdate();
	}

	public void addClient(Client client) throws SQLException
	{
		connection.prepareStatement("INSERT INTO CLIENT (NUME) VALUES (\'" + client.getNume() + "\')").executeUpdate();
	}

	public void addDepartament(Departament departament) throws SQLException
	{
		connection.prepareStatement("INSERT INTO DEPARTAMENT (NUME) VALUES (\'" + departament.getNume() + "\')").executeUpdate();
	}

	public void addImprumut(Imprumut imprumut) throws SQLException
	{
		connection.prepareStatement("INSERT INTO IMPRUMUT (CARTE, CLIENT) VALUES (\'" + imprumut.getCarte() + "\', \'" + imprumut.getClient() + "\')").executeUpdate();
	}

	public void addLog(Log log) throws SQLException
	{
		connection.prepareStatement("INSERT INTO LOG (NUME) VALUES (\'" + log.getNume() + "\')").executeUpdate();
	}

	public void addSediu(Sediu sediu) throws SQLException
	{
		connection.prepareStatement("INSERT INTO SEDIU (ADRESA) VALUES (\'" + sediu.getAdresa() + "\')").executeUpdate();
	}

	public void removeAngajatSauStagiar(String nume) throws SQLException
	{
		connection.prepareStatement("DELETE FROM ANGAJAT_SAU_STAGIAR WHERE NUME = \'" + nume + "\'").executeUpdate();
	}

	public void removeCarte(String nume) throws SQLException
	{
		connection.prepareStatement("DELETE FROM CARTE WHERE NUME = \'" + nume + "\'").executeUpdate();
	}

	public void removeCategorie(String nume) throws SQLException
	{
		connection.prepareStatement("DELETE FROM CATEGORIE WHERE NUME = \'" + nume + "\'").executeUpdate();
	}

	public void removeClient(String nume) throws SQLException
	{
		connection.prepareStatement("DELETE FROM CLIENT WHERE NUME = \'" + nume + "\'").executeUpdate();
	}

	public void removeDepartament(String nume) throws SQLException
	{
		connection.prepareStatement("DELETE FROM DEPARTAMENT WHERE NUME = \'" + nume + "\'").executeUpdate();
	}

	public void removeImprumut(String carte, String client) throws SQLException
	{
		connection.prepareStatement("DELETE FROM IMPRUMUT WHERE CARTE = \'" + carte + "\' AND CLIENT = \'" + client + "\'").executeUpdate();
	}

	public void removeSediu(String adresa) throws SQLException
	{
		connection.prepareStatement("DELETE FROM SEDIU WHERE ADRESA = \'" + adresa + "\'").executeUpdate();
	}

	public void updateAngajatSauStagiar(String nume, Angajat angajat) throws SQLException
	{
		if (angajat instanceof Stagiar)
		{
			Stagiar stagiar = (Stagiar)(angajat);

			connection.prepareStatement("UPDATE ANGAJAT_SAU_STAGIAR SET NUME = \'" + stagiar.getNume() + "\', DEPARTAMENT = \'" + stagiar.getDepartament() + "\', SEDIU = \'" + stagiar.getSediu() + "\', MENTOR = \'" + stagiar.getMentor() + "\' WHERE NUME = \'" + nume + "\'").executeUpdate();
		}
		else
		{
			connection.prepareStatement("UPDATE ANGAJAT_SAU_STAGIAR SET NUME = \'" + angajat.getNume() + "\', DEPARTAMENT = \'" + angajat.getDepartament() + "\', SEDIU = \'" + angajat.getSediu() + "\', MENTOR = NULL WHERE NUME = \'" + nume + "\'").executeUpdate();
		}
	}

	public void updateCarte(String nume, Carte carte) throws SQLException
	{
		connection.prepareStatement("UPDATE CARTE SET NUME = \'" + carte.getNume() + "\', CATEGORIE = \'" + carte.getCategorie() + "\' WHERE NUME = \'" + nume + "\'").executeUpdate();
	}

	public void updateCategorie(String nume, Categorie categorie) throws SQLException
	{
		connection.prepareStatement("UPDATE CATEGORIE SET NUME = \'" + categorie.getNume() + "\' WHERE NUME = \'" + nume + "\'").executeUpdate();
	}

	public void updateClient(String nume, Client client) throws SQLException
	{
		connection.prepareStatement("UPDATE CLIENT SET NUME = \'" + client.getNume() + "\' WHERE NUME = \'" + nume + "\'").executeUpdate();
	}

	public void updateDepartament(String nume, Departament departament) throws SQLException
	{
		connection.prepareStatement("UPDATE DEPARTAMENT SET NUME = \'" + departament.getNume() + "\' WHERE NUME = \'" + nume + "\'").executeUpdate();
	}

	public void updateImprumut(String carte, String client, Imprumut imprumut) throws SQLException
	{
		connection.prepareStatement("UPDATE IMPRUMUT SET CARTE = \'" + imprumut.getCarte() + "\', CLIENT = \'" + imprumut.getClient() + "\' WHERE CARTE = \'" + carte + "\' AND CLIENT = \'" + client + "\'").executeUpdate();
	}

	public void updateSediu(String adresa, Sediu sediu) throws SQLException
	{
		connection.prepareStatement("UPDATE SEDIU SET ADRESA = \'" + sediu.getAdresa() + "\' WHERE ADRESA = \'" + adresa + "\'").executeUpdate();
	}

}
