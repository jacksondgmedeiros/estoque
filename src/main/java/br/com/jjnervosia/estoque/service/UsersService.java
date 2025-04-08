package br.com.jjnervosia.estoque.service;

import br.com.jjnervosia.estoque.model.users.DadosAtualizaUsers;
import br.com.jjnervosia.estoque.model.users.DadosCadastroUsers;
import br.com.jjnervosia.estoque.model.users.Users;
import br.com.jjnervosia.estoque.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public List<Users> listaUsuarios() {
        return usersRepository.findAll();
    }

    public Users cadastrarUsuario(DadosCadastroUsers dados) {
        Users user = new Users(dados);
        return usersRepository.save(user);

    }

    public Long contarUsuarios(){
        return usersRepository.countUsers();
    }

    public void removerUsuario(Long id){
        usersRepository.deleteById(id);
    }

    public Users atualizarUsuario(Long id, DadosAtualizaUsers dados) {

        var user = usersRepository.getReferenceById(id);

        if (dados.userName() != null && !dados.userName().isEmpty()) {
            user.setUserName(dados.userName());
        }
        if (dados.nome() != null && !dados.nome().isEmpty()) {
            user.setNome(dados.nome());
        }

        return usersRepository.save(user);
    }


}
