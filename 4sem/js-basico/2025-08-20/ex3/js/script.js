var fullName = prompt("Olá, qual o seu nome?");
var age = prompt("Quantos anos você tem?");

var permission = "POSSUI";
if (age < 18) {
    permission = "NÃO POSSUI";
    alert(`${fullName.toUpperCase()}, você ainda ${permission} idade para tirar carteira, ainda falta(m) ${18 - age} anos`);
} else { 
    alert(`Olá, ${fullName}, você já ${permission} idade para tirar carteira!`);
}

document.write(`<h1>Olá, ${fullName.toUpperCase()}!</h1>`);
// FULANO, você já POSSUI idade para tirar carteira ou FULANO, você ainda NÃO POSSUI idade para tirar carteira, ainda falta(m) X anos