package javateca;



public class Stagiar extends Angajat
{

	private String mentor;

	public Stagiar(String nume, String departament, String sediu, String mentor)
	{
		super(nume, departament, sediu);
		this.mentor = mentor;
	}

	public String getMentor()
	{
		return mentor;
	}

	public void setMentor(String mentor)
	{
		this.mentor = mentor;
	}

}
