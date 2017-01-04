package usermodule;

public class callingFuncExamp 
{
	static int i=1;
	static String Totalprc="",qty ="",prtno="",prtnoAID="",Untprc="",uM="",spc="";
	static String xml="";
	
	public void iteratingXML(String xml)
	{
		if(xml.indexOf("<cXML payloadID")!=-1)
		{
			Totalprc = xml.substring(xml.indexOf("<Total>")+"<Total>".length());
			Totalprc = Totalprc.substring(Totalprc.indexOf("currency=\"USD\">")+"currency=\"USD\">".length());
			Totalprc = Totalprc.substring(0, Totalprc.indexOf("<"));
			System.out.println("Total price : " + Totalprc);
			xml= xml.substring(xml.indexOf("</PunchOutOrderMessageHeader>"));
		}
		while(xml.indexOf("<ItemIn")!=-1)
		{
			
			if(xml.indexOf("quantity=\"")!=-1)
			{
				qty = xml.substring(xml.indexOf("quantity=\"")+"quantity=\"".length());
				qty = qty.substring(0, qty.indexOf("\""));
			}
			if(xml.indexOf("SupplierPartID>")!=-1)
			{
				prtno = xml.substring(xml.indexOf("SupplierPartID>")+"SupplierPartID>".length());
				prtno = prtno.substring(0, prtno.indexOf("<"));
				prtnoAID = prtno;
			}
			if(xml.indexOf("currency=\"USD\">")!=-1)
			{
				Untprc = xml.substring(xml.indexOf("currency=\"USD\">")+"currency=\"USD\">".length());
				Untprc = Untprc.substring(0, Untprc.indexOf("<"));
			}
			if(xml.indexOf("UnitOfMeasure>")!=-1)
			{
				uM = xml.substring(xml.indexOf("UnitOfMeasure>")+"UnitOfMeasure>".length());
				uM = uM.substring(0, uM.indexOf("<"));
			}
			if(xml.indexOf("\"UNSPSC\">")!=-1)
			{
				spc = xml.substring(xml.indexOf("\"UNSPSC\">")+"\"UNSPSC\">".length());
				spc = spc.substring(0, spc.indexOf("<"));
			}
			/*System.out.println(i +"st"+" Item Qyantity : " + qty);
			System.out.println(i +"st"+" Item Part number : " + prtno);
			System.out.println(i +"st"+" Item Part AUX ID : " + prtno);
			System.out.println(i +"st"+" Item Unit Price : " + Untprc);
			System.out.println(i +"st"+" Item UOM : " + uM);
			System.out.println(i +"st"+" Item UNSPSC : " + spc);*/
			i++;
			xml = xml.substring(xml.indexOf("</ItemIn>")+"</ItemIn>".length());
			
		}
	}
	
	public static String getUntprc() {
		return Untprc;
	}

	public static void setUntprc(String untprc) {
		Untprc = untprc;
	}

	public static void main(String[] args) 
	{
		
		callingFuncExamp it = new callingFuncExamp();
		it.iteratingXML(xml);
		
	}
}
