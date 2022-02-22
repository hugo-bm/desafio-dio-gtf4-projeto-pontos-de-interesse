package com.br.dio.desafiodiogtf4projetopontosdeinteresse;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DesafioDioGtf4ProjetoPontosDeInteresseApplication.class);
	}

}
