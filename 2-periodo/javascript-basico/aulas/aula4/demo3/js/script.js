// pedra, papel, tesoura
var player_1 = ["pedra", "papel", "tesoura"];
var player_2 = ["pedra", "papel", "tesoura"];

// rodada unica e pontuacao
// document.write("<b>Rodada única:</b><br>");
// for (let i = 0; i < 1; i++) {
//     var choice_1 = Math.floor(Math.random() * 3);
//     var choice_2 = Math.floor(Math.random() * 3);

//     if (choice_1 == choice_2) {
//         console.log(player_1[choice_1] + " x " + player_2[choice_2] + " = Empate");
//         document.write(player_1[choice_1] + " x " + player_2[choice_2] + " = Empate<br>");
//     } else if ((choice_1 == 0 && choice_2 == 2) || (choice_1 == 1 && choice_2 == 0) || (choice_1 == 2 && choice_2 == 1)) {
//         console.log(player_1[choice_1] + " x " + player_2[choice_2] + " = Player 1 vence");
//         document.write(player_1[choice_1] + " x " + player_2[choice_2] + " = Player 1 vence<br>");
//     } else {
//         console.log(player_1[choice_1] + " x " + player_2[choice_2] + " = Player 2 vence");
//         document.write(player_1[choice_1] + " x " + player_2[choice_2] + " = Player 2 vence<br>");
//     }
// }
// document.write("<br>");

// // rodadas aleatórias e pontuação
// document.write("<b>Rodadas aleatórias:</b><br>");
// for (let i = 0; i < 10; i++) {
//     var choice_1 = Math.floor(Math.random() * 3);
//     var choice_2 = Math.floor(Math.random() * 3);

//     if (choice_1 == choice_2) {
//         console.log(player_1[choice_1] + " x " + player_2[choice_2] + " = Empate");
//         document.write(player_1[choice_1] + " x " + player_2[choice_2] + " = Empate<br>");
//     }   else if ((choice_1 == 0 && choice_2 == 2) || (choice_1 == 1 && choice_2 == 0) || (choice_1 == 2 && choice_2 == 1)) {
//         console.log(player_1[choice_1] + " x " + player_2[choice_2] + " = Player 1 vence");
//         document.write(player_1[choice_1] + " x " + player_2[choice_2] + " = Player 1 vence<br>");
//     } else {
//         console.log(player_1[choice_1] + " x " + player_2[choice_2] + " = Player 2 vence");
//         document.write(player_1[choice_1] + " x " + player_2[choice_2] + " = Player 2 vence<br>");
//     }
// }

// document.write("<br>");

// // pontuacao dos players
// var score_1 = 0;
// var score_2 = 0;

// for (let i = 0; i < 10; i++) {
//     var choice_1 = Math.floor(Math.random() * 3);
//     var choice_2 = Math.floor(Math.random() * 3);
//     if (choice_1 == choice_2) {
//         // empate
//         score_1 += 1;
//         score_2 += 1;
//     } else if ((choice_1 == 0 && choice_2 == 2) || (choice_1 == 1 && choice_2 == 0) || (choice_1 == 2 && choice_2 == 1)) {
//         // player 1 vence
//         score_1 += 2;
//     } else {
//         // player 2 vence
//         score_2 += 2;
//     }
// }

// console.log("Pontuação final - Player 1: " + score_1 + " | Player 2: " + score_2);
// document.write("<br><b>Pontuação final:</b> <br> Player 1: " + score_1 + " | Player 2: " + score_2 + "<br>");


// detalha e atualiza a pontuacao sozinho
var score_1 = 0;
var score_2 = 0;

document.write("<b>Detalhamento da pontuação:</b><br>");
for (let i = 0; i < 10; i++) {
    var choice_1 = Math.floor(Math.random() * 3);
    var choice_2 = Math.floor(Math.random() * 3);

    if (choice_1 == choice_2) {
        // empate
        score_1 += 1;
        score_2 += 1;
        console.log(player_1[choice_1] + " x " + player_2[choice_2] + " = <b>Empate</b>");
        document.write(player_1[choice_1] + " x " + player_2[choice_2] + " = <b>Empate</b><br>");
    } else if ((choice_1 == 0 && choice_2 == 2) || (choice_1 == 1 && choice_2 == 0) || (choice_1 == 2 && choice_2 == 1)) {
        // player 1 vence
        score_1 += 2;
        console.log(player_1[choice_1] + " x " + player_2[choice_2] + " = Player 1 vence");
        document.write(player_1[choice_1] + " x " + player_2[choice_2] + " = Player 1 vence<br>");
    } else {
        // player 2 vence
        score_2 += 2;
        console.log(player_1[choice_1] + " x " + player_2[choice_2] + " = Player 2 vence");
        document.write(player_1[choice_1] + " x " + player_2[choice_2] + " = Player 2 vence<br>");
    }

    console.log("<b>Pontuação atual:</b> <br> Player 1: " + score_1 + " | Player 2: " + score_2);
    document.write("<b>Pontuação atual:</b> <br> Player 1: " + score_1 + " | Player 2: " + score_2 + "<br><br>");
}

// somatorio final
console.log("-------------------------------");
console.log("Pontuação final - Player 1: " + score_1 + " | Player 2: " + score_2);
document.write("<br><b>Pontuação final:</b> <br> Player 1: " + score_1 + " | Player 2: " + score_2 + "<br>");