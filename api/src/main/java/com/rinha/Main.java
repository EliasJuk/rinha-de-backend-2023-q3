package com.rinha;

import java.io.IOException;

import com.rinha.api.PessoaHandler;
import com.rinha.api.SimpleRestServer;
public class Main {
	public static void main(String[] args) {
		try {
			SimpleRestServer server = new SimpleRestServer(8080);
			server.addRoute("/pessoas", new PessoaHandler());
			server.start();

			// Adiciona um shutdown hook para parar o servidor ao encerrar o programa
			Runtime.getRuntime().addShutdownHook(new Thread(server::stop));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}