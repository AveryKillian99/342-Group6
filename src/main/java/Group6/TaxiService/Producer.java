package Group6.TaxiService;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int producerId;

    @Column(nullable = false)
    private String producerName;

    @Column(nullable = false)
    private String producerEmail;

    @Column(nullable = false)
    private String producerPassword;


    public Producer(int producerId, String producerName, String producerType){
        this.producerId = producerId;
        this.producerName = producerName;
        this.producerEmail = producerEmail;
        this.producerPassword = producerPassword;

    }

    public Producer(String producerName, String producerType){
        this.producerName = producerName;
    }

    public Producer(){

    }

    // Constructors, Getters, and Setters (add for reviews as well)


    public int getProducerId(){return producerId;}

    public void setProducerId(int producerId){this.producerId=producerId;}

    public String getProducerName(){return producerName;}

    public void setProducerName(String producerName){this.producerName = producerName;}

    public String getProducerEmail(){return producerEmail;}

    public void setProducerEmail(String producerEmail){this.producerEmail=producerEmail;}

    public String getProducerPassword(){return producerPassword;}

    public void setProducerPassword(String producerPassword){this.producerPassword=producerPassword;}


}
