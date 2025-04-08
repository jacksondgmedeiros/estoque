package br.com.jjnervosia.estoque.controller;

import br.com.jjnervosia.estoque.model.users.DadosAtualizaUsers;
import br.com.jjnervosia.estoque.model.users.DadosCadastroUsers;
import br.com.jjnervosia.estoque.model.users.Users;
import br.com.jjnervosia.estoque.service.UsersService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<List<Users>> listaUsuarios() {
        List<Users> users = usersService.listaUsuarios();
        return ResponseEntity.ok().body(users);
   }

   @PostMapping
    public ResponseEntity<Users> cadastrarUsuario(@RequestBody DadosCadastroUsers dados) {
        var users = usersService.cadastrarUsuario(dados);
        return ResponseEntity.ok().body(users);
   }

   @PutMapping("{id}")
   public ResponseEntity<Users> alterarUsuario(@PathVariable Long id, @RequestBody DadosAtualizaUsers dados) {
        var atualizaUser = usersService.atualizarUsuario(id,dados );
        return ResponseEntity.ok().body(atualizaUser);
   }


   @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id) {
        usersService.removerUsuario(id);
        return ResponseEntity.accepted().body("Usuário deletado com sucesso!");
   }

    @GetMapping("/count")
    public ResponseEntity<Long> countUsuarios() {
        Long contar = usersService.contarUsuarios();
        return ResponseEntity.ok(contar);
    }

}
