// input
// nome
// nota bim 1
// nota bim 2

// output
// (aluno) voce esta aprovado!
// nota final:

// (aluno) voce esta reprovado
// faltam 35,0 pts para sua aprovacao

nome = prompt("Informe seu nome:")

nota1 = parseFloat(prompt("Informe sua nota bimestral:"))
nota2 = parseFloat(prompt("Informe sua outra nota bimestral:"))

soma = nota1 + nota2
console.log(soma)

if (soma >= 60) {
    alert(`${nome} voce esta aprovado! \nSua nota foi ${soma}`)
} else {
    alert(`${nome}, voce esta REPROVADO! \nFaltam ${60 - soma} pontos para sua apovacao.`)
}