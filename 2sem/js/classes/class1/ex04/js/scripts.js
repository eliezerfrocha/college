let nome = prompt("Qual seu nome?", "Eliezer");
let total = prompt("Quantas vezes deseja visualizar seu nome?", "5");
let cor = prompt("De qual cor você quer ver seu nome? (Escreva em inglês)", "red");

total = Number(total);

if (!isNaN(total) && total > 0) {
  console.log(cor);

  for (i=0; i<total; i++) {
    if (i > 0) {
      document.write(`<p style="color:${cor}">${i} - ${nome}</p>`);
    }
  }
} else {
  console.log("Por favor, insira um número válido para o total.");
}