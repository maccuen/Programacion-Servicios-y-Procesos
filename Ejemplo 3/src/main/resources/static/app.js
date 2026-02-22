var clienteStomp = null;

function fijarComoConectado(conectado) {
    $("#conectar").prop("disabled", conectado);
    $("#desconectar").prop("disabled", !conectado);
    if (conectado) {
        $("#conversacion").show();
    } else {
        $("#conversacion").hide();
    }
    $("#saludos").html("");
}

function conectar() {
    var socket = new SockJS('/chat-websocket');
    clienteStomp = Stomp.over(socket);
    clienteStomp.connect({}, function (frame) {
        fijarComoConectado(true);
        console.log('Conectado: ' + frame);
        clienteStomp.subscribe('/topic/saludos', function (saludo) {
            mostrarSaludo(JSON.parse(saludo.body).mensaje);
        });
    });
}

function desconectar() {
    if (clienteStomp !== null) {
        clienteStomp.disconnect();
    }
    fijarComoConectado(false);
    console.log("Desconectado con éxito!");
}

function enviarNombre() {
    clienteStomp.send("/chat/saludar", {}, JSON.stringify({'mensaje': $("#nombre").val()}));
}

function mostrarSaludo(saludo) {
    $("#saludos").append("<tr><td>" + saludo + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#conectar" ).click(function() { conectar(); });
    $( "#desconectar" ).click(function() { desconectar(); });
    $( "#enviar" ).click(function() { enviarNombre(); });
});

