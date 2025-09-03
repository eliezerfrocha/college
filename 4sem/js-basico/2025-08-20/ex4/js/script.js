alert("Bem-vindo ao controle de nota!");

var firstSemester = prompt("Insira a nota do primeiro bimestre:");
var secondSemester = prompt("Insira a nota do segundo bimestre:");

var total = (parseFloat(firstSemester) + parseFloat(secondSemester));
if (total >= 60) {
    alert(`Parabéns! Sua nota total foi ${total}. Você foi aprovado!`);
    document.write("Parabéns! Você foi aprovado!");
} else {
    var missingPoints = 60 - total;
    alert(`Sua nota total foi ${total}. Infelizmente você não foi aprovado, você precisa de mais ${missingPoints} pontos para ser aprovado.`);
    document.write("Infelizmente você foi reprovado.");
}