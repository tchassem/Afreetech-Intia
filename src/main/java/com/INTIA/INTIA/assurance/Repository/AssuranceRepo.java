package com.INTIA.INTIA.assurance.Repository;

import ch.qos.logback.core.net.server.Client;
import com.INTIA.INTIA.assurance.Entities.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssuranceRepo extends JpaRepository<Assurance, Long> {
    List<Assurance> findByClient(Client client);
}
