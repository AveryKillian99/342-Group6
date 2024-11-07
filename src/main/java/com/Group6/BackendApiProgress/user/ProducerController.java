package com.Group6.BackendApiProgress.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producers")
public class ProducerController {
    @Autowired
    private ProducerService service;


    @GetMapping("/{producerId}")
    public Producer getProducerById(@PathVariable int producerId){
        return service.getProducerById(producerId);
    }
    @PostMapping("/new")
    public Producer addNewProducer(@RequestBody Producer producer) {
        return service.addNewProducer(producer);
    }

    @PutMapping("/update/{producerId}")
    public Producer updateProducer(@PathVariable int producerId, @RequestBody Producer producer){
        Producer updatedProducer = service.updateProducer(producerId, producer);
        return updatedProducer;  // return updated producer directly
    }


    @DeleteMapping("/delete/{producerId}")
    public List<Producer> deleteProducerById(@PathVariable int producerId){
        service.deleteProducerById(producerId);
        return service.getAllProducers();
    }

}
