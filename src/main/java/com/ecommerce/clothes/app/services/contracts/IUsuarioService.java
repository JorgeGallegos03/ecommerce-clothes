package com.ecommerce.clothes.app.services.contracts;

import com.ecommerce.clothes.app.components.interfaces.ICrud;
import com.ecommerce.clothes.app.repositories.entities.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUsuarioService extends ICrud<Usuario, Long>, UserDetailsService {


}
