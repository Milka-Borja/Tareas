package Tarea_S2;

public class Producto {
    String nombre;
    double precio;
    int cantidad;
    //Con parametros
    public Producto(String nombre, double precio, int cantidad){
        this.nombre=nombre;
        this.precio = precio;
        this.cantidad= cantidad;
    }
    //sin parámetros con valores directos
    public Producto(){
        nombre="Leche";
        precio=1.00;
        cantidad=2;
    }
    //vacio
    public Producto(boolean m ){

    }
    public void mostrar(){
        System.out.println("Nombre del producto: "+nombre+"\nPrecio: "+precio+"\nCantidad: "+cantidad);
    }
    public static void main(String[] args){
        Producto producto1= new Producto("Helado",1.00,3);
        Producto producto2= new Producto();
        Producto producto3= new Producto(true);
        producto3.nombre="Gaseosa";
        producto3.precio=1.00;
        producto3.cantidad=3;

        System.out.println("----Constructor con parametros----");
        producto1.mostrar();
        System.out.println("----Constructor sin parametros y valores fijos----");
        producto2.mostrar();
        System.out.println("----Constructor vacio----");
        producto3.mostrar();
    }
}

