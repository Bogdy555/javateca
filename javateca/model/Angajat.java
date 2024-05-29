package javateca.model;



public class Angajat
{

	protected String nume;
	protected String departament;
	protected String sediu;

	public Angajat(String nume, String departament, String sediu)
	{
		this.nume = nume;
		this.departament = departament;
		this.sediu = sediu;
	}

	public String getNume()
	{
		return nume;
	}

	public String getDepartament()
	{
		return departament;
	}

	public String getSediu()
	{
		return sediu;
	}

	public void setNume(String nume)
	{
		this.nume = nume;
	}

	public void setDepartament(String departament)
	{
		this.departament = departament;
	}

	public void setSediu(String sediu)
	{
		this.sediu = sediu;
	}

}
