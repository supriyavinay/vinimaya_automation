package usermodule;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Read the data from excel sheet
 */
public class readdata_excel {

  /**
   * Responsible to read the data
   */
  public static void main(final String[] args) {
    readdata_excel readFile = new readdata_excel();
    // Read the data from excel sheet and stor in the map as supplier vs keyword
    List<suppliermodel> readdata_excel = readFile.readdata_excel("C:\\Copy of SupplierVsKeyword4.xlsx");
    // print the read data in to console
    readFile.printDataToConsole(readdata_excel);
  }

  public List<suppliermodel> readdata_excel(final String filePath) {
    List<suppliermodel> listOfKeywords = new ArrayList<>();
    try {

      FileInputStream file = new FileInputStream(new File(filePath));
      // Create Workbook instance holding reference to .xlsx file
      XSSFWorkbook workbook = new XSSFWorkbook(file);

      // Get first/desired sheet from the workbook
      XSSFSheet sheet = workbook.getSheetAt(0);

      // Iterate through each rows one by one
      Iterator<Row> rowIterator = sheet.iterator();
      while (rowIterator.hasNext()) {
        Row row = rowIterator.next();
        if (row.getRowNum() == 0) {
          continue;
        }
        DataFormatter dataFormater = new DataFormatter();
        // For each row, iterate through all the columns
        Cell supplierCell = row.getCell(1);
        String supplierName = supplierCell.getStringCellValue();
        Cell keywordCell = row.getCell(2);
        String keyword = keywordCell.getStringCellValue();
        Cell partCell = row.getCell(3);
        String formatCellValue = dataFormater.formatCellValue(partCell);
        suppliermodel supplierModel = new suppliermodel();
        supplierModel.setSupplierName(supplierName);
        supplierModel.setKeyword(keyword);
        supplierModel.setPartNo(formatCellValue);
        listOfKeywords.add(supplierModel);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
      System.out.println("Something went wrong!!!!!!!!!");
    }
    return listOfKeywords;
  }

  /**
   * @param listOfSupplierData
   */
  public void printDataToConsole(final List<suppliermodel> listOfSupplierData) {
    for (suppliermodel supplierModel : listOfSupplierData) {
      System.out.println(supplierModel.getSupplierName1());
      System.out.println(supplierModel.getKeyword());
      System.out.println(supplierModel.getPartNo());
    }
  }
}
