import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Zaif Yusuf 01/04/2021
 */



public class ExcelReader {
	
	
	
	
    public static final String SAMPLE_XLS_FILE_PATH = "./sample-xls-file.xls";
//    public static final String TWO_DRIVER_TEAM_LIST = "C:\\Users\\Equipo\\Documents\\ExcelReaderTesting1.xlsx";
//    public static final String THREE_DRIVER_TEAM_LIST = "C:\\Users\\Equipo\\Documents\\ExcelReaderTesting2.xlsx";

  
    
    
    static ArrayList<EntryData> valueList = new ArrayList<EntryData>();
    static ArrayList<EntryData> valueList2 = new ArrayList<EntryData>();
    static ArrayList<EntryDriver> driverList = new ArrayList<EntryDriver>();
    static ArrayList<Integer> raceNumberList = new ArrayList<Integer>();
    
    public static void main(String[] args) throws IOException, InvalidFormatException {

    	
    	Scanner consoleInput = new Scanner(System.in);
    	System.out.println("Insert the path of the TWO driver entry list spreadsheet:\n"
    			+ " Example:\"C:\\Users\\Me\\Documents\\TwoDriverEntries.xlsx\"");
    	String TWO_DRIVER_TEAM_LIST = consoleInput.nextLine();
    	System.out.println("Insert the path of the THREE driver entry list:\n"
    			+ " Example:\"C:\\\\Users\\\\Me\\\\Documents\\\\ThreeDriverEntries.xlsx\"");
    	String THREE_DRIVER_TEAM_LIST = consoleInput.nextLine();
    	
        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(TWO_DRIVER_TEAM_LIST));
        Workbook workbook2 = WorkbookFactory.create(new File(THREE_DRIVER_TEAM_LIST));

        // Retrieving the number of sheets in the Workbook
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        Iterator<Sheet> sheetIterator2 = workbook2.sheetIterator();

        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
        }
        
        while (sheetIterator2.hasNext()) {
        	Sheet sheet2 = sheetIterator2.next();
        }


        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);
        Sheet sheet2 = workbook2.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();
        DataFormatter dataFormatter2 = new DataFormatter();

     // obtain a rowIterator and columnIterator and iterate over them
        Iterator<Row> rowIterator = sheet.rowIterator();
        EntryDriver list = new EntryDriver();
        
        Iterator<Row> rowIterator2 = sheet2.rowIterator();
        EntryDriver list2 = new EntryDriver();
        
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();
            EntryData data = new EntryData();
            
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                if(cell.getColumnIndex()==0) {
                	data.setFirstName(cellValue);
                }else  if(cell.getColumnIndex()==1) {
                	data.setLastName(cellValue);
                }
                else  if(cell.getColumnIndex()==2) {
                	data.setShortName(cellValue);
                }
                else  if(cell.getColumnIndex()==3) {
                	data.setPlayerID(cellValue);
                }else if(cell.getColumnIndex()==4) {
                	int cellValueInt = Integer.parseInt(cellValue);
                	raceNumberList.add(cellValueInt);
                }
            }
            valueList.add(data);

        }
        
        while (rowIterator2.hasNext()) {
            Row row = rowIterator2.next();
            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();
            EntryData data = new EntryData();
            
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                if(cell.getColumnIndex()==0) {
                	data.setFirstName(cellValue);
                }else  if(cell.getColumnIndex()==1) {
                	data.setLastName(cellValue);
                }
                else  if(cell.getColumnIndex()==2) {
                	data.setShortName(cellValue);
                }
                else  if(cell.getColumnIndex()==3) {
                	data.setPlayerID(cellValue);
                }else if(cell.getColumnIndex()==4) {
                	int cellValueInt = Integer.parseInt(cellValue);
                	raceNumberList.add(cellValueInt);
                }
            }
            valueList2.add(data);

        }

        
        ObjectMapper mapper = new ObjectMapper();

        
        int count = 0;
        int count2 = 0;
        int raceNumberCount = 0;
        
                  
        //inserting the values of the 2 driver teams
        for(int i = 0; i < valueList.size()/2; i++) {
         ArrayList<EntryData> newTeamDrivers = new ArrayList<EntryData>();
        	for(int j = 0; j < 2; j++) {
        		newTeamDrivers.add(valueList.get(count));
        		count++;
        	}
        EntryDriver newTeam = new EntryDriver();
        newTeam.setDrivers(newTeamDrivers);
        newTeam.setRaceNumber(raceNumberList.get(raceNumberCount));
        raceNumberCount++;
        driverList.add(newTeam);
         }
        
        //inserting the values of the 3 driver teams
        for(int i = 0; i < valueList2.size()/3; i++) {
            ArrayList<EntryData> newTeamDrivers = new ArrayList<EntryData>();
           	for(int j = 0; j < 3; j++) {
           		newTeamDrivers.add(valueList2.get(count2));
           		count2++;
           	}
           EntryDriver newTeam = new EntryDriver();
           newTeam.setDrivers(newTeamDrivers);
           newTeam.setRaceNumber(raceNumberList.get(raceNumberCount));
           raceNumberCount++;
           driverList.add(newTeam);
            }
        
        EntryWrapper entryList = new EntryWrapper();
        entryList.setEntries(driverList);
        String driversJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entryList);
        System.out.println(driversJsonString);
        
        

        // Closing both workbooks
        workbook.close();
        workbook2.close();
        
//        Closing the scanner
        consoleInput.close();
    }

    
    public static ArrayList<EntryData> getValueList() {
    	return  valueList;
    }
    public static ArrayList<EntryData> getValueList2(){
    	return valueList2;
    }
}
