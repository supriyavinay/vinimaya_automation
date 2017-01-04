package usermodule;

import java.io.IOException;

public class beanClass 
{
	static String xml ="";
	static String purpose ="";
	static String Totalprc="",qty ="",prtno="",prtnoAID="",Untprc="",uM="",spc="",Outp="",Details="";
	static int i=1;

	static public void itemelement(String xml,String purpose) throws IOException
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
			
			
			
		//	Outp= qty+prtno+Untprc;
			//System.out.println(Outp);
			Outp = "Total price : " + Totalprc+"\n"+i +"st"+" Item Quantity : " + qty+"\n"+i +"st"+" Item Part number : " + prtno+"\n"+i +"st"+" Item Part AUX ID : " + prtno+"\n"+i +"st"+" Item Unit Price : " + Untprc+"\n"+i +"st"+" Item UOM : " + uM+"\n"+i +"st"+" Item UNSPSC : " + spc;
			Details=purpose;
			/*System.out.println(i +"st"+" Item Part AUX ID : " + prtno);
			System.out.println(i +"st"+" Item Unit Price : " + Untprc);
			System.out.println(i +"st"+" Item UOM : " + uM);
			System.out.println(i +"st"+" Item UNSPSC : " + spc);*/
			
			//System.out.println(i +"st"+" Total price : " + Totalprc);
			System.out.println(i +"st"+" Item Quantity : " + qty);
			System.out.println(i +"st"+" Item Part number : " + prtno);
			System.out.println(i +"st"+" Item Part AUX ID : " + prtno);
			System.out.println(i +"st"+" Item Unit Price : " + Untprc);
			System.out.println(i +"st"+" Item UOM : " + uM);
			System.out.println(i +"st"+" Item UNSPSC : " + spc);
			
			i++;
			xml = xml.substring(xml.indexOf("</ItemIn>")+"</ItemIn>".length());
		}
	
	}
	
	public static String getDetails() {
		return Details;
	}

	public static  void setDetails(String details) {
		Details = details;
	}
	
	public static String getOutp() {
	return Outp;
}

public static  void setOutp(String outp) {
	Outp = outp;
}
	
	public static void main(String[] args) 
	{
		
	}

	

	
}