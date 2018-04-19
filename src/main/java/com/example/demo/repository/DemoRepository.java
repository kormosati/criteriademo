package com.example.demo.repository;

import com.example.demo.models.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<DemoEntity, String>, JpaSpecificationExecutor<DemoEntity> {
}
