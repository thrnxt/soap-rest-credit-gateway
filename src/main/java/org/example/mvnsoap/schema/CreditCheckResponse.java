package org.example.mvnsoap.schema;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditCheckResponse", propOrder = {
        "requestId",
        "decision",
        "score",
        "comment"
})
@XmlRootElement(name = "CreditCheckResponse", namespace = "http://example.com/credit")
public class CreditCheckResponse {

    private String requestId;
    private String decision;
    private int score;
    private String comment;

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public String getDecision() { return decision; }
    public void setDecision(String decision) { this.decision = decision; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
