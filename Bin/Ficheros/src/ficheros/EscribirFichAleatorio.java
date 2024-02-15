package ficheros;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribirFichAleatorio {
    
 public static void main(String[] args) throws IOException {      
   File fichero = new File("C:\\Users\\alvar\\Downloads\\UD2_AccesoDatos (1)\\UT2_AccesoDatos\\EMPLEADOS.DAT"); //Declaración del fichero aleatorio
   RandomAccessFile file = new RandomAccessFile(fichero, "rw");
   
   //Declaración de los arrays que contienen los datos
   String nombre[] = {"Manuel","Carme","Arantxa","Paco", "Bruno"};
   String direccion[] = {"Rua das Orfas, 43, 44444444444","Praza do Toural, 5, 44444444444444444","Rua Paris, n21, 4444444444444","Praza de Europa, 13, 444444444", "Rua verde, 5, 4444444444444"};      
   Double salario[]={1700.5, 2000.2, 1400.5, 1900.0, 2200.2};  
   Double comision[]={600.5, 80.0, 300.2, 90.2, 95.9}; 
   StringBuffer bufferNombre = null; 
   StringBuffer bufferDireccion = null; 
   int n=nombre.length;      //Número de elementos que contiene el array
   
   for (int i=0;i<n; i++){     //Recorrido de los arrays          	  
    file.writeInt(i+1);   //Uso i+1 para identificar empleado (Código)
  
    bufferNombre = new StringBuffer(nombre[i]);      
    bufferNombre.setLength(10);     //10 caracteres que contiene el nombre, si tiene menos lo llenara y si tiene más los recortará.
    file.writeChars(bufferNombre.toString()); //Inserción del nombre

    bufferDireccion = new StringBuffer(direccion[i]);      
    bufferDireccion.setLength(20);     //20 caracteres que contiene la dirección
    file.writeChars(bufferDireccion.toString()); //Inserción de la dirección
    
    file.writeDouble(salario[i]);      //Inserción del salario
    file.writeDouble(comision[i]);     //Inserción de la comisión
    
    System.out.println("\nCODIGO: " + i);
    System.out.println("NOmbre: " + bufferNombre.toString());
    System.out.println("DIr: " + bufferDireccion.toString());
    System.out.println("SAL: " + salario[i]);
    System.out.println("COM: " + comision[i]);
    
   }     
   file.close();   //Cierre del fichero 
   }
   
}
