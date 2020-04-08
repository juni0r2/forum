package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping("/topicos")
    public List<TopicoDto> lista(String nomeCurso) {

        if (nomeCurso == null) {
            return TopicoDto.converter(topicoRepository.findAll());
        } else {
            return TopicoDto.converter(topicoRepository.carregarPorNomeCurso(nomeCurso));
        }
    }
}
