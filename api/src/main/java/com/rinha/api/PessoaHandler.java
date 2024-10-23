package com.rinha.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.rinha.models.Pessoa;
import com.sun.net.httpserver.HttpExchange;

public class PessoaHandler extends RequestHandler {
	private final List<Pessoa> pessoas = new ArrayList<>();
	private int nextId = 1;

	@Override
	protected String handleRequest(HttpExchange exchange) throws IOException {
    return switch (exchange.getRequestMethod()) {
      case "POST" -> createPessoa(exchange);
      case "GET" -> getPessoas(exchange);
      default -> "Método não suportado";
    };
	}

	private String createPessoa(HttpExchange exchange) throws IOException {
		InputStream inputStream = exchange.getRequestBody();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String nome = reader.readLine();
		Pessoa novaPessoa = new Pessoa(nextId++, nome);
		pessoas.add(novaPessoa);
		return "Pessoa criada: ID=" + novaPessoa.getId() + ", Nome=" + novaPessoa.getNome();
	}

	private String getPessoas(HttpExchange exchange) {
		StringBuilder response = new StringBuilder("Pessoas cadastradas:\n");
		for (Pessoa p : pessoas) {
			response.append("ID: ").append(p.getId()).append(", Nome: ").append(p.getNome()).append("\n");
		}
		return response.toString();
	}

	@Override
	protected int getResponseCode() {
		return 200;
	}
}