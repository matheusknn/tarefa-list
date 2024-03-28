package br.com.kenji.tarefalist.controllers;

import br.com.kenji.tarefalist.models.Tarefa;
import br.com.kenji.tarefalist.repositories.TarefaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
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

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable  Long id) {
        var tarefa = tarefaRepository.findById(id);
        if(tarefa.isEmpty()) {
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("tarefa/form", Map.of("tarefa", tarefa.get()));
    }

    @PostMapping("/edit/{id}")
    public String edit(Tarefa tarefa) {
        tarefa.setCriacao(LocalDateTime.now());
        tarefaRepository.save(tarefa);
        return "redirect:/";
    }

}
