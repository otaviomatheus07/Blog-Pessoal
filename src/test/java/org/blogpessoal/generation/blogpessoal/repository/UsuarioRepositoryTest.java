package org.blogpessoal.generation.blogpessoal.repository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.blogpessoal.generation.blogpessoal.model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository repository;

	@BeforeAll
	void start() {
		repository.deleteAll();
		repository.save(
				new Usuario(0L, "João da Silva", "joao@gmail.com", "12345678", "https://i.imgur.com/FETvs20.jpg"));
		repository.save(
				new Usuario(0L, "Manuela da Silva", "manu@gmail.com", "87654321", "https://i.imgur.com/NTyGneo.jpg"));
		repository.save(new Usuario(0L, "Adriana da Silva", "adriana@gmail.com", "11111111",
				"https://i.imgur.com/mB3VM2N.jpg"));
		repository.save(
				new Usuario(0L, "Paulo da Silva", "paulo@gmail.com", "123123123", "https://i.imgur.com/JR7kUFU.jpg"));
	}

	@Test
	@DisplayName("retorna 1 usuario")
	public void deveRetornarUmUsuario() {
		Optional<Usuario> usuario = repository.findByUsuario("joao@gmail.com");
		assertTrue(usuario.get().getUsuario().equals("joao@gmail.com"));
	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<Usuario> listaDeUsuarios = repository.findAllByNomeContainingIgnoreCase("Silva");

		assertEquals(3, listaDeUsuarios.size());

		assertTrue(listaDeUsuarios.get(0).getNome().equals("João da Silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Manuela da Silva"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Adriana da Silva"));

	}

	@AfterAll
	public void end() {
		repository.deleteAll();
	}
}
