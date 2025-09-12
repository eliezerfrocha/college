const naipes = [
  { sim: "♠", cor: "black" },
  { sim: "♥", cor: "red" },
  { sim: "♦", cor: "red" },
  { sim: "♣", cor: "black" },
];

const valores = ["A","2","3","4","5","6","7","8","9","10","J","Q","K"];

function sortearCarta() {
  const n = naipes[Math.floor(Math.random() * naipes.length)];
  const v = valores[Math.floor(Math.random() * valores.length)];
  const el = document.getElementById("carta");

  el.className = "card-ui " + (n.cor === "red" ? "red" : "black");
  el.innerHTML = `<div>${v}${n.sim}</div><div style="align-self:flex-end; transform:rotate(180deg)">${v}${n.sim}</div>`;

  document.getElementById("leg").textContent = `Carta: ${v} de ${n.sim}`;
}

window.addEventListener("load", sortearCarta);
