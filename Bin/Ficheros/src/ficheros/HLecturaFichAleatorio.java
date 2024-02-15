package ficheros;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class HLecturaFichAleatorio {
public static void main(String[] args) throws IOException {     
   File fichero = new File("C:\\Users\\alvar\\Downloads\\UD2_AccesoDatos (1)\\UT2_AccesoDatos\\EMPLEADOS.DAT");
   // Declaración del fichero aleatorio para lectura
   
   RandomAccessFile file = new RandomAccessFile(fichero, "r"); 
   int  codigo, pos;    
   Double salario, comision;	
   char nombre[] = new char[10], aux, direccion[] = new char[20]; 
   
   pos=0;  // Se posiciona al principio del fichero
   for(;;){     // El for se utiliza para recorrer el fichero (buble infinito)
	file.seek(pos); // Se posiciona en posición pos (en in pricipio 0)
        
	codigo=file.readInt();   // Se obtiene el código del empleado
        
        for (int i = 0; i < nombre.length; i++) {
             aux = file.readChar();//Se recorre el nombre caracter a caracter 
             nombre[i] = aux;    //Se guarda cada caracter en un array
        }  
        String nombreS= new String(nombre); //Se transforma el array a cadena
        
        for (int i = 0; i < direccion.length; i++) {
             aux = file.readChar();//Se recorre la dirección caracter a caracter 
             direccion[i] = aux;    //Se guarda cada caracter en un array
        }    
        String direccionS= new String(direccion); //Se transforma el array a cadena

        salario=file.readDouble();  //Obtiene el salario 
        comision=file.readDouble();  //Obtiene la comision 

        System.out.println("CODIGO: " + codigo + ", NOMBRE: "
            +  nombreS + ", DIRECCION: "+direccionS + ", "
            + " SALARIO: " + salario + " COMISION: " + comision);

        pos = pos + 80;// Al sumar 80 nos posicionamos en el siguiente alummno, cada alumo ocupa 80 Bytes 
                       // Cada empleado ocupa 80 bytes (4+2*10+2*20+8+8), es decir 4 para el cçodigo, 20 para el nombre,
                       // 40 para la dirección, 8 para el salario y 8 para la comisión. 
                       // Si se recorren todos los bytes sale del for	
	  
    if (file.getFilePointer()==file.length())
        break; // Salida del bucle 
   } 
   file.close();  // Cierre del fichero 
   }
    
}
