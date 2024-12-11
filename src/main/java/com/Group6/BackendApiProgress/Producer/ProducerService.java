package com.Group6.BackendApiProgress.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {
    @Autowired
    private ProducerRepository producerRepository;

    public List<Producer> getAllProducers(){return producerRepository.findAll();}

    public Producer getProducerById(int producerId) {
        return producerRepository.findById(producerId).orElse(null);
    }

    public Producer addNewProducer(Producer producer) {
        producerRepository.save(producer);
        return producer;
    }

    public Producer updateProducer(int producerId, Producer producer){
        Producer existing  = getProducerById(producerId);

        existing.setProducerName(producer.getProducerName());
        producerRepository.save(existing);
        return existing;
    }

    public void deleteProducerById(int producerId){
        producerRepository.deleteById(producerId);}


}
