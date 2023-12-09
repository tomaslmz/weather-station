package views;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import models.WeatherData;
import models.WeatherDataCentral;
import models.Updater;
import models.WeatherStation;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainDisplay extends JFrame implements Display {

	private JPanel contentPane;
	private JTextField txtMinTemp;
	private JTextField txtHumidity;
	private JTextField txtPressure;
	private JTable table;
	private JTextField txtMaxTemp;

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
	public WeatherData update(float minTemp, float maxTemp, float humidity, float pressure) {
		WeatherData weatherData = new WeatherData(minTemp, maxTemp, humidity, pressure);
		return weatherData;
	}

	public static boolean isNumeric(String str) { 
		try {  
			Double.parseDouble(str);  
			return true;
		} catch(NumberFormatException e){  
			return false;  
		}  
	}

	/**
	 * Create the frame.
	 */
	public MainDisplay() {
		Updater updater = new Updater();
		WeatherDataCentral weatherDataCentral = new WeatherDataCentral();
		WeatherStation station1 = new WeatherStation();

		updater.addSubscriber(weatherDataCentral);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMinTemp = new JTextField("0");
		txtMinTemp.setBounds(56, 69, 86, 20);
		contentPane.add(txtMinTemp);
		txtMinTemp.setColumns(10);
		
		txtHumidity = new JTextField("0");
		txtHumidity.setColumns(10);
		txtHumidity.setBounds(399, 69, 86, 20);
		contentPane.add(txtHumidity);
		
		txtPressure = new JTextField("0");
		txtPressure.setColumns(10);
		txtPressure.setBounds(589, 69, 86, 20);
		contentPane.add(txtPressure);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Temperature min", "Temperature max", "Humidity", "Pressure", "Avg. temperature"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(98);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(102);
		table.setBounds(10, 226, 735, 122);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 182, 735, 160);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!(isNumeric(txtMinTemp.getText()) && isNumeric(txtMaxTemp.getText()) && isNumeric(txtHumidity.getText()) && isNumeric(txtPressure.getText()))) {
						throw new Exception("Os valores devem conter apenas números!");
					}

					WeatherData weatherData = update(Float.parseFloat(txtMinTemp.getText()), Float.parseFloat(txtMaxTemp.getText()), Float.parseFloat(txtHumidity.getText()), Float.parseFloat(txtPressure.getText()));

					station1.setWeatherData(weatherData);
					
					updater.sendUpdate(station1.getWeatherData());

//					JOptionPane.showMessageDialog(null, "Min temperature: " + weatherDataCentral.getData().getMinTemp() + "\nMax temperature: " + weatherDataCentral.getData().getMaxTemp() + "\nHumidity: " + weatherDataCentral.getData().getHumidity() + "\nPressure: " + weatherDataCentral.getData().getPressure() + "\nAverage temperature: " + weatherDataCentral.getData().getAverageTemp());
					model.addRow(new Object[] {weatherDataCentral.getData().getMinTemp(), weatherDataCentral.getData().getMaxTemp(), weatherDataCentral.getData().getHumidity(), weatherDataCentral.getData().getPressure(), weatherDataCentral.getData().getAverageTemp()});
				} catch(Exception err) {
					JOptionPane.showMessageDialog(null, err.getMessage());
				}
			}
		});
		btnUpdate.setBounds(316, 100, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblNewLabel = new JLabel("Temperature min");
		lblNewLabel.setBounds(56, 44, 130, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblHumidity = new JLabel("Humidity");
		lblHumidity.setBounds(399, 44, 86, 14);
		contentPane.add(lblHumidity);
		
		JLabel lblPressure = new JLabel("Pressure");
		lblPressure.setBounds(589, 44, 86, 14);
		contentPane.add(lblPressure);
		
		
		
		txtMaxTemp = new JTextField("0");
		txtMaxTemp.setColumns(10);
		txtMaxTemp.setBounds(223, 69, 86, 20);
		contentPane.add(txtMaxTemp);
		
		JLabel lblTemperatureMax = new JLabel("Temperature max");
		lblTemperatureMax.setBounds(223, 44, 130, 14);
		contentPane.add(lblTemperatureMax);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() > -1) {
					model.removeRow(table.getSelectedRow());
				} else {
					JOptionPane.showMessageDialog(null, "You should selected a row in the table!");
				}
			}
		});
		btnDelete.setBounds(316, 134, 89, 23);
		contentPane.add(btnDelete);
	}
}
