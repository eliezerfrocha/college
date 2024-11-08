// globais
var alphabetTiny = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
var alphabetCapital = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
var numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

//01 letra minuscula aleatoria
var randomizerTiny = parseInt(Math.random() * alphabetTiny.length);
console.log(alphabetTiny[randomizerTiny]);

//02 letra maiuscula aleatoria
var randomizerCapital = parseInt(Math.random() * alphabetCapital.length);
console.log(alphabetCapital[randomizerCapital]);

//03 numero aleatorio
var randomizerNumber = parseInt(Math.random() * numbers.length);
console.log(numbers[randomizerNumber]);

//04 squencia letra minuscula aleatoria
// gera 04 letras minusculas aleatórias
function randomTinyLetters(qty) {
  let letters = "";
  for (let i = 0; i < qty; i++) {
    let randomIndex = Math.floor(Math.random() * alphabetTiny.length);
    letters += alphabetTiny[randomIndex];
  }
  return letters;
}
console.log(randomTinyLetters(4));

//05 squencia letra maiuscula aleatoria
// gera 04 letras maiuscula aleatórias
function randomCapitalLetters(qty) {
  let letters = "";
  for (let i = 0; i < qty; i++) {
    let randomIndex = Math.floor(Math.random() * alphabetCapital.length);
    letters += alphabetCapital[randomIndex];
  }
  return letters;
}
console.log(randomCapitalLetters(4));

//06 sequencia numeros aleatorios
// gera 04 numeros aleatórios
function randomNumbers(qty) {
  let letters = "";
  for (let i = 0; i < qty; i++) {
    let randomIndex = Math.floor(Math.random() * numbers.length);
    letters += numbers[randomIndex];
  }
  return letters;
}
console.log(randomNumbers(4));

//07
// gera 04 letras minusculas aleatórios seguidos de 04 numeros aleatorios
function randomLettersAndNumbers(qty) {
  var letters = randomTinyLetters(qty);
  var numbers = randomNumbers(qty);
  return letters + numbers;
}
console.log(randomLettersAndNumbers(4));

//08 gera senha forte
function generatePassword(qty) {
    var keys = alphabetCapital.join("") + alphabetTiny.join("") + numbers.join("");
    var password = "";
    for (let i = 0; i < qty; i++) {
        let randomIndex = Math.floor(Math.random() * keys.length);
        password += keys[randomIndex];
      }
    
    return password
}
console.log(generatePassword(8));


mat = [
    alphabetTiny,
    alphabetCapital,
    numbers
]

console.table(mat)


