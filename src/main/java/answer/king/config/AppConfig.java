package answer.king.config;

import answer.king.controller.ItemController;
import answer.king.model.Item;
import answer.king.repo.ItemRepository;
import answer.king.service.ItemService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = {ItemRepository.class})
@ComponentScan(basePackageClasses = {ItemController.class, ItemService.class, Item.class})
public class AppConfig {

    public static void main(String[] args) {

        SpringApplication.run(AppConfig.class, args);

        AppConfig appConfig = new AppConfig();
        appConfig.createBurger();
        appConfig.createChips();
        appConfig.listItems();

        appConfig.createOrder();;
        appConfig.addBurgerToOrder();
        appConfig.addChipsToOrder();
        appConfig.payForOrder();
        
        appConfig.changePrice();

    }

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.H2);
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);

        Properties jpaProperties = new Properties();

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setDataSource(dataSource());
        factory.setPackagesToScan(Item.class.getPackage().getName());
        factory.setJpaProperties(jpaProperties);

        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }

    public void createBurger() {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost postRequest = new HttpPost("http://localhost:8888/item");
        try {
            StringEntity input = new StringEntity("{\"name\":\"burger\", \"price\":\"1.99\"},");
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
     }

    public void createChips() {

        DefaultHttpClient httpClient = new DefaultHttpClient();  //TODO add them to constructor 
        HttpPost postRequest = new HttpPost("http://localhost:8888/item");
        try {
            StringEntity input = new StringEntity("{\"name\":\"chips\", \"price\":\"0.99\"},");
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public void listItems() {

        //Listing Items
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet("http://localhost:8888/item");
            getRequest.addHeader("GET", "application/json");

            HttpResponse response = httpClient.execute(getRequest);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();

        } catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void createOrder() {

        DefaultHttpClient httpClient = new DefaultHttpClient();  //TODO add them to constructor 
        HttpPost postRequest = new HttpPost("http://localhost:8888/order");
        try {

            HttpResponse response = httpClient.execute(postRequest);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public void addBurgerToOrder() {

        DefaultHttpClient httpClient = new DefaultHttpClient();  //TODO add them to constructor 
        HttpPut putRequest = new HttpPut("http://localhost:8888/order/1/addItem/1");
        try {

            HttpResponse response = httpClient.execute(putRequest);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public void addChipsToOrder() {

        DefaultHttpClient httpClient = new DefaultHttpClient();  //TODO add them to constructor 
        HttpPut putRequest = new HttpPut("http://localhost:8888/order/1/addItem/2");
        try {
            HttpResponse response = httpClient.execute(putRequest);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public void payForOrder() {

        DefaultHttpClient httpClient = new DefaultHttpClient();  //TODO add them to constructor 
        HttpPut putRequest = new HttpPut("http://localhost:8888/order/1/pay");
        try {

            StringEntity input = new StringEntity("50.00");
            input.setContentType("application/json");
            putRequest.setEntity(input);

            HttpResponse response = httpClient.execute(putRequest);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
    
    
//    It is possible that somebody could try and create an Item with
//            invalid data (price and name), amend the code base so that this cannot happen,
//                    supporting unit tests will need to be written as part of the task

    public boolean isPossibleCreateItenWithInvData() {
        
         

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost postRequest = new HttpPost("http://localhost:8888/item");
        try {
            StringEntity input = new StringEntity("{\"name\":\"hamburger\", \"price\":\"6.99\"},");
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();
        } catch (MalformedURLException e) {

            e.printStackTrace();
            return false;
        } catch (IOException e) {

            e.printStackTrace();
            return false;

        }
        return true;
   

    }
    
    public boolean isPossibleCreateItenWithInvEntityData() {
        
         

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost postRequest = new HttpPost("http://localhost:8888/item");
        try {
            StringEntity input = new StringEntity("{\"namex\":\"hamburger\", \"pricex\":\"6.99\"},");
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();
        } catch (MalformedURLException e) {

            e.printStackTrace();
            return false;
        } catch (IOException e) {

            e.printStackTrace();
            return false;

        }
        return true;
    }
    
    
     public void changePrice() { //17

        DefaultHttpClient httpClient = new DefaultHttpClient();  //TODO add them to constructor 
        HttpPut putRequest = new HttpPut("http://localhost:8888/item/1/changePrice");
        try {

            StringEntity input = new StringEntity("12.00");
            input.setContentType("application/json");
            putRequest.setEntity(input);

            HttpResponse response = httpClient.execute(putRequest);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
     
         public void payForOrderInsufficientFunds() {

        DefaultHttpClient httpClient = new DefaultHttpClient();  //TODO add them to constructor 
        HttpPut putRequest = new HttpPut("http://localhost:8888//1/pay");
        try {

            StringEntity input = new StringEntity("1.00");
            input.setContentType("application/json");
            putRequest.setEntity(input);

            HttpResponse response = httpClient.execute(putRequest);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            if(output == null)
            {
                 System.out.println("It is not possible to pay with insufficient funds. Payment should be done with sufficient funds"); // (15) TODO
            }

            httpClient.getConnectionManager().shutdown();
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
    

}
