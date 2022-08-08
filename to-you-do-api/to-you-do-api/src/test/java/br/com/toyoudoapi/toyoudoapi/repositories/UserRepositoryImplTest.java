package br.com.toyoudoapi.toyoudoapi.repositories;

import br.com.toyoudoapi.toyoudoapi.models.Usuario;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class UserRepositoryImplTest {
    @Autowired
    private UsuarioRepository userRepository;

    @Test
    public void deveRetornarUserAdmin(){
        Optional<Usuario> user = this.userRepository.findByUsername("admin@gmail.com");

        assertNotNull(user.get());
    }


}
