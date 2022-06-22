package com.prashhanth.tdd.products;

import com.prashhanth.tdd.product.entity.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestProductsFunctionality {

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost";

    private static RestTemplate restTemplate;

    @Autowired
    private TestProductsRepo h2Repository;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(":").concat(port + "");
    }

    @Test
    @Sql(statements = "DELETE FROM PRODUCT WHERE pname='SONY Bravia 22-in'", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testAddProduct() {
        Product product = new Product();
        product.setPid(5);
        product.setPrice(23142);
        product.setCountryOrign("JAPAN");
        product.setPname("SONY Bravia 22-in");
        Product response = restTemplate.postForObject(baseUrl.concat("/addProduct"), product, Product.class);
        assertEquals("SONY Bravia 22-in", response.getPname());
        assertEquals(23142,response.getPrice());
        assertEquals(2, h2Repository.findAll().size());
    }

    @Test
    @Sql(statements = "INSERT INTO PRODUCT (pid,price, pname, country_orign) VALUES (4,35080,'JBL Speakers 320 watt', 'CHINA')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM PRODUCT WHERE pname='JBL Speakers 320 watt'", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testGetProducts() {
        List<Product> products = restTemplate.getForObject(baseUrl.concat("/getProducts"), List.class);
        assertEquals(2, products.size());
        assertEquals(2, h2Repository.findAll().size());
    }

    @Test
    @Sql(statements = "INSERT INTO PRODUCT (pid,price, pname, country_orign) VALUES (3,4321,'Headphones', 'FRANCE')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM PRODUCT WHERE pid=3", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testFindProductById() {
        Product product = restTemplate.getForObject(baseUrl.concat("/getProduct/{id}") , Product.class, 3);
        assertAll(
                () -> assertNotNull(product),
                () -> assertEquals(3, product.getPid()),
                () -> assertEquals("Headphones", product.getPname())
        );

    }

    @Test
    @Sql(statements = "INSERT INTO PRODUCT (pid,price, pname, country_orign) VALUES (13,56723,'Think Pad', 'CHINA')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM PRODUCT WHERE pid=3", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testUpdateProduct(){
        Product product = new Product();
        product.setPrice(56923);
        product.setPid(13);
        product.setPname("Think Pad");
        restTemplate.put(baseUrl+"/updateProduct", product);
        Product productFromDB = h2Repository.findById(product.getPid()).get();
        assertAll(
                () -> assertNotNull(productFromDB),
                () -> assertEquals(56923, productFromDB.getPrice())
        );



    }

    @Test
    @Sql(statements = "INSERT INTO PRODUCT (pid,price, pname, country_orign) VALUES (11,543,'Wireless Changer', 'CHINA')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void testDeleteProduct(){
        int recordCount=h2Repository.findAll().size();
        assertEquals(1, recordCount);
        restTemplate.delete(baseUrl+"/deleteProduct/{id}", 11);
        assertEquals(0, h2Repository.findAll().size());

    }

    @Test
    @Sql(statements = "DELETE FROM PRODUCT WHERE pid<50", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void testDeleteAllProducts(){
        int recordCount=h2Repository.findAll().size();
        assertEquals(0, recordCount);
        assertEquals(0, h2Repository.findAll().size());

    }

}
