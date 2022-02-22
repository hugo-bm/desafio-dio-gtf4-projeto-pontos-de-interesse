package com.br.dio.desafiodiogtf4projetopontosdeinteresse.services;

import com.br.dio.desafiodiogtf4projetopontosdeinteresse.models.PontosInteresse;
/**
 * Interface para um CRUD de Pontso de Interesse
 * @author Hugo Moreno
 * @since Versão 1.0.0
 * @version versão 1.0.0
 */
public interface PontosInteresseService {
    
    Iterable<PontosInteresse> buscarTodos();

    PontosInteresse buscar(Long id);

    void inserir(PontosInteresse ponto);

    void atualizar(Long id, PontosInteresse ponto);

    void deletar(Long id);

}
