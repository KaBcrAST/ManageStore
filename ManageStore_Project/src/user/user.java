package user;

/**
 * @author Thomas
 *
 */
/**
 *  Interface entre la classe userIHM1 et la classe DAO userDAO
 * Les méthodes GET et SET permettent de passer les paramètres à la classe
 * Les variables publiques permettent également de passer les paramètres 
 * Les méthodes n'ont pas de paramétres, il faut donc passer les paramètres à la classe avant d'executer les méthodes
 *
 */

import javax.swing.DefaultListModel;

import emailists.ListOfEmailDAO;

public class user {
	public int UserId;
	public String UserMail;
	public String UserName;
	public String UserSurname;
	public String UserPassword;
	public String UserPseudo;
	public String RoleID;
	public String StoreId;
	
	public int GetUserId()
	{
		return(UserId);
	}
	
	public void SetUserId(int UserId)
	{
		this.UserId=UserId;
	}
	public String GetUserMail()
	{
		return(UserMail);
	}
	
	public void SetUserMail(String UserMail)
	{
		this.UserMail=UserMail;
	}
	
	
	public void SetUserName(String UserName)
	{
		this.UserName=UserName;
	}
	
	public String GetUserSurname()
	{
		return(UserSurname);
	}
	
	public void SetUserSurname(String UserSurname)
	{
		this.UserSurname=UserSurname;
	}
	
	public String GetUserPassword()
	{
		return(UserPassword);
	}
	
	public void SetUserPassword(String UserPassword)
	{
		this.UserPassword=UserPassword;
	}
	
	public String GetUserPseudo()
	{
		return(UserPseudo);
	}
	
	public void SetUserPseudo(String UserPseudo)
	{
		this.UserPseudo=UserPseudo;
	}
	
	public String GetRoleId()
	{
		return(RoleID);
	}
	
	public void SetRoleId(String RoleID)
	{

		this.RoleID=RoleID;

	}

	public void SetStoreId(String StoreId)
	{

		this.StoreId=StoreId;

	}
	
	
	public String GetStoreId()
	{
		return(StoreId);
	}
	/**
	 *  Méthode permettant de créer un produit
	 *  Il faut avoir préalablement passé à la classe les proproétés nécessaires
	 *  SetUserMail
	 *  SetUserName
	 *  SetUserSurname
	 *  SetUserPassword
	 *  SetUserUserPseudo
	 *  SetRoleID
	 *  SetStoreId
	 */
	
	public boolean CreateAccount() 
	{
		userDAO UserDAO =new userDAO();
		System.out.println("User.java: "+StoreId);
		return(UserDAO.DAOCreateAccount(UserMail,UserName,UserSurname,UserPassword,UserPseudo,RoleID,StoreId));
	
	}


	
	public boolean SingIn() {
		return(true);
	
	}
	 
	/**
	 *  Méthode permettant de mettre à jour un produit
	 *  Il faut avoir préalablement passé à la classe les proproétés nécessaires
	 *  SetUserMail
	 *  SetUserName
	 *  SetUserSurname
	 *  SetUserPassword
	 *  SetUserUserPseudo
	 *  SetRoleID
	 *  SetStoreId
	 */
	 
	public boolean UpdateAccount() 
	{
		userDAO UserDAO =new userDAO();
		System.out.println("User.java: "+StoreId);
		return(UserDAO.DAOUpdateAccount(UserId,UserMail,UserName,UserSurname,UserPassword,UserPseudo,RoleID,StoreId));
	}
	
	/**
	 *  Méthode permettant de supprimer un produit
	 *  Il faut avoir préalablement passé à la classe les proproétés nécessaires
	 *  SetUserId

	 */

	public boolean DeleteAccount() {
		userDAO UserDAO =new userDAO();
		emailists.ListOfEmail ListOfEmail =new emailists.ListOfEmail();
		ListOfEmail.SetEMail(UserMail);
		Boolean bOk=ListOfEmail.PutInBlackList();
		return(UserDAO.DAODeleteAccount(UserId));
	}
	
	/**
	 *  Méthode permettant de lister les utilisateurs

	 */

	public Object[][] ListAccount() {
		

		Object [][] donnees=new String[100][5];
		userDAO UserDAO =new userDAO();
		return(UserDAO.DAOListAccount());

	}

	/**
	 *  Méthode permettant de lister les utilisateurs d'un magasin préciser par Storeid
	 *  utiliser la méthode setStoreID
	 */

	public Object[][] ListEmployesInStore() {
		

		Object [][] donnees=new String[100][5];
		userDAO UserDAO =new userDAO();
		return(UserDAO.DAOListEmployeesInStore(StoreId));

	}
	
	
}

