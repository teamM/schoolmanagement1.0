package com.sms.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;



import com.sms.util.PropertyUtil;

/**
 * This class forms the tag handler for the label tag
 * 
 * @author t-renjith
 * 
 */
public class LabelTag extends SimpleTagSupport {
	private transient String label;
	private String labelText;
	/**
	 * Error logger for LabelTag class
	 */
	

	/**
	 * Sets the label attribute from the calling jsp
	 * 
	 * @param label
	 *            - The label to be displayed
	 */
	public void setLabel(final String label) {
		this.label = label;
	}

	/**
	 * The setter method which sets the label text value which is to be
	 * displayed in the jsp
	 * 
	 * @param labelText
	 *            - The label text retrieved from the property file
	 */
	public void setLabelText(final String labelText) {
		this.labelText = labelText;
	}

	/**
	 * @return label text retreived from the property file
	 */
	public String getLabelText() {
		return labelText;
	}

	public void doTag() {

		final JspWriter out = getJspContext().getOut();
		setLabelText(PropertyUtil.getUIText(label));
		try {
			out.print("<label>" + labelText + "</label>");
		} catch (IOException e) {
			
		}

	}
}
