package com.Group6.BackendApiProgress.user;

import jakarta.persistence.*;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;

    private String status;  // Active or assigned or completed or canceled

    @ManyToOne
    @JoinColumn(name = "consumer_id", nullable = false)
    private Consumer consumer;  // Each request is associated with a Consumer

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;  // A request can be assigned to a producer

    // Getters and Setters

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
