package com.example.hw5;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class Controller {

    private final Repository repository;

    @GetMapping(value = "/page", produces = MediaType.TEXT_HTML_VALUE)
    public String getPage() {
        System.out.println(factorialHavingLargeResult(5000));
        System.out.println(calc());
        Collection<Entity> entities = repository.findAll();
        repository.save(new Entity(null, "Hello World!"));

        return String.format(
                """
                <html>\n 
                <header><title>Welcome</title></header>\n 
                    <body>\n 
                        "Hello world\n 
                   
                        %s \n 
                    </body>\n 
                </html>
                """, entities);
    }

    public double calc() {
        double res = 1;
        for (int i =1; i < 50000000; i++) {
            res = Math.tan(res);
        }
        return res;
    }

    public BigInteger factorialHavingLargeResult(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}