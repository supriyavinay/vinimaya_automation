package usermodule;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Read the data from excel sheet
 */
public class keywordsupplier {

  /**
   * Responsible to read the data
   */
  public static void main(final String[] args) {
    keywordsupplier readFile = new keywordsupplier();
    // Read the data from excel sheet and stor in the map as supplier vs keyword
    Map<String, List<String>> dataFromExcelSheet = readFile.readExcelFile();
    // print the read data in to console
    readFile.printDataToConsole(dataFromExcelSheet);
  }

  private Map<String, List<String>> readExcelFile() {
    Map<String, List<String>> listOfSuppliersVsKeyword = new HashMap<>();
    try {

      FileInputStream file = new FileInputStream(new File("C:\\SupplierVsKeyword.xlsx"));
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
        // For each row, iterate through all the columns
        Cell supplierCell = row.getCell(1);
        String supplierName = supplierCell.getStringCellValue();
        // if(supplierName.startsWith("Supplier")){
        //
        // }
        Cell keywordCell = row.getCell(2);
        String keyword = keywordCell.getStringCellValue();
        if (listOfSuppliersVsKeyword.containsKey(supplierName)) {
          listOfSuppliersVsKeyword.get(supplierName).add(keyword);
        }
        else {
          List<String> listOfKeywords = new ArrayList<>();
          listOfKeywords.add(keyword);
          listOfSuppliersVsKeyword.put(supplierName, listOfKeywords);
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
      System.out.println("Something went wrong!!!!!!!!!");
    }
    return listOfSuppliersVsKeyword;
  }

  /**
   * @param dataFromExcelSheet
   */
  private void printDataToConsole(final Map<String, List<String>> dataFromExcelSheet) {
    Set<Entry<String, List<String>>> entrySet = dataFromExcelSheet.entrySet();
    for (Entry<String, List<String>> entry : entrySet) {
      List<String> keywords = entry.getValue();
      for (String keyword : keywords) {
        String supplierName = entry.getKey();
        // Here you can pass the supplier name and keyword to launch the search
        System.out.println("Supplier Name: " + supplierName + "    Keyword: " + keyword);
      }
    }
  }
}
