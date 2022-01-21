package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockBasket {
    private final String name;
    private Map<StockItem, Integer> list;

    public StockBasket(String name) {
        this.name = name;
        this.list = new HashMap<>();
    }
    public int addToBasket(StockItem item , int adet){
        if ((item !=null)&&  (adet>0)){
            int inBasket = list.getOrDefault(item,0);
            list.put(item,inBasket+adet);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem ,Integer> items(){
        return  Collections.unmodifiableMap(list);
    }

    public  int removeFromBasket(StockItem item, int adet){
        if ((item!= null)&&(adet>0)){
             int inBasket = list.getOrDefault(item,0);
             int newadet = inBasket+adet;
             if (newadet>0){
                 list.put(item,adet);
                 return adet;
             }else if(newadet==0){
                 list.remove(item);
                 return adet;
             }
        }
        return 0;
    }

    @Override
    public String toString() {
        String s ="\nShopping Basket\n";
        double total=0.0;
        for (Map.Entry<StockItem,Integer> item:list.entrySet()) {
            s= s+item.getKey()+" . "+ item.getValue()+"purchased \n";
            total+=item.getKey().getPrice()*item.getValue();
        }
        return s+" toplam:"+total;
    }
}
