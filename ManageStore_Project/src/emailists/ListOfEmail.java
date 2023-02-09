package emailists;

import javax.swing.DefaultListModel;

import user.userDAO;

/**
 *  Interface entre la classe userIHM1 et la classe DAO ListOfEmailDAO 
 * Les méthodes GET et SET permettent de passer les paramètres à la classe
 * Les variables publiques permettent également de passer les paramètres 
 * Les méthodes n'ont pas de paramétres, il faut donc passer les paramètres à la classe avant d'executer les méthodes
 *
 */
public class ListOfEmail {

	public int EMailId;
	public String EMail;
	public String Name;
	public String Surname;
	public String StoreId;
	public boolean WhiteList;
	public boolean BlackList;
	
	public int GetEMailId()
	{
		return(EMailId);
	}
	
	public void SetEMailId(int EMailId)
	{
		this.EMailId=EMailId;
	}
	
	public String GetEMail()
	{
		return(EMail);
	}
	public void SetEMail(String EMail)
	{
		this.EMail=EMail;
	}
	
	
	public void SetName(String Name)
	{
		this.Name=Name;
	}
	public String GetName()
	{
		return(Name);
	}
	
	public String GetSurname()
	{
		return(Surname);
	}
	
	public void SetSurname(String Surname)
	{
		this.Surname=Surname;
	}
	

	public void SetWhiteList(Boolean WhiteList)
	{
		this.WhiteList=WhiteList;
	}
	
	public Boolean GetWhiteList()
	{
		return(WhiteList);
	}
	
	public void SetStoreId(String StoreId)
	{
		this.StoreId=StoreId;
	}
	
	public String GetStoreId()
	{
		return(StoreId);
	}
	
	
	public int GetEmailId()
	{
		return(EMailId);
	}
	
	public void SetEmailId(int EmailId)
	{

		this.EMailId=EmailId;

	}
	
	/**
	 * Permet de passer les comptes de blacklist à whiteList et de créer un compte utilisateur
	 * 
	 *Les arrtibuts EMailId, EMail, Name, Surname,StoreId de la classe doivent être renseignées avant l'utilisation de la méthode  PutInWhiteList
	 *ListOfEmailDAO ListOfEmailDAO =new ListOfEmailDAO();
	 *ListOfEmailDAO.DAOCreateAccount(EMailId, EMail, Name, Surname,StoreId);
	 */
	public boolean PutInWhiteList() 
	{

		ListOfEmailDAO ListOfEmailDAO =new ListOfEmailDAO();
		ListOfEmailDAO.DAOCreateAccount(EMailId, EMail, Name, Surname,StoreId);
		
		return(true);
	}
	/**
	 * Permet de passer les comptes de whiteList à blacklist et de supprimer un copmte utilisateur
	 * 
	 *Les arrtibuts EMail de la classe doivent être renseignées avant l'utilisation de la méthode  PutInBlackList
	 *ListOfEmailDAO ListOfEmailDAO =new ListOfEmailDAO();
	 *ListOfEmailDAO.DAOCreateAccount(EMailId, EMail, Name, Surname,StoreId);
	 */
	
	public boolean PutInBlackList() 
	{

		ListOfEmailDAO ListOfEmailDAO =new ListOfEmailDAO();
		ListOfEmailDAO.DAODeleteAccount(EMail);
		return(true);
	}
	
	/**
	 * Permet de lister les comptes de la whiteList
	 */
	public Object[][] ListEmailInWhiteList() {
 

		Object [][] donnees=new String[10][5];
		ListOfEmailDAO ListOfEmailDAO =new ListOfEmailDAO();
		return(ListOfEmailDAO.DAOListOfEmail(true));

	}
	/**
	 * Permet de lister les comptes de la blacklist
	 */ 	
	public Object[][] ListEmailInBlackList() {
	

		Object [][] donnees=new String[10][5];
		ListOfEmailDAO ListOfEmailDAO =new ListOfEmailDAO();
		return(ListOfEmailDAO.DAOListOfEmail(false));

	}

}
