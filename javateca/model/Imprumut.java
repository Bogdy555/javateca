package javateca.model;



public class Imprumut
{

	private String carte;
	private String client;

	public Imprumut(String carte, String client)
	{
		this.carte = carte;
		this.client = client;
	}

	public String getCarte()
	{
		return carte;
	}

	public String getClient()
	{
		return client;
	}

	public void setCarte(String carte)
	{
		this.carte = carte;
	}

	public void setClient(String client)
	{
		this.client = client;
	}

}
