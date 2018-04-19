package com.example.demo.service;

import com.example.demo.models.entity.DemoEntity;
import com.example.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    public DemoEntity saveDemoEntity(DemoEntity entity) {
        return demoRepository.save(entity);
    }

    public List<DemoEntity> getEntities() {
        return demoRepository.findAll();
    }

}
