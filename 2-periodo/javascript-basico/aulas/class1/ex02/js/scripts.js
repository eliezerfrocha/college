var res;

var idade = prompt("Qual a sua idade?");
var nome = prompt("Qual seu nome?");

console.log(idade, typeof(idade));  // Verifica o tipo de 'idade'
console.log(nome, typeof(nome));    // Verifica o tipo de 'nome'

const h1 = document.getElementById("h1");

// Verifica se o usuário não forneceu a idade
if (idade === null || idade === "") {
  res = "Idade não fornecida";
} else {
  // Converte idade para número
  idade = Number(idade);

  // Verifica se a conversão foi bem-sucedida (ou seja, se o usuário inseriu um número)
  if (!isNaN(idade)) {
    if (idade > 18) {
      res = `${nome}, bora tirar essa carteira 🪪.`;
    } else {
      res = `${nome}, você ainda não tem idade 🚫.`;
    }
  } else {
    res = "Idade inválida.";
  }
}

h1.innerText = res;