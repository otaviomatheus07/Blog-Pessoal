package org.blogpessoal.generation.blogpessoal.repository;

import java.util.List;
import org.blogpessoal.generation.blogpessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{	//o extends puxa a classe do Model
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
}
