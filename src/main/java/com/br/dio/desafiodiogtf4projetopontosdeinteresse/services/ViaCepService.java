package com.br.dio.desafiodiogtf4projetopontosdeinteresse.services;

import com.br.dio.desafiodiogtf4projetopontosdeinteresse.models.Enderecos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Service para consumir o WebService ViaCEP
 * @implNote Foi implemetado utilizando spring-cloud OpenFeign
 * @see <a href="https://cloud.spring.io/spring-cloud-openfeign/reference/html/">OpenFeign<a/>,
 *   <a href="https://viacep.com.br/">WebService ViaCEP<a/>
 * @author Hugo Moreno
 * @since Versão 1.0.0
 * @version versão 1.0.0
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    Enderecos consultarCep(@PathVariable("cep") String cep);
}