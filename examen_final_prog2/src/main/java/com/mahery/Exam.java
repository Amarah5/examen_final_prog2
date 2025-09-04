package com.mahery;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Exam {
  private final int id;
  private final String title;
  private final Course courseAttachment;
  private final LocalDateTime sessionOfExamen;
  private final int examCoefficient;
}
