package br.com.toyoudoapi.toyoudoapi.models.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ToDoDTO implements Serializable {

    private Long id;

    @NotEmpty(message = "Informe um valor para a descrição!")
    private String descricao;

    private Boolean concluido;
}
