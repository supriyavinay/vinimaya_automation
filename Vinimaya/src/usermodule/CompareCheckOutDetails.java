
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

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author nhi6kor
 */
public class CompareCheckOutDetails {

  private final String PASS = "PASS";
  private final String FAIL = "FAIL";
  

  public Map<String, Map<String, List<String>>> compareCheckOutDetails(final String filePath) {
	  
    Map<String, Map<String, List<String>>> listOfPassFailSuppliers = new HashMap<>();
    Map<String, List<String>> listOfPassSupplier = new HashMap<>();
    Map<String, List<String>> listOfFailSupplier = new HashMap<>();
    listOfPassFailSuppliers.put(this.PASS, listOfPassSupplier);
    listOfPassFailSuppliers.put(this.FAIL, listOfFailSupplier);

    try {
      FileInputStream file = new FileInputStream(new File(filePath));
      // Create Workbook instance holding reference to .xlsx file
      XSSFWorkbook workbook = new XSSFWorkbook(file);

      // Get first/desired sheet from the workbook
      XSSFSheet wbSheet = workbook.getSheet(WriteToExcelSheet.WB_CHECKOUT_DETAILS);
      XSSFSheet sdSheet = workbook.getSheet(WriteToExcelSheet.SD_CHECKOUT_DETAILS);
   
      // Iterate through each rows one by one
   Iterator<Row> wbRows = wbSheet.iterator();
      while (wbRows.hasNext()) {
        Row wbRow = wbRows.next();
        if (wbRow.getRowNum() == 0) {
          continue;
        }
        String wbSupplierName = wbRow.getCell(1).getStringCellValue();
        Iterator<Row> sdRows = sdSheet.rowIterator();
        while (sdRows.hasNext()) {
          Row sdRow = sdRows.next();
          if (sdRow.getRowNum() == 0) {
            continue;
          }
          String sdSupplierName = sdRow.getCell(1).getStringCellValue();
          if (sdSupplierName.equalsIgnoreCase(wbSupplierName)) {
            boolean isComparisonFail = false;
            for (int j = 2; j <= 9; j++) {
              String wbCellValue = wbRow.getCell(j).getStringCellValue();
              String sdCellValue = sdRow.getCell(j).getStringCellValue();
              if (!wbCellValue.equalsIgnoreCase(sdCellValue)) {
                isComparisonFail = true;
                if (!listOfFailSupplier.containsKey(sdSupplierName)) {
                  List<String> listOfFields = new ArrayList<>();
                  listOfFailSupplier.put(sdSupplierName, listOfFields);
                }
                String fieldName = sdSheet.getRow(0).getCell(j).getStringCellValue();
                listOfFailSupplier.get(sdSupplierName).add(fieldName);
              }
            }
            if (!isComparisonFail) {
              // Passed Suppliers
              if (!listOfPassFailSuppliers.containsKey(sdSupplierName)) {
                List<String> listOfFields = new ArrayList<>();
                listOfFailSupplier.put(sdSupplierName, listOfFields);
              }
            }
          }
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
      System.out.println("Something went wrong!!!!!!!!!");
    }
    return listOfPassFailSuppliers;
  }

  public void printSupplierStatus(final Map<String, Map<String, List<String>>> listOfPassFailSuppliers) {
    System.out.println("**************" + this.FAIL + "**************");
    Map<String, List<String>> listOfFailedSupplier = listOfPassFailSuppliers.get(this.FAIL);
    Set<Entry<String, List<String>>> entrySet1 = listOfFailedSupplier.entrySet();
    for (Entry<String, List<String>> entry : entrySet1) {
      String supplierName = entry.getKey();

      System.out.println("Supplier Name: " + supplierName);
      List<String> values = entry.getValue();
      for (String field : values) {
        System.out.println("          " + field);
      }
    }
    System.out.println("******************************************");

    System.out.println("**************" + this.PASS + "**************");
    Map<String, List<String>> listOfPassedSupplier = listOfPassFailSuppliers.get(this.PASS);
    Set<Entry<String, List<String>>> entrySet = listOfPassedSupplier.entrySet();
    for (Entry<String, List<String>> entry : entrySet) {
      String supplierName = entry.getKey();
      System.out.println("Supplier Name: " + supplierName);
    }
    System.out.println("***********************************");

  }
}
