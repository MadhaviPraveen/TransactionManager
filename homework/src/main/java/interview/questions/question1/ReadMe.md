#Task 
To implement 2 methods (1. single threaded, 2. multithreaded) to find out the most popular transactions.
#Plan
1. Create transactions and set up a test bed to meet the requirements
2. Write a common method 
   `Map<String, List<Transaction>> categorizeTransactionsByTickerSymbol(List<Transaction> transactions)` 
   that converts the transaction list (List<Transaction>) into a Map<String,List<Transaction>>, 
   where the String is the tickerSymbol and the list has its corresponding transactions
3. Call the above method in the single threaded method and calculate the popularities and find the ticker symbol with 
   the highest sum(price * quantity). Then find the ticker with the maximum popularity in a single threaded manner.
   i.e. I am planning to create a `public static class TickerPopularity` that holds the ticker symbol and sum of its 
   absolute popularities. I will then create a list of the TickerPopularities, `List<TickerPopularity>` 
   and use streams to find the max popularity.
4. Call the above method in the multi threaded method and calculate the popularities and find the ticker symbol with
   the highest sum(price * quantity). Then find the ticker with the maximum popularity in a single threaded manner.
   i.e. I am planning to create a `public static class TickerPopularity` that holds the ticker symbol and sum of its 
   absolute popularites. I will then create a list of the TickerPopularities, `List<TickerPopularity>` and use parallel streams to find the max
   popularity.

