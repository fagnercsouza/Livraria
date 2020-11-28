package br.com.basis.livraria.service;

import br.com.basis.livraria.domain.Livro;
import br.com.basis.livraria.repository.LivroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LivroService {

//    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> buscarTodos(){
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarPorId(Integer id){
        return livroRepository.findById(id);
    }

    public Livro inserir(Livro livro){
        return livroRepository.save(livro);
    }

    public void deletar(Integer id){
        livroRepository.deleteById(id);
    }

    public Livro alterar(Livro livro){
        return livroRepository.save(livro);
    }
}
