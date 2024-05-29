package javateca.service;



import javateca.model.*;
import javateca.repository.*;

import java.sql.*;
import java.util.List;
import java.util.Set;



public interface Biblioteca
{

	public void addAngajatSauStagiar(Angajat angajat) throws SQLException;
	public void addCarte(Carte carte) throws SQLException;
	public void addCategorie(Categorie categorie) throws SQLException;
	public void addClient(Client client) throws SQLException;
	public Carte findCarte(String nume) throws SQLException;
	public void imprumutaCarte(String carte, String client) throws SQLException;
	public void returneazaCarte(String carte, String client) throws SQLException;
	public List<Carte> getCartiDinCategorie(String categorie) throws SQLException;
	public Set<Angajat> getAngajatSauStagiarDinDepartament(String departament) throws SQLException;
	public Set<Angajat> getAngajatSauStagiarDinSediu(String sediu) throws SQLException;

}
