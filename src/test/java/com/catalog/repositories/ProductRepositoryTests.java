package com.catalog.repositories;

import com.catalog.entities.Product;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository repository;

    @Test
    public void deleteShouldDeleteObjectWhenIdExists(){
        //preparar os dados
        long existingid = 1L;
        //executar os dados
        repository.deleteById(existingid);
        //verificar se realmente deletou
        Optional<Product> result = repository.findById(existingid);
        //testa se o objeto esta presente
        Assertions.assertFalse( result.isPresent());

    }
@Test
    public void testSaveProject(){
        Product product = new Product();
        product.setName("Test Product");
        product.setDescription("trestando");
        product.setPrice(400.00);
        product.setImgUrl("localhost/image");
        product.setDate(Instant.parse("2024-10-25T21:21:000+03:00"));
        //salvar produto
    Product savedProduct = repository.save(product);
    //Asserts são para certificar se tudo deu certo
    assertThat(savedProduct).isNotNull(); //verfifica se é não nulo
    assertThat(savedProduct.getName()).isEqualTo( "Test Product");

}


}

