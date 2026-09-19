function parseNumero(s) {
  return parseFloat(String(s).replace(",", "."));
}
document.getElementById("btn").addEventListener("click", () => {
  const n = parseNumero(document.getElementById("valor").value);
  if (isNaN(n)) {
    alert("Digite um número válido.");
    return;
  }
  document.getElementById("dobro").value = (n * 2).toString().replace(".", ",");
});
