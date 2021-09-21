import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Init {
    public static String ruta = "src/main/resources/Items.CSV";
    public static ArrayList<Item> items =new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        csvRead();
        showItems(items);
    }
    public static void showItems(ArrayList<Item> i){
        for (Item a:
             i) {
            a.show();
        }
    }

    public static void csvRead() throws FileNotFoundException {
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
        var builder=new CSVReaderBuilder(new FileReader(ruta));
        try (CSVReader reader =builder.withCSVParser(parser).withSkipLines(1).build()) {
            String[] nextLine = null;
            while ((nextLine = reader.readNext()) != null) {
                int id= Integer.parseInt(nextLine[0]);
                String nombre=nextLine[1];
                int precio= Integer.parseInt(nextLine[2]);
                int cantidad= Integer.parseInt(nextLine[2]);
                items.add(new Item(id, nombre, precio, cantidad));
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }


}
