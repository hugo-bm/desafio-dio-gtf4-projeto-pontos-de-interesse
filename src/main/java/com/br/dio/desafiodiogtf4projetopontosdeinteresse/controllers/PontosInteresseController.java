package com.br.dio.desafiodiogtf4projetopontosdeinteresse.controllers;

import com.br.dio.desafiodiogtf4projetopontosdeinteresse.models.PontosInteresse;
import com.br.dio.desafiodiogtf4projetopontosdeinteresse.services.PontosInteresseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller REST para Pontos de Interesse
 * @implNote Foi implementado utilizando spring-boot, spring-web-services e OpenAPI Swagger-ui
 * @author Hugo Moreno
 * @since Versão 1.0.0
 * @version versão 1.0.0
 * @see <a href="https://spring.io/projects/spring-boot">Spring-boot<a/>,
 * <a href="https://spring.io/projects/spring-ws">Spring-web-services<a/>,
 * <a href="https://swagger.io/tools/swagger-ui/">OpenAPI Swagger-ui<a/>
 */

@RestController
@RequestMapping("pontos-interesse")
public class PontosInteresseController {
    @Autowired
    private PontosInteresseService pontosInteresseService;

 

    @GetMapping()
    public ResponseEntity<Iterable<PontosInteresse>> buscarTodos() {
        return ResponseEntity.ok(pontosInteresseService.buscarTodos());
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<PontosInteresse> buscar(@RequestParam Long id) {
        return ResponseEntity.ok(pontosInteresseService.buscar(id));
    }

    @PostMapping()
    public ResponseEntity<String>  inserir(@RequestBody PontosInteresse ponto) {

        String msg;

        try {
            pontosInteresseService.inserir(ponto);
            System.out.println(ponto.getTitulo());
            msg = "Ponto de interesse criado com sucesso!";
        } catch (Exception e) {
            msg = "Não foi possivel criar um novo ponto de interesse!";
            return ResponseEntity.status(HttpStatus.valueOf(400)).body(msg);
        }
        return ResponseEntity.status(HttpStatus.valueOf(201)).body(msg);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String>  atualizar(@PathVariable Long id,@RequestBody PontosInteresse ponto) {
        String msg;
        try {
            pontosInteresseService.atualizar(id, ponto);
            System.out.println(ponto.getTitulo());
            msg = "Ponto de interesse atualizado com sucesso!";
        } catch (Exception e) {
            msg = "Não foi possivel atualizar o ponto de interesse!";
            return ResponseEntity.status(HttpStatus.valueOf(400)).body(msg);
        }
        return ResponseEntity.status(HttpStatus.valueOf(201)).body(msg);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deletar(@PathVariable Long id) {
        String msg;
        try {
            pontosInteresseService.deletar(id);
            msg = "Ponto de interesse deletado com sucesso!";
        } catch (Exception e) {
            msg = "Não foi possivel deletar o ponto de interesse!";
            return ResponseEntity.status(HttpStatus.valueOf(400)).body(msg);
        }
        return ResponseEntity.status(HttpStatus.valueOf(201)).body(msg);
    }
    

}