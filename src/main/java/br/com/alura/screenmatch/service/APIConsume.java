package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConsume {

	public String getFilmsAndSeriesData(String address) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).build();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch(IOException ioException) {
			throw new RuntimeException(ioException);
		} catch(InterruptedException interruptedException) {
			throw new RuntimeException(interruptedException);
		}
		String json = "";
		if(response != null) {
			json = response.body();
		}
		return json;
	}
}
