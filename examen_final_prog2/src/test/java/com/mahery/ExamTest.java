package com.mahery;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExamTest {

  private Student student;
  private Course prog2;
  private Exam midterm;
  private Exam finalExam;

  private final Instant timeOfMidtermGrade = Instant.parse("2023-10-20T10:00:00Z");
  private final Instant timeOfFinalExamGrade = Instant.parse("2023-12-15T10:00:00Z");
  private final Instant timeOfGradeCorrection = Instant.parse("2023-12-20T14:00:00Z");
  private final Instant timeAfterAllChanges = Instant.parse("2024-01-01T00:00:00Z");
  private final Instant timeBeforeAnyGrades = Instant.parse("2023-01-01T00:00:00Z");

  @BeforeEach
  void setUp() {
    prog2 = new Course(1, "PROG2", 6, null);
    midterm = new Exam(101, "Midterm", prog2, LocalDateTime.now(), 2);
    finalExam = new Exam(102, "Final", prog2, LocalDateTime.now(), 3);

    student = new Student(1, "RAZAFIMANANTSOA", "Mahery", "mahery@gmail.com", "2000-01-01", "+26618821223", "K4", null,
        new ArrayList<>());

    List<Notes> notes = List.of(
        new Notes(10.0, student, midterm, timeOfMidtermGrade, "Initial grade"),
        new Notes(12.0, student, finalExam, timeOfFinalExamGrade, "Initial grade"),
        new Notes(15.0, student, finalExam, timeOfGradeCorrection, "Correction after review"));
    student.setNotes(notes);
  }

  @Test
  void testGetExamGrade_beforeGradeIsEntered() {
    double grade = Exam.getExamGrade(midterm, student, timeBeforeAnyGrades);
    assertEquals(0.0, grade, "Grade should be 0 before any notes are entered.");
  }

  @Test
  void testGetExamGrade_getsInitialGrade() {
    double grade = Exam.getExamGrade(finalExam, student, timeOfFinalExamGrade);
    assertEquals(12.0, grade, "Should retrieve the initial grade of 12.0 for the final exam.");
  }

  @Test
  void testGetExamGrade_getsCorrectedGrade() {
    double grade = Exam.getExamGrade(finalExam, student, timeAfterAllChanges);
    assertEquals(15.0, grade, "Should retrieve the corrected grade of 15.0 for the final exam.");
  }

  @Test
  void testGetCourseGrade_withInitialFinalExamGrade() {
    double courseGrade = Exam.getCourseGrade(prog2, student, timeOfFinalExamGrade);
    assertEquals(11.2, courseGrade,
        "Course grade should be the weighted average of midterm and initial final exam grade.");
  }

  @Test
  void testGetCourseGrade_withCorrectedFinalExamGrade() {
    double courseGrade = Exam.getCourseGrade(prog2, student, timeAfterAllChanges);
    assertEquals(13.0, courseGrade, "Course grade should be the weighted average with the corrected final exam grade.");
  }
}
