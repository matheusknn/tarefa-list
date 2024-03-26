package br.com.kenji.tarefalist.controllers;

import br.com.kenji.tarefalist.models.Tarefa;
import br.com.kenji.tarefalist.repositories.TarefaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
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

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("tarefa/form", Map.of("tarefa", new Tarefa()));
    }

    @PostMapping("/create")
    public String create(Tarefa tarefa) {
        var dataAtual = LocalDateTime.now();
        tarefa.setCriacao(dataAtual);
        tarefaRepository.save(tarefa);
        return "redirect:/";
    }

}
