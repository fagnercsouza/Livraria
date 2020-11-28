package br.com.basis.livraria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioGenerator")
    @SequenceGenerator(name = "usuarioGenerator", sequenceName = "usuario_seq", allocationSize = 1)
    private Integer id;
    private String nome;
    private String email;
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Comentario> comentarios;

}
