
package usermodule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;


public class StartHere {

  /**
   * @param args
   */
  public static void main(final String[] args) {
    String filePath = "C:\\Copy of SupplierVsKeyword41.xlsx";
    // Read the Supplier and keyword from excel and launch the Search
   ISearch search = new param(); // for WB search
  List<suppliermodel> launchSearch = search.launchSearch(filePath);

    // Write the checkout data to the sheet here
   //filePath = "D:\\Selenium Automation\\Vinimaya\\bin\\Output.xlsx";// give out put path here
    
 //sheet.writeToExcelSheet(filePath, launchSearch);

    ISearch sdSearch = new SD_Checkout_Newark(); // SD Checkout
  List<suppliermodel> sdlaunchSearch = sdSearch.launchSearch(filePath);
    List<suppliermodel> listofWBandSD= new ArrayList();
    listofWBandSD.addAll(launchSearch);
    listofWBandSD.addAll(sdlaunchSearch);
  
  WriteToExcelSheet sheet = new WriteToExcelSheet();

    // Write the checkout data to the sheet here
  
  DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	Calendar cal = Calendar.getInstance();
	 filePath = "D:\\Selenium Automation\\Vinimaya\\bin\\Output_"+dateFormat.format(cal.getTime())+".xlsx";

//filePath = "D:\\Selenium Automation\\Vinimaya\\bin\\Output.xlsx";// give out put path here
sheet.writeToExcelSheet(filePath, listofWBandSD);
//sheet.writeToExcelSheet(filePath, listofWBandSD);

    // Do the compare here
CompareCheckOutDetails compareCheckOutDetails = new CompareCheckOutDetails();
    Map<String, Map<String, List<String>>> compareCheckOutDetails2 =
    compareCheckOutDetails.compareCheckOutDetails(filePath);
  compareCheckOutDetails.printSupplierStatus(compareCheckOutDetails2);
  }
}
