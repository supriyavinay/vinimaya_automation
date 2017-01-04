package usermodule;

public class suppliermodel {
	
	private String supplierName;
	  private String keyword;
	  private String partNo;
	  private String totalPrice;
	  private String quantity;
	  private String partAuxID;
	  private String unitPrice;
	  private String UOM;
	  private String UNSPSC;
	  private String supplierCheckOut;
	  private boolean isWBSearch = false;
	  private String xPath;


	  /**
	   * @return the xPath
	   */
	  public String getxPath() {
	    return this.xPath;
	  }


	  /**
	   * @param xPath the xPath to set
	   */
	  public void setxPath(final String xPath) {
	    this.xPath = xPath;
	  }


	  /**
	   * @return the isWBSearch
	   */
	  public boolean isWBSearch() {
	    return this.isWBSearch;
	  }


	  /**
	   * @param isWBSearch the isWBSearch to set
	   */
	  public void setWBSearch(final boolean isWBSearch) {
	    this.isWBSearch = isWBSearch;
	  }


	  /**
	   * @return the supplierCheckOut
	   */
	  public String getSupplierCheckOut() {
	    return this.supplierCheckOut;
	  }


	  /**
	   * @param supplierCheckOut the supplierCheckOut to set
	   */
	  public void setSupplierCheckOut(final String supplierCheckOut) {
	    this.supplierCheckOut = supplierCheckOut;
	  }

	  /**
	   * @return the totalPrice
	   */
	  public String getTotalPrice() {
	    return this.totalPrice;
	  }

	  /**
	   * @param totalPrice the totalPrice to set
	   */
	  public void setTotalPrice(final String totalPrice) {
	    this.totalPrice = totalPrice;
	  }

	  /**
	   * @return the quantity
	   */
	  public String getQuantity() {
	    return this.quantity;
	  }

	  /**
	   * @param quantity the quantity to set
	   */
	  public void setQuantity(final String quantity) {
	    this.quantity = quantity;
	  }


	  /**
	   * @return the partAuxID
	   */
	  public String getPartAuxID() {
	    return this.partAuxID;
	  }

	  /**
	   * @param partAuxID the partAuxID to set
	   */
	  public void setPartAuxID(final String partAuxID) {
	    this.partAuxID = partAuxID;
	  }

	  /**
	   * @return the unitPrice
	   */
	  public String getUnitPrice() {
	    return this.unitPrice;
	  }

	  /**
	   * @param unitPrice the unitPrice to set
	   */
	  public void setUnitPrice(final String unitPrice) {
	    this.unitPrice = unitPrice;
	  }

	  /**
	   * @return the uOM
	   */
	  public String getUOM() {
	    return this.UOM;
	  }

	  /**
	   * @param uOM the uOM to set
	   */
	  public void setUOM(final String uOM) {
	    this.UOM = uOM;
	  }

	  /**
	   * @return the uNSPSC
	   */
	  public String getUNSPSC() {
	    return this.UNSPSC;
	  }

	  /**
	   * @param uNSPSC the uNSPSC to set
	   */
	  public void setUNSPSC(final String uNSPSC) {
	    this.UNSPSC = uNSPSC;
	  }


	  /**
	   * @return the supplierName
	   */
	  public String getSupplierName1() {
	    return this.supplierName;
	  }

	  /**
	   * @param supplierName the supplierName to set
	   */
	  public void setSupplierName(final String supplierName) {
	    this.supplierName = supplierName;
	  }

	  /**
	   * @return the keyword
	   */
	  public String getKeyword() {
	    return this.keyword;
	  }

	  /**
	   * @param keyword the keyword to set
	   */
	  public void setKeyword(final String keyword) {
	    this.keyword = keyword;
	  }

	  /**
	   * @return the partNo
	   */
	  public String getPartNo() {
	    return this.partNo;
	  }

	  /**
	   * @param partNo the partNo to set
	   */
	  public void setPartNo(final String partNo) {
	    this.partNo = partNo;
	  }

	}
