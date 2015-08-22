package com.deedef.bean;

import java.util.List;

/**
 * @author Bamba
 */
public class RecipientsXmlBean {

	/**
	 * Obligatoire : oui
	 * D�finition : Liste des num�ros de t�l�phone correspondant aux destinataires du message. 
	 * Limite : aucune
	 */
	private List<GsmXmlBean> gsm;

	
	/**
	 *  Constructeur vide
	 */
	public RecipientsXmlBean() {
		super();
	}

	
	/**
	 * Constructeur avec tous les parametres
	 * @param listGSM
	 */
	public RecipientsXmlBean(List<GsmXmlBean> listGSM) {
		super();
		this.gsm = listGSM;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RecipientsXmlBean {");
		for (GsmXmlBean currentGSM : gsm) {
			builder.append("\n\t\t");
			builder.append(currentGSM);
		}
		builder.append("\n\t}");
		return builder.toString();
	}

	/**
	 * @return the gsm
	 */
	public List<GsmXmlBean> getGsm() {
		return gsm;
	}

	/**
	 * @param gsm the gsm to set
	 */
	public void setGsm(List<GsmXmlBean> gsm) {
		this.gsm = gsm;
	}
}