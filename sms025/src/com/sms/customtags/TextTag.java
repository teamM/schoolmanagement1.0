package com.sms.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//import org.apache.log4j.Logger;

import com.sms.util.PropertyUtil;

/**
 * The custom tag which prints the text on the JSP This tag accepts a text key
 * and prints the appropriate text by reading from the property files This can
 * be used for printing text inside headers H1,H2 etc
 * 
 * @author t-renjith
 * 
 */
public class TextTag extends SimpleTagSupport {
	/**
	 * Error logger for Text tag class
	 */
	//public static final Logger LOG = Logger.getLogger("TextTag");
	private transient String text;// The field which holds the value of text key based on

	// which the appropriate textvalue is to be retrieved
	// from the property file

	/**
	 * Sets the attribute value text for which the text value is to be retreived
	 * from property file
	 * 
	 * @param text
	 */
	public void setText(final String text) {
		this.text = text;
	}

	public void doTag() {
		final String textValue = PropertyUtil.getUIText(text);// Gets the text value
		final JspWriter out = getJspContext().getOut(); // gets the output stream to
		// write
		try {
			out.print(textValue);// Prints the content on the jsp page
		} catch (IOException e) {
			
		}
	}

}
