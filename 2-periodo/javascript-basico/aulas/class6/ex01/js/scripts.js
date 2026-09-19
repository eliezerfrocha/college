function somar(x, y) {
  return x + y;
}

function subtrair(x, y) {
  return x - y;
}

function multiplicar(x, y) {
  return x * y;
}

function dividir(x, y) {
  return x / y;
}

function calcular(opcao, valor1, valor2) {
  switch (opcao) {
    case "+":
      alert(somar(valor1, valor2));
      break;
    case "-":
      alert(subtrair(valor1, valor2));
      break;
    case "*":
      alert(multiplicar(valor1, valor2));
      break;
    case "/":
      alert(dividir(valor1, valor2));
      break;
    case "":
      alert("Escolha uma opção");
      break;
    default:
      alert("Opção inválida");
      location.reload();
  }
}

function lerValor(msg) {
  return parseFloat(prompt(msg));
}

function main() {
  var valor1 = lerValor("Digite o primeiro valor: ");
  var valor2 = lerValor("Digite o segundo valor: ");

  var opcao = prompt(
    "MENU\n [+] Somar \n [-] Subtrair \n [*] Multiplicar \n [/] Dividir"
  );

  calcular(opcao, valor1, valor2);
}

document.addEventListener("DOMContentLoaded", function () {
  main();
});
