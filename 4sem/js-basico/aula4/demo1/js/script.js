var vet = [];
for (let i = 0; i < 20; i++) {
    vet[i] = 10 * (i + 1);
}

console.log(vet);
var index = prompt("Voce deseja remover qual indice? (0 a 19)");

// mostrar o indice
console.log("Indice escolhido: " + index);
// mostrar o vetor atualizado
var removedElement = vet.splice(index, 1);
console.log("Vetor atualizado: " + vet);
// mostrar o elemento que foi removido
console.log("Elemento removido: " + removedElement);
