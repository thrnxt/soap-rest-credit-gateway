package org.example.mvnsoap.endpoint;


import org.example.mvnsoap.schema.CreditCheckRequest;
import org.example.mvnsoap.schema.CreditCheckResponse;
import org.example.mvnsoap.service.CreditCheckService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CheckCreditEndpoint {

    public static final String NAMESPACE = "http://example.com/credit";

    private final CreditCheckService service;

    public CheckCreditEndpoint(CreditCheckService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "CreditCheckRequest")
    @ResponsePayload
    public CreditCheckResponse checkCredit(@RequestPayload CreditCheckRequest request) {
        return service.checkCredit(request);
    }
}
