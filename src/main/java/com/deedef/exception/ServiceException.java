package com.deedef.exception;


/**
 * Exception qui sera propag� en cas de probl�me dans un traitement m�tier
 * @author Poichou (poichou@gmail.com)
 */
public class ServiceException extends Exception{

	/**
	 * generated UID
	 */
	private static final long serialVersionUID = -525884182433940999L;

	/**
	 * CONSTRUCTEURS 
	 */

	/**
	 * Red�finition d'un constructeur vide
	 * @see Exception#Exception()
	 */
	public ServiceException() {
		super();
	}

	/**
	 * Red�finition d'un constructeur avec un message
	 * @param message
	 * @see Exception#Exception(String message)
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * Red�finition d'un constructeur avec une cause
	 * @param cause
	 * @see Exception#Exception(Throwable cause)
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}
	
    /**
     * Red�finition d'un constructeur avec un message et une cause
     * @param message
     * @param cause
     * @see Exception#Exception(String message, Throwable cause)
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}

