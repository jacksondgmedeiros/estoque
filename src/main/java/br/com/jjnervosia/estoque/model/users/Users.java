package br.com.jjnervosia.estoque.model.users;

import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String userName;
    //@JsonIgnore //ignora e não mostra o password no retorno do json
    private String password;
    private boolean ativo;

    @Enumerated(EnumType.STRING)
    private Permissao permissao;

    public Users(Users dados) {

    }

    public Users(DadosCadastroUsers dadosCadastroUsers) {
        this.ativo = true;
        this.nome = dadosCadastroUsers.nome();
        this.userName = dadosCadastroUsers.userName();
        this.password = dadosCadastroUsers.password();
        this.permissao = dadosCadastroUsers.permissao();
    }

    public Users() {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }



    public String getUserName() {
        return userName;
    }



    public String getPassword() {
        return password;
    }



    public boolean isAtivo() {
        return ativo;
    }



    public Permissao getPermissao() {
        return permissao;
    }


}
