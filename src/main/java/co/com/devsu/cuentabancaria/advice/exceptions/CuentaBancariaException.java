package co.com.devsu.cuentabancaria.advice.exceptions;

import lombok.Getter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;

@Getter
public class CuentaBancariaException extends Exception {

	private static final long serialVersionUID = 1L;

	protected final String mensaje;
   
    protected final String mensajeCliente;

    protected final transient Object[] mensajeParams;

    /**
     * Constructor de la clase.En esta clase se recibe el error
     * y se registra en el log el error que ha
     * ocurrido
     *
     * @param mensaje Mensaje de error
     * @param log
     * @param mensajeParams
     */
    public CuentaBancariaException(String mensaje, Logger log, Object... mensajeParams) {
         this.mensaje = mensaje;
         this.mensajeCliente = mensaje;
         this.mensajeParams = mensajeParams;
         log.error(mensaje);
     }

     /**
      * Constructor de la clase.En esta clase se recibe el error, se llama al
      * constructor de la clase padre y se registra en el log el error que ha
      * ocurrido
      *
      * @param mensaje Mensaje de error
      * @param cause
      * @param log
      * @param mensajeParams
      */
     public CuentaBancariaException(String mensaje, Throwable cause, Logger log, Object... mensajeParams) {
         super(cause);
         this.mensaje = mensaje;
         this.mensajeCliente = mensaje;
         this.mensajeParams = mensajeParams;
         log.error(cause);
     }

     /**
      * Constructor que recibe el mensaje a ser retornado y como opcional
      * los parametros que van dentro del mensaje formateado
      *
      * @param mensaje
      * @param mensajeParams **/
     public CuentaBancariaException(String mensaje, Object... mensajeParams) {
         this.mensaje = mensaje;
         this.mensajeCliente = mensaje;
         this.mensajeParams = mensajeParams;
     }

     /**
      * Constructor que recibe el mensaje a ser retornado y como opcional
      * los parametros que van dentro del mensaje formateado
      *
      * @param mensajeServer
      * @param mensajeCliente
      * @param mensajeParams **/
     public CuentaBancariaException(String mensajeServer, String mensajeCliente, Object... mensajeParams) {
         this.mensaje = mensajeServer;
         this.mensajeCliente = mensajeCliente;
         this.mensajeParams = mensajeParams;
     }

     /**
      * Constructor que recibe la causa (Exception) que se le pasa a la clase padre,
      * el mensaje a ser retornado y como opcional
      * los parametros que van dentro del mensaje formateado
      *
      * @param cause
      * @param mensaje
      * @param mensajeParams **/
     public CuentaBancariaException(Exception cause, String mensaje, Object... mensajeParams) {
         super(cause);
         this.mensaje = mensaje;
         this.mensajeCliente = mensaje;
         this.mensajeParams = mensajeParams;
     }

     @Override
     public String getMessage() {
         return ArrayUtils.isNotEmpty(mensajeParams) ? ParameterizedMessage.format(mensaje, mensajeParams) : mensaje;
     }

     public String getMensajeCliente() {
         return ArrayUtils.isNotEmpty(mensajeParams) ? ParameterizedMessage.format(mensajeCliente, mensajeParams) : mensajeCliente;
     }
}
