package questions.question3;

import interview.questions.question3.Statistic;
import interview.questions.question3.StatisticsImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Question3Test {

   @Test
   public void testStatsImpl() {
      Statistic statistics = new StatisticsImpl();

      statistics.event(10);
      statistics.event(20);
      statistics.event(30);

      assertTrue("mean", 20 == statistics.mean());
      assertSame("max", statistics.maximum(), 30);
      assertSame("min", statistics.minimum(), 10);
      assertTrue("variance", statistics.variance() == 63.666668f);
   }

   @Test(expected = NoSuchElementException.class)
   public void testEmptyMean() {

      Statistic statistics = new StatisticsImpl();
      statistics.mean();
   }

   @Test(expected = NoSuchElementException.class)
   public void testEmptyMin() {

      Statistic statistics = new StatisticsImpl();
      statistics.minimum();
   }

   @Test(expected = NoSuchElementException.class)
   public void testEmptyMax() {

      Statistic statistics = new StatisticsImpl();
      statistics.maximum();
   }

   @Test(expected = NoSuchElementException.class)
   public void testEmptyVar() {

      Statistic statistics = new StatisticsImpl();
      statistics.variance();
   }
}
