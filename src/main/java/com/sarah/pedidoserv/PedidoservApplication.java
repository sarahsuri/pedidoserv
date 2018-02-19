package com.sarah.pedidoserv;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sarah.pedidoserv.domain.Pedido;
import com.sarah.pedidoserv.service.PedidoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class PedidoservApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidoservApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PedidoService pedidoService) {
		return args -> {
			try {
			byte[] jsonData = Files.readAllBytes(Paths.get("pedidos.json"));


			ObjectMapper objectMapper = new ObjectMapper();

			//convert json string to object
			Pedido pedidos = objectMapper.readValue(jsonData, Pedido.class);

				pedidoService.save(pedidos);
				System.out.println("Pedido(s) registrado(s) com sucesso!");
			} catch (IOException e){
				System.out.println("Falha ao registrar pedido(s) " + e.getMessage());
			}
		};
}}

