function parseNumero(s) {
  return parseFloat(String(s).replace(",", "."));
}
document.getElementById("btn").addEventListener("click", () => {
  const n1 = parseNumero(document.getElementById("b1").value);
  const n2 = parseNumero(document.getElementById("b2").value);
  if ([n1, n2].some(isNaN)) {
    alert("Preencha as duas notas corretamente.");
    return;
  }
  const soma = n1 + n2; // cada bimestre vale 50 -> total 100
  if (soma >= 60) {
    alert(`APROVADO! Nota final: ${soma.toFixed(1).replace(".", ",")}`);
  } else {
    const falta = 60 - soma;
    alert(
      `REPROVADO. Faltaram ${falta.toFixed(1).replace(".", ",")} ponto(s).`
    );
  }
});
