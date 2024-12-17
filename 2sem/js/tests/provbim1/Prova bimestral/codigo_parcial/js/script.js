var login = document.getElementById("user")
var senha = document.getElementById("pwe")

var emojis = ['emoji1.jpg','emoji2.jpg','emoji3.jpg','emoji4.jpg','emoji5.jpg',];

function validarForm() {
    if (login.value == "" || senha.value == "") {
         alert("Informe usuario e senha");
    } else if (login.value == "VISITANTE") {
        window.location.href = './visitante.html';
    }
    else {
        window.location.href = './construcao.html';
    }
}

function limpar() {
    login.value = "";
    senha.value = "";
}

function randomEmoji() {
    return randomElement = emojis[Math.floor(Math.random() * emojis.length)]
}

var btn = document.getElementsByTagName("input");
var img = document.getElementsByTagName("img");

btn.addEventListener("mouseout", function() {
     img.src = './img/' + randomEmoji();
});