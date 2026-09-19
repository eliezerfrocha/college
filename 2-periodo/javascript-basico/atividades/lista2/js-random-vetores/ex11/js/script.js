const TOTAL_CARTAS = 27;

function montarBaralho() {
  return Array.from({ length: TOTAL_CARTAS }, (_, i) => i + 1);
}

function embaralhar(deck) {
  for (let i = deck.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [deck[i], deck[j]] = [deck[j], deck[i]];
  }
}

function cartaHTML(numero) {
  const caminho = `../assets/cartas/carta${numero}.png`;
  return `<img src="${caminho}" alt="Carta ${numero}" class="carta-img">`;
}

function sortearTruco() {
  const deck = montarBaralho();
  embaralhar(deck);

  const mao = deck.slice(0, 12);
  const jogadores = [[], [], [], []];

  for (let i = 0; i < 12; i++) {
    jogadores[i % 4].push(mao[i]);
  }

  const areas = [
    document.getElementById("j1"),
    document.getElementById("j2"),
    document.getElementById("j3"),
    document.getElementById("j4"),
  ];

  jogadores.forEach((cartas, idx) => {
    areas[idx].innerHTML = cartas.map(cartaHTML).join("");
  });
}

window.addEventListener("load", sortearTruco);

// const naipes = [
//   { sim: "♠", cor: "black" },
//   { sim: "♥", cor: "red" },
//   { sim: "♦", cor: "red" },
//   { sim: "♣", cor: "black" },
// ];

// const valores = ["A","2","3","4","5","6","7","8","9","10","J","Q","K"];

// function montarBaralho() {
//   const deck = [];

//   for (const n of naipes) {
//     for (const v of valores) {
//       deck.push({ naipe: n, valor: v, id: `${v}${n.sim}` });
//     }
//   }

//   return deck;
// }

// function embaralhar(deck) {
//   for (let i = deck.length - 1; i > 0; i--) {
//     const j = Math.floor(Math.random() * (i + 1));
//     [deck[i], deck[j]] = [deck[j], deck[i]];
//   }
// }

// function cartaHTML(c) {
//   return `<div class="card-ui ${c.naipe.cor === "red" ? "red" : "black"}">
//     <div>${c.valor}${c.naipe.sim}</div>
//     <div style="align-self:flex-end; transform:rotate(180deg)">${c.valor}${
//     c.naipe.sim
//   }</div>
//   </div>`;
// }

// function sortearTruco() {
//   const deck = montarBaralho();
//   embaralhar(deck);

//   const mao = deck.slice(0, 12); // 12 cartas
//   const jogadores = [[], [], [], []];

//   for (let i = 0; i < 12; i++) {
//     jogadores[i % 4].push(mao[i]);
//   }

//   const areas = [
//     document.getElementById("j1"),
//     document.getElementById("j2"),
//     document.getElementById("j3"),
//     document.getElementById("j4"),
//   ];

//   jogadores.forEach((cartas, idx) => {
//     areas[idx].innerHTML = cartas.map(cartaHTML).join("");
//   });
// }

// window.addEventListener("load", sortearTruco);
