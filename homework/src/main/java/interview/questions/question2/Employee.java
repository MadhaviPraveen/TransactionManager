/*
 * Copyright (c) 2006-2019 Henri Tremblay.
 */
package interview.questions.question2;

import java.util.Objects;

public class Employee extends Person {
    private final String role;

    public Employee(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Employee)) return false;
      if (!super.equals(o)) return false;
      Employee employee = (Employee) o;
      return role.equals(employee.role);
   }

   @Override
   public int hashCode() {
      return  (super.getName() + "-"
         + super.getAge() + "-"
         + this.role).hashCode();
   }
}
