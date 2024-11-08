var boy = document.getElementById("boy");
var txt = document.getElementById("txt");

var personagem = [
    {src: , txt: }
]

//TODO - refatorar o código para que ele seja mais fácil de entender e manter

boy.addEventListener("mouseenter", function () {
  boy.src = "img/assustado.png";
  txt.innerHTML = "O que você quer?";
});

boy.addEventListener("mouseout", function () {
  boy.src = "img/pensativo.png";
  txt.innerHTML = "zzzzzzzz!";
});

boy.addEventListener("click", function () {
  var nome = prompt("Qual é o seu nome?");

  if (!nome) {
    txt.innerHTML = "Ei, não me faça perder meu tempo!";
    boy.src = "img/nervoso.png";
  } else {
    txt.innerHTML = `${nome}, seja bem-vindo!`;
    boy.src = "img/alegre.png";
  }
});
