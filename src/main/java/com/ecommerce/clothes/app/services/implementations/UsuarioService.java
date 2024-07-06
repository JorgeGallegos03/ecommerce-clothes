package com.ecommerce.clothes.app.services.implementations;

import com.ecommerce.clothes.app.repositories.IUsuarioRepository;
import com.ecommerce.clothes.app.repositories.entities.Role;
import com.ecommerce.clothes.app.repositories.entities.Usuario;
import com.ecommerce.clothes.app.services.contracts.IUsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UsuarioService extends BaseService implements IUsuarioService {
    private final Logger log = LoggerFactory.getLogger(UsuarioService.class.getName());
    private final IUsuarioRepository repository;


    public UsuarioService(IUsuarioRepository repository) {
        super(UsuarioService.class.getName());
        this.repository = repository;
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public List<Usuario> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Usuario findOne(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public void save(Usuario usuario) {
        this.repository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.repository.findByUsername(username);

        if (usuario == null) {
            log.error("Error en el Login: no existe el usuario '" + username + "' en el sistema!");
            throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Role role : usuario.getRoles()) {
            log.info("Role: ".concat(role.getAuthority()));
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        if (authorities.isEmpty()) {
            log.error("Error en el Login: Usuario '" + username + "' no tiene roles asignados!");
            throw new UsernameNotFoundException("Error en el Login: usuario '" + username + "' no tiene roles asignados!");
        }

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
    }
}


