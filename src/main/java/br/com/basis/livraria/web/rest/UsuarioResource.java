package br.com.basis.livraria.web.rest;

import br.com.basis.livraria.domain.Usuario;
import br.com.basis.livraria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> buscarTodos(){
        return usuarioService.buscarTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Integer id){

        return new ResponseEntity(usuarioService.buscarPorId(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Usuario> inserir(@RequestBody Usuario usuario){
        return new ResponseEntity(usuarioService.inserir(usuario), HttpStatus.CREATED);
    }
}
