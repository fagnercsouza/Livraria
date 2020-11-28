package br.com.basis.livraria.service;

import br.com.basis.livraria.domain.Comentario;
import br.com.basis.livraria.domain.Livro;
import br.com.basis.livraria.domain.exception.LivrariaException;
import br.com.basis.livraria.repository.ComentarioRepository;
import br.com.basis.livraria.repository.LivroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ComentarioService {
    private ComentarioRepository comentarioRepository;
    private LivroRepository livroRepository;

    public List<Comentario> listarTodos(){
        return comentarioRepository.findAll();
    }
    public Optional<Comentario> buscarPorId(Integer id){
        return comentarioRepository.findById(id);
    }
    public Comentario inserir(Comentario comentario){
        Optional<Livro> livro = livroRepository.findById(comentario.getLivro().getId());

        if(livro.isPresent()){
            comentario.setLivro(livro.get());
            return comentarioRepository.save(comentario);
        }

        throw new LivrariaException("Livro não encontrado");

//        return comentarioRepository.save(comentario);
    }
    public void deletar(Integer id){
        comentarioRepository.deleteById(id);
    }

    public Comentario alterar(Comentario comentario){
        return comentarioRepository.save(comentario);
    }
}
