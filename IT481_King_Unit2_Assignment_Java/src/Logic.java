import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class Logic extends JFrame {

	private JPanel contentPane;
	private DB database;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logic frame = new Logic();
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
	public Logic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConnect = new JLabel("Connect");
		lblConnect.setBounds(15, 65, 50, 20);
		contentPane.add(lblConnect);

		JButton btnConnect = new JButton("Connect to Northwind DB");
		btnConnect.setBounds(100, 60, 200, 30);
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String dbURL = "jdbc:sqlserver://IRONMAN\\SQLEXPRESS03;"
							+ "database=Northwind;"
							+ "user=sa;"
							+ "password=GetOffMyLawn;"
							+ "encrypt=false;"
							+ "trustServerCertificate=false;"
							+ "loginTimeout=30;";			
					database = new DB(dbURL);
					JOptionPane.showMessageDialog(null, "Connected");
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				}
			});
		
		contentPane.add(btnConnect);
		
		JLabel lblCount = new JLabel("Count");
		lblCount.setBounds(15, 140, 50, 20);
		contentPane.add(lblCount);
		
		JButton btnCount = new JButton("Customer Count");
		btnCount.setBounds(100, 135, 200, 30);
		btnCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String countValue = database.getCustomerCount();
					JOptionPane.showMessageDialog(null, "The customer count is: " + countValue);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		contentPane.add(btnCount);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(15, 215, 50, 20);
		contentPane.add(lblName);
		
		JButton btnName = new JButton("Get Company Names");
		btnName.setBounds(100, 210, 200, 30);
		btnName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nameValue = database.getCompanyNames();
					javax.swing.JOptionPane.showMessageDialog(null, "Our Customer names are: " + nameValue);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		contentPane.add(btnName);		
	}

}
