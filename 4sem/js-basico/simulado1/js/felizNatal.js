// Espera a página carregar
document.addEventListener("DOMContentLoaded", function(){
    // Pega os elementos da página
    let numeroMensagens = document.getElementById("textoFala");
    let botaoCriar = document.getElementById("botaoFala");
    let areaMensagens = document.getElementById("containerFalas");

    // Quando clicar no botão
    botaoCriar.addEventListener("click", function(){
        // Quantas vezes vamos repetir
        let quantasVezes = 0;
        // Pega o número digitado
        quantasVezes = Number(numeroMensagens.value);

        // Repete o número de vezes escolhido
        let vezesFeitas = 0;
        while(vezesFeitas < quantasVezes){
            // Cria mensagem de natal
            let mensagemNatal = document.createElement("p");
            // Coloca o texto do Papai Noel
            mensagemNatal.textContent = "Ho Ho Ho Feliz Natal!";
            // Adiciona o estilo especial
            mensagemNatal.classList.add("fala");
            // Coloca a mensagem na área
            areaMensagens.appendChild(mensagemNatal);
            // Conta mais uma vez feita
            vezesFeitas = vezesFeitas + 1;
        }
    })
})