package com.ecommerce.clothes.app.constants;


public class OrderStatusConstant {
    //el usuario ha iniciado un proceso de formar pedido
    public static final String IN_PROCESS = "en proceso";

    //el usuario ha finalizado un pedido y un administrador podrá gestionarlo
    public static final String FINISHED = "terminado";

    //un administrador ha preparado "físicamente" el envío para ser recogido
    //por la empresa de mensajería
    public static final String READY_TO_SEND = "listo para enviar";

    //la empresa de mensajería ha confirmado la recepción del pedido
    public static final String RECEIVED_BY_THE_CUSTOMER = "recibido por el cliente";
    public static final String PARAMETER_OPERATION = "operation";
    public static final String PARAMETER_GENEROS = "generos";
    public static final String PARAMETER_ROLES = "roles";
    public static final String PARAMETER_PELICULA = "pelicula";
    public static final String PARAMETER_USUARIO = "usuario";
    public static final String PARAMETER_PELICULAS= "peliculas";
    public static final String PARAMETER_USUARIOS= "usuarios";
    public static final String PARAMETER_PAGE= "page";
    public static final String PARAMETER_THEME_DANGER= "danger";
    public static final String PARAMETER_THEME= "theme";
    public static final String PARAMETER_MESSAGE= "message";
    public static final String ROLE_ADMIN= "ROLE_ADMIN";
    public static final String PATH_PELICULA_VIEW_REGISTER = "/peliculas/register";
    public static final String PATH_USUARIO_VIEW_REGISTER = "/usuarios/register";
    public static final String PATH_REDIRECT_PELICULA_VIEW_LISTAR = "redirect:/peliculas/listar";
    public static final String PATH_REDIRECT_USUARIO_VIEW_LISTAR = "redirect:/usuarios/listar";
}