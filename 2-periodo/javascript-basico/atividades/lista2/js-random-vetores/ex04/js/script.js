let N = parseInt(prompt("Informe N (inteiro):"), 10);
let M = parseInt(prompt("Informe M (inteiro):"), 10);

document.write(`<h2>Ex04 – Aleatório entre ${N} e ${M}</h2>`);

if (!Number.isFinite(N) || !Number.isFinite(M)) {
  document.write("<p>Valores inválidos.</p>");
} else {
  // garante N <= M
  if (N > M) [N, M] = [M, N];
  const n = Math.floor(Math.random() * (M - N + 1)) + N;
  document.write("<h1>" + n + "</h1>");
}
