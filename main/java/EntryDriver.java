import java.util.ArrayList;
import java.util.List;

public class EntryDriver {
	ArrayList<EntryData>  drivers;
	int raceNumber = -1;
	int forcedCarModel = -1;
	int overrideDriverInfo = 1;
	int isServerAdmin = 0;
	
	public ArrayList<EntryData> getDrivers() {
		return drivers;
	}
	public void setDrivers(ArrayList<EntryData> drivers) {
		this.drivers = drivers;
	}
	public int getRaceNumber() {
		return raceNumber;
	}
	public void setRaceNumber(int raceNumber) {
		this.raceNumber = raceNumber;
	}
	public int getForcedCarModel() {
		return forcedCarModel;
	}
	public void setForcedCarModel(int forcedCarModel) {
		this.forcedCarModel = forcedCarModel;
	}
	public int getOverrideDriverInfo() {
		return overrideDriverInfo;
	}
	public void setOverrideDriverInfo(int overrideDriverInfo) {
		this.overrideDriverInfo = overrideDriverInfo;
	}
	public int getIsServerAdmin() {
		return isServerAdmin;
	}
	public void setIsServerAdmin(int isServerAdmin) {
		this.isServerAdmin = isServerAdmin;
	}
	


}
