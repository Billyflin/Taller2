import java.util.ArrayList;

public class Item {
    public static ArrayList<Item> items =new ArrayList<>();
    private final int Id;
    private final String Name;
    private final int Value;
    private final int Stock;

    public Item(int id, String name, int value, int stock) {
        Id = id;
        Name = name;
        Value = value;
        Stock = stock;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public int getStock() {
        return Stock;
    }

    public int getValue() {
        return Value;
    }

    @Override
    public String toString() {
        return  Id + ";" + Name + ';'+ Value +";" + Stock;
    }

    public void show() {
        System.out.println("-----------");
        System.out.println("Id: " + this.Id);
        System.out.println("Name: " + this.Name);
        System.out.println("Value: " + this.Value);
        System.out.println("Stock: " + this.Stock);
        System.out.println("-----------");
    }
}
