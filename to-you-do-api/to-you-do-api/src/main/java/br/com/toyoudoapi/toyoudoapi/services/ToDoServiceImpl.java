package br.com.toyoudoapi.toyoudoapi.services;

import br.com.toyoudoapi.toyoudoapi.models.ToDo;
import br.com.toyoudoapi.toyoudoapi.models.dto.ToDoDTO;
import br.com.toyoudoapi.toyoudoapi.repositories.ToDoRepository;
import br.com.toyoudoapi.toyoudoapi.services.interfaces.ToDoService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepository toDoRepository;

    @Override
    @CachePut(value = "todo", key = "#todo.id")
    public ToDo save(final ToDo todo) {
        return this.toDoRepository.save(todo);
    }

    @Override
    @Cacheable(value = "todo", key = "#id")
    public Optional<ToDo> findById(final Long id) {
        return this.toDoRepository.findById(id);
    }

    @Override
    @Cacheable(value = "todos")
    public List<ToDo> findAll() {
        return this.toDoRepository.findAll();
    }

    @Override
    @Cacheable(value = "todo", key = "#descricao")
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
    @CacheEvict(value = { "todo", "todos", "todosConcluido"}, allEntries = true)
    public void deleteById(final Long id) {
        this.toDoRepository.deleteById(id);
    }

    @Override
    @CacheEvict(value = { "todo", "todos", "todosConcluido"}, allEntries = true)
    public void delete(final ToDo todo) {
        this.toDoRepository.delete(todo);
    }

    @Override
    @Cacheable(value = "todosConcluido", key = "#concluido")
    public List<ToDo> findByConcluido(boolean concluido) {
        return this.toDoRepository.findByConcluido(concluido);
    }

    /*
       ID COMPOSTO exemplo:
       @Cacheable(key = "{#pageNo,#pageSize}")
       public List<Post> retrieveAllPost(int pageNo,int pageSize)
    */
}
