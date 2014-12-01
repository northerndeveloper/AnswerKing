/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answer.king.service;

import static com.jayway.restassured.RestAssured.expect;
import com.jayway.restassured.response.Response;
import groovyx.net.http.ContentType;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.matchers.JUnitMatchers.hasItems;

/**
 *
 * @author NTB-357
 */
public class OrderServiceTest {

    public OrderServiceTest() {
    }

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
     * Test of getAll method, of class OrderService.
     */
    @Test
    public void testGetAll() {
        expect().body("id", hasItems(1)).contentType(ContentType.JSON).when().get("http://localhost:8888/order");
        expect().body("paid", hasItems(false)).contentType(ContentType.JSON).when().get("http://localhost:8888/order");
        expect().body("items.id[0]", hasItems(1)).contentType(ContentType.JSON).when().get("http://localhost:8888/order");
        expect().body("items.name[0]", hasItems("burger")).contentType(ContentType.JSON).when().get("http://localhost:8888/order");
        expect().body("items.price[0]", hasItems(1.99)).contentType(ContentType.JSON).when().get("http://localhost:8888/order");
    }

    /**
     * Test of save method, of class OrderService.
     */
    @Test
    public void testSave() {

    }

    /**
     * Test of addItem method, of class OrderService.
     */
    @Test
    public void testAddItem() {

        Response response = expect().contentType(ContentType.JSON).when().put("http://localhost:8888/order/1/addItem/1");
        Assert.assertEquals(200, response.getStatusCode()); //Eger status 200 ise bu put isleminin basariyla gerceklestigini gosterir.

        response = expect().contentType(ContentType.JSON).when().put("http://localhost:8888/order/1/addItem/2");
        Assert.assertEquals(200, response.getStatusCode()); //Eger status 200 ise bu put isleminin basariyla gerceklestigini gosterir.

    }

    /**
     * Test of pay method, of class OrderService.
     */
    @Test
    public void testPay() {

//        expect().put("payment", new BigDecimal(50)).when().put("http://localhost:8888/order/1/pay");
//        Assert.assertEquals(200, response.getStatusCode()); //Eger status 200 ise bu put isleminin basariyla gerceklestigini gosterir.
    
    //    expect().contentType(ContentType.ANY).when().put("http://localhost:8888/order/1/pay");
}
}