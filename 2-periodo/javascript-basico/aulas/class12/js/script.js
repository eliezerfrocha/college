window.addEventListener("DOMContentLoaded", function () {
  var txtInfo = document.getElementById("txtInfo");
  var btnValidar = this.document.getElementById("btnValidar");

  btnValidar.addEventListener("click", function () {
    //var padrao = /\d/; //valida se ha numeros em qualquer lugar
    //var padrao = /^\d/; //valida se ha numeros no inicio
    //var padrao = /\d$/; //valida se ha numeros no final
    //var padrao = /^\d$/; //valida se ha dois numeros seguidos

    // valida numero de telefone com ddd
    // var padrao = /^\(?\d{2}\)?\s?\9\d{4}-?\d{4}$/;
    // valida data de nascimento com / e dd/mm/aaaa
    //var padrao = /^\d{2}\/\d{2}\/\d{4}/;
    // valida cep com pnctuacao
    //var padrao = /^\d{5}-\d{3}/;

    // var padrao = /^IFTM-\d{4,6}-(TSPI|LCO|MKT):\d-[A-Z]$/; // | ou
    // var padrao = /^[Ii]Ff][Tt][Mm]-\d{4,6}-(TSPI|LCO|MKT):\d-[A-Z]$/; // [ ] ou

    // var padrao =/^(M|m|F|f)$/i; // i ignora case sensitive
    // var padrao =/^(M|F|Masculino|Feminino)$/i; // i ignora case sensitive

    //var padrao = /^IFTM\s{1,3}TSPI$/i; // {1,3} 1 a 3
    //var padrao = /^IFTM\s{1,}TSPI$/i; // {1,} 1 ou mais
    //var padrao = /^IFTM\s*TSPI$/i; // * 0 ou mais
    //var padrao = /^IFTM\s?TSPI$/i; // ? opcional

    // var padrao = /^[abdce]{2,}$/i; // {2,} 2 ou mais
    // var padrao = /^#?([a-fA-F0-9]{1,6}|[a-fA-F0-9]{1,3})$/; // valida cor hexadecimal
    // var padrao = /^[0-9a-f]$/; // valida cor hexadecimal
    // var padrao = /^[0-9a-f]+$/; // valida cor hexadecimal
    // var padrao = /^[^*+-]+$/; // nega o que esta dentro do colchetes
    
    /// melhorar (22:22)
    //var padrao = /^\d{2}:\d{2}$/;

    var padrao = /^[A-z]{4,}\d{2,4}\W{2}$/; // valida placa de carro
    console.log(padrao.test(txtInfo.value));
    if (padrao.test(txtInfo.value)) {
      alert("✅ VÁLIDO!");
    } else {
      alert("❌ INVÁLIDO!!");
    }
  });
});
