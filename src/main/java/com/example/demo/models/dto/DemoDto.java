package com.example.demo.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@AllArgsConstructor
public class DemoDto {

    private String name;
    private int age;
    private boolean male;

    @Tolerate
    public DemoDto() {}

}
