package org.example.mvnsoap.schema;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditCheckRequest", propOrder = {
        "requestId",
        "iin",
        "firstName",
        "lastName",
        "amount"
})
@XmlRootElement(name = "CreditCheckRequest", namespace = "http://example.com/credit")
public class CreditCheckRequest {
    @jakarta.xml.bind.annotation.XmlElement(namespace = "http://example.com/credit")
    private String requestId;
    @jakarta.xml.bind.annotation.XmlElement(namespace = "http://example.com/credit")
    private String iin;
    @jakarta.xml.bind.annotation.XmlElement(namespace = "http://example.com/credit")
    private String firstName;
    @jakarta.xml.bind.annotation.XmlElement(namespace = "http://example.com/credit")
    private String lastName;
    @jakarta.xml.bind.annotation.XmlElement(namespace = "http://example.com/credit")
    private BigDecimal amount;

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public String getIin() { return iin; }
    public void setIin(String iin) { this.iin = iin; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}
