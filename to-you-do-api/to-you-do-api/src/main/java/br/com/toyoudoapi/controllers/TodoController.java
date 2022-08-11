package br.com.toyoudoapi.controllers;

import br.com.toyoudoapi.configs.security.dto.ResponseError;
import br.com.toyoudoapi.models.ToDo;
import br.com.toyoudoapi.models.dto.ToDoDTO;
import br.com.toyoudoapi.services.interfaces.ToDoService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class TodoController {

    private static final Logger log = LoggerFactory.getLogger(TodoController.class);

    private final ToDoService toDoService;

    @GetMapping(value = "/save")
    public ResponseEntity<?> saveTodo(@Valid@RequestBody ToDoDTO dto, BindingResult result){
        ResponseError responseError = new ResponseError();
        try {
            if (result.hasErrors()) {
                log.info("Erro ao salvar ToDo: {}", result.getAllErrors());
                result.getAllErrors().forEach(error -> responseError.getError().add(error.toString()));
                return ResponseEntity.badRequest().body(responseError);
            }
            ToDo todo = toDoService.TodoDTOtoTodo(dto);
            log.info("Salvando ToDo: {}", todo);
            toDoService.save(todo);
            return ResponseEntity.ok(todo);
        }catch(Exception e){
            responseError.getError().add(e.toString());
            return ResponseEntity.badRequest().body(responseError);
        }
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") Long id){
        ResponseError responseError = new ResponseError();
        try {
            log.info("Deletando ToDo id: {}", id);
            toDoService.deleteById(id);
            return ResponseEntity.ok("ToDO "+id+" deletado com sucesso!");
        }catch(Exception e){
            responseError.getError().add(e.toString());
            return ResponseEntity.badRequest().body(responseError);
        }
    }

    @GetMapping(value = "/todo/{id}")
    public ResponseEntity<?> findTodoById(@PathVariable("id") Long id){
        ResponseError responseError = new ResponseError();
        try {
            return ResponseEntity.ok(toDoService.findById(id));
        }catch(Exception e){
            responseError.getError().add(e.toString());
            return ResponseEntity.badRequest().body(responseError);
        }
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll(){
        ResponseError responseError = new ResponseError();
        try {
            //log.info("Retornando todos os ToDo");
            return ResponseEntity.ok(toDoService.findAll());
        }catch(Exception e){
            responseError.getError().add(e.toString());
            return ResponseEntity.badRequest().body(responseError);
        }
    }

    @GetMapping(value = "/concluido/{isConcluido}")
    public ResponseEntity<?> findConcluidos(@PathVariable("isConcluido") boolean isConcluido){
        ResponseError responseError = new ResponseError();
        try {
            //log.info("Retornando todos os ToDo");
            return ResponseEntity.ok(toDoService.findByConcluido(isConcluido));
        }catch(Exception e){
            responseError.getError().add(e.toString());
            return ResponseEntity.badRequest().body(responseError);
        }
    }

}
