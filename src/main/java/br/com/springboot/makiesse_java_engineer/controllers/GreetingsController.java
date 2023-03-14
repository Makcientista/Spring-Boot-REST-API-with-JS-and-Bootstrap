package br.com.springboot.makiesse_java_engineer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import br.com.springboot.makiesse_java_engineer.repository.UsuarioRepository;
import br.springboot.makiesse_java_engineer.model.Usuario;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
	
	@Autowired /*IC/CD ou CDI - Injeção de dependência*/
	private UsuarioRepository usuarioRepository;
	
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/mostrarnome/{name}", method = RequestMethod.GET) //Mapeamento de requisição
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return " Welcome to the first CTD " + name + "!";
    }
    
    @RequestMapping(value = "/olamundo/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String retornaOlaMundo(@PathVariable String nome) {
    	
    	Usuario usuario = new Usuario();
    	usuario.setNome(nome);
    	
    	usuarioRepository.save(usuario); /*Gravar no banco de dados*/
    	
    	return "Olá mundo " + nome;
    }
    
    @GetMapping(value = "listatodos") /*Primeiro método de API*/
    @ResponseBody /*Retorna os dados para o corpo da resposta*/
    public ResponseEntity<List<Usuario>> listaUsuario(){
    	
    List<Usuario> usuarios = usuarioRepository.findAll(); /*Executa a consulta no bando de dados*/
    
    return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    	
    }
    
}
