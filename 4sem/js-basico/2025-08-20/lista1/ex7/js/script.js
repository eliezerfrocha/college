var r = prompt("Digite o valor de R (0 a 255):");
var g = prompt("Digite o valor de G (0 a 255):");
var b = prompt("Digite o valor de B (0 a 255):");

r = parseInt(r);
g = parseInt(g);
b = parseInt(b);

var cor = "rgb(" + r + "," + g + "," + b + ")";
document.write(
    "<p style='color:" + cor + "; font-size:24px; text-align:center;'>Fundamentos de Web Design II</p>"
);