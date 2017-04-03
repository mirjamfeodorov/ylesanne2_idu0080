package ee.ttu.idu0080.hinnakiri.exceptions;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "HinnakiriDecimalNumberFormatFault") 
public class HinnakiriDecimalNumberFormatFault { 
	private String message;
	
	public HinnakiriDecimalNumberFormatFault() { }

	public String getMessage() { 
		return message; 
	}
	
	public void setMessage(String message) { 
		this.message = message; 
	}
}