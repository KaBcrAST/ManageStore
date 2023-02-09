package user;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Page_conn extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page_conn frame = new Page_conn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Page_conn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(221, 112, 1, 1);
		contentPane.add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(108, 65, 65, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(108, 112, 65, 24);
		contentPane.add(lblPassword);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(168, 181, 89, 23);
		contentPane.add(btnQuit);
		
		txtLogin = new JTextField();
		txtLogin.setText("admin@store.fr");
		txtLogin.setBounds(168, 67, 189, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JButton btnSignin = new JButton("Sign in");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connexion connect=new Connexion();
				connect.Login=txtLogin.getText();
				connect.Password=txtPassword.getText();

				if (!connect.signin())
				{
					showMessageDialog(null, "Identifiant invalide");
				}
				else
				{

					userIHM1 IHM=new userIHM1(connect.Login,connect.RoleId, connect.StoreName);

					IHM.setVisible(true);
					dispose();


					
				}
				
				
			}
			
		});
		
		btnSignin.setBounds(168, 147, 89, 23);
		contentPane.add(btnSignin);
		txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                int len=txtLogin.getText().length();
                char c = evt.getKeyChar();
                
                if (len>=25) {
                  evt.consume();  
                }
                
            }
        });
		txtLogin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				BasicFunction.BasicFunction B=new BasicFunction.BasicFunction();
				boolean bOk;

				bOk=B.isValidEmailAdress(txtLogin.getText());
				if (!bOk)
				{
			
					showMessageDialog(null, "Format d'email incorrect");
					txtLogin.setText("");
				}
			}
		});
		
		txtPassword = new JPasswordField();
		txtPassword.setText("admin");
		txtPassword.setToolTipText("");
		txtPassword.setBounds(168, 112, 134, 20);
		contentPane.add(txtPassword);
	}
}
