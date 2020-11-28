package br.com.basis.livraria.web.dto;

import br.com.basis.livraria.domain.Comentario;
import br.com.basis.livraria.domain.Livro;
import br.com.basis.livraria.domain.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComentarioDto {

    private Byte avaliacao;
    private String descricao;
    private Integer idLivro;
    private Usuario idUsuario;

    public static Comentario toComentario(ComentarioDto comentarioDto){
        Comentario comentario = new Comentario();
        comentario.setAvaliacao(comentarioDto.getAvaliacao());
        comentario.setDescricao(comentarioDto.getDescricao());
        Livro livro = new Livro();
        livro.setId(comentarioDto.getIdLivro());


        return comentario;
    }
}
