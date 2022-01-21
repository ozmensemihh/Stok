package com.company;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
	    StockItem temp = new StockItem("ekmek",2.50,250);
        stockList.addStock(temp);

        temp = new StockItem("kalem",0.50,100);
        stockList.addStock(temp);

        System.out.println(stockList);

    }
}
