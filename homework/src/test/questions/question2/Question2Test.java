package questions.question2;

import interview.questions.question2.Employee;
import interview.questions.question2.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(JUnit4.class)
public class Question2Test {

   @Test
   public void testEquality() {
      Employee employee1 = new Employee("Madhavi", 31, "Developer");
      Employee employee2 = new Employee("Praveen", 35, "Engineer");
      Employee employee3 = new Employee("Madhavi", 31, "Developer");

      Person person1 = new Person("Madhavi", 31);
      Person person2 = new Person("Praveen", 35);
      Person person3 = new Person("Madhavi", 31);

      assertEquals("Different Employee objects equal", employee1, employee3);
      assertEquals("Same Employee objects equal", employee1, employee1);
      assertNotEquals("Employee not equal", employee1, employee2);

      assertNotEquals("Employee and person not equal", employee1, person1);
      assertNotEquals("Two persons not equal", person1, person2);

      assertEquals("Two different person objects equal", person1, person3);
      assertEquals("Same person objects equal", person1, person1);
   }
}
