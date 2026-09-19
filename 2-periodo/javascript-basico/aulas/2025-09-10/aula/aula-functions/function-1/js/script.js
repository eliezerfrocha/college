function main() {
    var num1 = prompt("Digite o primeiro número:");
    var operacao = prompt("Digite a operação [+, -, *, /]:");
    var num2 = prompt("Digite o segundo número:");
    
    calculadora(operacao, num1, num2); 
}

function calculadora(operacao, num1, num2) { 
    alert(`${num1} ${operacao} ${num2} = ${eval(num1 + operacao + num2)}`);
 }

main();

