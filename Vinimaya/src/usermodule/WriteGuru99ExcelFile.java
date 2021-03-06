

package usermodule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteGuru99ExcelFile extends beanClass

{

	int ij=1;
	int hj=2;
	
	static String two=getOutp();
	static String one=getDetails();
	

    public void writeExcel(String filePath,String fileName,String sheetName,String[] dataToWrite) throws Throwable{

        //Create a object of File class to open xlsx file

        File file =    new File(filePath+"\\"+fileName);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook guru99Workbook = null;

        //Find the file extension by spliting file name in substing and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if(fileExtensionName.equals(".xlsx")){

        //If it is xlsx file then create object of XSSFWorkbook class

        guru99Workbook = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of XSSFWorkbook class

            guru99Workbook = new HSSFWorkbook(inputStream);

        }

        

    //Read excel sheet by sheet name    

    Sheet sheet = guru99Workbook.getSheet(sheetName);

    //Get the current count of rows in excel file

    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

    //Get the first row from the sheet

    Row row = sheet.getRow(0);
    //System.out.println("rowcount  "+rowCount);
    //System.out.println("currrow  "+row);
   
    //Create a new row and append it at last of sheet

    Row newRow = sheet.createRow(rowCount+1);
   // System.out.println("newRow  "+newRow);
    //Create a loop over the cell of newly created Row

    for(int j = 0; j < row.getLastCellNum(); j++){

        //Fill data in row

        Cell cell = newRow.createCell(j);

        cell.setCellValue(dataToWrite[j]);

    }

    //Close input stream

    inputStream.close();

    //Create an object of FileOutputStream class to create write data in excel file

    FileOutputStream outputStream = new FileOutputStream(file);

    //write data in the excel file

    guru99Workbook.write(outputStream);

    //close output stream

    outputStream.close();

    

    }
    
    public static void main(String...strings) {
   // public static void passvalue(String one, String two) throws IOException{
        //Create an array with the data in the same order in which you expect to be filled in excel file
    	  //WriteGuru99ExcelFile paass = new WriteGuru99ExcelFile();
    	//paass.writeExcel(null, null, null, null, one, two);
    	
        String[] valueToWrite = {one,two};

        //Create an object of current class

        WriteGuru99ExcelFile objExcelFile = new WriteGuru99ExcelFile();

        //Write the file using file name , sheet name and the data to be filled
        
      //  objExcelFile.writeExcel("D:\\","TestVineSsv.xls","VineetSheetvk",valueToWrite);
       
        try {
			objExcelFile.writeExcel(System.getProperty("user.dir")+"\\src\\excelExportAndFileIO","Vinimaya_Demo_OutputFile.xlsx","Vinimaya_Demo",valueToWrite);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

}