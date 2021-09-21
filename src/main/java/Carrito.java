import java.util.ArrayList;
import java.util.Scanner;

public class Carrito {
    public static ArrayList<Item> carrito=new ArrayList<>();
    public void agregarAlCarrito(Item item){
        carrito.add(item);
    }
    public void showCarrito(){
        for (Item i:carrito) {
            i.show();
        }
    }
    public void eliminarItem(){
        System.out.println("Ingrese el índice del producto a eliminar");
        showCarrito();
        carrito.remove(getIndex());
        showCarrito();
    }

    private int getIndex() {
        return validar(carrito.size());
    }

    public static int validar(int x) {
        int n = -1;
        do {
            //Scanner ponerlo dentro del DO, y dentro de una funcion
            Scanner teclado = new Scanner(System.in);
            //System.out.println("ingrese otro numero");
            try {
                n = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("Error");
            }
            if (n < 0 || n > x) {
                System.out.println("Indice Erróneo");
            }
        } while (n < 0 || n > x);
        return n;
    }
}
