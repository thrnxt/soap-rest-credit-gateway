package org.example.mvnsoap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.util.StreamUtils;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreditServiceIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String load(String path) throws Exception {
        ClassPathResource r = new ClassPathResource(path);
        return StreamUtils.copyToString(r.getInputStream(), StandardCharsets.UTF_8);
    }

    @Test
    void invalidIin_shouldReturnSoapFault() throws Exception {
        String requestXml = load("test-requests/invalid-iin-request.xml"); // создадим файл в resources/test-requests
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_XML);
        ResponseEntity<String> resp = restTemplate.postForEntity("/ws", new HttpEntity<>(requestXml, headers), String.class);
        assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(resp.getBody()).contains("Validation");
    }

    @Test
    void score720_shouldReturnApproved() throws Exception {
        String requestXml = load("test-requests/req-720.xml");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_XML);
        ResponseEntity<String> resp = restTemplate.postForEntity("/ws", new HttpEntity<>(requestXml, headers), String.class);
        assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resp.getBody()).contains("<cr:decision>APPROVED</cr:decision>");
        assertThat(resp.getBody()).contains("<cr:score>720</cr:score>");
    }

    @Test
    void score580_shouldReturnRejected() throws Exception {
        String requestXml = load("test-requests/req-580.xml");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_XML);
        ResponseEntity<String> resp = restTemplate.postForEntity("/ws", new HttpEntity<>(requestXml, headers), String.class);
        assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resp.getBody()).contains("<cr:decision>REJECTED</cr:decision>");
        assertThat(resp.getBody()).contains("<cr:score>580</cr:score>");
    }
}
