arr = [10, 20, 30, 40, 50];

// imprimir o vetor para cada uma das estruturas abaixo
// for
console.log("[ for ]");
for (let i = 0; i < arr.length; i++) {
    console.log(arr[i]);
}

// while
let i = 0;
console.log("[ while ]");
while (i < arr.length) {
    console.log(arr[i]);
    i++;
}

// for..in
console.log("[ for..in ]");
for (let index in arr) {
    console.log(arr[index]);
}