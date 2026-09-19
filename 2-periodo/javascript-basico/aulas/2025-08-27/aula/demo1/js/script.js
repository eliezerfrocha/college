alert("Seja bem-vindo!");
var nome = prompt("Qual o seu nome?");
var sobrenome = prompt("Qual o seu sobrenome?");
alert(`Olá, ${nome} ${sobrenome}!`);

document.write(`Total de caracteres no seu nome = ${(nome + sobrenome).length}`);