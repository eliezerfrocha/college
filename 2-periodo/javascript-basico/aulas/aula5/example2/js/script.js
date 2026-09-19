input = document.getElementById("txtValor");
btn = document.getElementById("btnDobrar");

btn.addEventListener("click", dobrar);

function dobrar() {
  txt = input.value;
  if (txt.trim() == "" || isNaN(txt)) {
    alert("Por favor, informe apenas números!");
    return;
  } else {
    alert(`DOBRO: ${txt * 2}`);
  }
}

// btn = document.getElementById("btnTestar");
// btn.addEventListener("click", valor);

// function valor() {
//     let val1 = document.getElementById("val1").value;
//     let val2 = document.getElementById("val2").value;

//     let soma = parseInt(val1) + parseInt(val2);
//     let dobro = soma * 2;

//     alert(`A soma de ${val1} + ${val2} = ${soma} e seu dobro é: ${dobro}`);
// }
