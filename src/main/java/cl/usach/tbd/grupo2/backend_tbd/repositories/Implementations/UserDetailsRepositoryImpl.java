package cl.usach.tbd.grupo2.backend_tbd.repositories.implementations;

import cl.usach.tbd.grupo2.backend_tbd.controllers.LoginController;
import cl.usach.tbd.grupo2.backend_tbd.entities.UsuarioEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailsRepositoryImpl implements UserDetailsService {
    @Autowired
    UsuarioRepositoryImpl usuarioRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsRepositoryImpl.class);

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UsuarioEntity usuario = usuarioRepository.getByEmail(email);
        String encodedPass = passwordEncoder.encode(usuario.getPassword());
        logger.info(usuario.toString());

        if (usuario == null) {
            throw new UsernameNotFoundException(email);
        }
        return User
                .withUsername(email)
                .password(encodedPass)
                .roles(usuario.getRol())
                .build();
    }
}
