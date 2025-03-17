package br.com.jjnervosia.estoque.model.users;

public record DadosCadastroUsers(
        String nome,
        String userName,
        String password,
        Permissao permissao
) {
}
