function exibirMsg(msg) {
  alert(msg);
}

var btn = document.getElementById("btn1");

btn.addEventListener("click", function () {
  exibirMsg("clicou");
});

btn.addEventListener("mouseout", function () {
  exibirMsg("tchau");
});
