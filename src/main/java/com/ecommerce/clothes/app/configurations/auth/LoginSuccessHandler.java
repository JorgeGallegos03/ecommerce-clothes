package com.ecommerce.clothes.app.configurations.auth;

import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;



@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    public LoginSuccessHandler(final MessageSource messageSource,
                               final LocaleResolver localeResolver) {
        this.messageSource = messageSource;
        this.localeResolver = localeResolver;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SessionFlashMapManager flashMapManager = new SessionFlashMapManager();
        FlashMap flashMap = new FlashMap();
        Locale locale = localeResolver.resolveLocale(request);
        String mensaje = String.format(messageSource.getMessage("text.login.success", null, locale), authentication.getName());
        flashMap.put("success", mensaje);
        flashMapManager.saveOutputFlashMap(flashMap, request, response);

        if (authentication != null) {
            logger.info("El usuario '" + authentication.getName() + "' ha iniciado sesión con éxito");
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}


