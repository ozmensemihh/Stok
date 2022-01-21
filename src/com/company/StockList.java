package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new HashMap<>();
    }

    public int addStock(StockItem item){
        if(item!=null){
            StockItem stockItem = list.getOrDefault(item.getName(),item);
            if(stockItem!=item){
                stockItem.addJustStock(item.getStock());
            }
            list.put(stockItem.getName(),stockItem);
            return stockItem.getStock();
        }
        return 0;
    }
    public int sellStock(String name,int adet){
        StockItem item = list.get(name);
        if ((item!=null)&&(adet>0)){
            return item.finalrezerced(adet);
        }


//        StockItem stockItem = list.getOrDefault(name,null);
//        if((stockItem!=null)&&(stockItem.getStock()>stock)&&stock>0){
//            stockItem.addJustStock(-stock);
//            return stock;
//        }
        return 0;

    }

    public int rezerveStock(String name,int adet){
        StockItem item = list.get(name);
        if ((item!=null)&&(adet>0)){
            return item.rezervedStock(adet);
        }
        return 0;
    }

    public int unrezerveStock(String name,int adet){
        StockItem item = list.get(name);
        if ((item!=null)&&(adet>0)){
            return item.unrezervedStock(adet);
        }
        return 0;
    }


    public Map<String ,StockItem>items(){
        return Collections.unmodifiableMap(list);
    }
    public StockItem get(String key){
        return list.get(key);
    }

    @Override
    public String toString() {
        String s = "\nStock Listesi\n";
        double toplam =0.0;
        for (Map.Entry<String,StockItem>item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemvalue = stockItem.getStock()*stockItem.getPrice();
            s= s + stockItem+" .  There are "+stockItem.getStock()+" in stock. Value in stock price";
            s=s+ String.format("%.0f",itemvalue)+"\n";
            toplam+=itemvalue;
        }
        return s+=" toplam :"+toplam;
    }
}
