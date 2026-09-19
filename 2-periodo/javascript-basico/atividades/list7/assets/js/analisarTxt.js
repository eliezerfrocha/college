document.addEventListener("DOMContentLoaded", () => {
    const textoUsuario = localStorage.getItem("textoUsuario") || "";
    const textoParagrafo = document.getElementById("texto-usuario");
    textoParagrafo.textContent = textoUsuario;

    const analisarBtn = document.getElementById("analisar");
    analisarBtn.addEventListener("click", () => {
        const novaSelecao = document.getElementById("selecao").value;
        const textoExtra = document.getElementById("texto-extra").value.trim();

        let textoAnalise = novaSelecao === "sim" ? textoExtra : textoUsuario;

        if (textoAnalise === "") {
            alert("Texto inválido para análise.");
            return;
        }

        const palavras = textoAnalise.split(" ").filter(palavra => palavra !== "");
        document.getElementById("qtd-palavras").textContent = palavras.length;

        const palavrasM = palavras.filter(p => p.toLowerCase().startsWith("m")).join(", ");
        document.getElementById("palavras-m").value = palavrasM;

        document.getElementById("primeira-palavra").value = palavras[0] || "";
        document.getElementById("segunda-palavra").value = palavras[1] || "O texto não possui mais palavras";
        document.getElementById("ultima-palavra").value = palavras[palavras.length - 1] || "";

        document.getElementById("papai-noel").onclick = () => {
            window.location.href = "felizNatal.html";
        };
    });
});