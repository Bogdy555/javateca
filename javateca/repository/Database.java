package javateca.repository;



import javateca.model.*;

import java.util.List;
import java.sql.*;



public interface Database
{

	public List<Angajat> getAngajatSauStagiar() throws SQLException;
	public List<Carte> getCarte() throws SQLException;
	public List<Categorie> getCategorie() throws SQLException;
	public List<Client> getClient() throws SQLException;
	public List<Departament> getDepartament() throws SQLException;
	public List<Imprumut> getImprumut() throws SQLException;
	public List<Sediu> getSediu() throws SQLException;

	public void addAngajatSauStagiar(Angajat angajat) throws SQLException;
	public void addCarte(Carte carte) throws SQLException;
	public void addCategorie(Categorie categorie) throws SQLException;
	public void addClient(Client client) throws SQLException;
	public void addDepartament(Departament departament) throws SQLException;
	public void addImprumut(Imprumut imprumut) throws SQLException;
	public void addSediu(Sediu sediu) throws SQLException;

	public void removeAngajatSauStagiar(String nume) throws SQLException;
	public void removeCarte(String nume) throws SQLException;
	public void removeCategorie(String nume) throws SQLException;
	public void removeClient(String nume) throws SQLException;
	public void removeDepartament(String nume) throws SQLException;
	public void removeImprumut(String carte, String client) throws SQLException;
	public void removeSediu(String adresa) throws SQLException;

	public void updateAngajatSauStagiar(String nume, Angajat angajat) throws SQLException;
	public void updateCarte(String nume, Carte carte) throws SQLException;
	public void updateCategorie(String nume, Categorie categorie) throws SQLException;
	public void updateClient(String nume, Client client) throws SQLException;
	public void updateDepartament(String nume, Departament departament) throws SQLException;
	public void updateImprumut(String carte, String client, Imprumut imprumut) throws SQLException;
	public void updateSediu(String adresa, Sediu sediu) throws SQLException;

}
