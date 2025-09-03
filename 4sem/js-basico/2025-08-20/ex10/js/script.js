var x = prompt("Digite um valor inteiro positivo maior que zero:");
x = parseInt(x);

var nome = prompt("Digite seu nome completo:");
for (var i = 0; i < x; i++) {
    document.write(nome + "<br>")
}