package com.certificatic.model;

import javax.xml.bind.annotation.XmlRootElement;

//Esta notacion ayuda a que el objeto pueda convertirse en JSON o XML, es lo de marshall unmarshall
@XmlRootElement
public class Respuesta {
	private int code;
	private String mensaje;
	
	public Respuesta() {
	}
	
	
	public Respuesta(int code, String mensaje) {
		this.code = code;
		this.mensaje = mensaje;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
