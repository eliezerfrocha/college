document.addEventListener("DOMContentLoaded", () => {
  const nome = localStorage.getItem("nome");
  const passatempo = localStorage.getItem("passatempo");
  const titulo = document.getElementById("titulo");
  const detalhesLista = document.getElementById("carroDetalhes");

  titulo.innerHTML = `${nome}, veja as opções para o seu perfil:`;

  const carros =
    passatempo === "shopping"
      ? [
          {
            img: "assets/img/civic.jpg",
            detalhes: [
              "Fabricante: Honda",
              "Nome: Civic",
              "Potência do motor: 150 cv",
              "Garantia: 5 anos",
              "Consumo (cidade): 9,7 km/l",
            ],
          },
          {
            img: "assets/img/corolla.jpg",
            detalhes: [
              "Fabricante: Toyota",
              "Nome: Corolla",
              "Potência do motor: 144 cv",
              "Garantia: 5 anos",
              "Consumo (cidade): 10,6 km/l",
            ],
          },
        ]
      : [
          {
            img: "assets/img/troller.jpg",
            detalhes: [
              "Fabricante: Ford",
              "Nome: Troller",
              "Potência do motor: 200 cv",
              "Garantia: 3 anos",
              "Consumo (cidade): 7,7 km/l",
            ],
          },
          {
            img: "assets/img/wrangler.jpg",
            detalhes: [
              "Fabricante: Jeep",
              "Nome: Wrangler",
              "Potência do motor: 199 cv",
              "Garantia: 2 anos",
              "Consumo (cidade): 3,1 km/l",
            ],
          },
        ];

  let index = 0;
  const img = document.getElementById("carroImg");

  function atualizarCarro() {
    img.src = carros[index].img;
    detalhesLista.innerHTML = carros[index].detalhes
      .map((detalhe) => `<li>${detalhe}</li>`)
      .join("");
    index = (index + 1) % carros.length;
  }

  atualizarCarro();
  setInterval(atualizarCarro, 3000);

  document.getElementById("mudarPerfil").addEventListener("click", () => {
    window.location.href = "index.html";
  });
});
