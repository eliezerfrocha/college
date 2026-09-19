function megaSena(numero) {
    const numerosSorteados = [5, 12, 23, 34, 45, 56];
    return numerosSorteados.includes(numero) ? true : false;
}

function main() {
    const numero = parseInt(prompt("Digite um número entre 1 e 60:"));
    if (isNaN(numero) || numero < 1 || numero > 60) {
        alert("Número inválido. Por favor, digite um número entre 1 e 60.");
        return;
    }

    if (megaSena(numero)) {
        alert(`Parabéns! O número ${numero} foi sorteado! [true]`,);
    } else {
        alert(`Que pena! O número ${numero} não foi sorteado. [false]`,);
    }
}

main();
