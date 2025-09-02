package com.apigate.mcp.oas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiRepository extends JpaRepository<Api, Long> {

    String findByDescription(String description);

    List<Api> findByLevel(int level);
}
