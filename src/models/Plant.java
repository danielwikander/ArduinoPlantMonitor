package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a plant.
 * The object contains the plants information, such as name, icon etc.
 */
public class Plant implements Serializable {

	private static final long serialVersionUID = 2679207460693826435L;
	private ArrayList<DataPoint> dataPoints;
	private String plantIconFile;
	private String plantSpecies;
	private String mac;
	private String email;
	private String alias;
	private boolean soilMoistureMonitor;
	private int soilMoistureMax;
	private int soilMoistureMin;
	private boolean humidityMonitor;
	private int humidityMax;
	private int humidityMin;
	private boolean temperatureMonitor;
	private int temperatureMax;
	private int temperatureMin;

	/**
	 * Constructor that sets the plants variables.
	 * @param plantSpecies	The type of plant.
	 */
	public Plant(String mac, String email, String plantSpecies, String alias,
				 boolean soilMoistureMonitor, int soilMoistureMax, int soilMoistureMin,
				 boolean humidityMonitor, int humidityMax, int humidityMin,
				 boolean temperatureMonitor, int temperatureMax, int temperatureMin) {
		this.mac = mac;
		this.email = email;
		this.plantSpecies = plantSpecies;
		this.alias = alias;
		this.soilMoistureMonitor = soilMoistureMonitor;
		this.soilMoistureMax = soilMoistureMax;
		this.soilMoistureMin = soilMoistureMin;
		this.humidityMonitor = humidityMonitor;
		this.humidityMax = humidityMax;
		this.humidityMin = humidityMin;
		this.temperatureMonitor = temperatureMonitor;
		this.temperatureMax = temperatureMax;
		this.temperatureMin = temperatureMin;
		this.plantIconFile = "client/images/" + plantSpecies + ".png";
	}

	public ArrayList<DataPoint> getDataPoints() {
		return dataPoints;
	}

	public void setDataPoints(ArrayList<DataPoint> dataPoints) {
		this.dataPoints = dataPoints;
	}

	public void setPlantSpecies(String plantSpecies) {
		this.plantSpecies = plantSpecies;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setPlantIconFile(String plantIconFile) {
		this.plantIconFile = plantIconFile;
	}

	/**
	 * Returns the path to the plants icon file.
	 * @return	Returns the path to the icon.
	 */
	public String getPlantIconFile() {
		return plantIconFile;
	}

	/**
	 * Returns the plants alias.
	 * @return Returns the alias.
	 */
	public String getPlantAlias() {
		return alias;
	}

	/**
	 * Returns the plant species (if specified).
	 * @return Returns the species.
	 */
	public String getPlantSpecies() {
		return plantSpecies;
	}
	
	public boolean monitoringSoilMoisture() {
		return soilMoistureMonitor;
	}

	public void setSoilMoistureMonitor(boolean soilMoistureMonitor) {
		this.soilMoistureMonitor = soilMoistureMonitor;
	}

	public int getSoilMoistureMax() {
		return soilMoistureMax;
	}

	public void setSoilMoistureMax(int soilMoistureMax) {
		this.soilMoistureMax = soilMoistureMax;
	}

	public int getSoilMoistureMin() {
		return soilMoistureMin;
	}

	public void setSoilMoistureMin(int soilMoistureMin) {
		this.soilMoistureMin = soilMoistureMin;
	}

	public boolean monitoringHumidity() {
		return humidityMonitor;
	}

	public void setHumidityMonitor(boolean humidityMonitor) {
		this.humidityMonitor = humidityMonitor;
	}

	public int getHumidityMax() {
		return humidityMax;
	}

	public void setHumidityMax(int humidityMax) {
		this.humidityMax = humidityMax;
	}

	public int getHumidityMin() {
		return humidityMin;
	}

	public void setHumidityMin(int humidityMin) {
		this.humidityMin = humidityMin;
	}

	public boolean monitoringTemperature() {
		return temperatureMonitor;
	}

	public void setTemperatureMonitor(boolean temperatureMonitor) {
		this.temperatureMonitor = temperatureMonitor;
	}

	public int getTemperatureMax() {
		return temperatureMax;
	}

	public void setTemperatureMax(int temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	public int getTemperatureMin() {
		return temperatureMin;
	}

	public void setTemperatureMin(int temperatureMin) {
		this.temperatureMin = temperatureMin;
	}
}