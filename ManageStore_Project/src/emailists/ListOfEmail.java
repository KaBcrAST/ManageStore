package emailists;

import javax.swing.DefaultListModel;

import user.userDAO;

/**
 *  Interface entre la classe userIHM1 et la classe DAO ListOfEmailDAO 
 * Les m�thodes GET et SET permettent de passer les param�tres � la classe
 * Les variables publiques permettent �galement de passer les param�tres 
 * Les m�thodes n'ont pas de param�tres, il faut donc passer les param�tres � la classe avant d'executer les m�thodes
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
	 * Permet de passer les comptes de blacklist � whiteList et de cr�er un compte utilisateur
	 * 
	 *Les arrtibuts EMailId, EMail, Name, Surname,StoreId de la classe doivent �tre renseign�es avant l'utilisation de la m�thode  PutInWhiteList
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
	 * Permet de passer les comptes de whiteList � blacklist et de supprimer un copmte utilisateur
	 * 
	 *Les arrtibuts EMail de la classe doivent �tre renseign�es avant l'utilisation de la m�thode  PutInBlackList
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
