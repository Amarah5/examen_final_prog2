package com.mahery;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notes {
  private double value;
  private Student student;
  private Exam exam;
  private Instant timestamp;
  private String motif;

}
