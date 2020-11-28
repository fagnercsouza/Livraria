package br.com.basis.livraria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comentarioGenerator")
    @SequenceGenerator(name = "comentarioGenerator", sequenceName = "comentario_seq", allocationSize = 1)
    private Integer id;
    private Byte avaliacao;
    private String descricao;
    private LocalDateTime criacao;
    @ManyToOne
    @JoinColumn(name = "id_livro")
    @JsonIgnore
    private Livro livro;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @PrePersist
    private void setCriacao(){
        this.criacao =  LocalDateTime.now();
    }

}
