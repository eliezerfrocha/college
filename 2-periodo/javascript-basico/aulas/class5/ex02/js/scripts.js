var passageirosHomens = [];
var passageirosMulheres = [];
var sexo, nome;

const totalPassageiros = prompt("Quantos passageiros vão entrar?");
for (var i = 0; i < totalPassageiros; i++) {
  //Leitura sexo
  sexo = prompt(`Qual o sexo do passageiro ${i + 1} - (H ou M)?`);
  //Leitura nome de cada passageiros
  nome = prompt(`Qual o nome do passageiro ${i + 1}?`);

  if (sexo == "H") passageirosHomens.push(nome);
  else passageirosMulheres.push(nome);
}

// console.log(passageirosHomens);
// console.log(passageirosMulheres);

let nroInteracoes;
if (passageirosHomens.length > passageirosMulheres.length) 
    nroInteracoes = passageirosHomens.length;
else
    nroInteracoes = passageirosMulheres.length;

document.write(`<table border=1>`);
for (var i=0; i<nroInteracoes; i++) {
    if (passageirosHomens[i] != undefined) 

    document.write(`    <tr>`);
    document.write(`        <td>${passageirosHomens[i]}</td>`);
    document.write(`        <td>${passageirosMulheres[i]}</td>`);
    document.write(`    </tr>`);
}
document.write(`</table>`);


