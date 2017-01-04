package usermodule;

import javax.swing.plaf.synth.SynthStyle;

import org.apache.regexp.recompile;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;

public class readexcelvk
{
	static String val1;
	static String val2;
	
	
	public static void setVal1(String first) {
		readexcelvk.val1 = first;
		System.out.println("This is A : " + readexcelvk.val1);
		
	}
	
	public static void setVal2(String second) {
		readexcelvk.val2 = second;
		System.out.println("This is B: " + readexcelvk.val2);
	}
	static
	{
		System.out.println("This is A : " + readexcelvk.val1);
	}
}
