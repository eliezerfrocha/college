window.addEventListener("DOMContentLoaded", () => {

    // ELEMENTOS (inputs)
    const elNasc   = document.querySelector("#inpNasc");
    const elCpf    = document.querySelector("#inpCpf");
    const elMat    = document.querySelector("#inpMat");
    const elD1     = document.querySelector("#inpDisc1");
    const elD2     = document.querySelector("#inpDisc2");
    const elD3     = document.querySelector("#inpDisc3");
    const elD4     = document.querySelector("#inpDisc4");
    const elCampus = document.querySelector("#inpCampus");
    const elF1     = document.querySelector("#inpFone1");
    const elF2     = document.querySelector("#inpFone2");
    const elAlt    = document.querySelector("#inpAlt");
    const elFat    = document.querySelector("#inpFat");
    const elCron   = document.querySelector("#inpCron");
    const elSenha  = document.querySelector("#inpSenha");

    // BOTÕES
    const btnNasc   = document.querySelector("#btnNasc");
    const btnCpf    = document.querySelector("#btnCpf");
    const btnMat    = document.querySelector("#btnMat");
    const btnD1     = document.querySelector("#btnDisc1");
    const btnD2     = document.querySelector("#btnDisc2");
    const btnD3     = document.querySelector("#btnDisc3");
    const btnD4     = document.querySelector("#btnDisc4");
    const btnCampus = document.querySelector("#btnCampus");
    const btnF1     = document.querySelector("#btnFone1");
    const btnF2     = document.querySelector("#btnFone2");
    const btnAlt    = document.querySelector("#btnAlt");
    const btnFat    = document.querySelector("#btnFat");
    const btnCron   = document.querySelector("#btnCron");
    const btnSenha  = document.querySelector("#btnSenha");

    // utilitário para exibir resultado
    function runCheck(regex, value, okMsg, badMsg) {
        alert(regex.test(value) ? okMsg : badMsg);
    }

    // validações
    btnNasc.addEventListener("click", () => {
        const rx = /^\d{2}\/\d{2}\/\d{2}(\d{2})?$/;
        runCheck(rx, elNasc.value, "Data de nascimento: VÁLIDA", "Data de nascimento: INVÁLIDA");
    });

    btnCpf.addEventListener("click", () => {
        const rx = /^\d{3}\.\d{3}\.\d{3}-\d{2}$/;
        runCheck(rx, elCpf.value, "CPF: VÁLIDO", "CPF: INVÁLIDO");
    });

    btnMat.addEventListener("click", () => {
        const rx = /^IFTM-\d{3}\/\d{3}-[a-zA-Z0-9]{2}$/i;
        runCheck(rx, elMat.value, "Número de matrícula: VÁLIDO", "Número de matrícula: INVÁLIDO");
    });

    btnD1.addEventListener("click", () => {
        const rx = /^MT-\d{2}\.\d{3}-IFTM$/i;
        runCheck(rx, elD1.value, "Código de disciplina v1: VÁLIDO", "Código de disciplina v1: INVÁLIDO");
    });

    btnD2.addEventListener("click", () => {
        const rx = /^MT-\d{2}\.\d{3}-[iI][fF][tT][mM]$/;
        runCheck(rx, elD2.value, "Código de disciplina v2: VÁLIDO", "Código de disciplina v2: INVÁLIDO");
    });

    btnD3.addEventListener("click", () => {
        const rx = /^M\s{0,1}T-\d{2}\.\d{3}-[Ii]\s{0,1}[Ff]\s{0,1}[Tt]\s{0,1}[Mm]$/;
        // versão 3 aceita até um espaço entre letras (usei \s{0,1} em vez de \s{1} pra cobrir sem espaço também)
        runCheck(rx, elD3.value, "Código de disciplina v3: VÁLIDO", "Código de disciplina v3: INVÁLIDO");
    });

    btnD4.addEventListener("click", () => {
        const rx = /^MT-\d{2}\.\d{3}-IFTM(?: Uberlândia(?: Centro)?)?$/;
        // aceita "MT-xx.xxx-IFTM", "MT-xx.xxx-IFTM Uberlândia" ou "MT-xx.xxx-IFTM Uberlândia Centro"
        runCheck(rx, elD4.value, "Código de disciplina v4: VÁLIDO", "Código de disciplina v4: INVÁLIDO");
    });

    btnCampus.addEventListener("click", () => {
        const rx = /^IFTM campus Uberlândia(?: Centro)?$/;
        runCheck(rx, elCampus.value, "Campus: VÁLIDO", "Campus: INVÁLIDO");
    });

    btnF1.addEventListener("click", () => {
        const rx = /^\+\d{2}\(\d{2}\)\d{5}-\d{4}$/;
        runCheck(rx, elF1.value, "Telefone: VÁLIDO", "Telefone: INVÁLIDO");
    });

    btnF2.addEventListener("click", () => {
        const rx = /^\(\d{2,3}\)\d{5}-\d{4}$/;
        runCheck(rx, elF2.value, "Telefone v2: VÁLIDO", "Telefone v2: INVÁLIDO");
    });

    btnAlt.addEventListener("click", () => {
        const rx = /^(1[.,][3-9]\d?|2[.,][0-4]\d?|2[.,]5[0-0]?)$/;
        // regex que tenta respeitar intervalo [1.3,2.5] com separador . ou ,
        // versão original mais simples também funciona: /^(1[\,\.][3-9]([0-9])?|2[\,\.][0-5]([0-9])?)$/
        runCheck(rx, elAlt.value, "Altura: VÁLIDA", "Altura: INVÁLIDA");
    });

    btnFat.addEventListener("click", () => {
        const rx = /^R\$(\d{1,3}(\.\d{3}){0,3})([,.])\d{1,2}$/;
        runCheck(rx, elFat.value, "Faturamento: VÁLIDO", "Faturamento: INVÁLIDO");
    });

    btnCron.addEventListener("click", () => {
        const rx = /^(?:[01]?[0-9]|2[0-3]):(?:[0-5]?[0-9]):(?:[0-5]?[0-9]):(?:[0-9]{2})$/;
        runCheck(rx, elCron.value, "Cronômetro: VÁLIDO", "Cronômetro: INVÁLIDO");
    });

    btnSenha.addEventListener("click", () => {
        const rx = /^[A-Za-z0-9._-]{5,}&[A-Pa-p]+\.[aeiou]+(?:\.[A-Za-z0-5]+)?-[^0-9]+,[^A-Za-z0-9]{2}\.[^ab01]+$/;
        runCheck(rx, elSenha.value, "Senha: VÁLIDA", "Senha: INVÁLIDA");
    });

});
