package com.INTIA.INTIA.assurance.Repository;

import ch.qos.logback.core.net.server.Client;
import com.INTIA.INTIA.assurance.Entities.Branche;
import com.INTIA.INTIA.assurance.Entities.Client_;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepo extends JpaRepository<Client_, Long> {
    List<Client_> findByBranche(Branche branche);
}
