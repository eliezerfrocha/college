document.getElementById("btnCadastrar").addEventListener("click", () => {
  validarFormulario();
});

function validarFormulario() {
  const nome = document.getElementById("nome").value.trim();
  const sobrenome = document.getElementById("sobrenome").value.trim();
  const selectIdade = document.getElementById("selectIdade").value;
  console.log(selectIdade);

  const msgAlerta = document.getElementById("msgAlerta");
  const imgAlerta = document.getElementById("imgAlerta");

  if (!nome) {
    msgAlerta.innerHTML = "Nome e sobrenome devem ser informados";
    msgAlerta.style.color = "red";
    imgAlerta.src = "img/erro.png";
    return;
  }

  if (!sobrenome) {
    msgAlerta.innerHTML = "Nome e sobrenome devem ser informados";
    msgAlerta.style.color = "red";
    imgAlerta.src = "img/erro.png";
    return;
  }

  if (!selectIdade) {
    msgAlerta.innerHTML = "Selecione a sua faixa etária";
    msgAlerta.style.color = "red";
    imgAlerta.src = "img/erro.png";
    return;
  }

  if (selectIdade == "1") {
    msgAlerta.innerHTML = `${nome}, você ainda não tem idade suficiente.`;
    msgAlerta.style.color = "darkred";
    imgAlerta.src = "img/erro.png";
  } else {
    if (selectIdade == "2") {
        localStorage.setItem("aplicacao", "Poupança estudante");
    }
    if (selectIdade == "3") {
        localStorage.setItem("aplicacao", "Renda Fixa");
    }
    if (selectIdade == "4") {
        localStorage.setItem("aplicacao", "Ações");
    }
    if (selectIdade == "5") {
        localStorage.setItem("aplicacao", "Fundo de Investimento Imobiliário");
    }

    localStorage.setItem("nome", nome);
    localStorage.setItem("sobrenome", sobrenome);

    processandoRequisicao(imgAlerta, msgAlerta);
  }
}

function processandoRequisicao(imgAlerta, msgAlerta) {
  const tempo = Math.floor(Math.random() * 6) + 5;

  let contador = tempo;
  const interval = setInterval(() => {
    contador--;

    imgAlerta.src = "img/processando.gif";
    msgAlerta.style.color = "blue";
    msgAlerta.innerHTML = `Processando. Aguarde (${contador} segundos)`;

    if (contador <= 0) {
      clearInterval(interval);

      localStorage.setItem("cadastrado", 1);
      window.location.href = "processa.html";
    }
  }, 1000);
}
