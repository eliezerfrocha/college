document.addEventListener("DOMContentLoaded", () => {
  const tempo = Math.floor(Math.random() * 6) + 5; // Gera entre 5 e 10 segundos
  const display = document.getElementById("tempo");

  let contador = tempo;
  display.innerHTML = contador;

  const interval = setInterval(() => {
    contador--;

    // Aplica a cor vermelha somente nos últimos 4 segundos
    if (contador <= 4) {
      display.style.color = "red";
    } else {
      display.style.color = "#333"; // Mantém a cor padrão antes disso
    }

    display.innerHTML = contador;

    if (contador <= 0) {
      clearInterval(interval);
      window.location.href = "verVeiculo.html";
    }
  }, 1000);
});