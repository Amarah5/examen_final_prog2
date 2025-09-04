package com.mahery;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Course {
  private final int id;
  private String labelOfcourse;
  private int credit;
  private Enseignant enseignant;
}
