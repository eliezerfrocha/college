document.addEventListener("DOMContentLoaded", () => {
    alert("Seja bem-vindo!");

    const enviarBtn = document.getElementById("enviar");
    const textoInput = document.getElementById("texto");

    enviarBtn.addEventListener("click", () => {
        const texto = textoInput.value.trim();
        if (texto === "") {
            alert("Por favor, informe um texto válido.");
        } else {
            // Salva o texto no armazenamento local para usar na próxima página
            localStorage.setItem("textoUsuario", texto);
            window.location.href = "analisarTxt.html";
        }
    });
});