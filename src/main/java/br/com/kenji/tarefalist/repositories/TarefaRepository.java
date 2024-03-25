package br.com.kenji.tarefalist.repositories;

import br.com.kenji.tarefalist.models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
