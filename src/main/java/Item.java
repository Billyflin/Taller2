public class Item {
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
}
