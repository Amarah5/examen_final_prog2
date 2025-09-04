package com.mahery;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Tuteur {
  private final int id;
  private String name, firstName, birthday, email, phoneNumber, descriptionLinkOfStudent;
}
