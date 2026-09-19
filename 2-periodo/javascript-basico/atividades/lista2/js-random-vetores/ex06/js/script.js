function gerarMega() {
  const nums = new Set();
  while (nums.size < 6) {
    nums.add(Math.floor(Math.random() * 60) + 1);
  }
  const arr = [...nums].sort((a, b) => a - b);

  document.getElementById("numeros").innerHTML = arr
    .map((n) => `<div class="bolinha">${String(n).padStart(2, "0")}</div>`)
    .join("");
}
window.addEventListener("load", gerarMega);
