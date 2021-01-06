import java.util.ArrayList;
import java.util.List;

public class EntryWrapper {
	ArrayList<EntryDriver> entries;
	String forceEntryList = "1";
	public ArrayList<EntryDriver> getEntries() {
		return entries;
	}
	public void setEntries(ArrayList<EntryDriver> entries) {
		this.entries = entries;
	}
	public String getForceEntryList() {
		return forceEntryList;
	}
	public void setForceEntryList(String forceEntryList) {
		this.forceEntryList = forceEntryList;
	}
	
}
