package tienda;

import java.util.Scanner;

public class TiendaFinal {
	
	public static void menu() {
		System.out.println("1- Alta de producto");
		System.out.println("2- Ingreso de stock");
		System.out.println("3- Registrar venta");
		System.out.println("4- Balance diario");
		System.out.println("5- --Salir--");
	
		System.out.print("\n Selecciona una opción: ");
	}
	public static void submenu1() {
        System.out.println("---Alta---");
        System.out.println("Seleccione tipo de producto");
        System.out.println("1- Televisor");
        System.out.println("2- Heladera");
        System.out.println("3- Lavarropa");
	}
	
	public static void main(String[] args) {
		
	    Scanner input = new Scanner(System.in);
	    int opcion;
	    do {
		System.out.println("////////Bienvenido a nuestra Tienda////////"+"\n");
		
		TiendaFinal.menu();
        opcion = input.nextInt();
        
        switch (opcion) {
        case 1:
        	
        	TiendaFinal.submenu1();
            int tipo = input.nextInt();
            
            	switch(tipo) {
            	case 1:
                    System.out.println("ingrese ID:\n");Integer id = input.nextInt();
                    input.nextLine();
                    System.out.println("ingrese Marca:\n");String marca = input.nextLine();
                    System.out.println("ingrese Modelo:\n");String modelo = input.nextLine();
                    System.out.println("ingrese Cantidad:\n");Integer cantidad = input.nextInt();
                    System.out.println("ingrese Precio:\n");Double precio = input.nextDouble();
                    System.out.println("ingrese Pulgadas:\n");Integer pulgadas = input.nextInt();
                    System.out.println("Es smart? si/no:\n");String texto = input.nextLine();
                    input.nextLine();
                    Boolean smart=null;
                    if (texto == "si") {
                    	smart = true;
                    }else smart = false;
                    
                    Televisor television = new Televisor(pulgadas,smart,precio,id,cantidad,marca,modelo);
                    break;//acá se añadiría el objeto a una coleccion
                    
            	case 2:
            		  /*
                    System.out.println("ingrese ID:\n");
                    Integer id=input.nextInt();
                    
                    System.out.println("ingrese Marca:\n");
                    String marca=input.nextLine();
                    
                    System.out.println("ingrese Modelo:\n");
                    String modelo = input.nextLine();
                    
                    System.out.println("ingrese Cantidad:\n");
                    Integer cantidad=input.nextInt();
                    
                    System.out.println("ingrese Precio:\n");
                    Double precio = input.nextDouble();
                    
                    Heladera heladera = new Heladera(////);
                    */
            		break;
            		
            	case 3:
            		  /*
                    System.out.println("ingrese ID:\n");
                    Integer id=input.nextInt();
                    
                    System.out.println("ingrese Marca:\n");
                    String marca=input.nextLine();
                    
                    System.out.println("ingrese Modelo:\n");
                    String modelo = input.nextLine();
                    
                    System.out.println("ingrese Cantidad:\n");
                    Integer cantidad=input.nextInt();
                    
                    System.out.println("ingrese Precio:\n");
                    Double precio = input.nextDouble();
                    
                    Lavarropa lavarropa = new lavarropa(///);
                    */
                    break;
            	}                   
            break;
        case 2:
            System.out.println("Has seleccionado la opción 2");
            
            break;
        case 3:
            System.out.println("Has seleccionado la opción 3");
            
            break;
        case 4:
            System.out.println("¡Adiós!");
            break;
        default:
            System.out.println("Opción inválida, intenta de nuevo.");
            break;
    }
		

	}while(opcion!=4);
  }
}
