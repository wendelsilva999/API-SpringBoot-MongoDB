package com.greyhat.workoshop.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.greyhat.workoshop.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	//um query metodo do spring, o Containing checa pra min qualquer dado que eu passar
	//findbytitle e so o nome que quis dar e o ignorecase e so pra ignorar maiusculasa e minusculas
	//a varios desses query methods ja cridos basta ver a doc do spring relaciondo a esse banco e claro
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	
	//pra testes vamos fazer o mesmo metodo acima ou quase isso na "unha"
	//lembrar que o mongo tem um jeito proprio de fazer consulta nele usando json
	//campo que quero buscar 'title' e o ?0 eo primeiro parametro que vier no metodo o text no caso
	// 'i' ira ignorar maiusculas e minusculas
	@Query("{ 'title': {$regex: ?0, $options: 'i' } }")
	List<Post> searchtTitle(String text);
}
