package com.deedef.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Bamba
 */
@XmlRootElement(name="sms")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "authentificationXmlBean", "messageXmlBean", "recipientsXmlBean" })
public class SmsXmlBean {
	@XmlElement(name="authentification")
	private AuthentificationXmlBean authentificationXmlBean;
	@XmlElement(name="message")
	private MessageXmlBean messageXmlBean;
	@XmlElement(name="recipients")
	private RecipientsXmlBean recipientsXmlBean;

	/**
	 * Constructeur vide
	 */
	public SmsXmlBean() {
		super();
	}

	/**
	 * Constructeur avec tous les params
	 * @param authentification
	 * @param message
	 * @param recipients
	 */
	public SmsXmlBean(AuthentificationXmlBean authentification, MessageXmlBean message,
			RecipientsXmlBean recipients) {
		super();
		this.authentificationXmlBean = authentification;
		this.messageXmlBean = message;
		this.recipientsXmlBean = recipients;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SmsXmlBean {\n\tauthentificationXmlBean=");
		builder.append(authentificationXmlBean);
		builder.append("\n\tmessageXmlBean=");
		builder.append(messageXmlBean);
		builder.append("\n\trecipientsXmlBean=");
		builder.append(recipientsXmlBean);
		builder.append("\n}");
		return builder.toString();
	}

	/**
	 * @return the authentificationXmlBean
	 */
	public AuthentificationXmlBean getAuthentificationXmlBean() {
		return authentificationXmlBean;
	}

	/**
	 * @param authentificationXmlBean the authentificationXmlBean to set
	 */
	public void setAuthentificationXmlBean(
			AuthentificationXmlBean authentificationXmlBean) {
		this.authentificationXmlBean = authentificationXmlBean;
	}

	/**
	 * @return the messageXmlBean
	 */
	public MessageXmlBean getMessageXmlBean() {
		return messageXmlBean;
	}

	/**
	 * @param messageXmlBean the messageXmlBean to set
	 */
	public void setMessageXmlBean(MessageXmlBean messageXmlBean) {
		this.messageXmlBean = messageXmlBean;
	}

	/**
	 * @return the recipientsXmlBean
	 */
	public RecipientsXmlBean getRecipientsXmlBean() {
		return recipientsXmlBean;
	}

	/**
	 * @param recipientsXmlBean the recipientsXmlBean to set
	 */
	public void setRecipientsXmlBean(RecipientsXmlBean recipientsXmlBean) {
		this.recipientsXmlBean = recipientsXmlBean;
	}
}