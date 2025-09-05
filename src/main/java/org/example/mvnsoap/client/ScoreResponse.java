package org.example.mvnsoap.client;


public class ScoreResponse {
    private String requestId;
    private int score;
    private String decision;
    private String reason;

    public ScoreResponse() {}

    public ScoreResponse(String requestId, int score, String decision, String reason) {
        this.requestId = requestId;
        this.score = score;
        this.decision = decision;
        this.reason = reason;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
