package com.mahery;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

  public static double getExamGrade(Exam exam, Student student, Instant t) {
    if (student.getNotes() == null) {
      return 0.0;
    }
    Optional<Notes> latestNote = student.getNotes().stream()
        .filter(note -> note.getExam().equals(exam))
        .filter(note -> !note.getTimestamp().isAfter(t))
        .max(Comparator.comparing(Notes::getTimestamp));

    return latestNote.map(Notes::getValue).orElse(0.0);
  }

  public static double getCourseGrade(Course course, Student student, Instant t) {
    if (student.getNotes() == null) {
      return 0.0;
    }

    List<Exam> examsForCourse = student.getNotes().stream()
        .map(Notes::getExam)
        .filter(exam -> exam.getCourseAttachment().equals(course))
        .distinct()
        .collect(Collectors.toList());

    if (examsForCourse.isEmpty()) {
      return 0.0;
    }

    double totalPoints = 0;
    int totalCoefficients = 0;

    for (Exam exam : examsForCourse) {
      double examGrade = getExamGrade(exam, student, t);
      int coefficient = exam.getExamCoefficient();
      totalPoints += examGrade * coefficient;
      totalCoefficients += coefficient;
    }

    if (totalCoefficients == 0) {
      return 0.0;
    }

    return totalPoints / totalCoefficients;

  }
}
