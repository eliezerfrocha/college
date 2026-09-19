const v1 = document.getElementById("v1");
const v2 = document.getElementById("v2");
const res = document.getElementById("res");

function parseNumero(s) {
  return parseFloat(String(s).replace(",", "."));
}

function calcular(op) {
  const a = parseNumero(v1.value);
  const b = parseNumero(v2.value);
  if (isNaN(a) || isNaN(b)) {
    alert("Preencha os dois números antes de calcular.");
    return;
  }
  if (op === "/" && b === 0) {
    alert("Divisão por zero não é permitida.");
    return;
  }
  const r =
    op === "+" ? a + b : op === "-" ? a - b : op === "*" ? a * b : a / b;
  res.value = String(r).replace(".", ",");
}

document.querySelectorAll("button[data-op]").forEach((btn) => {
  btn.addEventListener("click", () => calcular(btn.dataset.op));
});
