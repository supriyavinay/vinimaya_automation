package usermodule;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class WriteToExcelSheet {
private final String[] arrayOfHeaders = {
      "Sl no",
      "Supplier Name",
      "Searched Keyword",
      "Total Price",
      "Quantity",
      "Part #",
      "Part Aux ID",
      "Unit Price",
      "UOM",
      "UNSPSC" };

public static final String WB_CHECKOUT_DETAILS = "WB_Checkout_Results";
  public static final String SD_CHECKOUT_DETAILS = "SD_Checkout_Results";
public void writeToExcelSheet(final String filePath, final List<suppliermodel> listOfSupplierData) {
    List<suppliermodel> listOfCheckedOutItems = parseSupplierData(listOfSupplierData);
    writeToExcel(filePath, listOfCheckedOutItems);
  }

  /**
   * @param filePath
   * @param listOfCheckedOutItems
   */
	
private void writeToExcel(final String filePath, final List<suppliermodel> listOfCheckedOutItems) {
    try {
      File file = new File(filePath);
      FileOutputStream fot = new FileOutputStream(file);
      XSSFWorkbook workbook = new XSSFWorkbook();

      // Get the condition to write to WB or SD

      XSSFSheet sheet = workbook.getSheet(WriteToExcelSheet.WB_CHECKOUT_DETAILS);
      if (sheet == null) {
        sheet = workbook.createSheet(WriteToExcelSheet.WB_CHECKOUT_DETAILS);
      }
      sheet = workbook.getSheet(WriteToExcelSheet.SD_CHECKOUT_DETAILS);
      if (sheet == null) {
        sheet = workbook.createSheet(WriteToExcelSheet.SD_CHECKOUT_DETAILS);
      }
      // Iterate through each rows one by one
      int slNo = 1;
      for (suppliermodel supplierData : listOfCheckedOutItems) {
        sheet = null;
        if (supplierData.isWBSearch()) {
          sheet = workbook.getSheet(WriteToExcelSheet.WB_CHECKOUT_DETAILS);
        }
        else {
          sheet = workbook.getSheet(WriteToExcelSheet.SD_CHECKOUT_DETAILS);
        }
        int lastRowNum = sheet.getLastRowNum();
        if (lastRowNum == 0) {
          createHeaders(sheet);
        }
        XSSFRow row = sheet.createRow(++lastRowNum);
        int i = 0;
        XSSFCell cellSlNo = row.createCell(i++);
        cellSlNo.setCellValue(slNo++);

        XSSFCell cell = row.createCell(i++);
        cell.setCellValue(supplierData.getSupplierName1());

        cell = row.createCell(i++);
        cell.setCellValue(supplierData.getKeyword());

        cell = row.createCell(i++);
        cell.setCellValue(supplierData.getTotalPrice());

        cell = row.createCell(i++);
        cell.setCellValue(supplierData.getQuantity());

        cell = row.createCell(i++);
        cell.setCellValue(supplierData.getPartNo());

        cell = row.createCell(i++);
        cell.setCellValue(supplierData.getPartAuxID());

        cell = row.createCell(i++);
        cell.setCellValue(supplierData.getUnitPrice());

        cell = row.createCell(i++);
        cell.setCellValue(supplierData.getUOM());

        cell = row.createCell(i++);
        cell.setCellValue(supplierData.getUNSPSC());
      }
      workbook.write(fot);
    }
    catch (Exception e) {
      e.printStackTrace();
      System.out.println("Something went wrong!!!!!!!!!");
    }


  }

  /**
   * @param listOfSupplierData
   * @return
   */
  private List<suppliermodel> parseSupplierData(final List<suppliermodel> listOfSupplierData) {
    List<suppliermodel> listOfSupplier = new ArrayList<>();
    for (suppliermodel supplierModelData : listOfSupplierData) {
      String xml = supplierModelData.getSupplierCheckOut();
      String totalprc = "";
      if (xml.indexOf("<cXML payloadID") != -1) {
        totalprc = xml.substring(xml.indexOf("<Total>") + "<Total>".length());
        totalprc = totalprc.substring(totalprc.indexOf("currency=\"USD\">") + "currency=\"USD\">".length());
        totalprc = totalprc.substring(0, totalprc.indexOf("<"));
        System.out.println("Total price : " + totalprc);
        xml = xml.substring(xml.indexOf("</PunchOutOrderMessageHeader>"));
      }
      while (xml.indexOf("<ItemIn") != -1) {
    	  suppliermodel supplierModel = new suppliermodel();
        supplierModel.setSupplierName(supplierModelData.getSupplierName1());
        supplierModel.setWBSearch(supplierModelData.isWBSearch());
        supplierModel.setKeyword(supplierModelData.getKeyword());
        supplierModel.setTotalPrice(totalprc);
        if (xml.indexOf("quantity=\"") != -1) {
          String qty = xml.substring(xml.indexOf("quantity=\"") + "quantity=\"".length());
          qty = qty.substring(0, qty.indexOf("\""));
          supplierModel.setQuantity(qty);
        }
        if (xml.indexOf("SupplierPartID>") != -1) {
          String prtno = xml.substring(xml.indexOf("SupplierPartID>") + "SupplierPartID>".length());
          prtno = prtno.substring(0, prtno.indexOf("<"));
          supplierModel.setPartNo(prtno);
          supplierModel.setPartAuxID(prtno);
        }
        if (xml.indexOf("currency=\"USD\">") != -1) {
          String untprc = xml.substring(xml.indexOf("currency=\"USD\">") + "currency=\"USD\">".length());
          untprc = untprc.substring(0, untprc.indexOf("<"));
          supplierModel.setUnitPrice(untprc);
        }
        if (xml.indexOf("UnitOfMeasure>") != -1) {
          String uom = xml.substring(xml.indexOf("UnitOfMeasure>") + "UnitOfMeasure>".length());
          uom = uom.substring(0, uom.indexOf("<"));
          supplierModel.setUOM(uom);
        }
        if (xml.indexOf("\"UNSPSC\">") != -1) {
          String unspsc = xml.substring(xml.indexOf("\"UNSPSC\">") + "\"UNSPSC\">".length());
          unspsc = unspsc.substring(0, unspsc.indexOf("<"));
          supplierModel.setUNSPSC(unspsc);
        }
        listOfSupplier.add(supplierModel);
        System.out.println(" Supplier Name : " + supplierModel.getSupplierName1());
        System.out.println(" keyword : " + supplierModel.getKeyword());
        System.out.println(" total price : " + supplierModel.getTotalPrice());
        System.out.println(" Item Quantity : " + supplierModel.getQuantity());
        System.out.println(" Item Part number : " + supplierModel.getPartNo());
        System.out.println(" Item Part AUX ID : " + supplierModel.getPartAuxID());
        System.out.println(" Item Unit Price : " + supplierModel.getUnitPrice());
        System.out.println(" Item UOM : " + supplierModel.getUOM());
        System.out.println(" Item UNSPSC : " + supplierModel.getUNSPSC());
        xml = xml.substring(xml.indexOf("</ItemIn>") + "</ItemIn>".length());
      }
    }
    return listOfSupplier;
  }


  /**
   * @param sheet
   */
  private void createHeaders(final XSSFSheet sheet) {
    XSSFRow headerRow = sheet.createRow(0);
    for (int i = 0; i < this.arrayOfHeaders.length; i++) {
      XSSFCell cell = headerRow.createCell(i);
      cell.setCellValue(this.arrayOfHeaders[i]);
    }
  }

}