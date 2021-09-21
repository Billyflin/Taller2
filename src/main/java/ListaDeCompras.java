import java.io.*;
import java.util.ArrayList;

public class ListaDeCompras {

    public static void main(String[] args) {

        var archivo = crear("src/main/resources/boveda.csv");
        var boleta = leer(archivo);
        mostrarBoleta(boleta);
    }

    public static void mostrarBoleta(ArrayList<String> boleta){

        var subTotal = 0;
        var iva = 0;
        System.out.println("Productos     " + "Cant     " + "Total P.");
        System.out.println("--------------------------------");
        for(int i = 0; i < boleta.size(); i++){

            var producto = boleta.get(i).split(";")[1];
            var cantidad = Integer.parseInt(boleta.get(i).split(";")[3]);
            var total = calcularTotal(boleta.get(i));

            subTotal += total;
            iva = (int) (subTotal * 0.19);
            System.out.println(producto + "    " + cantidad + "    " + total);
            System.out.println("--------------------------------");
        }
        System.out.println("Subtotal:         " + subTotal);
        System.out.println("IVA(19%):         " + iva);
        System.out.println("Total:         " + (subTotal + iva));
    }

    public static int calcularTotal(String linea){
        var precio = Integer.parseInt(linea.split(";")[2]);    //Split es un separador
        var cantidad = Integer.parseInt(linea.split(";")[3]);
        return precio * cantidad;
    }

    public static File crear(String ruta) {
        var archivo = new File(ruta);
        try {

            if(!archivo.exists()) {                 // exists() revisa que exista un archivo en la ruta
                if (!archivo.createNewFile()) {     // .createNewFile crea un archivo real en el pc
                    throw new IOException();
                }
            }
        } catch (IOException e) {
            System.err.println("Fallo al crear el archivo: " + e.getMessage());   // e.getMessage imprime información
                                                                                  // adicional sobre el error.
            return null;
        }
        return archivo;
    }

    public static ArrayList<String> leer(File archivo) {

        var informacion = new ArrayList<String>();
        String[] lineas;
        String cadena;

        try {
            if (!archivo.exists()) {
                throw new FileNotFoundException();
            }

            var lector = new BufferedReader(new FileReader(archivo));     // BufferedReader memoria temporal donde se
                                                                          // guardan las cosas

            while ((cadena = lector.readLine()) != null) {
                lineas = cadena.split("\n");
                informacion.add(lineas[0]);
            }

            lector.close();

        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo: " + e.getMessage());
            return null;
        } catch (IOException e) {
            System.err.println("Fallo al leer el archivo: " + e.getMessage());
        }

        return informacion;
    }

}
