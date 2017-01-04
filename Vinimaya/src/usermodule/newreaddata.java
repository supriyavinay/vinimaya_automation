
package usermodule;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import statements
public class newreaddata 
{
	public static void main(String[] args) 
	{
		try
		{
			FileInputStream file = new FileInputStream(new File("D:/Selenium Automation/Vinimaya/bin/excelExportAndFileIO/ExportExcel.xlsx"));

			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) 
				{
					Cell cell = cellIterator.next();
					//Check the cell type and format accordingly
					switch (cell.getCellType()) 
					{

					case Cell.CELL_TYPE_STRING:
						//System.out.print(cell.getStringCellValue() + " , ");
						String first = cell.getStringCellValue();
						//setVal2(first);
						System.out.println("A : " + first);
						//System.out.println("Value of cell is : " + first);

						break;
						
					case Cell.CELL_TYPE_NUMERIC:
						//System.out.print(cell.getNumericCellValue() + " , ");

						double i = cell.getNumericCellValue();
						//System.out.println("price value : " +i);

						//setVal1(i);
						System.out.println("B : " + i);

						break;
					}
				}
				System.out.println("");
			}
			file.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}

