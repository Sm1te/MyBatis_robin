package com.robin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Introduce parameterless construction 、get、set、toString Other methods
@AllArgsConstructor // The parametric construction method is introduced
@NoArgsConstructor // Introduce the parameterless construction method
public class Teacher {

    private int id; // Teacher number
    private String name; // Teacher's name
}
