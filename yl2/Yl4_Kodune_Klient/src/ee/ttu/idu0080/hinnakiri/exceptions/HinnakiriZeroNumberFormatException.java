package ee.ttu.idu0080.hinnakiri.exceptions;

import javax.xml.ws.WebFault;

@WebFault(name = "HinnakiriZeroNumberFormatFault") 
public class HinnakiriZeroNumberFormatException extends Exception {

	private HinnakiriZeroNumberFormatFault faultInfo;
	public HinnakiriZeroNumberFormatException(){ 
		this("Number has zero value"); 
	}
	public HinnakiriZeroNumberFormatException(String message) { 
		super(message);
		
		// Set fault message 
		faultInfo = new HinnakiriZeroNumberFormatFault(); 
		faultInfo.setMessage(message); 
	}

	public HinnakiriZeroNumberFormatException(String message, 
			HinnakiriZeroNumberFormatFault faultInfo) { 
		super(message);
		this.faultInfo = faultInfo; 
	}
	
	public HinnakiriZeroNumberFormatFault getFaultInfo()	{ 
		return faultInfo; 
	} 
}