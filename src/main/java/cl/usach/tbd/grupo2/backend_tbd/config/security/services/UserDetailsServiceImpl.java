package cl.usach.tbd.grupo2.backend_tbd.config.security.services;

import cl.usach.tbd.grupo2.backend_tbd.entities.UsuarioEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.implementations.UsuarioRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioRepositoryImpl usuarioRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UsuarioEntity usuario = usuarioRepository.getByEmail(email);
        String encodedPass = passwordEncoder.encode(usuario.getPassword());

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
