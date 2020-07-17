package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriver {

	FileInputStream fin;
	XSSFWorkbook wb;
	XSSFSheet st;
	XSSFRow rw;
	XSSFCell cl;
	
	public int getRowCount(String xlfilePath, int xlSheet ) throws IOException {
		fin= new FileInputStream(xlfilePath);
		wb= new XSSFWorkbook(fin);
		st = wb.getSheetAt(xlSheet);
		int rowCount =st.getLastRowNum();
		
		
		return rowCount;
		
	}
	
	public int getCellCount(String xlfilePath, int xlSheet,int romNumber) throws Exception {
		fin= new FileInputStream(xlfilePath);
		wb= new XSSFWorkbook(fin);
		st = wb.getSheetAt(xlSheet);
		rw = st.getRow(romNumber);
		int cellCount = rw.getLastCellNum();
		
		
		return cellCount;
		
		
	}
	
	public String getCellData(String xlfilePath, int xlSheet,int romNumber,int cellNumber) throws Exception {
		fin= new FileInputStream(xlfilePath);
		wb= new XSSFWorkbook(fin);
		st = wb.getSheetAt(xlSheet);
		rw = st.getRow(romNumber);
		cl = rw.getCell(cellNumber);
		
	
		
		String alldata = st.getRow(romNumber).getCell(cellNumber).getStringCellValue();
		return alldata;
		
		
	}
	
	

}
