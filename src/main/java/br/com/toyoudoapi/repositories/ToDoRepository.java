package br.com.toyoudoapi.repositories;

import br.com.toyoudoapi.models.ToDo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    Optional<ToDo> findByDescricao(String descricao);

    List<ToDo> findByConcluido(boolean concluido);
}
