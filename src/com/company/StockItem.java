package com.company;

public class StockItem implements Comparable<StockItem> {
    private final  String name;
    private  double price;
    private int stock=0;
    private int rezerved=0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.stock=0;
    }

    public StockItem(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock-rezerved;
    }

    public void setPrice(double price) {
        if(price>0.0){
            this.price = price;
        }
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public  void addJustStock(int stock ){
        int yenistock = this.stock+stock;
        if(yenistock>=0){
            this.stock=yenistock;
        }
    }

    public int rezervedStock(int adet){
        if (adet<=getStock()){
            rezerved+=adet;
            return adet;
        }
        return 0;
    }
    public int unrezervedStock(int adet){
        if (adet<=rezerved){
            rezerved-=adet;
            return adet;
        }
        return 0;
    }

    public  int finalrezerced(int adet){
        if (adet<=rezerved){
            stock-=adet;
            rezerved-=adet;
            return adet;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj== this){
            return true;
        }
        if ((obj==null)||(obj.getClass() != this.getClass())){
            return false;
        }
        return this.name.equals(((StockItem)obj).getName());
    }

    @Override
    public int hashCode() {
        return this.name.hashCode()+10;
    }

    @Override
    public int compareTo(StockItem o) {
        if(this==o){
            return 0;
        }
        if(o!=null){
            this.name.compareTo(o.getName());
        }
        throw  new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : Price "+this.price+". Rezerve :"+this.rezerved;
    }
}
