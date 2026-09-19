// Espera a página carregar antes de executar
document.addEventListener("DOMContentLoaded", function(){
    // Pega as informações salvas
    let textoSalvo = localStorage.getItem("infoUser");
    
    // Pega todos os elementos que vamos usar
    let caixaTexto = document.getElementById("textoCaixa");
    let comecaComM = document.getElementById("textoM");
    let palavraInicio = document.getElementById("textoPrimeira");
    let palavraMeio = document.getElementById("textoSegunda");
    let palavraFim = document.getElementById("textoUltima");
    let escolhaTexto = document.getElementById("novoSelect");
    let botaoVerificar = document.getElementById("botaoAnalise");
    let botaoPaginaNatal = document.getElementById("botaoNatal");
    
    // Mostra o texto salvo na tela
    let mostrarTexto = document.createElement("p");
    mostrarTexto.textContent = textoSalvo;
    document.getElementById("armazenaTexto").appendChild(mostrarTexto);

    // Quando clicar no botão de análise
    botaoVerificar.addEventListener("click", function(){
        // Decide qual texto vamos analisar
        let textoParaAnalisar = textoSalvo;
        
        // Se escolher usar texto novo e tiver algo digitado
        if(escolhaTexto.value == "Não" && caixaTexto.value.trim() != ""){
            textoParaAnalisar = caixaTexto.value.trim();
        }

        // Separa o texto em palavras
        let todasPalavras = textoParaAnalisar.split(" ");
        
        // Coloca primeira, segunda e última palavra nos campos
        palavraInicio.value = todasPalavras[0] || "";
        palavraMeio.value = todasPalavras[1] || "";
        palavraFim.value = todasPalavras[todasPalavras.length - 1] || "";

        // Procura palavras que começam com M
        let listaComM = [];
        for(let contador = 0; contador < todasPalavras.length; contador++){
            // Pega a primeira letra e vê se é M
            let primeiraLetra = todasPalavras[contador][0];
            if(primeiraLetra.toUpperCase() == "M"){
                listaComM.push(todasPalavras[contador]);
            }
        }
        
        // Junta as palavras com M usando vírgula
        comecaComM.value = listaComM.join(", ");
    })

    // Quando clicar no botão de natal
    botaoPaginaNatal.addEventListener("click", function(){
        // Vai para a página de natal
        window.location.href = "felizNatal.html";
    })

    // Fim do código
})