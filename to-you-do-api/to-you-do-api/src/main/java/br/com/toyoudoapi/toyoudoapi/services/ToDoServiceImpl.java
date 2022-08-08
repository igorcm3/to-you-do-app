package br.com.toyoudoapi.toyoudoapi.services;

import br.com.toyoudoapi.toyoudoapi.models.ToDo;
import br.com.toyoudoapi.toyoudoapi.models.dto.ToDoDTO;
import br.com.toyoudoapi.toyoudoapi.repositories.ToDoRepository;
import br.com.toyoudoapi.toyoudoapi.services.interfaces.ToDoService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepository toDoRepository;

    @Override
    public ToDo save(final ToDo todo) {
        return this.toDoRepository.save(todo);
    }

    @Override
    public Optional<ToDo> findById(final Long id) {
        return this.toDoRepository.findById(id);
    }

    @Override
    public List<ToDo> findAll() {
        return this.toDoRepository.findAll();
    }

    @Override
    public Optional<ToDo> findByDescricao(final String descricao) {
        return this.toDoRepository.findByDescricao(descricao);
    }

    @Override
    public ToDo TodoDTOtoTodo(final ToDoDTO dto) {
        // Se for novo, constroi e retorna para ser salvo.
        if(dto.getId() == null){
            ToDo todo = new ToDo();
            BeanUtils.copyProperties(dto, todo);
            return todo;
        }
        Optional<ToDo> todoOpt = this.findById(dto.getId());
        if(todoOpt.isPresent()){
           ToDo todo = todoOpt.get();
            BeanUtils.copyProperties(dto, todo, "version");
            return todo;
        }
        return null;
    }

    @Override
    public void deleteById(final Long id) {
        this.toDoRepository.deleteById(id);
    }

    @Override
    public void delete(final ToDo todo) {
        this.toDoRepository.delete(todo);
    }

    @Override
    public List<ToDo> findByConcluido(boolean concluido) {
        return this.toDoRepository.findByConcluido(concluido);
    }
}
