btn = document.getElementById("enviar");

btn.addEventListener("click", clicouEmMim);
btn.addEventListener("mouseenter", mouseEnter);
btn.addEventListener("mouseout", mouseEnter);
btn.addEventListener("mousemove", mouseMove);

function clicouEmMim() { 
    alert("Você clicou em mim!");
}

function mouseEnter() {
    alert("Chegou, hein!");
}

function mouseOut() {
    alert("Até logo!");
}

function mouseMove() {
    alert("Para de provocar!");
}