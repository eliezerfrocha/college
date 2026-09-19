const   min = 10,
        max = 50;

const n = Math.floor(Math.random() * (max - min + 1)) + min;

document.write("<h1>" + n + "</h1>");
console.log("Sorteado:", n);
