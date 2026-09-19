// // => explorando
// // const pessoa = [
// //   {
// //     nome: "Eliezer",
// //     idade: 27,
// //     cidade: "Uberlândia",
// //     estado: "MG",
// //     profissao: "Desenvolvedor",
// //   },
// //   {
// //     nome: "Eliezer",
// //     idade: 27,
// //     cidade: "Uberlândia",
// //     estado: "MG",
// //     profissao: "Desenvolvedor",
// //   },
// //   {
// //     nome: "Eliezer",
// //     idade: 27,
// //     cidade: "Uberlândia",
// //     estado: "MG",
// //     profissao: "Desenvolvedor",
// //   },
// // ];

// // // const nomes = JSON.stringify(pessoa.map(p => p.nome, p.cidade))
// // const nomes = JSON.stringify(pessoa.map(p => ({ nome: p.nome, cidade: p.cidade })));

// // console.log(nomes);
// // //console.log(pessoa[0].nome, pessoa[1]);

// //=> objeto javascript
// var cadeira = { peso: 100, cor: "amarela", altura: 100, marca: "Cadeira" };
// //var pessoa = { nome: "Wilton Filho", idade: 43, profissao: "prof" };

// // => pessoa com mais de uma pessoa
// var pessoa = [
//   {
//     nome: "Eliezer",
//     idade: 27,
//     profissao: "dev"
//   },
//   {
//     nome: "Wilton",
//     idade: 43,
//     profissao: "prof"
//   }
// ];
// console.log(pessoa[0].nome);
// console.log(pessoa[1].nome);


// var res = JSON.stringify(pessoa.map(p => (
//   { 
//     nome: p.nome, 
//     idade: p.idade,
//     profissao: p.profissao 
//   },
//   { 
//     nome: p.nome, 
//     idade: p.idade,
//     profissao: p.profissao 
//   }
// ))); 
// // console.log(res);

// => exercicio 01
// crie um objeto para representar a figura geometrica triangulo. Dica: esse objeto possui 3 atributos: lado1, lado2, lado3
// 1 objeto: triangulo equilatero
// 2 objeto: triangulo escaleno
// 3 objeto: triangulo isosceles

// const trianguloEquilatero = [
//   {lado1: 10, lado2: 10, lado3: 10},
//   {lado1: 10, lado2: 10, lado3: 10},
//   {lado1: 10, lado2: 10, lado3: 10}
// ]

// const trianguloEscaleno = [
//   { lado1: 10, lado2: 12, lado3: 14 },
//   { lado1: 7, lado2: 9, lado3: 11 },
//   { lado1: 8, lado2: 10, lado3: 12 }
// ];

// const trianguloIsosceles = [
//   { lado1: 10, lado2: 10, lado3: 8 },
//   { lado1: 12, lado2: 12, lado3: 9 }, 
//   { lado1: 15, lado2: 15, lado3: 10 }  
// ];

for(var x=0;x<100;x++) {
  console.log(parseInt(Math.random()*10+1))
}

