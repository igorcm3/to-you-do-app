package br.com.toyoudoapi.toyoudoapi.configs.security.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by igorcm3 on 05/08/2022 - 21:57
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError implements Serializable {
    private List<String> error = new ArrayList<>();
}
