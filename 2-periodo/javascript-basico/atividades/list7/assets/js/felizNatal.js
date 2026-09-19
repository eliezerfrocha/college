document.getElementById("mostrar").addEventListener("click", () => {
    const qtd = parseInt(document.getElementById("quantidade").value);
    const falasDiv = document.getElementById("falas");
    falasDiv.innerHTML = "";

    if (isNaN(qtd) || qtd <= 0) {
        alert("Por favor, informe um valor válido!");
        return;
    }

    for (let i = 0; i < qtd; i++) {
        const p = document.createElement("p");
        p.textContent = "Ho Ho Ho Feliz Natal!";
        falasDiv.appendChild(p);
    }

    const img = document.createElement("img");
    img.src = "assets/imagens/presente.png";
    falasDiv.appendChild(img);
});