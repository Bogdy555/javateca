package javateca;



import java.util.*;



public class Database
{

	public TreeSet<Angajat> angajati;
	public TreeSet<Carte> carti;
	public TreeSet<Categorie> categorii;
	public TreeSet<Client> clienti;
	public TreeSet<Departament> departamente;
	public ArrayList<Imprumut> imprumuturi;
	public TreeSet<Sediu> sedii;

	public Database()
	{
		angajati = new TreeSet<Angajat>();
		carti = new TreeSet<Carte>();
		categorii = new TreeSet<Categorie>();
		clienti = new TreeSet<Client>();
		departamente = new TreeSet<Departament>();
		imprumuturi = new ArrayList<Imprumut>();
		sedii = new TreeSet<Sediu>();
	}

	public void addAngajat(Angajat angajat)
	{
		angajati.add(angajat);
	}

	public void addCarte(Carte carte)
	{
		carti.add(carte);
	}

	public void addCategorie(Categorie categorie)
	{
		categorii.add(categorie);
	}

	public void addClient(Client client)
	{
		clienti.add(client);
	}

	public Carte findCarte(String nume)
	{
		for (Carte carte : carti)
		{
			if (carte.getNume() == nume)
			{
				return carte;
			}
		}

		return null;
	}

	public void imprumutaCarte(Carte carte, Client client)
	{
		Imprumut imprumut = new Imprumut(carte.getNume(), client.getNume());
		imprumuturi.add(imprumut);
	}

	public void returneazaCarte(Carte carte, Client client)
	{
		for (Imprumut imprumut : imprumuturi)
		{
			if (imprumut.getCarte() == carte.getNume() && imprumut.getClient() == client.getNume())
			{
				imprumuturi.remove(imprumut);
				return;
			}
		}
	}

	public TreeSet<Carte> cartiDinCategorie(Categorie categorie)
	{
		TreeSet<Carte> rezultat = new TreeSet<Carte>();

		for (Carte carte : carti)
		{
			if (carte.getCategorie() == categorie.getNume())
			{
				rezultat.add(carte);
			}
		}

		return rezultat;
	}

	public TreeSet<Angajat> angajatiDinDepartament(Departament departament)
	{
		TreeSet<Angajat> rezultat = new TreeSet<Angajat>();

		for (Angajat angajat : angajati)
		{
			if (angajat.getDepartament() == departament.getNume())
			{
				rezultat.add(angajat);
			}
		}

		return rezultat;
	}

	public TreeSet<Angajat> angajatiDinSediu(Sediu sediu)
	{
		TreeSet<Angajat> rezultat = new TreeSet<Angajat>();

		for (Angajat angajat : angajati)
		{
			if (angajat.getSediu() == sediu.getAdresa())
			{
				rezultat.add(angajat);
			}
		}

		return rezultat;
	}

}
