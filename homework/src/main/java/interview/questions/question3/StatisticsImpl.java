package interview.questions.question3;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class StatisticsImpl implements Statistic{
   private final List<Integer> data = new ArrayList<>();

   @Override
   public synchronized void event(int value) {
         data.add(value);
   }

   @Override
   public float mean() {
      if (data.isEmpty()) {
         throw new NoSuchElementException();
      }

      long sum = data.parallelStream().reduce(0, Integer::sum);
      long count = data.parallelStream().count();

      return sum/count;
   }

   @Override
   public int minimum() {
      if (data.isEmpty()) {
         throw new NoSuchElementException();
      }

      Optional<Integer> min =  data.parallelStream().min(Integer::compareTo);

      if (!min.isPresent()) {
         throw new NoSuchElementException();
      }

      return min.get();
   }

   @Override
   public int maximum() {
      if (data.isEmpty()) {
         throw new NoSuchElementException();
      }

      Optional<Integer> max =  data.parallelStream().max(Integer::compareTo);

      if (!max.isPresent()) {
         throw new NoSuchElementException();
      }

      return max.get();
   }

   @Override
   public float variance() {
      if (data.isEmpty()) {
         throw new NoSuchElementException();
      }

      float mean = this.mean();
      long count = data.parallelStream().count();

      return (float) this.data.parallelStream().mapToDouble(dat -> {
         return (Math.pow(dat - mean, 2) / count - 1);
      }).sum();

   }
}
