package br.com.springboot.makiesse_java_engineer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.springboot.makiesse_java_engineer.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { // Usuario = classe persistente que representa o banco de dado | E o tipo de dao que representa a primary key Long -> ID
	

}
