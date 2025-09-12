const opcoes = [
  { nome: "Pedra", icon: "✊" },
  { nome: "Papel", icon: "✋" },
  { nome: "Tesoura", icon: "✌️" },
];

function jogar() {
  const j1 = opcoes[Math.floor(Math.random() * 3)];
  const j2 = opcoes[Math.floor(Math.random() * 3)];
  let vencedor = "Empate";
  if (j1.nome !== j2.nome) {
    if (
      (j1.nome === "Pedra" && j2.nome === "Tesoura") ||
      (j1.nome === "Papel" && j2.nome === "Pedra") ||
      (j1.nome === "Tesoura" && j2.nome === "Papel")
    ) {
      vencedor = "JOGADOR 1";
    } else {
      vencedor = "JOGADOR 2";
    }
  }
  document.getElementById("j1").textContent = j1.icon + " " + j1.nome;
  document.getElementById("j2").textContent = j2.icon + " " + j2.nome;
  document.getElementById("vencedor").innerHTML =
    "<strong>Vencedor:</strong> " + vencedor;
}

window.addEventListener("load", jogar);
