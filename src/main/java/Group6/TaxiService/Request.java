package Group6.TaxiService;

import jakarta.persistence.*;

@Entity
public class Request {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int requestId;

    @Column(nullable = false)
    private String requestDetails;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private boolean isAccepted;

    public Request() {}

    public Request(String requestDetails, String customerName) {
        this.requestDetails = requestDetails;
        this.customerName = customerName;
        this.isAccepted = false; // Default value when created
    }

    // Getters and Setters
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getRequestDetails() {
        return requestDetails;
    }

    public void setRequestDetails(String requestDetails) {
        this.requestDetails = requestDetails;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
}

