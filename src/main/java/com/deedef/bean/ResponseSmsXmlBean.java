package com.deedef.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Bamba
 */
@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "status", "message", "ticket", "credits" })
public class ResponseSmsXmlBean {
	
	/**
	 * Obligatoire : oui
	 * D�finition : l'adresse email de votre compte sur www.deedef.com
	 */
	private String status;
	
	/**
	 * Obligatoire : oui
	 * D�finition : l'adresse email de votre compte sur www.deedef.com
	 */
	private String message;
	
	/**
	 * Obligatoire : oui
	 * D�finition : l'adresse email de votre compte sur www.deedef.com
	 */
	private String ticket;
	
	/**
	 * Obligatoire : oui
	 * D�finition : l'adresse email de votre compte sur www.deedef.com
	 */
	private String credits;

	/**
	 * Constructeur vide
	 */
	public ResponseSmsXmlBean() {
		super();
	}

	/**
	 * Constructeur avec tous les params
	 * @param status
	 * @param message
	 * @param ticket
	 * @param credits
	 */
	public ResponseSmsXmlBean(String status, String message, String ticket,
			String credits) {
		super();
		this.status = status;
		this.message = message;
		this.ticket = ticket;
		this.credits = credits;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseSmsXmlBean {\n\tstatus=");
		builder.append(status);
		builder.append("\n\tmessage=");
		builder.append(message);
		builder.append("\n\tticket=");
		builder.append(ticket);
		builder.append("\n\tcredits=");
		builder.append(credits);
		builder.append("\n}");
		return builder.toString();
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the ticket
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return the credits
	 */
	public String getCredits() {
		return credits;
	}

	/**
	 * @param credits the credits to set
	 */
	public void setCredits(String credits) {
		this.credits = credits;
	}
}