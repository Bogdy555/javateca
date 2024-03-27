package javateca;



public class Carte
{

	private String nume;
	private String categorie;

	public Carte(String nume, String categorie)
	{
		this.nume = nume;
		this.categorie = categorie;
	}

	public String getNume()
	{
		return nume;
	}

	public String getCategorie()
	{
		return categorie;
	}

	public void setNume(String nume)
	{
		this.nume = nume;
	}

	public void setCategorie(String categorie)
	{
		this.categorie = categorie;
	}

}
