package com.deedef.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Bamba
 */
@XmlType(propOrder = { "username", "password" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "authentification")
public class AuthentificationXmlBean {

	/**
	 * Obligatoire : oui
	 * D�finition : l�adresse email de votre compte sur www.deedef.com
	 */
	private String username;
	
	/**
	 * Obligatoire : oui
	 * D�finition : Mot de passe de votre compte www.deedef.com et correspondant au login
	 */
	private String password;
	
	
	/**
	 *  Constructeur vide
	 */
	public AuthentificationXmlBean() {
		super();
	}
	
	/**
	 *  Constructeur avec tous les params
	 * @param username
	 * @param password
	 */
	public AuthentificationXmlBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AuthentificationXmlBean {username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append("}");
		return builder.toString();
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
