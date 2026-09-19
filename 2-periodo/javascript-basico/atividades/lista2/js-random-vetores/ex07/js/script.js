function rolar() {
  const faces = ["\u2680", "\u2681", "\u2682", "\u2683", "\u2684", "\u2685"]; // ⚀..⚅
  const n = Math.floor(Math.random() * 6); // 0..5
  
  document.getElementById("dado").textContent = faces[n];
  document.getElementById("legenda").textContent = "Resultado: " + (n + 1);
}

window.addEventListener("load", rolar);
