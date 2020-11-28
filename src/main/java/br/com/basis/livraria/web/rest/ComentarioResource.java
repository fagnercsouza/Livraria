package br.com.basis.livraria.web.rest;

import br.com.basis.livraria.domain.Comentario;
import br.com.basis.livraria.domain.Livro;
import br.com.basis.livraria.service.ComentarioService;
import br.com.basis.livraria.web.dto.ComentarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioResource {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public List<Comentario> buscarTodos(){
        return comentarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Integer id){
        return new ResponseEntity(comentarioService.buscarPorId(id), HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity cadastrar(@RequestBody Comentario comentario){
//        return new ResponseEntity(comentarioService.inserir(comentario), HttpStatus.CREATED);
//    }
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody ComentarioDto comentarioDto){
        Comentario comentario = comentarioDto.toComentario(comentarioDto);
        return new ResponseEntity(comentarioService.inserir(comentario), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id){
        comentarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    public ResponseEntity<Comentario> alterar(@RequestBody Comentario comentario){
        Comentario comentarioAlterado = comentarioService.alterar(comentario);
        return new ResponseEntity(comentarioAlterado, HttpStatus.OK);
    }
}
