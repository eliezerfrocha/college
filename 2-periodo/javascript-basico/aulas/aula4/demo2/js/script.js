var arr = [];
for (let i = 0; i < 60; i++) {
    arr[i-1] = i;
}

// console.log(vet);

// Gera um numero aleatório entre 0 e 59 (ultimo indice do vetor)
// index = Math.floor(Math.random() * 60);
// luckynumber = arr[index];
// console.log("Numero sorteado: " + luckynumber);
// // mostrar o vetor atualizado
// var removedElement = arr.splice(index, 1);
// console.log("Vetor atualizado: " + arr);
// // mostrar o elemento que foi removido
// console.log("Elemento removido: " + removedElement);

for (let i=0; i<6; i++) {
    index = Math.floor(Math.random() * arr.length);
    luckynumber = arr[index];
    
    // console.log("Numero sorteado: " + luckynumber);
    console.log(luckynumber);
    document.write(luckynumber + "<br>");
    var removedNumber = arr.splice(index, 1);

    // console.log(arr);
}