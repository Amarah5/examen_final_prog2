package com.mahery;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
  private final int id;
  private String name, firstName, email, birthday, phoneNumber, groupe;
  private Tuteur tuteur;
  private List<Notes> notes;

}
