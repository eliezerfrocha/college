const listaCandidatos = [
  { nome: "Jair Messias Bolsonaro", partido: "PL", img: "candidato1.png" },
  { nome: "Luís Inácio Lula da Silva", partido: "PT", img: "candidato2.png" },
  { nome: "Ciro Gomes", partido: "PDT", img: "candidato3.png" },
  { nome: "Simone Tebet", partido: "MDB", img: "candidato4.png" }
]

document.getElementById("btnGerar").onclick = () => {
  const indices = [0, 1, 2, 3]

  const indiceA = indices.splice(Math.floor(Math.random() * indices.length), 1)[0]
  const indiceB = indices.splice(Math.floor(Math.random() * indices.length), 1)[0]

  const candA = listaCandidatos[indiceA]
  const candB = listaCandidatos[indiceB]

  const votosA = +(Math.random() * 100).toFixed(1)
  const votosB = +(100 - votosA).toFixed(1)

  document.getElementById("nomeCandidato1").textContent = candA.nome
  document.getElementById("partidoCandidato1").textContent = candA.partido
  document.getElementById("imgCandidato1").src = `./img/${candA.img}`
  document.getElementById("percentual1").textContent = votosA

  document.getElementById("nomeCandidato2").textContent = candB.nome
  document.getElementById("partidoCandidato2").textContent = candB.partido
  document.getElementById("imgCandidato2").src = `./img/${candB.img}`
  document.getElementById("percentual2").textContent = votosB

  let vencedorAtual = "Empate"
  if (votosA > votosB) vencedorAtual = candA.nome
  if (votosB > votosA) vencedorAtual = candB.nome

  document.getElementById("nomeVencedor").textContent = vencedorAtual
}