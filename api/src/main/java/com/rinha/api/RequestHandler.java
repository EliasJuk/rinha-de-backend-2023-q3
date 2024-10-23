package com.rinha.api;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public abstract class RequestHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		String response = handleRequest(exchange);
		exchange.sendResponseHeaders(getResponseCode(), response.length());
		try (OutputStream os = exchange.getResponseBody()) {
			os.write(response.getBytes());
		}
	}

	protected abstract String handleRequest(HttpExchange exchange) throws IOException;
	protected abstract int getResponseCode();
}