// Cria um objeto de data com a data atual
const dataAtual = new Date();

var diaSemana = ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb'];
const dia = dataAtual.getDate();
const mes = dataAtual.getMonth() + 1;
const ano = dataAtual.getFullYear();

var p = document.getElementById("resp");
p.innerText = `Hoje é ${diaSemana[dataAtual.getDay()]} - ${dia}/${mes}/${ano}`