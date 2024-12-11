package com.Group6.BackendApiProgress.user.Producer;

import com.Group6.BackendApiProgress.user.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Integer> {

}
