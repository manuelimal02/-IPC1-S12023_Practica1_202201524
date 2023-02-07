
package com.mycompany.super_25;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author manuel
 */

class Producto{
    String nombre;
    double precio;
    int contadorReporte;
    int contadorFactura;
}
class Descuento{
    String codigo;
    double porcentaje;
}

public class SUPER_25 {
   
    public static Scanner entrada = new Scanner(System.in);
    public static Scanner entradaNum = new Scanner(System.in);
    public static Scanner entradaPrecio = new Scanner(System.in);
    public static Producto listaProducto[] = new Producto[1000];
    public static Descuento listaDescuento[] = new Descuento[1000];
    
    public static void main(String[] args) {
       
       String usuario = "";
       String contra = "";
       String opcion = "";
       
        do{
            System.out.println("--------------------------------------------------------------");
            System.out.println("Ingrese el Usuario:");
            usuario = entrada.nextLine();

            System.out.println("Ingrese la Contraseña:");
            contra = entrada.nextLine();
        
            if(!usuario.equals("cajero_202201524") || !contra.equals("ipc1_202201524")){
                System.out.println("--------------------------------------------------------------");
                System.out.println("Sus credenciales son incorrectas. Inténtelo de nuevo.");
            }
        }while(!usuario.equals("cajero_202201524") || !contra.equals("ipc1_202201524"));
        
        while(!opcion.equals("5")){
            System.out.println("--------------------------------------------------------------");
            System.out.println("Bienvenido al Menú Principal. Ingresa el número de Una Opción.");
            System.out.println("1. Agregar Nuevos Productos.");
            System.out.println("2. Agregar Cupones de Descuento.");
            System.out.println("3. Realizar Venta.");
            System.out.println("4. Realizar Reporte.");
            System.out.println("5. Salir del Menú Principal.");
            opcion = entrada.nextLine();
            
            switch(opcion){
                case "1":
                    IngresoProducto();
                break;
                    
                case "2":
                    IngresoCupones();
                break;
                    
                case "3":
                    Ventas(); 
                break;
                    
                case "4":
                    Reporte();   
                break;
                
                default:
                    System.out.println("NO HA SELECCIONADO NINGUNA OPCIÓN");
                    
            }
            
        } 
    }
    
    public static void IngresoProducto(){
        
        int contador1=0, contador2=0;
        double precio;
        System.out.println("--------------------------------------------------------------");
        System.out.println("Agregar Nuevos Productos");
        /*PARA EL NOMBRE*/
        System.out.println("Ingrese El Nombre del Produto:");
        String nombre = entrada.nextLine();
        for(int i=0; i<listaProducto.length; i++){
            if(listaProducto[i]==null){
                break;
            }else{
                while(listaProducto[i].nombre.equals(nombre)==true){
                    i=0;
                    System.out.println("---------------------------------");
                    System.out.println("Ingrese un Nuevo Producto (El Producto Ya Existe): ");
                    nombre = entrada.nextLine();
                }  
            }  
        }
        /*PARA EL PRECIO*/
        System.out.println("Ingrese El Precio del Produto:");
        precio = entradaPrecio.nextDouble();
        while(precio<=0){
            System.out.println("---------------------------------");
            System.out.println("Ingrese Un Precio Mayor a Cero:");
            precio = entradaPrecio.nextDouble();
        }
        /*PARA INGRESAR EL PRODUCTO*/
        Producto productoNuevo = new Producto();
        productoNuevo.nombre=nombre;
        productoNuevo.precio=precio;
        productoNuevo.contadorReporte=contador1;
        productoNuevo.contadorFactura=contador2;
        
        for(int i=0; i<listaProducto.length; i++){
            if(listaProducto[i]==null){
                listaProducto[i]= productoNuevo;
                break;
            }
        }
        System.out.println("---------------------------------");
        System.out.println("Producto Ingresado Correctamente. La Lista de Productos es:");
        
        for(int i=0; i<listaProducto.length; i++){
            if(listaProducto[i]==null){
                break;
            }
            System.out.println("Nombre: "+listaProducto[i].nombre+" - Precio: "+ listaProducto[i].precio);
        }
        
    }
    
    public static void IngresoCupones(){   
        String codigo;
        long caracterCodigo;
        int descuento;
        System.out.println("--------------------------------------------------------------");
        System.out.println("Agregar Cupones de Descuento.");
        /*PARA LOS CARACTERES DEL DESCUENTO*/
        System.out.println("Ingrese El Código de Descuento:");
        codigo = entrada.nextLine();  
        caracterCodigo = codigo.chars().filter(ch -> ch != ' ').count();
        while(caracterCodigo!=4){
            System.out.println("---------------------------------");
            System.out.println("Ingrese un Código de Descuento de 4 Carácteres: ");
            codigo = entrada.nextLine();
            caracterCodigo = codigo.chars().filter(ch -> ch != ' ').count();
        }
        /*PARA VEREFICAR SI EL DESCUENTO EXISTE*/
        for(int i=0; i<listaDescuento.length; i++){
            if(listaDescuento[i]==null){
                break;
            }else{
                while(listaDescuento[i].codigo.equals(codigo)==true){
                    i=0;
                    System.out.println("---------------------------------");
                    System.out.println("Ingrese un Código de Descuento (El Código de Descuento Ya Existe): ");
                    codigo = entrada.nextLine();
                    caracterCodigo = codigo.chars().filter(ch -> ch != ' ').count();
                    while(caracterCodigo!=4){
                        System.out.println("---------------------------------");
                        System.out.println("Ingrese un Código de Descuento de 4 Carácteres: ");
                        codigo = entrada.nextLine();
                        caracterCodigo = codigo.chars().filter(ch -> ch != ' ').count();
                    }
                }  
            }  
        }
        /*PARA EL VALOR DEL DESCUENTO*/
        System.out.println("Ingrese El Valor Del Descuento en (%): ");
        descuento = entradaNum.nextInt();
        while(descuento<=0 || descuento>99){
            System.out.println("---------------------------------");
            System.out.println("Ingrese Un Valor de Descuento Mayor a Cero O Menor a 100:");
            descuento = entradaNum.nextInt();
        }
        double porcentaje = descuento*0.01;
        /*PARA REGISTRAR EL CUPON DE DESCUENTO*/
        Descuento descuentoNuevo = new Descuento();
        descuentoNuevo.codigo=codigo;
        descuentoNuevo.porcentaje=porcentaje;
        
        for(int i=0; i<listaDescuento.length; i++){
            if(listaDescuento[i]==null){
                listaDescuento[i]= descuentoNuevo;
                break;
            }
        }
        System.out.println("---------------------------------");
        System.out.println("Cupón Ingresado Correctamente. La Lista de Cupones es:");
        for(int i=0; i<listaDescuento.length; i++){
            if(listaDescuento[i]==null){
                break;
            }
            System.out.println("Codigo: "+listaDescuento[i].codigo+" - Descuento: "+ listaDescuento[i].porcentaje*100+" %");
        }
    }
    public static void Ventas(){
        String cliente, nombre, codigo;
        long nit;
        int opcion, compra, cantidad=0, opcion1;
        double subtotal=0,total=0, porcentaje=0;
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("Realizar Venta.");
        System.out.println("Ingrese el Nombre del Cliente: ");
        cliente = entrada.nextLine();
        System.out.println("Desea Agregar NIT: ");
        System.out.println("1. SI ");
        System.out.println("2. NO ");
        opcion = entradaNum.nextInt();
        
        switch(opcion){
            case 1:
                for (int t = 0; t <listaProducto.length; t++) {
                    if(listaProducto[t]==null){
                        break;
                    }else{
                        listaProducto[t].contadorFactura=0;
                    }
                }
                System.out.println("Ingresar Número de NIT: ");
                nit = entradaNum.nextLong();
                System.out.println("---------------------------------");
                System.out.println("Lista de Productos En el Inventario");
                for(int i=0; i<listaProducto.length; i++){
                    if(listaProducto[i]==null){
                        break;
                    }
                    System.out.println("Producto: "+listaProducto[i].nombre+" - Precio: Q. "+listaProducto[i].precio);
                }
                do{
                    
                    System.out.println("Ingrese el Nombre del Producto:");
                    nombre = entrada.nextLine();
                    
                    System.out.println("Ingrese la cantidad de "+nombre+" que desea comprar:");
                    cantidad = entradaNum.nextInt();
                    
                    for(int i=0; i<listaProducto.length; i++){
                        if(listaProducto[i]==null){
                            break;
                        }else if(listaProducto[i].nombre.equals(nombre)==true){
                            listaProducto[i].contadorFactura=listaProducto[i].contadorFactura+cantidad;
                            listaProducto[i].contadorReporte=listaProducto[i].contadorReporte+cantidad;
                            subtotal=subtotal+(cantidad*listaProducto[i].precio);
                            System.out.println("Su SubTotal es: Q. "+subtotal);
                        }    
                    }                  
                    System.out.println("Desea Realizar Otra Compra: ");
                    System.out.println("1. SI ");
                    System.out.println("2. NO ");
                    compra = entradaNum.nextInt();
                }while(compra!=2);
                
                System.out.println("Su SubTotal de la Compra: "+subtotal);
                System.out.println("---------------------------------");
                System.out.println("Desea Agregar un Cupón de Descuento: ");
                System.out.println("1. SI ");
                System.out.println("2. NO ");
                opcion1 = entradaNum.nextInt();               
                if(opcion1==1){
                    System.out.println("Ingrese el Código De Descuento:");
                    codigo= entrada.nextLine();  
                    for(int i=0; i<listaDescuento.length; i++){
                        if(listaDescuento[i]==null){
                            break;
                        }else if(listaDescuento[i].codigo.equals(codigo)==true){
                            total=subtotal-(listaDescuento[i].porcentaje*subtotal);
                            porcentaje=(listaDescuento[i].porcentaje*100);
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("Factura Electrónica");
                            System.out.println("SUPER-25 A.S.");
                            System.out.println("Cajero: Carlos Manuel Lima Y Lima");
                            System.out.println("Cliente: "+cliente);
                            System.out.println("NIT: "+nit);
                            DateTimeFormatter hora = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
                            System.out.println(hora.format(LocalDateTime.now()));
                            System.out.println("--------------------------------------------------------------");
                                for(int j=0; j<listaProducto.length; j++){
                                    if(listaProducto[j]==null){
                                    break;
                                }else if(listaProducto[j].contadorFactura>0){
                                    System.out.println("Producto: "+listaProducto[j].nombre+" - Precio: Q."+ listaProducto[j].precio+" - Cantidad: "+listaProducto[j].contadorFactura);
                                } 
                            }
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("El Subtotal es: "+subtotal);
                            System.out.println("El Porcentaje de Descuento es: "+porcentaje+" %");
                            System.out.println("Su Total es: "+total);
                        }
                    } 
                }else{
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Factura Electrónica");
                    System.out.println("SUPER-25 A.S.");
                    System.out.println("Cajero: Carlos Manuel Lima Y Lima");
                    System.out.println("Cliente: "+cliente);
                    System.out.println("NIT: "+nit);
                    DateTimeFormatter hora = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
                    System.out.println(hora.format(LocalDateTime.now()));
                    System.out.println("--------------------------------------------------------------");
                    for(int j=0; j<listaProducto.length; j++){
                            if(listaProducto[j]==null){
                                break;
                            }else if(listaProducto[j].contadorFactura>0){
                                System.out.println("Producto: "+listaProducto[j].nombre+" - Precio: Q."+ listaProducto[j].precio+" - Cantidad: "+listaProducto[j].contadorFactura);
                            } 
                        }
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("El Subtotal es: "+subtotal);
                    System.out.println("El Porcentaje de Descuento es: "+porcentaje+" %");
                    System.out.println("Su Total es: "+subtotal);    
                }
            break;
            
            case 2:
                for (int t = 0; t <listaProducto.length; t++) {
                    if(listaProducto[t]==null){
                        break;
                    }else{
                        listaProducto[t].contadorFactura=0;
                    }
                }
                System.out.println("C/F ");
                System.out.println("---------------------------------");
                System.out.println("Lista de Productos En el Inventario");
                for(int i=0; i<listaProducto.length; i++){
                    if(listaProducto[i]==null){
                        break;
                    }
                    System.out.println("Producto: "+listaProducto[i].nombre+" - Precio: Q."+listaProducto[i].precio);
                }
                do{
                    System.out.println("---------------------------------");
                    System.out.println("Ingrese el Nombre del Producto:");
                    nombre = entrada.nextLine();
                    
                    System.out.println("Ingrese la cantidad de "+nombre+" que desea comprar:");
                    cantidad = entradaNum.nextInt();
                    
                    for(int i=0; i<listaProducto.length; i++){
                        if(listaProducto[i]==null){
                            break;
                        }else if(listaProducto[i].nombre.equals(nombre)==true){
                            listaProducto[i].contadorFactura=listaProducto[i].contadorFactura+cantidad;
                            listaProducto[i].contadorReporte=listaProducto[i].contadorReporte+cantidad;
                            subtotal=subtotal+(cantidad*listaProducto[i].precio);
                            System.out.println("Su SubTotal es: Q. "+subtotal);
                        }    
                    }                    
                    System.out.println("---------------------------------");
                    System.out.println("Desea Realizar Otra Compra: ");
                    System.out.println("1. SI ");
                    System.out.println("2. NO ");
                    compra = entradaNum.nextInt();
                }while(compra!=2);
                System.out.println("---------------------------------");
                System.out.println("Su SubTotal de la Compra: "+subtotal);
                System.out.println("---------------------------------");
                System.out.println("Desea Agregar un Cupón de Descuento: ");
                System.out.println("1. SI ");
                System.out.println("2. NO ");
                opcion1 = entradaNum.nextInt();               
                if(opcion1==1){
                    System.out.println("Ingrese el Código De Descuento:");
                    codigo= entrada.nextLine();  
                    for(int i=0; i<listaDescuento.length; i++){
                        if(listaDescuento[i]==null){
                            break;
                        }else if(listaDescuento[i].codigo.equals(codigo)==true){
                            total=subtotal-(listaDescuento[i].porcentaje*subtotal);
                            porcentaje=(listaDescuento[i].porcentaje*100);
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("Factura Electrónica");
                            System.out.println("SUPER-25 A.S.");
                            System.out.println("Cajero: Carlos Manuel Lima Y Lima");
                            System.out.println("Cliente: "+cliente);
                            System.out.println("NIT: C/F");
                            DateTimeFormatter hora = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
                            System.out.println(hora.format(LocalDateTime.now()));
                            System.out.println("--------------------------------------------------------------");
                            for(int j=0; j<listaProducto.length; j++){
                                if(listaProducto[j]==null){
                                    break;
                                }else if(listaProducto[j].contadorFactura>0){
                                    System.out.println("Producto: "+listaProducto[j].nombre+" - Precio: Q."+ listaProducto[j].precio+" - Cantidad: "+listaProducto[j].contadorFactura);
                                }    
                            }
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("El Subtotal es: "+subtotal);
                            System.out.println("El Porcentaje de Descuento es: "+porcentaje+" %");
                            System.out.println("Su Total es: "+total);
                        }
                    } 
                }else{
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Factura Electrónica");
                    System.out.println("SUPER-25 A.S.");
                    System.out.println("Cajero: Carlos Manuel Lima Y Lima");
                    System.out.println("Cliente: "+cliente);
                    System.out.println("NIT: C/F");
                    DateTimeFormatter hora = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
                    System.out.println(hora.format(LocalDateTime.now()));
                    System.out.println("--------------------------------------------------------------");
                    for(int j=0; j<listaProducto.length; j++){
                            if(listaProducto[j]==null){
                                break;
                            }else if(listaProducto[j].contadorFactura>0){
                                System.out.println("Producto: "+listaProducto[j].nombre+" - Precio: Q."+ listaProducto[j].precio+" - Cantidad: "+listaProducto[j].contadorFactura);
                            } 
                        }
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("El Subtotal es: "+subtotal);
                    System.out.println("El Porcentaje de Descuento es: "+porcentaje+" %");
                    System.out.println("Su Total es: "+subtotal);    
                }
                
            break;
                
            default:
                System.out.println("NO HA SELECCIONADO NINGUNA OPCIÓN");   
        }         
    }
    
    public static void Reporte(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("Realizar Reporte.");
        for (int i = 0; i <listaProducto.length; i++) {
            for (int j = 0; j <listaProducto.length-1; j++) {
                if(listaProducto[j]==null || listaProducto[j+1]==null){
                    break;
                }
                Producto productoActual= listaProducto[j+1];
                Producto productoSiguiente= listaProducto[j];
                if(productoActual.contadorReporte>productoSiguiente.contadorReporte){
                    listaProducto[j+1]=productoSiguiente;
                    listaProducto[j]=productoActual;
                }
            }     
        }
        for(int i=0; i<listaProducto.length; i++){
            if(listaProducto[i]==null){
                break;
            }
            System.out.println("Producto: "+listaProducto[i].nombre+" - Precio: "+ listaProducto[i].precio+" - Cantidad De Veces Vendido: "+listaProducto[i].contadorReporte);
        } 
    }
    
}
