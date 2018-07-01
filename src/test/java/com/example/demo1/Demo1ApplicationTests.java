package com.example.demo1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class Demo1ApplicationTests {

    @LocalServerPort
    private int port ;

    private URL base;

    @Autowired
    private TestRestTemplate template ;

    @Before
    public  void  setUp()  throws Exception{
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void contextLoads() {
        ResponseEntity<String> resp = template.getForEntity(base.toString(),String.class);
        Assert.isTrue("Greetings from Spring Boot!".equals(resp.getBody())
                ,"返回不通过");
    }

}
