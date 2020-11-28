package br.com.basis.livraria.web.dto;

import br.com.basis.livraria.domain.Comentario;

import java.util.List;

public class UsuarioDto {

    private Integer id;
    private String nome;
    private String email;
    private List<Comentario> comentarios;
}
