var nome = document.getElementById("txtnome");
var sobrenome = document.getElementById("txtsobrenome");
var nomeCompleto = document.getElementById("txtnomeSobrenome");

document.getElementById("btnExibir").addEventListener("click", function () {
    nomeCompleto.value = `${nome.value} ${sobrenome.value}`;
});
