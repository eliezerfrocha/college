package prog5tratamento;

class Usuario {
    private String usuario;
    private String senha;

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public void validarLogin(String usuario, String senha) throws Validacao {
        if (!this.usuario.equals(usuario)) {
            throw new Validacao("Usuário inválido!");
        }
        if (!this.senha.equals(senha)) {
            throw new Validacao("Senha inválida!");
        }
    }
}
