package com.dmytr0.mono.monostat.repository;

import com.dmytr0.mono.monostat.domain.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface StatementRepository extends JpaRepository<Statement, String> {

    @Query("SELECT MAX(s.time) FROM Statement s")
    Optional<LocalDateTime> findMaxTime();
}

