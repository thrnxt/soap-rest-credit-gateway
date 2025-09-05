package org.example.mvnsoap.client;


import java.math.BigDecimal;

public class ScoreRequest {
    private String requestId;
    private String iin;
    private String firstName;
    private String lastName;
    private BigDecimal amount;

    public ScoreRequest() {}

    public ScoreRequest(String requestId, String iin, String firstName, String lastName, BigDecimal amount) {
        this.requestId = requestId;
        this.iin = iin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
