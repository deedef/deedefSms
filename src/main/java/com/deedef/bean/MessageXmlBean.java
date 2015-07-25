package com.deedef.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Bamba
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message")
public class MessageXmlBean {
	/* valeur par d�faut */
	private final static String DEFAULT_FLASH = "0";
	private final static String DEFAULT_TYPE = "longSMS";

	/**
	 * Obligatoire : oui
	 * D�finition : Exp�diteur du message tel qu�il apparaitra sur le t�l�phone.
	 * Limite : 11 caract�res alphanum�riques.
	 */
	private String sender;
	
	/**
	 * Obligatoire : oui
	 * D�finition : Message de votre sms. Les caract�res autoris�s sont les caract�res de la norme SMS GSM7 (cf. : http ://sms.24cro.com/op_1_4_en.htm).
	 * Tous les caract�res qui ne sont pas dans cette norme seront convertis dans le caract�re le plus proche (exemple : � => e). 
	 * Le syst�me g�re les SMS longs. 
	 * Le message peut donc d�passer 160 caract�res et sera visualis� par le destinataire comme un seul SMS.
	 * Limite : 1120 caract�res.
	 */
	private String text;
	
	/**
	 * Obligatoire : non � par d�faut 0 (false)
	 * D�finition : D�termine si le sms est un sms flash. 
	 * Cette fonctionnalit� n�est pas compatible avec tous les t�l�phones portables. Les SMS Flash sont des SMS qui s'affichent
	 * directement sur l'�cran du t�l�phone, au lieu d'aller vers la messagerie.
	 * Liste de valeurs : 0 ou 1
	 */
	private String isFlash;
	
	/**
	 * Obligatoire : non � par d�faut "longSMS"
	 * D�finition : Un texte plus long, appel� SMS long ou SMS concat�n�s, peut �tre envoy� en le segmentant en plusieurs messages, 
	 * de mani�re automatique par l�appareil mobile. 
	 * C�est le terminal r�cepteur qui est charg� de r�assembler le message, puis de le pr�senter � l�utilisateur d�un seul tenant. 
	 * Bien que le standard permette th�oriquement jusqu�� 255 segments, en pratique seuls 6 � 8 segments de messages sont possibles, 
	 * et chaque segment est factur� au prix d�un message individuel. 
	 * Si le SMS d�passe 160 caract�res alors le syst�me coupe les SMS par tranche de 153 caract�res. 
	 * Les 7 caract�res restants servant � la concat�nation des messages.
	 * Si le message est un message WAP alors utilisez le type � bookmark �.
	 * Liste de valeurs : "longSMS", "bookmark" 
	 */
	private String type;
	
	/**
	 * Obligatoire : non
	 * D�finition : Permet de lier le message WAP (sms de type bookmark) � une adresse internet. 
	 * Ainsi en ouvrant le message l�utilisateur pourra acc�der directement au lien.
	 * Exemple : www.smsfactor.com
	 */
	private String bookmark;
	
	/**
	 * Obligatoire : non
	 * D�finition : D�termine la date � laquelle le message sera envoy�. Si une date dans le pass� est envoy�e, le message sera envoy� imm�diatement. 
	 * Si ce champ n�est pas renseign� le SMS sera envoy� en instantan�.
	 * Format : yyyy-mm-jjThh:mm:ss (exemple : 2010-09-21T21:10:00)
	 */
	private String delay;
	
	/**
	 *  Constructeur vide
	 */
	public MessageXmlBean() {
		super();
	}

	/**
	 *  Constructeur avec les params obligatoires
	 * @param sender
	 * @param text
	 */
	public MessageXmlBean(String sender, String text) {
		super();
		this.sender = sender;
		this.text = text;
		this.isFlash = DEFAULT_FLASH;
		this.type = DEFAULT_TYPE;
	}
	
	/**
	 *  Constructeur avec tous les params
	 * @param sender
	 * @param text
	 * @param isFlash
	 * @param type
	 * @param bookmark
	 * @param delay
	 */
	public MessageXmlBean(String sender, String text, Boolean isFlash, String type,
			String bookmark, String delay) {
		this(sender,text);
		if(isFlash!=null && isFlash.booleanValue())
		{
			this.isFlash="1";
		}
		this.type = type;
		this.bookmark = bookmark;
		this.delay = delay;
	}	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AuthentificationXmlBean {sender=");
		builder.append(sender);
		builder.append(", text=");
		builder.append(text);
		builder.append(", isFlash=");
		builder.append(isFlash);
		builder.append(", type=");
		builder.append(type);
		builder.append(", bookmark=");
		builder.append(bookmark);
		builder.append(", delay=");
		builder.append(delay);
		builder.append("}");
		return builder.toString();
	}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBookmark() {
        return bookmark;
    }

    public void setBookmark(String bookmark) {
        this.bookmark = bookmark;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getIsFlash() {
        return isFlash;
    }

    public void setIsFlash(String isFlash) {
        this.isFlash = isFlash;
    }

    public static void main(String [] args){
        System.out.println("LHcdsv dsvdsvdsvds");
    }
}