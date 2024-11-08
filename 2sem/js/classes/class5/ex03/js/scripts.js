let num = prompt("Digite um número:");

// -> estrutura de selecao multipla

//switch () 
//case
//break
//default

// -> estrutura de selecao composta

//if (num % 2 == 0) alert(`${num} é par!`)
//else alert(`${num} é ímpar!`)

// -> estrutura de selecao encadeamento

//if()
//else
//else if ()

// -> estrutura de selecao operador ternario

// (num % 2 == 0) ? alert(`${num} é par!`) : alert(`${num} é ímpar!`);

(num % 2 == 0) ? 
    alert(`O dobro de ${num} é ${numDobro(num)} e é par!`) : 
    alert(`O tripo de ${num} é ${numTriplo(num)} e é ímpar!`);

function numDobro(num) {
    num = (num * 2);
    return num;
}

function numTriplo(num) {
    num = (num * 3);
    return num;
}