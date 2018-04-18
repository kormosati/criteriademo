package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DemoDto {

    private String name;
    private int age;
    private boolean male;

}
