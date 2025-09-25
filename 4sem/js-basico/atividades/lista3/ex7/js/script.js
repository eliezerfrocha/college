// Validações simples, como pedido
const login = document.getElementById('login');
const senha = document.getElementById('senha');
const confirmar = document.getElementById('confirmar');
const btnEntrar = document.getElementById('entrar');
const btnLimpar = document.getElementById('limpar');

btnEntrar.addEventListener('click', (e) => {
  e.preventDefault();

  if (!login.value.trim()) {
    alert('Por favor, preencha o Login.');
    login.focus();
    return;
  }

  if (senha.value !== confirmar.value) {
    alert('As senhas não conferem. Digite novamente.');
    senha.value = '';
    confirmar.value = '';
    senha.focus();
    return;
  }

  alert('Todos os campos foram digitados corretamente!');
});

btnLimpar.addEventListener('click', () => {
  login.value = '';
  senha.value = '';
  confirmar.value = '';
  login.focus();
});