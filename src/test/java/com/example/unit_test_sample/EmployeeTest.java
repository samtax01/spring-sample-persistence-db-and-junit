package com.example.unit_test_sample;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
public class EmployeeTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void helloTest() {
        webTestClient.get().uri("/hello")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(Integer.class)
            .hasSize(4);
    }


    @Test
    public void indexTest(){
//        EntityExchangeResult<List<Employee>> indexResult = webTestClient.get().uri("/api/v1/employees")
//            .accept(MediaType.APPLICATION_JSON)
//            .exchange()
//            .expectStatus().isOk()
//            .expectBodyList(Employee.class)
//            .returnResult();
//
//         List<Employee> employee = Collections.singletonList(
//                 Employee.builder()
//                         .firstName("Samson")
//                         .lastName("SiaSia")
//                         .jobTitle("Software Developer")
//                         .build()
//         );
//
//        assertEquals(employee, indexResult.getResponseBody());
    }




    @Test
    public void indexTest2(){
//        List<Employee> employee = Collections.singletonList(
//                Employee.builder()
//                        .firstName("Samson")
//                        .lastName("SiaSia")
//                        .jobTitle("Software Developer")
//                        .build()
//        );
//
//        webTestClient.get().uri("/api/v1/employees")
//            .accept(MediaType.APPLICATION_JSON)
//            .exchange()
//            .expectStatus().isOk()
//            .expectBodyList(Employee.class)
//            .consumeWith((response)-> assertEquals(employee, response.getResponseBody()));
    }




}
