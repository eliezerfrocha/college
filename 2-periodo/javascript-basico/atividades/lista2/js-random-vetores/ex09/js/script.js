function sortearOrdem() {
  const arr = document.getElementById("nomes").value.trim();

  if (!arr) return alert("Informe pelo menos um nome por linha.");

  const nomes = arr
    .split(/\n+/)
    .map((s) => s.trim())
    .filter(Boolean);

  for (let i = nomes.length - 1; i > 0; i--) {
    // embaralhar (Fisher-Yates)
    const j = Math.floor(Math.random() * (i + 1));
    [nomes[i], nomes[j]] = [nomes[j], nomes[i]];
  }

  document.getElementById("saida").innerHTML = nomes
    .map((n, i) => `<div>${i + 1}. <strong>${n}</strong></div>`)
    .join("");
}
