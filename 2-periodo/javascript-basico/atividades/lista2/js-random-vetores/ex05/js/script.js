function calcular() {
  const arr = document.getElementById("lista").value.trim();
  
  if (!arr) 
    return alert("Informe pelo menos uma linha no formato Nome,Idade.");

  const linhas = arr.split(/\n+/);
  const pessoas = [];

  for (const l of linhas) {
    const [nome, idadeStr] = l.split(",").map((s) => s && s.trim());
    const idade = Number(idadeStr);
    if (!nome || !Number.isFinite(idade)) {
      return alert("Formato inválido na linha: " + l + "\nUse: Nome,Idade");
    }
    pessoas.push({ nome, idade });
  }

  const media = pessoas.reduce((acc, p) => acc + p.idade, 0) / pessoas.length;
  const sorteado = pessoas[Math.floor(Math.random() * pessoas.length)];
  
  document.getElementById("saida").innerHTML = `
    <br>
    ----------------------------------------------------------------------
    <div class="card">
      <p><strong>Quantidade:</strong> ${pessoas.length}</p>
      <p><strong>Idade média:</strong> ${media.toFixed(2)}</p>
      <p><strong>Almoço grátis:</strong> <span class="pill">${
        sorteado.nome
      }</span></p>
    </div>
  `;
}
