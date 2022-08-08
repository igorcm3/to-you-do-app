package br.com.toyoudoapi.toyoudoapi.configs.security.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by igorcm3 on 05/08/2022 - 21:48
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto implements Serializable {
    private String token;
}
