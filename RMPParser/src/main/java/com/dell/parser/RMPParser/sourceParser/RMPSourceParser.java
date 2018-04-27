package com.dell.parser.RMPParser.sourceParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import  org.apache.poi.ss.usermodel.Row;



import javafx.scene.control.Cell;

public class RMPSourceParser {

	public RMPSourceParser() {
		// TODO Auto-generated constructor stub
	}

	public void readExcel () throws FileNotFoundException
	{
		
		try {
			String file ="C:\\Users\\mishrn4\\Desktop\\OpenText_RMP_Project\\SampleTest.xls";
			FileInputStream excelSourceRead = new FileInputStream(file);
			System.out.println("file reading completed");
			Workbook workbook = new HSSFWorkbook(excelSourceRead);
			Sheet dataSheet = workbook.getSheet("Source Structure");
			 Iterator iterator = dataSheet.iterator();
			 
			 System.out.println("Printing name of sheets");

			 for (int j = 0; j < workbook.getNumberOfSheets(); j++) {
				 System.out.println("Sheet Name " + j +workbook.getSheetName(j));
			}
			 
			 
			 
			 while (iterator.hasNext())
			 {
				// System.out.println("inside row");
				Row row = (Row) iterator.next();
				System.out.println(row.getLastCellNum());
				//Iterator<org.apache.poi.ss.usermodel.Cell> cellItr = row.iterator();
				 
				// HSSRow currentRow = (Row) iterator.next();
				 //HSSFRow currentRow = dataSheet.getRo
				// HSSFCell currentCell = (HSSFCell) currentRow.getCell(0);
				// System.out.println(currentCell.getStringCellValue());
				 
				 //System.out.println("Row is selected");
			/*while (cellItr.hasNext())
			{
				org.apache.poi.ss.usermodel.Cell cell = cellItr.next();
				//System.out.println("Going to print cell");
				System.out.println("Cell Value " + cellItr.next());
			}*/
				 
			 }
			// workbook.close();
			
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception Source Parser");
		}
		
	}

}
