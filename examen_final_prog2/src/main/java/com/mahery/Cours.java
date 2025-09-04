package com.mahery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cours {
  private final int id;
  private String labelOfcourse;
  private int credit;
  private Enseignant enseignant;
}
