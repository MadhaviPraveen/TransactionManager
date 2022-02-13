package questions.question1;


import interview.questions.question1.Transaction;
import interview.questions.question1.TransactionStatistics;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TransactionStatisticTest {

   private List<Transaction> transactionList;

   @Before
   public void load() {
      transactionList = new ArrayList<>();
      transactionList.add(Transaction.transaction("a", -10, 2.0));
      transactionList.add(Transaction.transaction("a", 20, 1.0));
      transactionList.add(Transaction.transaction("b", 5, 1.0));
      transactionList.add(Transaction.transaction("b", 10, 1.0));
      transactionList.add(Transaction.transaction("b", 10, 1.0));
   }

   @Test
   public void testCategorizeTransactionsByTickerSymbol() {
      Map<String, List<Transaction>> transactionMap
         = TransactionStatistics.categorizeTransactionsByTickerSymbol(transactionList);
      assertNotNull("size", transactionMap);
      assertEquals("a size", transactionMap.get("a").size(), 2);
      assertEquals("b size", transactionMap.get("b").size(), 3);
   }

   @Test
   public void testMostPopularTicker() {
      String tickerSymbol = TransactionStatistics.mostPopularTicker(transactionList);
      assertEquals("popular ticker", tickerSymbol, "a");
   }

   @Test
   public void testMostPopularTickerParallel() {
      String tickerSymbol = TransactionStatistics.mostPopularTickerParallel(transactionList);
      assertEquals("popular ticker", tickerSymbol, "a");
   }

}
