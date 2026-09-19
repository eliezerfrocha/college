txt_valor1 = document.getElementById("txtValor");
txt_dobro = document.getElementById("txtDobro");
btn = document.getElementById("btnDobrar");

btn.addEventListener("click", dobrar);

function dobrar(event) {
  event.preventDefault();
  txt_dobro.value = txt_valor1.value * 2;
}