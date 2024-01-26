package com.java.learning.reactiveprogramming;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class ReactiveProgrammingApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void testMono() {
        Mono<?> monoString = Mono.just("Swapy")
                .log();
        monoString.subscribe(e -> System.out.println(e));
    }

    @Test
    void testFlux() {
        Flux<?> fluxString = Flux.just("A", "X", "B", "C", "D").log();
        fluxString.subscribe(e -> System.out.println(e));
    }


}
