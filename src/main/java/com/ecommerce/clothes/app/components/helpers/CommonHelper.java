package com.ecommerce.clothes.app.components.helpers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.Objects;


//@UtilityClass
public class CommonHelper {
    private static final Long ID_ZERO_VALUE = 0L;

    public static boolean isValidateId(final Long id) {
        if (Objects.isNull(id) || ID_ZERO_VALUE.equals(id)) {
            return false;
        }

        return id > ID_ZERO_VALUE;
    }


    public static boolean validateRoles(String role) {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return false;
        }
        Authentication auth = context.getAuthentication();
        if (auth == null) {
            return false;
        }
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        return authorities.contains(new SimpleGrantedAuthority(role));
    }

}