package com.deedef.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author Bamba
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "gsm")
public class GsmXmlBean {
	
	/**
 	 * Obligatoire : non
	 * D�finition : num�ros de t�l�phone correspondant au destinataire du message   
	 * Format : Exemple pour la France : 33600000000.
	 * Tous les num�ros doivent commencer avec un indicatif couvert par le syst�me. 
	 * Pour plus de renseignements sur notre zone de couverture merci de visiter le site internet � l�adresse www.deedef.com.
	 */
	@XmlValue
	private String content;
	
	/**
	 * Obligatoire : non
	 * D�finition :  Pour la gestion des accus�s de r�ception il est possible de d�finir une valeur dans l�attribut � gsmsmsid �. 
	 * Ce dernier servira pour retrouver l�accus� de r�ception plus pr�cis�ment. 
	 * 
	 * Pour la gestion des accus�s de r�ception il est possible de d�finir une valeur dans l�attribut � gsmsmsid �. 
	 * Ce dernier servira pour retrouver l�accus� de r�ception plus pr�cis�ment. 
	 * Tous les num�ros doivent commencer avec un indicatif couvert par le syst�me. 
	 * Pour plus de renseignements sur notre zone de couverture merci de visiter le site internet � l�adresse www.deedef.com.
	 */
	@XmlAttribute
	private Integer gsmsmsid;
	
	/**
	 *  Constructeur vide
	 */
	public GsmXmlBean() {
		super();
	}

	/**
	 *  Constructeur avec tous les params
	 * @param content
	 * @param gsmsmsid
	 */
	public GsmXmlBean(String content, Integer gsmsmsid) {
		super();
		this.content = content;
		this.gsmsmsid = gsmsmsid;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GsmXmlBean {content=");
		builder.append(content);
		builder.append(", gsmsmsid=");
		builder.append(gsmsmsid);
		builder.append("}");
		return builder.toString();
	}
	
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * @return the gsmsmsid
	 */
	public Integer getGsmsmsid() {
		return gsmsmsid;
	}
	
	/**
	 * @param gsmsmsid the gsmsmsid to set
	 */
	public void setGsmsmsid(Integer gsmsmsid) {
		this.gsmsmsid = gsmsmsid;
	}
}