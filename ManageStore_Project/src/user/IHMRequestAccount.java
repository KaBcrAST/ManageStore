package user;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IHMRequestAccount extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtName;
	private JTextField txtSurname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMRequestAccount frame = new IHMRequestAccount();
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
	public IHMRequestAccount() {
		setTitle("Store manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("E-mail");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(40, 43, 48, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(40, 68, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Surname :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(40, 93, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtEmail.setBounds(102, 40, 136, 20);
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
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtName.setBounds(102, 68, 136, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
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
		
		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtSurname.setBounds(102, 93, 136, 20);
		contentPane.add(txtSurname);
		txtSurname.setColumns(10);
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
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtEmail.getText()!="" && txtName.getText()!="")
				{
					RequestAccount RequestAccount=new RequestAccount();
					RequestAccount.email=txtEmail.getText();
					RequestAccount.Name=txtName.getText();;
					RequestAccount.Surname=txtSurname.getText();
					Boolean bOk= RequestAccount.RequestForAnAccount();
				}
			}
				
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(149, 130, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.setBounds(149, 164, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Request for an account on Store Manager");
		lblNewLabel_3.setBounds(40, 11, 269, 14);
		contentPane.add(lblNewLabel_3);
	}
}
