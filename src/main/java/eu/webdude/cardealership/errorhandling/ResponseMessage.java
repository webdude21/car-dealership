package eu.webdude.cardealership.errorhandling;

import java.io.Serializable;

public class ResponseMessage implements Serializable {

	private static final long serialVersionUID = 6435952479680013663L;

	private String response;

	public ResponseMessage(String response) {
		this.setResponse(response);
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}