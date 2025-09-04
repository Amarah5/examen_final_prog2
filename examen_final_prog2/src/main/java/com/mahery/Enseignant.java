package com.mahery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Enseignant {
  private final int id;
  private String name, fristName, birthday, email, phoneNumber, speciality;

}
