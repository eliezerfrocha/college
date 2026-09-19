const N = parseInt(prompt("Informe N (inteiro > 0):"), 10);

if (Number.isFinite(N) && N > 0) {
  document.write(`<h2>Ex03 – Aleatório entre 1 e ${N}</h2>`);
  const n = Math.floor(Math.random() * N) + 1;
  document.write("<h1>" + n + "</h1>");
} else {
  document.write("<p>Valor inválido.</p>");
}
