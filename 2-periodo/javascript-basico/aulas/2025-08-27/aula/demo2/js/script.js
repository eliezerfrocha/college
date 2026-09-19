var name = prompt("Digite o seu nome completo:", "Wilton de Paula Filho");

option = prompt ("[MENU]" +
"\n[1] Letras Maiúsculas" +
"\n[2] Letras Minúsculas" +
"\n[3] Primeira letra do primeiro nome maiúscula "+
"\n[4] Primeiro nome "+
"\n[5] Primeiro nome maiúsculo e último nome minúsculo"+
"\n[6] Substitua o primeiro nome por um novo nome "+
"\n[7] Primeira letra do primeiro e ultimo nome maiusculas concatenadas"+
"\n[8] Exiba as 3 primeiras letras do nome"+
"\n[9] Exiba o nome ao contrário" +
"\n[10] Subistitua todas as vogais por '*' ");

//Exemplos esperados:
//nome = "Wilton de Paula Filho"
// [1] "WILTON DE PAULA FILHO"
// [2] "wilton de paula filho"
// [3] "W"
// [4] "Wilton"
// [5] "WILTON filho"
// [6] Qual o novo nome? "Joao" -> "Joao de Paula Filho"
// [7] "WF"
// [8] "Wil"
// [9] "ohlif aluaP ed notliW"
// [10] "W*lt*n d* P**l* F*lh*

switch (option) {
    case "1":
        document.write(`<p>${name.toUpperCase()}</p>`);
        break;
    case "2":
        document.write(`<p>${name.toLowerCase()}</p>`);
        break;
    case "3":
        document.write(`<p>${name.charAt(0).toUpperCase()}</p>`);
        break;
    case "4":
        document.write(`<p>${name.split('')[0]}</p>`);
        break;
    case "5":
        arrName = name.split(" ");
        document.write(`<p>${arrName[0].toUpperCase()} ${arrName[arrName.length - 1].toLowerCase()}</p>`);
        break;
    case "6":
        var newName = prompt("Qual o novo nome?");
        arrName = name.split(" ");
        arrName[0] = newName;
        document.write(`<p>${arrName.join(' ')}</p>`);
        break;
    case "7":
        // tentar com vetores
        var firstLetter = name.charAt(0).toUpperCase();
        var lastLetter = name.charAt(name.lastIndexOf(" ") + 1).toUpperCase();
        document.write(`<p>${firstLetter}${lastLetter}</p>`);
        break;
    case "8":
        document.write(`<p>${name.substring(0, 3)}</p>`);
        break;
    case "9":
        var invertedName = name.split("").reverse().join("");
        document.write(`<p>${invertedName}</p>`);
        break;
    case "10":
        var nameWithAsterisks = name.replace(/[aeiouAEIOU]/g, "*");
        document.write(`<p>${nameWithAsterisks}</p>`);
        break;
    default:
        document.write("<p>Opção inválida!</p>");
        break;
        
}