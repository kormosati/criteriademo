package com.example.demo;

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
