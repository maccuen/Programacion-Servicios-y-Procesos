package com.gregoriofer.procesos.ejemplo.controller;

import com.gregoriofer.procesos.ejemplo.dto.Mensaje;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChatController {

    @MessageMapping("/saludar")
    @SendTo("/topic/saludos")
    public Mensaje saludar(final Mensaje mensaje) throws Exception {
        Thread.sleep(1000);
        final Mensaje mensaje1 = new Mensaje();
        mensaje1.setMensaje("Hola " + HtmlUtils.htmlEscape(mensaje.getMensaje()) + "!");
        return mensaje1;
    }
}