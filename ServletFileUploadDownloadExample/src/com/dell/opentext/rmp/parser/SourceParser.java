/**
 * 
 */
package com.dell.opentext.rmp.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.collections4.listValueMap;

import com.sun.rowset.internal.Row;

import javafx.scene.control.Cell;

/**
 * @author mishrn4
 *
 */
public class SourceParser {

	/**
	 * 
	 */
	public SourceParser() {
		// TODO Auto-generated constructor stub
	}
	
	public void readExcel () throws FileNotFoundException
	{
		
		try {
			String file ="C:\\Users\\mishrn4\\Desktop\\OpenText_RMP_Project\\SampleTest.xls";
			FileInputStream excelSourceRead = new FileInputStream(file);
			System.out.println("file reading completed");
			Workbook workbook = new XSSFWorkbook(excelSourceRead);
			Sheet dataSheet = workbook.getSheetAt(0);
			 Iterator iterator = dataSheet.iterator();
			 
			 while (iterator.hasNext())
			 {
				 Row currentRow = (Row) iterator.next();
				 Iterator<org.apache.poi.ss.usermodel.Cell> cellIterator = ((Iterable<org.apache.poi.ss.usermodel.Cell>) currentRow).iterator();
				 System.out.println("Row is selected");
			while (cellIterator.hasNext())
			{
				Cell currentCell = (Cell) cellIterator.next();
				System.out.println("Going to print cell");
				System.out.println("Cell Value" + currentCell);
			}
				 
			 }
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception Source Parser");
		}
		
	}

}
