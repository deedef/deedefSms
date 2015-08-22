package com.deedef.service.impl;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.deedef.bean.AuthentificationXmlBean;
import com.deedef.bean.GsmXmlBean;
import com.deedef.bean.MessageXmlBean;
import com.deedef.bean.RecipientsXmlBean;
import com.deedef.bean.ResponseSmsXmlBean;
import com.deedef.bean.SmsXmlBean;
import com.deedef.exception.ServiceException;
import com.deedef.service.ISendSmsService;


/**
 * @author ndiaye
 */
public class SendSmsServiceImpl implements ISendSmsService {

	/** The Constant log. */
	private final Logger logger = Logger.getLogger(getClass().getName());

	private final static String CHARSET = "UTF-8";
	private final static String CODE_REPONSE_SUCCES = "1";

	/* URL du service expos� par le partenaire */
	private String deedefUrl;
	/* Adresse email du compte sur www.deedef.com */
	private String deedefUsername;
	/* Password du compte sur www.deedef.com */
	private String deedefPassword;
	/* Exp�diteur du message tel qu'il apparaitra sur le t�l�phone. */
	private String deedefSender;
	
	/**
	 * Constructeur
	 */
	public SendSmsServiceImpl()
	{
        Properties prop = new Properties();
        InputStream input = null;

        try {

            //input = new FileInputStream(" C:\\Users\\Fatou\\IdeaProjects\\deedef\\deedefProperties.properties");
            // input = new FileInputStream("C:/Users/Fatou/IdeaProjects/deedef/deedefProperties.properties");
             input= getClass().getClassLoader().getResourceAsStream("deedef");

            // / load a properties file
            prop.load(input);

            deedefUrl=prop.getProperty("deedef.com.url");
            deedefUsername=prop.getProperty("deedef.com.username");
            deedefPassword=prop.getProperty("deedef.com.password");
            deedefSender=prop.getProperty("deedef.com.sender");


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }}





	
	/* (non-Javadoc)
	 * @see com.deedef.service.ISendSmsService#envoiSMS(java.lang.String, java.lang.String)
	 */
	@Override
	public void envoiSMS(String numeroTelDestinataire, String contenu) throws ServiceException {
		envoiSMS(numeroTelDestinataire, contenu, null);
	}
	
	/* (non-Javadoc)
	 * @see com.deedef.service.ISendSmsService#envoiSMS(java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public void envoiSMS(String numeroTelDestinataire, String contenu, Integer idSuiviSMS) throws ServiceException {
		try
		{
			//cr�ation du bean � envoyer
			SmsXmlBean sms = createSmsXmlBean(numeroTelDestinataire, contenu, idSuiviSMS);
	
			//envoi du bean
			InputStream reponse = sendSmsXmlBean(sms);
			
			//analyse de la r�ponse
	//		analyseResponse(reponse, idSuiviSMS);
			
		} catch (Exception e) {
			logger.error("Exception", e);
			throw new ServiceException(e);
		}
	}
	
	/**
	 * M�thode permettant d'analyser le r�sultat transmis par le partenaire deedef
	 * D�finition : Code r�ponse suite � l'envoi.
	 * Code r�ponse		D�finition
	 * 		 1			Message envoy�
	 * 		-1			Le login et le mot de passe ne correspondent pas.
	 * 		-2			Erreur XML
	 * 		-3			Le nombre de cr�dits n'est pas suffisant
	 * 		-4			La date diff�r�e n'est pas correcte
	 * 		-5			La liste des destinataires contient une erreur.
	 * @param response   : InputStream du retour renvoy� par le partenaire
	 * @throws Exception : si le SMS n'a pas �t� envoy� correctement
	 */
	private void analyseResponse(InputStream response, Integer idSuiviSMS) throws Exception
	{
		try
		{
			// D�claration du context JAXB pour parser le XML de retour
			JAXBContext context = JAXBContext.newInstance(ResponseSmsXmlBean.class);
			Unmarshaller um = context.createUnmarshaller();
			ResponseSmsXmlBean responseSmsXmlBean = (ResponseSmsXmlBean) um.unmarshal(response);
			if(logger.isDebugEnabled())
			{
				logger.debug("out analyseResponse"+responseSmsXmlBean);
			}
			if(responseSmsXmlBean.getStatus()!=null && !CODE_REPONSE_SUCCES.equalsIgnoreCase(responseSmsXmlBean.getStatus()))
			{
				String errorMessage = "[deedef] erreur lors de la tentative d'envoi du SMS (id:"+idSuiviSMS+"). Cause : "+responseSmsXmlBean.getMessage();
				logger.error(errorMessage);
				throw new ServiceException(errorMessage);
			}


		}
		finally
		{
			if (response != null) try { response.close(); } catch (IOException logOrIgnore) {logger.error("erreur lors du close InputStream",logOrIgnore);}
		}
	}
	
	/**
	 * M�thode permettant de cr�er un SmsXmlBean d'apr�s les param�tres saisies.
	 * Le SmsXmlBean permettra de g�n�rer le xml � envoyer au partenaire
	 * @param numeroTelDestinataire
	 * @param contenu
	 * @param idSuiviSMS
	 * @return le SmsXmlBean valoris�
	 * @throws ServiceException 
	 */
	private SmsXmlBean createSmsXmlBean(String numeroTelDestinataire, String contenu, Integer idSuiviSMS) throws ServiceException
	{
		SmsXmlBean retour = null;
		//v�rification sur le format du num�ro de t�l�phone
		if(numeroTelDestinataire==null || numeroTelDestinataire.length()!=11 || !numeroTelDestinataire.startsWith("33"))
		{
			throw new ServiceException("Le format du num�ro de t�l�phone du destinataire du SMS est invalide ("+numeroTelDestinataire+") le format est le suivant : 33621533749");
		}
		//authentification aupr�s du partenaire
		AuthentificationXmlBean authentification = new AuthentificationXmlBean(deedefUsername, deedefPassword);
		//contenu du message � envoyer
		MessageXmlBean message = new MessageXmlBean(deedefSender,contenu);
		//destinataire du sms
		List<GsmXmlBean> listGSM = new ArrayList<GsmXmlBean>();
		
		listGSM.add(new GsmXmlBean(numeroTelDestinataire, idSuiviSMS));
		RecipientsXmlBean recipients = new RecipientsXmlBean(listGSM);

		//cr�ation du bean de retour
		retour = new SmsXmlBean(authentification, message,
				recipients);
		logger.debug("in createSmsXmlBean : "+retour);
		
		return retour;
	}
	
	/**
	 * M�thode permettant d'envoyer le SmsXmlBean par POST HTTP au partenaire Deedef au format XML
	 * @param smsXmlBean le bean � envoyer
	 * @return InputStream du retour renvoy� par le partenaire
	 * @throws Exception
	 */
	private InputStream sendSmsXmlBean(SmsXmlBean smsXmlBean) throws Exception
	{
		InputStream retour = null;
		// D�claration du context JAXB pour formatter le XML
		JAXBContext context = JAXBContext.newInstance(SmsXmlBean.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");	
		StringWriter stringWriter = null;
		String content = null;
		try
		{
			stringWriter = new StringWriter();
			m.marshal(smsXmlBean, stringWriter);
			content = stringWriter.toString();
		} finally {
		    if (stringWriter != null) try { stringWriter.close(); } catch (IOException logOrIgnore) {logger.error("erreur lors du close StringWriter",logOrIgnore);}
		}
		
		// Encodage et envoi du flux
		String param = URLEncoder.encode(content, CHARSET);
		String query = String.format("XML=%s", param);
        String complement="?pseudo="+smsXmlBean.getAuthentificationXmlBean().getUsername()+"&pass="+smsXmlBean.getAuthentificationXmlBean().getPassword()+"&message="
                +smsXmlBean.getMessageXmlBean().getText()+"&numero="+smsXmlBean.getRecipientsXmlBean().getGsm().get(0).getContent();
       // https://api.smsmode.com/http/1.6/sendSMS.do?
        // pseudo=bambandiay&pass=0ri0g86f&
        // message=Deedef SMS is ready !!!Test&
        // numero=0634450980,0699640387,0622847455,0679854465,0652530242&date_envoi=29112014-20:26
       URLConnection urlConnection = new URL(deedefUrl.concat(complement)).openConnection();
      //  URLConnection urlConnection = new URL("http://api.smsmode.com/http/1.6/sendSMS.do?pseudo=bambandiay&pass=0ri0g86f&message=Deedef SMS is ready !!!Test&numero=33661081494&date_envoi=30112014-14:16").openConnection();


        urlConnection.setUseCaches(false);
	urlConnection.setDoOutput(true); // Triggers POST.
//		urlConnection.setRequestProperty("accept-charset", CHARSET);
//		urlConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
		OutputStreamWriter writer = null;
		try {
		    writer = new OutputStreamWriter(urlConnection.getOutputStream(), CHARSET);
		    writer.write(query); // Write POST query string (if any needed).
		} finally {
		    if (writer != null) try { writer.close(); } catch (IOException logOrIgnore) {logger.error("erreur lors du close OutputStreamWriter",logOrIgnore);}
		}
	
		// R�cup�ration de la r�ponse du partenaire
		retour = urlConnection.getInputStream();
		logger.debug("in sendSmsXmlBean reponse : "+retour);
		return retour;
	}

	/**
	 * @return the deedefUsername
	 */
	public String getdeedefUsername() {
		return deedefUsername;
	}

	/**
	 * @param deedefUsername the deedefUsername to set
	 */
	public void setdeedefUsername(String deedefUsername) {
		this.deedefUsername = deedefUsername;
	}

	/**
	 * @return the deedefPassword
	 */
	public String getdeedefPassword() {
		return deedefPassword;
	}

	/**
	 * @param deedefPassword the deedefPassword to set
	 */
	public void setdeedefPassword(String deedefPassword) {
		this.deedefPassword = deedefPassword;
	}

	/**
	 * @return the deedefSender
	 */
	public String getdeedefSender() {
		return deedefSender;
	}

	/**
	 * @param deedefSender the deedefSender to set
	 */
	public void setdeedefSender(String deedefSender) {
		this.deedefSender = deedefSender;
	}

	/**
	 * @return the deedefUrl
	 */
	public String getdeedefUrl() {
		return deedefUrl;
	}

	/**
	 * @param deedefUrl the deedefUrl to set
	 */
	public void setdeedefUrl(String deedefUrl) {
		this.deedefUrl = deedefUrl;
	}
}
