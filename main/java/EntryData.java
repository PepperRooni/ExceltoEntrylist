
public class EntryData {

	String firstName;
	String lastName;
	String shortName;
	String playerID;
	
	public EntryData() {
		this.firstName = null;
		this.lastName = null;
		this.shortName = null;
		this.playerID = null;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getPlayerID() {
		return playerID;
	}

	public void setPlayerID(String steamIdDriver1) {
		this.playerID = steamIdDriver1;
	}
	
	public String toString() {
		return "\"drivers\": [" + "\r\n" + "],";
	}
	
	

	
}
