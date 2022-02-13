/*
 * Copyright (c) 2006-2019 Henri Tremblay.
 */
package interview.questions.question1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Please implement the {@link #mostPopularTicker(List)} method. With a sequential and a parallel algorithm.
 * DO NOT modify the existing code.
 */
public final class TransactionStatistics {

   public static class TickerPopularity {
      private String ticker;
      private double popularity;

      public String getTicker() {
         return ticker;
      }

      public void setTicker(String ticker) {
         this.ticker = ticker;
      }

      public double getPopularity() {
         return popularity;
      }

      public void setPopularity(double popularity) {
         this.popularity = popularity;
      }

      public TickerPopularity(String ticker, double popularity) {
         this.ticker = ticker;
         this.popularity = popularity;
      }

      public TickerPopularity() {

      }
   }
   /**
    * Return the most popular ticker in terms of transaction total absolute value (i.e. abs(price * quantity)). For example,
    * let's say we have these transactions:
    * <ul>
    *     <li>transaction("a", -10, 2.0)</li>
    *     <li>transaction("a", 20, 1.0)</li>
    *     <li>transaction("b", 5, 1.0)</li>
    *     <li>transaction("b", 10, 1.0)</li>
    *     <li>transaction("b", 10, 1.0)</li>
    * </ul>
    * The most popular one ticker is "a" with a traded value of 40 compared to b that only has 25.
    *
    * @param transactions List containing all transactions we want to look at
    * @return the most popular ticker
    */
   public static String mostPopularTicker(List<Transaction> transactions) {
      Map<String, List<Transaction>> data = categorizeTransactionsByTickerSymbol(transactions);
      List<TransactionStatistics.TickerPopularity> statistics = new ArrayList<>();

      for (Map.Entry<String, List<Transaction>> entry : data.entrySet()) {

         if (entry.getValue() == null) {
            continue;
         }

         double sum = entry.getValue().stream().filter(a -> a != null)
            .mapToDouble(t -> Math.abs(t.getPrice() * t.getQuantity()))
            .sum();

         statistics.add(new TickerPopularity(entry.getKey(), sum));
      }

      Optional<TickerPopularity> tickerPopularity = statistics.stream()
         .filter(a -> a != null)
         .max((a, b) -> (int) (a.getPopularity() - b.getPopularity()));

      if (tickerPopularity.isPresent()) {
         return tickerPopularity.get().getTicker();
      }

      return null;
   }

   public static String mostPopularTickerParallel(List<Transaction> transactions) {
      Map<String, List<Transaction>> data = categorizeTransactionsByTickerSymbol(transactions);
      List<TransactionStatistics.TickerPopularity> statistics = new ArrayList<>();

      for (Map.Entry<String, List<Transaction>> entry : data.entrySet()) {

         if (entry.getValue() == null) {
            continue;
         }

         double sum = entry.getValue().parallelStream().filter(a -> a != null)
            .mapToDouble(t -> Math.abs(t.getPrice() * t.getQuantity()))
            .sum();

         statistics.add(new TickerPopularity(entry.getKey(), sum));
      }

      Optional<TickerPopularity> tickerPopularity = statistics.parallelStream()
         .filter(a -> a != null)
         .max((a, b) -> (int) (a.getPopularity() - b.getPopularity()));

      if (tickerPopularity.isPresent()) {
         return tickerPopularity.get().getTicker();
      }

      return null;
   }

   public static Map<String, List<Transaction>> categorizeTransactionsByTickerSymbol
      (List<Transaction> transactions) {
      Map<String, List<Transaction>> map = new HashMap<>();

      transactions.forEach(transaction -> {

         if (transaction != null) {

            if (map.get(transaction.getTicker()) == null) {
               map.put(transaction.getTicker(), new ArrayList<>());
            }

            map.get(transaction.getTicker()).add(transaction);
         }
      });

      return map;
   }

   private TransactionStatistics()  {}


}
