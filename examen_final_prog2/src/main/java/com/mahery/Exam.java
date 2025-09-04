package com.mahery;

import java.time.Instant;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Exam {

  private final int id;
  private String title;
  private Course coursAttachemenent;
  private LocalDateTime sessionOfExamen;
  private int examenCoeffcicient;

  public double getExamGrade(Exam exam, Student student, Instant t) {
    return examenCoeffcicient;

  }

  public double getCourseGrade(Course course, Student student, Instant t) {
    return examenCoeffcicient;

  }

}
