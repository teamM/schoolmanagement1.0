package com.sms.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//import org.apache.log4j.Logger;

import com.sms.util.PropertyUtil;

/**
 * This is a jsp custom tag for html links
 * 
 * @author t-renjith
 * 
 */
public class LinkTag extends SimpleTagSupport {
	/**
	 * Error logger for LinkTag
	 */
	//public static final Logger LOG = Logger.getLogger("LinkTag");
	private transient String href;
	private transient String linkText;

	/**
	 * The setter method for link reference
	 * 
	 * @param href
	 *            - The URL to be visisted on clicking the link
	 */
	public void setHref(final String href) {
		this.href = href;
	}

	/**
	 * The setter method for the URL text
	 * 
	 * @param linkText
	 *            - The text to be displayed as link
	 */
	public void setLinkText(final String linkText) {
		this.linkText = linkText;
	}

	public void doTag() {
		final String linkText = PropertyUtil.getUIText(this.linkText);// Gets the text
		// from the
		// property file
		final JspWriter out = getJspContext().getOut();// Gets the out stream to write
		// to the jsp page
		try {
			out.print("<a href=" + href + ">" + linkText
					+ "</a>"); // prints the text to the jsp page
		} catch (IOException e) {
			//LOG.error(e);
		}

	}
}
