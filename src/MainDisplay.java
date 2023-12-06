import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainDisplay extends JFrame implements Display {

	private JPanel contentPane;
	private JTextField txtTemperature;
	private JTextField txtHumidity;
	private JTextField txtPressure;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainDisplay frame = new MainDisplay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// @Override
	public WeatherData update(float temperature, float humidity, float pressure) {
		WeatherData weatherData = new WeatherData(temperature, humidity, pressure);
		return weatherData;
	}

	/**
	 * Create the frame.
	 */
	public MainDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTemperature = new JTextField();
		txtTemperature.setBounds(29, 28, 86, 20);
		contentPane.add(txtTemperature);
		txtTemperature.setColumns(10);
		
		txtHumidity = new JTextField();
		txtHumidity.setColumns(10);
		txtHumidity.setBounds(29, 70, 86, 20);
		contentPane.add(txtHumidity);
		
		txtPressure = new JTextField();
		txtPressure.setColumns(10);
		txtPressure.setBounds(29, 109, 86, 20);
		contentPane.add(txtPressure);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WeatherData weatherData = update(Float.parseFloat(txtTemperature.getText()), Float.parseFloat(txtHumidity.getText()), Float.parseFloat(txtPressure.getText()));
				JOptionPane.showMessageDialog(null, "Temperature: " + weatherData.getTemperature());
			}
		});
		btnUpdate.setBounds(167, 69, 89, 23);
		contentPane.add(btnUpdate);
	}
}
