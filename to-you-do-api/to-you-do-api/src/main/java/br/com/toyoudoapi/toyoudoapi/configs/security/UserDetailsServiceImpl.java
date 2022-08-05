package br.com.toyoudoapi.toyoudoapi.configs.security;

import br.com.toyoudoapi.toyoudoapi.models.User;
import br.com.toyoudoapi.toyoudoapi.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by igorcm3 on 04/08/2022 - 19:01
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    UserRepository userRepository;

    public UserDetailsServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
    }
}
