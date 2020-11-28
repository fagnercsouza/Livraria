package br.com.basis.livraria.web.rest;

import br.com.basis.livraria.domain.Livro;
import br.com.basis.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> buscarTodos(){
        return livroService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Integer id){
        return new ResponseEntity(livroService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody Livro livro){
        return new ResponseEntity(livroService.inserir(livro), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id){
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Livro> alterar(@RequestBody Livro livro){
        Livro livroALterado = livroService.alterar(livro);
        return new ResponseEntity(livroALterado, HttpStatus.OK);
    }
}
