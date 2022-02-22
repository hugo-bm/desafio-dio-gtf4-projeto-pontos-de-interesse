package com.br.dio.desafiodiogtf4projetopontosdeinteresse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioDioGtf4ProjetoPontosDeInteresseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioDioGtf4ProjetoPontosDeInteresseApplication.class, args);
	}

}
