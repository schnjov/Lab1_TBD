package cl.usach.tbd.grupo2.backend_tbd.controllers;

import cl.usach.tbd.grupo2.backend_tbd.config.security.model.AuthenticationReq;
import cl.usach.tbd.grupo2.backend_tbd.config.security.model.TokenInfo;
import cl.usach.tbd.grupo2.backend_tbd.config.security.services.JwtUtilService;
import cl.usach.tbd.grupo2.backend_tbd.config.security.services.UserDetailsServiceImpl;
import cl.usach.tbd.grupo2.backend_tbd.entities.UsuarioEntity;
import cl.usach.tbd.grupo2.backend_tbd.repositories.UsuarioRepository;
import cl.usach.tbd.grupo2.backend_tbd.repositories.implementations.UsuarioRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin("*")
@RestController()
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    UserDetailsServiceImpl usuarioDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtilService jwtUtilService;

    @Autowired
    private UsuarioRepositoryImpl usuarioRepository;

    @PostMapping("/api/login")
    public ResponseEntity<TokenInfo> getToken(@RequestBody AuthenticationReq authenticationReq){
        logger.info(authenticationReq.getEmail());
        logger.info(authenticationReq.getClave());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationReq.getEmail(),
                        authenticationReq.getClave()));
        final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(
                authenticationReq.getEmail());

        final String jwt = jwtUtilService.generateToken(userDetails);

        return ResponseEntity.ok(new TokenInfo(jwt));
    }

    @PostMapping("api/register")
    public ResponseEntity<TokenInfo> createUser(@RequestBody UsuarioEntity usuario){
        try{
            usuarioRepository.create(usuario);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuario.getEmail(),
                            usuario.getPassword()));
            final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(
                    usuario.getEmail());

            final String jwt = jwtUtilService.generateToken(userDetails);

            return ResponseEntity.ok(new TokenInfo(jwt));
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().build();
        }
    }


}
