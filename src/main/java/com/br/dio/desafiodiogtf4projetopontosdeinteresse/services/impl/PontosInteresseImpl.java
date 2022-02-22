package com.br.dio.desafiodiogtf4projetopontosdeinteresse.services.impl;

import java.util.Optional;

import com.br.dio.desafiodiogtf4projetopontosdeinteresse.models.Enderecos;
import com.br.dio.desafiodiogtf4projetopontosdeinteresse.models.EnderecosRepository;
import com.br.dio.desafiodiogtf4projetopontosdeinteresse.models.PontosInteresse;
import com.br.dio.desafiodiogtf4projetopontosdeinteresse.models.PontosInteresseRepository;
import com.br.dio.desafiodiogtf4projetopontosdeinteresse.services.PontosInteresseService;
import com.br.dio.desafiodiogtf4projetopontosdeinteresse.services.ViaCepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Implementação do Serviço de Pontos de Interesse 
 * - Permite criar, salvar, autalizar e excluir um ponto de interesse
 * @author Hugo Moreno
 * @since Versão 1.0.0
 * @version versão 1.0.0
 * 
 */
@Service
public class PontosInteresseImpl implements PontosInteresseService {

    @Autowired
    private EnderecosRepository enderecosRepository;

    @Autowired
    private ViaCepService cepService;

    @Autowired
    private PontosInteresseRepository pontosInteresseRepository;

    /**
     * Função Para Salvamento de Pontos de Interesse
     * @param PontosInteresse ponto - Objeto com informações minimas de titulo,descrição e CEP
     * @return PontosInteresse - Retorna o Objeto com Endereço preenchido através do WebService ViaCep
     * @author Hugo Moreno
     * @since Versão 1.0.0
     * @version versão 1.0.0
     * @see <a href="https://viacep.com.br/">WebService ViaCEP<a/>
     */

    private PontosInteresse salvarPontosIntereceComCep(PontosInteresse ponto){
        String cep = ponto.getEndereco().getCep();
        Enderecos endereco = enderecosRepository.findById(cep).orElseGet(()->{
            Enderecos novoEndereco = cepService.consultarCep(cep);
            enderecosRepository.save(novoEndereco);
            return novoEndereco;
        });
        ponto.setEndereco(endereco);
        pontosInteresseRepository.save(ponto);
        return ponto;
    }   

    @Override
    public Iterable<PontosInteresse> buscarTodos() {
        return pontosInteresseRepository.findAll();
    }

    @Override
    public PontosInteresse buscar(Long id) {
        Optional<PontosInteresse> ponto = pontosInteresseRepository.findById(id);
        if(ponto.isPresent()) return ponto.get();
        return null;
    }

    @Override
    public void inserir(PontosInteresse ponto) {
        salvarPontosIntereceComCep(ponto);
    }

    @Override
    public void atualizar(Long id, PontosInteresse ponto) {
        Optional<PontosInteresse> pontoBuscado = pontosInteresseRepository.findById(id);
        if(pontoBuscado.isPresent())
        salvarPontosIntereceComCep(ponto);        
    }

    @Override
    public void deletar(Long id) {
        pontosInteresseRepository.findById(id);        
    }
    
}
