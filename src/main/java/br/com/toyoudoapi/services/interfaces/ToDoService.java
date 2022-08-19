package br.com.toyoudoapi.services.interfaces;

import br.com.toyoudoapi.models.ToDo;
import br.com.toyoudoapi.models.dto.ToDoDTO;
import java.util.List;
import java.util.Optional;

public interface ToDoService {
    /**
     * Salva ou edita um ToDo
     * @param todo
     * @return
     */
    ToDo save(final ToDo todo);

    /**
     * Busca um ToDo filtrando por ID
     * @param id
     * @return
     */
    Optional<ToDo> findById(final Long id);

    /**
     * Retorna todos os ToDo
     * @return
     */
    List<ToDo> findAll();

    /**
     * Retorna um ToDo filtrando pela descrição
     * @param descricao
     * @return
     */
    Optional<ToDo> findByDescricao(final String descricao);

    /**
     * Converte um ToDO DTO para Entity
     * @param dto
     * @return
     */
    ToDo TodoDTOtoTodo(final ToDoDTO dto);

    /**
     * Deleta pelo ID
     * @param id
     */
    void deleteById(final Long id);

    /**
     * Deleta pela Entity
     * @param todo
     */
    void delete(final ToDo todo);

    /**
     * Retorna todos os ToDo concluidos
     * @return
     */
    List<ToDo> findByConcluido(final boolean isConcluido);
}
