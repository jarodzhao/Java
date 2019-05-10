package com.jarod.demo.dao;

import com.jarod.demo.domain.EmergencyNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface EmergencyNodeDao extends JpaRepository<EmergencyNode, Long> {

    EmergencyNode findByEmergencyId(String emergencyId);

    List<EmergencyNode> findAll();
}
