package com.deedef.service;

import com.deedef.exception.ServiceException;

/**
 * Interface du service permettant d'envoyer un SMS via le partenaire deedef.com
 * @author Bamba
 */
public interface ISendSmsService {
	
	/**
	 * M�thode permettant d'envoyer un SMS
	 * @param numeroTelDestinataire : num�ro de t�l�phone � qui le SMS va �tre envoy�
	 * @param contenu : contenu du SMS
	 * @throws ServiceException
	 */
	public void envoiSMS(String numeroTelDestinataire, String contenu) throws ServiceException;
	
	/**
	 * M�thode permettant d'envoyer un SMS
	 * @param numeroTelDestinataire : num�ro de t�l�phone � qui le SMS va �tre envoy�
	 * @param contenu : contenu du SMS
	 * @param idSuiviSMS : id technique permettant de faire un suivi du sms
	 * @throws ServiceException
	 */
	public void envoiSMS(String numeroTelDestinataire, String contenu, Integer idSuiviSMS) throws ServiceException;
	
}
