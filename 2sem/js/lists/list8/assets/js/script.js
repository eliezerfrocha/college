document.getElementById("verOpcoesBtn").addEventListener("click", () => {
  validarFormulario();
});

function validarFormulario() {
  const nome = document.getElementById("nome").value.trim();
  const idade = parseInt(document.getElementById("idade").value);
  const passatempo = document.getElementById("passatempo").value;

  if (!nome) {
    alert("O campo 'Nome' é obrigatório!");
    return;
  }

  if (isNaN(idade) || idade < 1 || idade > 130) {
    alert("Por favor, insira uma idade válida (entre 1 e 130).");
    return;
  }

  if (!passatempo) {
    alert("Por favor, selecione um passatempo.");
    return;
  }

  // Armazena as informações no localStorage
  localStorage.setItem("nome", nome);
  localStorage.setItem("idade", idade);
  localStorage.setItem("passatempo", passatempo);

  // Redireciona para a página aguarde.html
  window.location.href = "aguarde.html";
}
