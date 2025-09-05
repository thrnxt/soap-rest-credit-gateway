package org.example.mvnsoap.mock;


import org.example.mvnsoap.client.ScoreRequest;
import org.example.mvnsoap.client.ScoreResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class MockCreditController {

    @PostMapping(value = "/score", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ScoreResponse score(@RequestBody ScoreRequest req) {
        int score;
        if (req.getRequestId() != null && req.getRequestId().contains("720")) {
            score = 720;
        } else if (req.getRequestId() != null && req.getRequestId().contains("580")) {
            score = 580;
        } else {
            score = Math.abs(req.getIin().hashCode() % 1000);
        }

        String decision = (score >= 650 && req.getAmount().compareTo(new BigDecimal("2000000")) <= 0) ? "APPROVED" : "REJECTED";
        return new ScoreResponse(req.getRequestId(), score, decision, "ok");
    }
}
