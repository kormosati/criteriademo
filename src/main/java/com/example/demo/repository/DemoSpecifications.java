package com.example.demo.repository;

import com.example.demo.models.entity.DemoEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by attila.kormos on 2018. 04. 18..
 */
public class DemoSpecifications {

    public static Specification<DemoEntity> demoSpecification1() {
        return (Root<DemoEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
                Predicate isOlder = criteriaBuilder.gt(root.get("age"), 18);
                Predicate isStartWith = criteriaBuilder.like(root.get("name"), "Atis");
                Predicate isYounger = criteriaBuilder.le(root.get("age"), 30);
                return criteriaBuilder.and(isOlder, isStartWith, isYounger);
            };
        }
    }

