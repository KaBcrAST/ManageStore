package user;


import java.awt.EventQueue;
import java.awt.event.*;

import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;

import javax.swing.JTabbedPane;

import javax.swing.JDesktopPane;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import storeInventory.StoreInventory;

import java.awt.Color;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.Icon;

public class userIHM1 extends JFrame {

	private JFrame frmusers;
	private JTextField txtEmail;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtPseudo;
	private Object[][] donnees = new String[101][9];
	private Object[][] donneesStore = new String[101][5];
	private Object[][] donneesStoreC = new String[101][5];
	private Object[][] donneesProduct = new String[101][5];
	private Object[][] donneesWList = new String[101][5];
	private Object[][] donneesBList = new String[101][5];
	private Object[][] donneesRole = new String[101][5];
	private Object[][] donneesEmployeesInStore = new String[101][5];	
	private Object[][] donneesUOM = new String[101][5];	
	
	private Object[][] donneesProductInStore = new String[101][5];	
	private Object[][] donneesProductNotInStore = new String[101][5];


	private JTextField TxtId;
	private JTextField txtProductName;
	private JTextField txtProductDescription;
	private JTextField TxtProductPrice;
	private JTextField txtStoreName;
	private JTextField txtStoreLocation;
	private JTextField TxtStoreId;
	private JTextField txtStoreQuantity;
	private JTextField TxtProductId;
	private JTextField txtBid;
	private JTextField txtWid;
	private JTextField txtProductNotInStore;
	private JTextField txtcomboStore;
	private JTextField txtProductInStore;
	private JPasswordField txtPassword;
	private boolean UserRight;
	private String Login;

	private JButton btnAddProduct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userIHM1 window = new userIHM1("","","");
					window.frmusers.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	
	//Surcharge du constructeur pour pouvoir récupérer les paramétres de la connexion
	// Login, RoleID et Storename
	
	public userIHM1(String Login, String RoleId, String StoreName) {

		initialize(Login,RoleId,StoreName);

	}

	/**
	 * Initialize the contents of the frame.
	 */

	/*Méthode d'initialisation de toutes les listes ici user */
	private void Listusers(JDesktopPane desktopPane,JList list)
	{
		user user = new user();
		donnees=user.ListAccount();
		int i;
		String value;
		DefaultListModel model = new DefaultListModel();

		for (i=0; i<100;i++)
		{ 
			value= donnees[i][2]+" " + donnees[i][3];
			
			if (donnees[i][2]!=null)
			{
				model.addElement(value);
			}
		}
		list.setModel(model);

		
	}
	/*Méthode d'initialisation de toutes les listes ici les empluyes d'un magasin */	
	private void ListEmployeesInStore(JDesktopPane desktopPane,JList list,String StoreId)
	{
		user user = new user();
		user.StoreId=StoreId;
		donneesEmployeesInStore=user.ListEmployesInStore();
		int i;
		String value;
		DefaultListModel model = new DefaultListModel();

		for (i=0; i<100;i++)
		{ 
			value= donneesEmployeesInStore[i][1]+" " + donneesEmployeesInStore[i][2];
			
			if (donneesEmployeesInStore[i][2]!=null)
			{
				model.addElement(value);
			}
		}
		list.setModel(model);

		
	}
	/*Méthode d'initialisation de toutes les listes ici les produits présents en magasin */
	private void ListProductInStore(JDesktopPane desktopPane,JList list,String storeID)
	{
		StoreInventory StoreInventory = new StoreInventory();
		StoreInventory.StoreId=storeID;
		donneesProductInStore=StoreInventory.ListProductInStore();
		int i;
		String value;
		DefaultListModel model = new DefaultListModel();

		for (i=0; i<100;i++)
		{ 
			value= donneesProductInStore[i][1]+" Quantité: " + donneesProductInStore[i][2] + " " +donneesProductInStore[i][3];
			
			if (donneesProductInStore[i][1]!=null)
			{
				model.addElement(value);
			}
		}
		list.setModel(model);

		
	}
	/*Méthode de chargement de toutes les listes ici les produits absents en magasin */
	private void ListProductNotInStore(JDesktopPane desktopPane,JList list,String storeID)
	{
		StoreInventory StoreInventory = new StoreInventory();
		StoreInventory.StoreId=storeID;
		donneesProductNotInStore=StoreInventory.ListProductNotInStore();
		int i;
		String value;
		DefaultListModel model = new DefaultListModel();

		for (i=0; i<100;i++)
		{ 
			value= donneesProductNotInStore[i][1]+" ";
			
			if (donneesProductNotInStore[i][1]!=null)
			{
				model.addElement(value);
			}
		}
		list.setModel(model);

		
	}
	/*Méthode de chargement de la liste  des magasins à charger dans une liste */
	private void ListStores(JDesktopPane desktopPane,JList list)
	{
		store.store store=new store.store();
		donneesStore=store.ListStore();
		int i;
		String value;
		DefaultListModel model = new DefaultListModel();

		for (i=0; i<100;i++)
		{ 
			value= donneesStore[i][1]+" " + donneesStore[i][2];
			
			if (donneesStore[i][1]!=null)
			{
				model.addElement(value);
			}
		}
		list.setModel(model);

		
	}
	/*Méthode de chargement de la liste  des magasins à charger dans une combo */
	private void ListStores(JDesktopPane desktopPane,JComboBox combo,String UserStoreName)
	{
		store.store store=new store.store();
		donneesStoreC=store.ListStore();
		int i;
		String value;
		Boolean bOK=false;
		combo.removeAllItems();
		for (i=0; i<100;i++)
		{ 
			value= donneesStoreC[i][1]+"";
			
			if (donneesStoreC[i][1]!=null)
			{

				combo.addItem(value);
				bOK=true;
			}
//			if (bOK)
//			{
//				if (UserStoreName!="")
//				{
//					combo.setSelectedItem(UserStoreName);
//				}
//				else
//				{
//					combo.setSelectedIndex(0);
//				}
//			}
		
		}
		
	}
	/*Méthode de chargement de la liste des roles utilisateurs.La table est initilalsé avec 2 roles*/
	private void ListRole(JDesktopPane desktopPane,JComboBox combo)
	{
		role.Role role=new role.Role();
		donneesRole=role.ListRole();
		int i;
		String value;
		Boolean bOK=false;

		for (i=0; i<100;i++)
		{ 
			value=donneesRole[i][1]+ "";
			
			if (donneesRole[i][1]!=null)
			{
				combo.addItem(value);
				bOK=true;
			}
			if (bOK)
			{
				combo.setSelectedIndex(0);
				
			}
		
		}
		
	}
	/*Méthode de chargement de la liste  des inutés de mesure*/
	private void ListUniteofmeasure(JDesktopPane desktopPane,JComboBox combo)
	{
		
		product.UnitOfMeasure Unit=new product.UnitOfMeasure();
		donneesUOM=Unit.ListUnit();
		int i;
		String value;
		Boolean bOK=false;

		for (i=0; i<100;i++)
		{ 
			value=donneesUOM[i][1]+ "";
			
			if (donneesUOM[i][1]!=null)
			{
				combo.addItem(value);
				bOK=true;
			}
			if (bOK)
			{
				combo.setSelectedIndex(0);
				
			}
		
		}
	}

	
	/*Méthode de chargement de la liste des produits*/
	private void ListProducts(JDesktopPane desktopPane,JList list)
	{
		product.Product product=new product.Product();
		donneesProduct=product.ListProduct();
		int i;
		String value;
		DefaultListModel model = new DefaultListModel();

		for (i=0; i<100;i++)
		{ 
			value= donneesProduct[i][1]+" " + donneesProduct[i][2];
			
			if (donneesProduct[i][1]!=null)
			{
				model.addElement(value);
			}
		}
		list.setModel(model);

		
	}
	/*Méthode de chargement de la liste des email en whitelist*/
	private void ListEmailWhiteList(JDesktopPane desktopPane,JList list)
	{
		emailists.ListOfEmail ListOfEmail=new emailists.ListOfEmail();
		donneesWList=ListOfEmail.ListEmailInWhiteList();
		int i;
		String value;
		DefaultListModel model = new DefaultListModel();

		for (i=0; i<100;i++)
		{ 
			value= donneesWList[i][1]+"      " + donneesWList[i][2]+" " + donneesWList[i][3];
			if (donneesWList[i][1]!=null)
			{
				model.addElement(value);
			}



		}
		list.setModel(model);

		
	}
	/*Méthode de chargement de la liste des email en blacklist*/
	private void ListEmailBlackList(JDesktopPane desktopPane,JList list)
	{
		emailists.ListOfEmail ListOfEmail=new emailists.ListOfEmail();
		donneesBList=ListOfEmail.ListEmailInBlackList();
		int i;
		String value;
		DefaultListModel model = new DefaultListModel();

		for (i=0; i<100;i++)
		{ 
			value= donneesBList[i][1]+"      " + donneesBList[i][2]+" " + donneesBList[i][3];
			
			if (donneesBList[i][1]!=null)
			{
				model.addElement(value);
			}
		}
		list.setModel(model);

		
	}
	
	
	private void initialize(String Login, String RoleId, String StoreName){
		frmusers = new JFrame();
		frmusers.setTitle("Store Management");
	
		frmusers.setBounds(100, 100, 1112, 639);
		frmusers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmusers.getContentPane().setLayout(new BoxLayout(frmusers.getContentPane(), BoxLayout.X_AXIS));
		frmusers.setVisible(true);
		this.Login=Login;
		if (Integer.parseInt(RoleId)==1) // Role administrateur
		{
			this.UserRight=true;

		}
		else   // Role utilisateur
		{
			this.UserRight=false;
		}
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmusers.getContentPane().add(tabbedPane);
		
		final JDesktopPane desktStore = new JDesktopPane();
		tabbedPane.addTab("Stores              ", (Icon) null, desktStore, null);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		
		JLabel lblNewLabel_11 = new JLabel("Employees :");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_11.setBounds(22, 375, 85, 37);
		desktStore.add(lblNewLabel_11);
		
		final JList lstEmployeesInStore = new JList();
		lstEmployeesInStore.setBorder(new LineBorder(new Color(0, 0, 0)));
		lstEmployeesInStore.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lstEmployeesInStore.setBounds(85, 385, 336, 165);
		desktStore.add(lstEmployeesInStore);
		
		final JList listStore = new JList();
		listStore.setFont(new Font("Tahoma", Font.PLAIN, 10));
		listStore.setBorder(new LineBorder(new Color(0, 0, 0)));
		listStore.addMouseListener (new MouseAdapter() {
	         public void mouseClicked(MouseEvent me) {
	            if (me.getClickCount() == 1) {
	               JList target = (JList)me.getSource();
	               int index = target.locationToIndex(me.getPoint());
	               if (index >= 0) {

	            	   Object value;
						txtStoreName.setText("");
						txtStoreLocation.setText("");
						
						if (index>=0)
						{
							value=donneesStore[index][0];
							TxtStoreId.setText(value.toString());
							value=donneesStore[index][1];
							
							txtStoreName.setText(value.toString());
							value=donneesStore[index][2];
							txtStoreLocation.setText(value.toString());
							ListEmployeesInStore(desktStore, lstEmployeesInStore,TxtStoreId.getText());
							
						}
	               }
	            }
	         }
		});
		listStore.setBounds(85, 24, 336, 340);
		
				desktStore.add(listStore);
				
				JLabel lblNewLabel_12 = new JLabel("Name :");
				lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 10));
				lblNewLabel_12.setBounds(439, 29, 48, 14);
				desktStore.add(lblNewLabel_12);
				
				JLabel lblNewLabel_13 = new JLabel("Location :");
				lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 10));
				lblNewLabel_13.setBounds(439, 59, 48, 14);
				desktStore.add(lblNewLabel_13);
				
				txtStoreName = new JTextField();
				txtStoreName.setEnabled(UserRight);
				txtStoreName.setFont(new Font("Tahoma", Font.PLAIN, 10));
				txtStoreName.addKeyListener(new java.awt.event.KeyAdapter() {
		            public void keyTyped(KeyEvent evt) {
		                int len=txtStoreName.getText().length();
		                char c = evt.getKeyChar();
		                if (c >= '0' && c <= '9') {
		
		                    //suppression du caractï¿½re
		                    evt.consume();
		                }
		                if (len>=30) {
		                  evt.consume();  
		                }
		                
		            }
		        });
				
				
				
				txtStoreName.setBounds(497, 23, 169, 20);
				
				desktStore.add(txtStoreName);
				txtStoreName.setColumns(10);
				
				txtStoreLocation = new JTextField();
				txtStoreLocation.setEnabled(UserRight);
				txtStoreLocation.setFont(new Font("Tahoma", Font.PLAIN, 10));
				txtStoreLocation.addKeyListener(new java.awt.event.KeyAdapter() {
		            public void keyTyped(KeyEvent evt) {
		                int len=txtStoreLocation.getText().length();
		                char c = evt.getKeyChar();
		                if (c >= '0' && c <= '9') {
		                    evt.consume();
		                }
		                if (len>=30) {
		                  evt.consume();  
		                }
		                
		            }
		        });
				final JDesktopPane deskProduct = new JDesktopPane();
				tabbedPane.addTab("Products            ", null, deskProduct, null);
				final JDesktopPane deskStoreInventory = new JDesktopPane();
				deskStoreInventory.setEnabled(UserRight);
				tabbedPane.addTab("Store Inventory     ", null, deskStoreInventory, null);
				
				final JComboBox comboStore = new JComboBox();
				comboStore.setEnabled(UserRight);
				

				tabbedPane.addTab("Store Inventory     ", null, deskStoreInventory, null);
				
				JLabel lblNewLabel_14 = new JLabel("Store :");
				lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 10));
				lblNewLabel_14.setBounds(10, 26, 48, 14);
				deskStoreInventory.add(lblNewLabel_14);
				
				

				
				JLabel lblNewLabel_14_1 = new JLabel("Products :");
				lblNewLabel_14_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
				lblNewLabel_14_1.setBounds(10, 66, 48, 14);
				deskStoreInventory.add(lblNewLabel_14_1);
				
				final JList lstProductNotInStore = new JList();
				lstProductNotInStore.setFont(new Font("Tahoma", Font.PLAIN, 10));
				lstProductNotInStore.setBorder(new LineBorder(new Color(0, 0, 0)));
				
				lstProductNotInStore.addMouseListener (new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            if (me.getClickCount() == 1) {
		               JList target = (JList)me.getSource();
		               int index = target.locationToIndex(me.getPoint());
		               if (index >= 0) {
		            	   Object value;
								
									if (index>=0)
									{
										value=donneesProductNotInStore[index][0];
										txtProductNotInStore.setText(value.toString());
										
									}
		               }
		            }
		         }
					});
		
				final JList lstProductInStore = new JList();
				lstProductInStore.setFont(new Font("Tahoma", Font.PLAIN, 10));
				lstProductInStore.setBorder(new LineBorder(new Color(0, 0, 0)));
				lstProductInStore.addMouseListener (new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            if (me.getClickCount() == 1) {
		               JList target = (JList)me.getSource();
		               int index = target.locationToIndex(me.getPoint());
		               if (index >= 0) {
		            	   Object value;
										
											if (index>=0)
											{
												value=donneesProductInStore[index][0];
												txtProductInStore.setText(value.toString());
												value=donneesProductInStore[index][2];
												txtStoreQuantity.setText(value.toString());
												
											}
		               }
		            }
		         }
							});
						
						
					lstProductNotInStore.setBounds(70, 66, 244, 347);
					deskStoreInventory.add(lstProductNotInStore);
					
					JButton btnNewButton_4 = new JButton("Add In store");
					btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
					btnNewButton_4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							StoreInventory StoreInventory = new StoreInventory();
							StoreInventory.ProductId=Integer.parseInt(txtProductNotInStore.getText());
							StoreInventory.StoreId=txtcomboStore.getText();

							StoreInventory.AddProductInStore();
							ListProductInStore(deskStoreInventory,lstProductInStore,StoreInventory.StoreId);
							ListProductNotInStore(deskStoreInventory,lstProductNotInStore,StoreInventory.StoreId);	
							
						}
					});
					btnNewButton_4.setBounds(324, 110, 120, 41);
					deskStoreInventory.add(btnNewButton_4);
					
					JButton btnNewButton_5 = new JButton("Remove from Store");
					btnNewButton_5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							StoreInventory StoreInventory = new StoreInventory();
							if (txtProductInStore.getText()!="")
							{
								StoreInventory.ProductId=Integer.parseInt(txtProductInStore.getText());;
								StoreInventory.StoreId=txtcomboStore.getText();
								StoreInventory.RemoveProductInStore();
								ListProductInStore(deskStoreInventory,lstProductInStore,StoreInventory.StoreId);
								ListProductNotInStore(deskStoreInventory,lstProductNotInStore,StoreInventory.StoreId);	
							}
						}
					});
					btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
					btnNewButton_5.setBounds(324, 266, 120, 41);
					deskStoreInventory.add(btnNewButton_5);
					
					JLabel lblNewLabel_14_1_1 = new JLabel("Products in store :");
					lblNewLabel_14_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
					lblNewLabel_14_1_1.setBounds(336, 66, 94, 14);
					deskStoreInventory.add(lblNewLabel_14_1_1);
					

					lstProductInStore.setBounds(458, 65, 244, 347);
					deskStoreInventory.add(lstProductInStore);
					
					JLabel lblNewLabel_14_1_1_1 = new JLabel("Quantity :");
					lblNewLabel_14_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
					lblNewLabel_14_1_1_1.setBounds(712, 69, 56, 14);
					deskStoreInventory.add(lblNewLabel_14_1_1_1);
					
					txtStoreQuantity = new JTextField();
					txtStoreQuantity.setFont(new Font("Tahoma", Font.PLAIN, 10));
					txtStoreQuantity.setBounds(764, 66, 88, 20);
					txtStoreQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
			            public void keyTyped(KeyEvent evt) {
			                int len=txtStoreQuantity.getText().length();
			                char c = evt.getKeyChar();
			                if (!(c >= '0' && c <= '9')) {
			                    evt.consume();
			                }
			                if (len>=6) {
			                  evt.consume();  
			                }
			                
			            }
			        });
					deskStoreInventory.add(txtStoreQuantity);
					txtStoreQuantity.setColumns(10);
					
					JButton btnNewButton_6 = new JButton("Update Quantity");
					btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
					btnNewButton_6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {


							StoreInventory StoreInventory = new StoreInventory();
							
							StoreInventory.ProductId=Integer.parseInt(txtProductInStore.getText());
							StoreInventory.StoreId=txtcomboStore.getText();
							StoreInventory.Quantity=Integer.parseInt(txtStoreQuantity.getText());
							StoreInventory.UpdateProductQuantityInStore();
							ListProductInStore(deskStoreInventory,lstProductInStore,StoreInventory.StoreId);
							txtStoreQuantity.setText("");

							
						}
					});
					btnNewButton_6.setBounds(766, 113, 105, 41);
					deskStoreInventory.add(btnNewButton_6);
					

					comboStore.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int index=comboStore.getSelectedIndex();
							
							Object value;
							if (index>=0)
							{
								value=donneesStoreC[index][0];
								int value1=Integer.parseInt(value.toString());

								txtcomboStore.setText(value.toString());
								txtcomboStore.getText();
								//int value1=Integer.parseInt(txtcomboStore.getText());
								ListProductInStore(deskStoreInventory,lstProductInStore,txtcomboStore.getText());
								ListProductNotInStore(deskStoreInventory,lstProductNotInStore,txtcomboStore.getText());		
								
							}
							
						}
					});
					comboStore.setFont(new Font("Tahoma", Font.PLAIN, 10));
					comboStore.setBounds(68, 24, 332, 18);
					deskStoreInventory.add(comboStore);
					

					
					

					
					txtProductNotInStore = new JTextField();
					txtProductNotInStore.setVisible(false);
					txtProductNotInStore.setBounds(10, 82, 38, 20);
					deskStoreInventory.add(txtProductNotInStore);
					txtProductNotInStore.setColumns(10);
					
					txtcomboStore = new JTextField();
					txtcomboStore.setVisible(false);
					txtcomboStore.setText("0");
					txtcomboStore.setBounds(410, 23, 48, 20);
					deskStoreInventory.add(txtcomboStore);
					txtcomboStore.setColumns(10);
					
					txtProductInStore = new JTextField();
					txtProductInStore.setVisible(false);
					txtProductInStore.setBounds(340, 79, 38, 20);
					deskStoreInventory.add(txtProductInStore);
					txtProductInStore.setColumns(10);
					
					
					
					
					// *******************   Fin Onglet   Manage WHITELIST **************************************************
					ListProductInStore(deskStoreInventory,lstProductInStore,txtcomboStore.getText());
					ListProductNotInStore(deskStoreInventory,lstProductNotInStore,txtcomboStore.getText());
					ListStores(deskStoreInventory,comboStore,StoreName);
					
					JButton btnNewButton_10 = new JButton("Quit");
					btnNewButton_10.setFont(new Font("Tahoma", Font.PLAIN, 10));
					btnNewButton_10.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.exit(0);
						}
					});
					btnNewButton_10.setBounds(764, 367, 107, 34);
					deskStoreInventory.add(btnNewButton_10);
					final JDesktopPane deskUser = new JDesktopPane();
					tabbedPane.addTab("Users               ", null, deskUser, null);
					JComboBox combotStoreUser = new JComboBox();
					combotStoreUser.setBounds(537, 203, 151, 22);
					combotStoreUser.setEnabled(UserRight);
					
					txtStoreLocation.setBounds(497, 56, 169, 20);
					desktStore.add(txtStoreLocation);
					txtStoreLocation.setColumns(10);
					
					JButton btnCreateStore = new JButton("Create store");
					btnCreateStore.setEnabled(UserRight);
					btnCreateStore.setFont(new Font("Tahoma", Font.PLAIN, 10));
					btnCreateStore.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						store.store store = new store.store();
						store.SetStoreName(txtStoreName.getText());
						store.SetStorelocation(txtStoreLocation.getText());

						store.CreateStore();
						ListStores(desktStore,listStore);ListStores(desktStore,listStore);
						ListStores(deskStoreInventory,comboStore,StoreName);
						ListStores(deskUser,combotStoreUser,StoreName);					}
				});
					btnCreateStore.setBounds(498, 87, 165, 45);
					desktStore.add(btnCreateStore);
	
					JComboBox comboUnit = new JComboBox();
					comboUnit.setFont(new Font("Tahoma", Font.PLAIN, 10));
					comboUnit.setBounds(800, 35, 94, 22);
					deskProduct.add(comboUnit);
					
					
					
					JButton btnUpdateStore = new JButton("Update store");
					btnUpdateStore.setEnabled(UserRight);
					btnUpdateStore.setFont(new Font("Tahoma", Font.PLAIN, 10));
					btnUpdateStore.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							store.store store = new store.store();
							int value;
	
							value=Integer.parseInt(TxtStoreId.getText());
	
							
							store.SetStoreId(value);
							store.SetStoreName(txtStoreName.getText());
							store.SetStorelocation(txtStoreLocation.getText());
	
							store.UpdateStore();
							ListStores(desktStore,listStore);
							ListStores(deskStoreInventory,comboStore,StoreName);
							ListStores(deskUser,combotStoreUser,StoreName);
								
							}
						});
				
					btnUpdateStore.setBounds(497, 143, 166, 45);
					desktStore.add(btnUpdateStore);
					
					JButton btnDeleteStore = new JButton("Delete store");
					btnDeleteStore.setEnabled(UserRight);
					btnDeleteStore.setFont(new Font("Tahoma", Font.PLAIN, 10));
					btnDeleteStore.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						store.store store = new store.store();
						int value=Integer.parseInt(TxtStoreId.getText());
						store.SetStoreId(value);
						
						store.DeleteStore();
						ListStores(desktStore,listStore);
						ListStores(deskStoreInventory,comboStore,"");
							
						}
					});
				
				
				
				btnDeleteStore.setBounds(497, 198, 166, 45);
				desktStore.add(btnDeleteStore);
				ListStores(desktStore,listStore);
				
				TxtStoreId = new JTextField();
				TxtStoreId.setVisible(false);
				TxtStoreId.setBounds(676, 26, 48, 20);
				desktStore.add(TxtStoreId);
				TxtStoreId.setColumns(10);
				
				JButton btnNewButton_7 = new JButton("Quit");
				btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
				btnNewButton_7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				btnNewButton_7.setBounds(497, 512, 169, 38);
				desktStore.add(btnNewButton_7);
				
				JLabel lblNewLabel_11_1 = new JLabel("Stores :");
				lblNewLabel_11_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
				lblNewLabel_11_1.setBounds(30, 26, 48, 14);
				desktStore.add(lblNewLabel_11_1);
		

		
			final JList listProduct = new JList();
			listProduct.setFont(new Font("Tahoma", Font.PLAIN, 10));
			listProduct.setBorder(new LineBorder(new Color(0, 0, 0)));
			listProduct.addMouseListener (new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            if (me.getClickCount() == 1) {
		               JList target = (JList)me.getSource();
		               int index = target.locationToIndex(me.getPoint());
		               if (index >= 0) {
	
		            	   Object value;
							txtProductName.setText("");
						
							if (index>=0)
							{
								value=donneesProduct[index][0];
								TxtProductId.setText(value.toString());
								value=donneesProduct[index][1];
								txtProductName.setText(value.toString());
								value=donneesProduct[index][2];
								TxtProductPrice.setText(value.toString());
								value=donneesProduct[index][4];
								comboUnit.setSelectedItem(value);
	
								
								
								
							}
		               }
		            }
		         }
			});
			listProduct.setBounds(85, 24, 374, 455);
		
		deskProduct.add(listProduct);
		
		JLabel lblNewLabel_7 = new JLabel("Products :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_7.setBounds(10, 26, 56, 14);
		deskProduct.add(lblNewLabel_7);
		
		btnAddProduct = new JButton("Add product");
		btnAddProduct.setEnabled(UserRight);
		
						btnAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 10));
						btnAddProduct.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								product.Product product = new product.Product();
								product.SetProductName(txtProductName.getText());
								product.SetProductdescription(txtProductDescription.getText());
								product.SetProductPrice(Integer.parseInt(TxtProductPrice.getText()));
								int j = comboUnit.getSelectedIndex();
								String b = donneesUOM[j][0].toString();
								product.SetUnitID(b);
								product.CreateProduct();
								ListProducts(deskProduct,listProduct);
								
							}
						});
					btnAddProduct.setBounds(538, 119, 157, 39);
					deskProduct.add(btnAddProduct);
					
					JLabel lblNewLabel_8 = new JLabel("Name :");
					lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 10));
					lblNewLabel_8.setBounds(469, 39, 48, 14);
					deskProduct.add(lblNewLabel_8);
					
					JLabel lblNewLabel_9 = new JLabel("Description :");
					lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 10));
					lblNewLabel_9.setBounds(469, 64, 75, 14);
					deskProduct.add(lblNewLabel_9);
					
					JLabel lblNewLabel_10 = new JLabel("Price :");
					lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 10));
					lblNewLabel_10.setBounds(469, 89, 48, 14);
					deskProduct.add(lblNewLabel_10);
					
					txtProductName = new JTextField();
					txtProductName.setEnabled(UserRight);
					txtProductName.setFont(new Font("Tahoma", Font.PLAIN, 10));
					txtProductName.setBounds(538, 36, 157, 20);
					deskProduct.add(txtProductName);
					txtProductName.setColumns(10);
					
					txtProductDescription = new JTextField();
					txtProductDescription.setEnabled(UserRight);
					txtProductDescription.setFont(new Font("Tahoma", Font.PLAIN, 10));
					txtProductDescription.setBounds(538, 61, 157, 20);
					deskProduct.add(txtProductDescription);
					txtProductDescription.setColumns(10);
					
					TxtProductPrice = new JTextField();
					TxtProductPrice.setEnabled(UserRight);
					TxtProductPrice.setFont(new Font("Tahoma", Font.PLAIN, 10));
					TxtProductPrice.setBounds(538, 86, 157, 20);
					TxtProductPrice.addKeyListener(new java.awt.event.KeyAdapter() {
			            public void keyTyped(KeyEvent evt) {
			                int len=TxtProductPrice.getText().length();
			                char c = evt.getKeyChar();
			                if (!(c >= '0' && c <= '9')) {
			                    evt.consume();
			                }
			                if (len>=6) {
			                  evt.consume();  
			                }
			                
			            }
			        });
					deskProduct.add(TxtProductPrice);
					TxtProductPrice.setColumns(10);
					
					JButton btnDeleteProduct = new JButton("Delete product");
					btnDeleteProduct.setEnabled(UserRight);
					btnDeleteProduct.setFont(new Font("Tahoma", Font.PLAIN, 10));
					btnDeleteProduct.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							product.Product product = new product.Product();
							if (TxtProductId.getText()!="")
							{
								int value=Integer.parseInt(TxtProductId.getText());
								product.SetProductId(value);
								
								product.DeleteProduct();
								ListProducts(deskProduct,listProduct);
							}
						}
					});
					btnDeleteProduct.setBounds(538, 224, 157, 44);
					deskProduct.add(btnDeleteProduct);
					
					JButton btnUpdateProduct = new JButton("Update product");
					btnUpdateProduct.setEnabled(UserRight);
					btnUpdateProduct.setFont(new Font("Tahoma", Font.PLAIN, 10));
					btnUpdateProduct.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						product.Product product = new product.Product();
						int value=Integer.parseInt(TxtProductId.getText());
						product.SetProductId(value);
						product.SetProductName(txtProductName.getText());
						product.SetProductPrice(Integer.parseInt(TxtProductPrice.getText()));
						int index=comboUnit.getSelectedIndex();
						String value1=donneesUOM[index][0].toString();
						System.out.println(value1);
						product.SetUnitID(value1);
						product.UpdateProduct();
						ListProducts(deskProduct,listProduct);
							
						}

					});
					btnUpdateProduct.setBounds(538, 169, 157, 44);
					deskProduct.add(btnUpdateProduct);
					ListProducts(deskProduct,listProduct);
					
					TxtProductId = new JTextField();
					TxtProductId.setVisible(false);
					TxtProductId.setBounds(732, 36, 25, 20);
					deskProduct.add(TxtProductId);
					TxtProductId.setColumns(10);
					
					JButton btnNewButton_8 = new JButton("Quit");
					btnNewButton_8.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.exit(0);
						}
					});
					btnNewButton_8.setBounds(538, 440, 157, 39);
					deskProduct.add(btnNewButton_8);
					
					
					JLabel lblNewLabel_8_1 = new JLabel("Unit :");
					lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
					lblNewLabel_8_1.setBounds(767, 39, 48, 14);
					deskProduct.add(lblNewLabel_8_1);
		

		deskUser.setLayout(null);
		JComboBox cmbRole = new JComboBox();
		cmbRole.setBounds(537, 170, 151, 22);
		cmbRole.setEnabled(UserRight);
		cmbRole.setFont(new Font("Tahoma", Font.PLAIN, 10));
		deskUser.add(cmbRole);
		

		
		//Listusers(desktopPane);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(490, 52, 46, 14);
		deskUser.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Surname :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(481, 86, 86, 14);
		deskUser.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pseudo :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(480, 114, 66, 14);
		deskUser.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(490, 27, 46, 14);
		deskUser.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("R\u00F4le :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(495, 174, 51, 14);
		deskUser.add(lblNewLabel_4);

				txtEmail = new JTextField();
				txtEmail.setBounds(537, 24, 151, 20);
				txtEmail.setEnabled(UserRight);
				txtEmail.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						
						BasicFunction.BasicFunction B=new BasicFunction.BasicFunction();
						boolean bOk;

						bOk=B.isValidEmailAdress(txtEmail.getText());
						if (!bOk)
						{
					
							showMessageDialog(null, "Format d'email incorrect");
							txtEmail.setText("");
						}
					}
				});
				deskUser.add(txtEmail);
				
						txtName = new JTextField();
						txtName.setBounds(537, 55, 151, 20);
						txtName.setEnabled(UserRight);
						txtName.setFont(new Font("Tahoma", Font.PLAIN, 10));
						txtName.addKeyListener(new java.awt.event.KeyAdapter() {
				            public void keyTyped(KeyEvent evt) {
				                int len=txtName.getText().length();
				                char c = evt.getKeyChar();
				                if (c >= '0' && c <= '9') {
				                    evt.consume();
				                }
				                if (len>=30) {
				                  evt.consume();  
				                }
				                
				            }
				        });
						deskUser.add(txtName);
						
						txtSurname = new JTextField();
						txtSurname.setBounds(537, 83, 151, 20);

						txtSurname.setEnabled(UserRight);
						txtSurname.setFont(new Font("Tahoma", Font.PLAIN, 10));
						txtSurname.addKeyListener(new java.awt.event.KeyAdapter() {
				            public void keyTyped(KeyEvent evt) {
				                int len=txtSurname.getText().length();
				                char c = evt.getKeyChar();
				                if (c >= '0' && c <= '9') {
				                    evt.consume();
				                }
				                if (len>=30) {
				                  evt.consume();  
				                }
				                
				            }
				        });
						deskUser.add(txtSurname);
						
						txtPseudo = new JTextField();
						txtPseudo.setBounds(537, 111, 151, 20);
						txtPseudo.setEnabled(UserRight);
						txtPseudo.setFont(new Font("Tahoma", Font.PLAIN, 10));
						txtPseudo.addKeyListener(new java.awt.event.KeyAdapter() {
				            public void keyTyped(KeyEvent evt) {
				                int len=txtPseudo.getText().length();

				                if (len>=30) {
				                  evt.consume();  
				                }
				                
				            }
				        });
						deskUser.add(txtPseudo);
						
						TxtId = new JTextField();
						TxtId.setVisible(false);
						TxtId.setBounds(729, 23, 36, 29);
						deskUser.add(TxtId);
						

						combotStoreUser.setBounds(537, 203, 151, 22);
						combotStoreUser.setEnabled(UserRight);
						combotStoreUser.setFont(new Font("Tahoma", Font.PLAIN, 10));
						deskUser.add(combotStoreUser);
						combotStoreUser.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								int index=combotStoreUser.getSelectedIndex();
								
								Object value;
								if (index>=0)
								{
									value=donneesStoreC[index][0];
									int value1=Integer.parseInt(value.toString());


									//int value1=Integer.parseInt(txtcomboStore.getText());
									
								}
								
							}
						});
						
						JButton btnUpdateuser = new JButton("Update user");
						btnUpdateuser.setBounds(535, 322, 151, 38);
						btnUpdateuser.setEnabled(UserRight);
						btnUpdateuser.setFont(new Font("Tahoma", Font.PLAIN, 10));

						deskUser.add(btnUpdateuser);
						
						JLabel lblNewLabel_5 = new JLabel("Password :");
						lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
						lblNewLabel_5.setBounds(470, 144, 66, 14);
						deskUser.add(lblNewLabel_5);
						
						JButton btnDeleteuser = new JButton("Delete user");
						btnDeleteuser.setBounds(535, 371, 151, 46);
						btnDeleteuser.setEnabled(UserRight);
						btnDeleteuser.setFont(new Font("Tahoma", Font.PLAIN, 10));
						
						
						final JList list = new JList();
						list.setBounds(85, 24, 375, 455);
						list.setFont(new Font("Tahoma", Font.PLAIN, 10));
						list.addMouseListener (new MouseAdapter() {
					         public void mouseClicked(MouseEvent me) {
					            if (me.getClickCount() == 1) {
					               JList target = (JList)me.getSource();
					               int index = target.locationToIndex(me.getPoint());
					               if (index >= 0) {

					            	   Object value;
;
										txtEmail.setText("");
										txtName.setText("");
										txtSurname.setText("");
										txtPassword.setText("");
										txtPseudo.setText("");
										cmbRole.setSelectedItem("");
										
										if (index>=0)
										{
											value=donnees[index][0];
											TxtId.setText(value.toString());
											value=donnees[index][1];
											txtEmail.setText(value.toString());
											value=donnees[index][2];
											txtName.setText(value.toString());
											value=donnees[index][3];
											txtSurname.setText(value.toString());
											value=donnees[index][4];
											txtPseudo.setText(value.toString());
											value=donnees[index][5];

											txtPassword.setText(value.toString());
											value=donnees[index][6];
											int i=Integer.parseInt(value.toString());

											cmbRole.setSelectedIndex(i-1);	
											value=donnees[index][7];

											i=Integer.parseInt(value.toString());

											combotStoreUser.setSelectedItem(donnees[index][8]);
										}
										boolean Enable;
										if (txtEmail.getText().compareTo(Login)==0)
										{
											Enable=true;

										}
										else
										{
											Enable=false;

										}	
										if (UserRight)
										{
											Enable=true;

										}

										TxtId.setEnabled(Enable);
										txtEmail.setEnabled(Enable);
										txtName.setEnabled(Enable);
										txtSurname.setEnabled(Enable);
										txtPseudo.setEnabled(Enable);
										txtPassword.setEnabled(Enable);
										txtPassword.setVisible(Enable);
										lblNewLabel_5.setVisible(Enable);
										btnUpdateuser.setEnabled(Enable);
										btnDeleteuser.setEnabled(Enable);

											
										}
					               }
					            
					         }
						});
						
						btnUpdateuser.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								user user = new user();
								int value=Integer.parseInt(TxtId.getText());
								user.SetUserId(value);
								user.SetUserMail(txtEmail.getText());
								user.SetUserName(txtName.getText());
								user.SetUserSurname(txtSurname.getText());
								user.SetUserPseudo(txtPseudo.getText());
								user.SetUserPassword(txtPassword.getText());
								
								int i=cmbRole.getSelectedIndex();
								String value1 =donneesRole[i][2].toString();
								int j=combotStoreUser.getSelectedIndex();
								String value2 =donneesStore[j][0].toString();								

								user.SetRoleId(value1);
								user.SetStoreId(value2);
								user.UpdateAccount();
								Listusers(deskUser,list);
								
							}
						});
						
						list.setBorder(new LineBorder(new Color(0, 0, 0)));
						deskUser.add(list);
						

						
						JButton btnCreateuser = new JButton("Create user");
						btnCreateuser.setVisible(false);
						btnCreateuser.setBounds(535, 260, 151, 38);
						btnCreateuser.setEnabled(UserRight);
						btnCreateuser.setFont(new Font("Tahoma", Font.PLAIN, 10));
						btnCreateuser.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								user user = new user();
								user.SetUserMail(txtEmail.getText());
								user.SetUserName(txtName.getText());
								user.SetUserSurname(txtSurname.getText());
								String Password=txtPassword.getText();
								BasicFunction.BasicFunction B=new BasicFunction.BasicFunction();
								Password=B.hashPassword(Password);
								

								user.SetUserPassword(Password);
								user.SetUserMail(txtPseudo.getText());
								int i = cmbRole.getSelectedIndex();
								String j=donneesRole[i][2]+"";
								int y= Integer.parseInt(j);
								int b = combotStoreUser.getSelectedIndex();
								String j1=donneesStore[b][0]+"";

								user.SetRoleId(j);
								user.SetStoreId(j1);
								user.CreateAccount();
								Listusers(deskUser,list);
							}
						});
						deskUser.add(btnCreateuser);
						
						final JDesktopPane deskWhiteList = new JDesktopPane();
						tabbedPane.addTab("Manage White List    ", null, deskWhiteList, null);
						tabbedPane.setEnabledAt(4, UserRight);
						deskWhiteList.setFont(null);
						
						final JList listWlist = new JList();
						listWlist.setFont(new Font("Tahoma", Font.PLAIN, 10));
						listWlist.setBorder(new LineBorder(new Color(0, 0, 0)));
						listWlist.addMouseListener (new MouseAdapter() {
					         public void mouseClicked(MouseEvent me) {
					            if (me.getClickCount() == 1) {
					               JList target = (JList)me.getSource();
					               int index = target.locationToIndex(me.getPoint());
					               if (index >= 0) {
					            	   Object value;
									
										if (index>=0)
										{
											value=donneesWList[index][0];
											txtWid.setText(value.toString());
											
										}
					               }
					            }
					         }
						});
						
						
						listWlist.setBounds(478, 65, 211, 333);
						deskWhiteList.add(listWlist);
						
						final JList listBlist = new JList();
						listBlist.setFont(new Font("Tahoma", Font.PLAIN, 10));
						listBlist.setBorder(new LineBorder(new Color(0, 0, 0)));
						listBlist.addMouseListener (new MouseAdapter() {
					         public void mouseClicked(MouseEvent me) {
					            if (me.getClickCount() == 1) {
					               JList target = (JList)me.getSource();
					               int index = target.locationToIndex(me.getPoint());
					               if (index >= 0) {
					            	   Object value;
									
										if (index>=0)
										{
											value=donneesBList[index][0];
											txtBid.setText(value.toString());
											
										}
					               }
					            }
					         }
						});
						
						listBlist.setBounds(87, 65, 211, 333);
						deskWhiteList.add(listBlist);

		
		JButton btnAddToWhiteList = new JButton("Add to WhiteList");
		btnAddToWhiteList.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAddToWhiteList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emailists.ListOfEmail ListOfEmail = new emailists.ListOfEmail();
				int index = listBlist.getSelectedIndex();
				if (!txtBid.getText().isEmpty())
				{
					int value=Integer.parseInt(txtBid.getText());
					ListOfEmail.SetEMailId(value);
					txtBid.setText("");


					ListOfEmail.SetEMail(donneesBList[index][1].toString());
					ListOfEmail.SetName(donneesBList[index][2].toString());
					ListOfEmail.SetSurname(donneesBList[index][3].toString());
					ListOfEmail.SetStoreId(donneesStore[0][0].toString());
					ListOfEmail.PutInWhiteList();
					ListEmailWhiteList(deskWhiteList,listWlist);						
					ListEmailBlackList(deskWhiteList,listBlist);
					Listusers(deskUser,list);
				}

			}
		});
		btnAddToWhiteList.setBounds(320, 151, 141, 58);
		deskWhiteList.add(btnAddToWhiteList);
						

						btnDeleteuser.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								user user = new user();
								int value=Integer.parseInt(TxtId.getText());
								user.SetUserId(value);
								user.SetUserMail(txtEmail.getText());
								user.DeleteAccount();
								Listusers(deskUser,list);
								ListEmailWhiteList(deskWhiteList,listWlist);						
								ListEmailBlackList(deskWhiteList,listBlist);
								
							}
						});
						deskUser.add(btnDeleteuser);
						

						
								
						JLabel lblNewLabel_6 = new JLabel("Utilisateurs :");
						lblNewLabel_6.setBounds(19, 26, 78, 14);
						deskUser.add(lblNewLabel_6);
						

						Listusers(deskUser,list);
						ListEmailWhiteList(deskWhiteList,listWlist);						
						ListEmailBlackList(deskWhiteList,listBlist);
						
						JButton btnNewButton_9 = new JButton("Quit");
						btnNewButton_9.setBounds(537, 441, 151, 38);
						btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 10));
						btnNewButton_9.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.exit(0);
							}
						});
						deskUser.add(btnNewButton_9);

		
		
		// *******************   Onglet   Manage WHITELIST **************************************************
		
	
		
		JLabel lblNewLabel_16 = new JLabel("Whitelist :");
		lblNewLabel_16.setBounds(405, 67, 63, 14);
		deskWhiteList.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("BlackList :");
		lblNewLabel_17.setBounds(10, 67, 61, 14);
		deskWhiteList.add(lblNewLabel_17);
		
		JButton btnRemoveFromWhiteList = new JButton("Remove from Whitelist");
		btnRemoveFromWhiteList.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRemoveFromWhiteList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emailists.ListOfEmail ListOfEmail = new emailists.ListOfEmail();
				int index = listWlist.getSelectedIndex();
				if (!txtWid.getText().isEmpty())
				{
					ListOfEmail.SetEMailId(Integer.parseInt(txtWid.getText()));
					ListOfEmail.SetEMail(donneesWList[index][1].toString());
					txtWid.setText("");
					ListOfEmail.PutInBlackList();
					ListEmailWhiteList(deskWhiteList,listWlist);						
					ListEmailBlackList(deskWhiteList,listBlist);
					Listusers(deskUser,list);
				}
			}
		});
		btnRemoveFromWhiteList.setBounds(320, 221, 141, 58);
		deskWhiteList.add(btnRemoveFromWhiteList);
		
		ListEmailWhiteList(deskWhiteList,listWlist);						
		ListEmailBlackList(deskWhiteList,listBlist);	
		
		txtBid = new JTextField();
		txtBid.setVisible(false);
		txtBid.setBounds(10, 93, 36, 20);

		
		deskWhiteList.add(txtBid);
		txtBid.setColumns(10);
		
		txtWid = new JTextField();
		txtWid.setVisible(false);
		txtWid.setBounds(415, 92, 39, 20);
		deskWhiteList.add(txtWid);
		txtWid.setColumns(10);
		
		JButton btnNewButton = new JButton("Refresh List");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListEmailWhiteList(deskWhiteList,listWlist);						
				ListEmailBlackList(deskWhiteList,listBlist);
				
			}
		});
		btnNewButton.setBounds(320, 364, 141, 34);
		deskWhiteList.add(btnNewButton);
		ListRole(deskUser,cmbRole);
		ListStores(deskUser,combotStoreUser,StoreName);
		ListUniteofmeasure(deskProduct,comboUnit);

		
		JLabel lblNewLabel_2_1 = new JLabel("Store :");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_1.setBounds(490, 207, 66, 14);
		deskUser.add(lblNewLabel_2_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(537, 139, 151, 20);
		txtPassword.setEnabled(UserRight);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 10));
		deskUser.add(txtPassword);
				
	


	
	}
}