package br.com.basis.livraria.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Livro {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livroGenerator")
    @SequenceGenerator(name = "livroGenerator", sequenceName = "livro_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "autor")
    private String autor;
    // usar o mappedBy para indicar o atributo da classe
    @OneToMany(mappedBy = "livro")
//    @JsonIgnore
    private List<Comentario> comentarios;


}
