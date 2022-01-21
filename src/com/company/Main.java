package com.company;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
	    StockItem temp = new StockItem("ekmek",2.50,250);
        stockList.addStock(temp);

        temp = new StockItem("kalem",0.50,100);
        stockList.addStock(temp);

        System.out.println(stockList);
        StockBasket sepet = new StockBasket("semih");
        sellItem(sepet,"kalem",20);
        System.out.println(sepet);
    }


    public static int sellItem(StockBasket basket,String item, int adet){
        StockItem stockItem = stockList.get(item);
        if(stockItem==null){
            System.out.println("Ürün bulunamadı"+stockItem.getName());
            return 0;
        }
        if (stockList.sellStock(item,adet)!=0){
            basket.addToBasket(stockItem,adet);
            return adet;
        }
        return 0;
    }

}
