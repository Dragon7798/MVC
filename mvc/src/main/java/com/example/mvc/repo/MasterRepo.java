package com.example.mvc.repo;

import com.example.mvc.model.QueryStatusMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepo extends JpaRepository<QueryStatusMaster, Integer> {
}
