package com.mahery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Tuteur {
  private final int id;
  private String name, firstName, birthday, email, phoneNumber, descriptionLinkOfStudent;

}
