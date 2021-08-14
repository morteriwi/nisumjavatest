package nisum.java.test.models.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorInfo {
	@JsonProperty("mensaje")
	private String mensaje;
	
	public ErrorInfo(String msg) {
	       this.mensaje = msg;
	   }
}
