package com.mahery;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Examen {

  private final int id;
  private String title;
  private Cours coursAttachemenent;
  private LocalDateTime sessionOfExamen;
  private int examenCoeffcicient;

  public double getExamGrade(Examen examen, Etudiant student, Instant t) {

  }

}
