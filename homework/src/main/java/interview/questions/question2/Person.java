/*
 * Copyright (c) 2006-2019 Henri Tremblay.
 */
package interview.questions.question2;

import java.util.Objects;

public class Person {
    private final int age;
    private final String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + name + " has " + age + " years old";
    }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Person)) return false;
      Person person = (Person) o;
      return age == person.age && name.equals(person.name);
   }

   @Override
   public int hashCode() {
      return (this.name + "_" + this.age).hashCode();
   }

   public int getAge() {
      return age;
   }

   public String getName() {
      return name;
   }


}
