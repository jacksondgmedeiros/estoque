package br.com.jjnervosia.estoque.model.users;

public record DadosAtualizaUsers(
        String nome,
        String userName,
        String password,
        boolean ativo,
        Permissao permissao
) {
}
