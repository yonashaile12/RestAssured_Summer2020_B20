package Interview_Parctice;

public class POJO {

    private int id;
    private String name;
    private long updated_at;
    private int price;
    private String manufacturer;

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public long getUpdated_at(){
        return updated_at;
    }
    public int getPrice(){
        return price;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public String toString(){
        return "id "+id+"\n name "+name
                +" \nupdatedId "+updated_at
                +" \nPrice "+price
                +" \nmanufacturer "+manufacturer;
    }

}
