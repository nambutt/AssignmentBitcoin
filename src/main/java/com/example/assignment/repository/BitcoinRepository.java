package com.example.assignment.repository;

import com.example.assignment.model.Bitcoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitcoinRepository extends JpaRepository <Bitcoin, Long> {
}
