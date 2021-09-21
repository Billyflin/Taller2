import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Init {
    public static String ruta = "src/main/resources/Items.CSV";

    public static void main(String[] args) throws FileNotFoundException {
        menu();
    }

    public static void showItems(ArrayList<Item> i){
        for (Item a:i) {
            a.show();
        }
    }

    public static void menu() throws FileNotFoundException {
        csvRead();
        int x;
        do{
            System.out.println("MENU");
            System.out.println("-------------------------------------");
            System.out.println("[1] Guardar la boleta en archivo txt");
            System.out.println("[2] Modificar cantidad de un producto");
            System.out.println("[3] Eliminar un producto de la lista");
            System.out.println("[4] Análisis de la lista de compra");
            System.out.println("[0] SALIR");
            menuswitch();
            System.out.println("Desea realizar otra acción (No (0) / Si (1))");
            x= Carrito.validar(1);
        }while (x!=0);

    }
    public static void menuswitch(){
        switch (Carrito.validar(6)) {
            case 0 -> System.out.println("Gracias!");
            case 1 -> showItems(Item.items);
//            case 2 -> ();
//            case 3 -> ();
//            case 4 -> ();
        }
    }

    public static void csvRead() throws FileNotFoundException {
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
        var builder=new CSVReaderBuilder(new FileReader(ruta));
        try (CSVReader reader =builder.withCSVParser(parser).withSkipLines(1).build()) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                int id= Integer.parseInt(nextLine[0]);
                String nombre=nextLine[1];
                int precio= Integer.parseInt(nextLine[2]);
                int cantidad= Integer.parseInt(nextLine[3]);
                Item.items.add(new Item(id, nombre, precio, cantidad));
            }
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }


}
