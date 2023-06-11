package cl.usach.tbd.grupo2.backend_tbd.controllers;

import cl.usach.tbd.grupo2.backend_tbd.config.security.model.AuthenticationReq;
import cl.usach.tbd.grupo2.backend_tbd.config.security.model.TokenInfo;
import cl.usach.tbd.grupo2.backend_tbd.config.security.services.JwtUtilService;
import cl.usach.tbd.grupo2.backend_tbd.config.security.services.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    UserDetailsServiceImpl usuarioDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtilService jwtUtilService;

    @GetMapping("/mensaje")
    public ResponseEntity<?> getMensaje() {
        logger.info("Obteniendo el mensaje");

        var auth =  SecurityContextHolder.getContext().getAuthentication();
        logger.info("Datos del Usuario: {}", auth.getPrincipal());
        logger.info("Datos de los Roles {}", auth.getAuthorities());
        logger.info("Esta autenticado {}", auth.isAuthenticated());

        Map<String, String> mensaje = new HashMap<>();
        mensaje.put("contenido", "Hola Peru");
        return ResponseEntity.ok(mensaje);
    }

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


}
