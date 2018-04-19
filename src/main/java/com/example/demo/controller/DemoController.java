package com.example.demo.controller;

import com.example.demo.models.dto.DemoDto;
import com.example.demo.models.entity.DemoEntity;
import com.example.demo.repository.DemoRepository;
import com.example.demo.repository.DemoSpecifications;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "/api/entities", consumes = "application/json")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private DemoRepository demoRepository;

    @PersistenceContext
    EntityManager entityManager;


    @GetMapping("/helloWorld")
    public ResponseEntity<String> helloWord() {
        return ResponseEntity.ok("Hello World!");
    }

    @PostMapping
    public ResponseEntity<DemoEntity> saveEntity(@RequestBody DemoDto demoDto) {
        DemoEntity build = DemoEntity.builder()
                .age(demoDto.getAge())
                .name(demoDto.getName())
                .male(demoDto.isMale())
                .build();
        return ResponseEntity.ok(demoService.saveDemoEntity(build));
    }

    @GetMapping
    public ResponseEntity<List<DemoEntity>> getEntities() {
       return ResponseEntity.ok(demoService.getEntities());
    }

    @GetMapping("/demo")
    public ResponseEntity<DemoEntity> getDemo() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

//        CriteriaQuery<DemoEntity> query = criteriaBuilder.createQuery(DemoEntity.class);
//        Root<DemoEntity> root = query.from(DemoEntity.class);

        Specification<DemoEntity> demoEntitySpecification = DemoSpecifications.demoSpecification1();
        List<DemoEntity> all = demoRepository.findAll(demoEntitySpecification);


//        query.where(demoEntitySpecification);
//        List<DemoEntity> resultList = entityManager.createQuery(query.select(root)).getResultList();
        return ResponseEntity.ok(all.get(0));
    }

    @DeleteMapping("/demo")
    @Transactional
    public void deleteDemo() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

//        CriteriaQuery<DemoEntity> query = criteriaBuilder.createQuery(DemoEntity.class);
        CriteriaDelete<DemoEntity> query = criteriaBuilder.createCriteriaDelete(DemoEntity.class);
        Root<DemoEntity> root = query.from(DemoEntity.class);

        Predicate isOlder = criteriaBuilder.gt(root.get("age"), 18);
        Predicate isStartWith = criteriaBuilder.like(root.get("name"), "Atis");
        Predicate isYounger = criteriaBuilder.le(root.get("age"), 30);

        query.where(criteriaBuilder.and(isOlder, isStartWith, isYounger));
        Query query1 = entityManager.createQuery(query);
        query1.executeUpdate();

    }


}
