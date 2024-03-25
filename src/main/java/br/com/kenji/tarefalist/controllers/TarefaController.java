package br.com.kenji.tarefalist.controllers;

import br.com.kenji.tarefalist.repositories.TarefaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class TarefaController {

    private final TarefaRepository tarefaRepository;

    public TarefaController(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @GetMapping("/")
    public ModelAndView list() {
        return new ModelAndView("tarefa/lista", Map.of("tarefas", tarefaRepository.findAll()));
    }
}
