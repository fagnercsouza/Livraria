package br.com.basis.livraria.service;

import br.com.basis.livraria.domain.Usuario;
import br.com.basis.livraria.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepository.findById(id);
    }
    public Usuario inserir(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
