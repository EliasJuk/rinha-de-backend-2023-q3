package com.rinha.api;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class SimpleRestServer {
	private final int port;
	private final HttpServer server;
	private final Map<String, HttpHandler> routes = new HashMap<>();

	public SimpleRestServer(int port) throws IOException {
		this.port = port;
		this.server = HttpServer.create(new InetSocketAddress(port), 0);
	}

	public void start() {
		server.setExecutor(null);
		for (Map.Entry<String, HttpHandler> entry : routes.entrySet()) {
			server.createContext(entry.getKey(), entry.getValue());
		}
		server.start();
		System.out.println("Servidor iniciado na porta " + port);
	}

	public void stop() {
		server.stop(0);
		System.out.println("Servidor parado.");
	}

	public void addRoute(String path, HttpHandler handler) {
		routes.put(path, handler);
	}
}
