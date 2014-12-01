/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answer.king.service;

import answer.king.repo.ItemRepository;
import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.response.Response;
import groovyx.net.http.ContentType;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.matchers.JUnitMatchers.hasItems;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author NTB-357
 */
public class ItemServiceTest {

    public ItemServiceTest() {
    }

    @Autowired
    private ItemRepository itemRepository;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAll method, of class ItemService.
     */
    @Test
    public void testGetAll() {
        expect().body("name", hasItems("burger")).contentType(ContentType.JSON).when().get("http://localhost:8888/item");
        expect().body("name", hasItems("chips")).contentType(ContentType.JSON).when().get("http://localhost:8888/item");
        expect().body("price", hasItems(1.99)).contentType(ContentType.JSON).when().get("http://localhost:8888/item");
        expect().body("price", hasItems(0.99)).contentType(ContentType.JSON).when().get("http://localhost:8888/item");
    }

    /**
     * Test of save method, of class ItemService.
     */
    @Test
    public void testSave() {

        Response post = given().param("name", "burger").contentType(ContentType.JSON).when().post("http://localhost:8888/item");
        assertEquals(200, post.getStatusCode());//200 baþarýlý kodu olduðu için geçti kabul ediyoruz
        
        post = given().param("price", "1.99").contentType(ContentType.JSON).when().post("http://localhost:8888/item");
        assertEquals(200, post.getStatusCode());//200 baþarýlý kodu olduðu için geçti kabul ediyoruz

    }

}
