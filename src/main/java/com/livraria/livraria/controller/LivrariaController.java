package com.livraria.livraria.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.livraria.livraria.model.Livro;



@RestController
@RequestMapping("biblioteca")
public class LivrariaController {

    private List<Livro> livros;

    public LivrariaController(){
        livros = new ArrayList<>();
        livros.add(new Livro(1, "Dom Casmurro", "Machado de Assis", 2000));
        livros.add(new Livro(2, "Perdida", "Carina Rissi", 2010));
        livros.add(new Livro(3, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943));
    }

    @GetMapping
    public String mensagemDeBemVindo(){
        return "Bem-vindo à nossa Livraria!";
    }

    @GetMapping("livros")
    public List<Livro> getLivros(){
        return livros;
    }

    @GetMapping("autores")
    public List<String> getAutores() {
        List<String> autores = new ArrayList<>();
        for (Livro livro : livros) {
            autores.add(livro.getAutor()); 
        }
        return autores;
    }

    @GetMapping("autores-anos")
    public List<String> getAutoresEAnos(){
        List<String> autoresEAnos = new ArrayList<>();
        for(Livro livro : livros){
            autoresEAnos.add(livro.getAutor() + " - " + livro.getAno());
        } 
        return autoresEAnos;
    }

    @PostMapping("livro")
    public String criarLivro(@RequestBody Livro novoLivro) {
        livros.add(novoLivro);
        return "Livro adicionado com sucesso!";
    
    }
}
