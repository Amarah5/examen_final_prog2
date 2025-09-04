package com.mahery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Etudiant {
  private final int id;
  private String name, firstName, email, birthday, phoneNumber, groupe;
  private Tuteur tuteur;

}
