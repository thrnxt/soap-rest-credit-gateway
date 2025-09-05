package org.example.mvnsoap.service;


import org.example.mvnsoap.client.RestCreditClient;
import org.example.mvnsoap.client.ScoreResponse;
import org.example.mvnsoap.schema.CreditCheckRequest;
import org.example.mvnsoap.schema.CreditCheckResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreditCheckService {

    private final RestCreditClient restClient;

    public CreditCheckService(RestCreditClient restClient) {
        this.restClient = restClient;
    }

    public CreditCheckResponse checkCredit(CreditCheckRequest req) {
        Mono<ScoreResponse> mono = restClient.getScore(req.getRequestId(), req.getIin(), req.getFirstName(), req.getLastName(), req.getAmount());
        ScoreResponse scoreResp;
        try {
            scoreResp = mono.block();
        } catch (Exception ex) {
            CreditCheckResponse r = new CreditCheckResponse();
            r.setRequestId(req.getRequestId());
            r.setDecision("REJECTED");
            r.setScore(0);
            r.setComment("External scoring error: " + ex.getMessage());
            return r;
        }

        CreditCheckResponse resp = new CreditCheckResponse();
        resp.setRequestId(req.getRequestId());
        resp.setScore(scoreResp.getScore());
        resp.setDecision(scoreResp.getDecision());
        resp.setComment(scoreResp.getReason());
        return resp;
    }
}
