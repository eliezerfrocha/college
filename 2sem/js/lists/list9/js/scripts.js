const regexList = {
    binario: /^[01]+$/,
    hexadecimal: /^0[xX][0-9a-fA-F]+$/,
    decimal: /^\d+$/,
    real: /^\d+([.,]\d+)?$/,
    horario: /^([01]\d|2[0-3]):[0-5]\d:[0-5]\d$/,
    dataNascimento: /^\d{2}\/\d{2}\/(\d{2}|\d{4})$/,
    cep: /^\d{5}-\d{3}$/,
    cpf: /^\d{3}\.\d{3}\.\d{3}-\d{2}$/,
    cnpj: /^\d{2}\.\d{3}\.\d{3}\/\d{4}-\d{2}$/,
    parenteses: /^\(\d+\)$/,
    email: /^[\w.-]+@[a-zA-Z]+\.[a-zA-Z]{2,3}$/,
    ipv4: /^(\d{1,3}\.){3}\d{1,3}$/,
    altura: /^\d[,\.]\d{1,2}$/,
    nome: /^[A-Z][a-z]+$/,
    telefone: /^\+\d{2}\(\d{2}\)\d{4,5}-\d{4}$/,
    texto: /^IFTM campus Uberlândia( Centro)?$/,
    numero: /^([1-9]|[1-9]\d|100)$/,
    placa: /^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$/,
    palavra: /^[abcd]+$/,
    faturamento: /^R\$((\d{1,3}(\.\d{3})*|\d+),\d{1,2})$/,
    matricula1: /^iftm-\d{3}\/\d{3}-[a-zA-Z]{2}$/i,
    matricula2: /^MT-\d{2}\.\d{3}-IFTM$/i,
    matricula3: /^MT-\d{2}\.\d{3}-IFTM ?(UBERLÂNDIA CENTRO|UBERLÂNDIA)$/i,
};

function validar(campoId) {
    const input = document.getElementById(campoId);
    const valor = input.value;
    const regex = regexList[campoId];
    const valido = regex.test(valor);

    if (valido) {
        alert(`O campo "${campoId}" é válido!`);
    } else {
        alert(`O campo "${campoId}" é inválido!`);
    }
}

document.getElementById("validationForm").addEventListener("submit", (event) => {
    event.preventDefault(); 
});