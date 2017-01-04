package usermodule;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 





//import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
 
public class createOutputFile {
public static void main(String args[]) throws IOException {
Workbook wb = new XSSFWorkbook();
//FileOutputStream fileOut = new FileOutputStream(
	//	"D:\\Selenium Automation\\Vinimaya\\src\\excelExportAndFileIO\\src\\excelExportAndFileIO\\ExportExcelv.xlsx");
FileOutputStream fileOut = new FileOutputStream(
"D:\\Selenium Automation\\Vinimaya\\src\\excelExportAndFileIO\\Vinimaya_Demo_OutputFile.xlsx");
// Workbook wb = new XSSFWorkbook();
 
CreationHelper createHelper = wb.getCreationHelper();
org.apache.poi.ss.usermodel.Sheet sheet = wb
.createSheet("Vinimaya_Demo");
Row row1 = sheet.createRow((short) 0);

//inserting first row cell value
row1.createCell(0).setCellValue(
createHelper.createRichTextString("ValidationSite_WB_SD"));

row1.createCell(1).setCellValue(
createHelper.createRichTextString("CheckOut_Details"));
 
wb.write(fileOut);
fileOut.close();
}
 
}