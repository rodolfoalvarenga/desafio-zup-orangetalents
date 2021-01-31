package com.rodolfoalvarengazup.zuplottery.repositories;

import com.rodolfoalvarengazup.zuplottery.entities.Betting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BettingRepository extends JpaRepository<Betting, Long> {
}
