package br.com.toyoudoapi.configs.security.controllers;

import br.com.toyoudoapi.configs.security.dto.JwtAuthenticationDto;
import br.com.toyoudoapi.configs.security.dto.ResponseError;
import br.com.toyoudoapi.configs.security.dto.TokenDto;
import br.com.toyoudoapi.configs.security.utils.JwtTokenUtil;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by igorcm3 on 05/08/2022 - 21:46
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthenticationController {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    private final UserDetailsService userDetailsService;

    /**
     * Gera e retorna um novo token JWT.
     *
     * @param authenticationDto
     * @param result
     * @return ResponseEntity<Response<TokenDto>>
     * @throws AuthenticationException
     */
    @PostMapping
    public ResponseEntity<?> gerarTokenJwt(
            @Valid @RequestBody JwtAuthenticationDto authenticationDto, BindingResult result)
            throws AuthenticationException {
        TokenDto response = new TokenDto();

        if (result.hasErrors()) {
            log.info("Erro ao gerar token Jwt: {}", result.getAllErrors());
            ResponseError responseError = new ResponseError();
            result.getAllErrors().forEach(error -> responseError.getError().add(error.toString()));
            return ResponseEntity.badRequest().body(responseError);
        }
        log.info("Gerando token para o email {}.", authenticationDto.getEmail());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationDto.getEmail(), authenticationDto.getSenha()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDto.getEmail());
        String token = jwtTokenUtil.obterToken(userDetails);
        return ResponseEntity.ok(new TokenDto(token));
    }

    /**
     * Gera um novo token com uma nova data de expiração.
     *
     * @param request
     * @return ResponseEntity<Response<TokenDto>>
     */
    @PostMapping(value = "/refresh")
    public ResponseEntity<?> gerarRefreshTokenJwt(HttpServletRequest request) {
        log.info("Gerando refresh token JWT.");
        Optional<String> token = Optional.ofNullable(request.getHeader(JwtTokenUtil.TOKEN_HEADER));

        if (token.isPresent() && token.get().startsWith(JwtTokenUtil.BEARER_PREFIX)) {
            token = Optional.of(token.get().substring(7));
        }
        ResponseError responseError = new ResponseError();

        if (token.isEmpty()) {
            responseError.getError().add("Token não informado.");
        } else if (!jwtTokenUtil.tokenValido(token.get())) {
            responseError.getError().add("Token inválido ou expirado.");
        }

        if (!responseError.getError().isEmpty()) {
            return ResponseEntity.badRequest().body(responseError);
        }
        String refreshedToken = jwtTokenUtil.refreshToken(token.get());
        return ResponseEntity.ok(new TokenDto(refreshedToken));
    }
}
