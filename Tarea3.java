package tarea3;
import java.util.Scanner;   // Paquete para poder ingresar informacion al programa
import java.util.concurrent.TimeUnit; // Paquete para trabajar con un temporalizador
import java.util.logging.Level; // Paquete para trabajar con un temporalizador
import java.util.logging.Logger;    // Paquete para trabajar con un temporalizador
public class Tarea3 {               // Declaracion de variables publicas a utilizar
    public static long Numero =0;
    public static int Contador =0;
    public static int Promedios = 0;
    public static int Ordenar[]= new int[3];
    public static String Usuario[]= new String[6];
    public static int Promedio[][] = new int[7][7];
    
    public static void main(String[] args) {   
        Cargar();     // desde el main, se llama a un metodo para evitar tener que programar en el Main
    }
    
    public static void Limpieza(){  // Metodo para poder borrar la pantalla de CMD
        for (int i=0;i<50;i++){
            System.out.println("");
        }
   }
    public static void Cargar(){    
        Limpieza();
        Menu_Principal();
    }
    public static void Menu_Principal(){    // La interfaz inicial del programa
       System.out.println("xxxxxxx     x       xxxxx    xxxxxx       x");
       System.out.println("   x       x x      x    x   x           x x");
       System.out.println("   x      x   x     xxxxx    xxxxxx     x   x");
       System.out.println("   x     xxxxxxx    x  x     x         xxxxxxx");
       System.out.println("   x    x       x   x    x   xxxxxx   x       x");
       System.out.println();
       System.out.println();
       System.out.println("     1) Usuarios");
       System.out.println();
       System.out.println("     2) Contador de digitos");
       System.out.println();
       System.out.println("     3) Tres numeros de mayor a menor");
       System.out.println();
       System.out.println("     4) Calcular Promedio");
       System.out.println();
       System.out.println("     5) Salir");
       System.out.println();
       Scanner entrada = new Scanner(System.in);
       int menu;
       menu = entrada.nextInt();
       switch(menu){ // con el dato ingresado, se usa switch para hacar acceder al contenido deseado
           case 1:
               Usuarios();
               break; // es para finalizar la operacion, evita que el case cargue valores de las otras opciones
           case 2:
               Contador();
               break;
           case 3:
               Tres_numeros();
               break;
           case 4:
               Promedio();
               break;
           case 5:
               System.exit(0); // comando para cerrar el programa
               break;
       }
        }
    public static void Usuarios(){
        Limpieza();// limpiar pantalla
        System.out.println("   Usuarios:"); // opciones del la aplicacion
        System.out.println();
        System.out.println("   1) Ingresar Usuarios");
        System.out.println("   2) Mostrar Usuarios Ascendente");
        System.out.println("   3) Mostrar Usuarios Descendente");
        System.out.println("   4) Menu principal");
        Scanner entrada5 = new Scanner(System.in);
        int menu4;
        menu4 = entrada5.nextInt();
        switch(menu4){
           case 1:
               Limpieza();
               for(int U = 0; U < 4;U++){
               System.out.println("Ingrese un Usuario:");
               Scanner entrada6 = new Scanner(System.in);
               Usuario[U] = entrada6.nextLine(); // Guardar los datos ingresados en cada posicion de uno en uno
               }
               Usuarios();// regresa al menu principal
               break;
           
           case 2: // comparando cada valor con el siguiente para ordenar de manera ascendente
               Limpieza();
               for(int m = 0; m < 5;m++){
                    for(int n = 0; n <= 5 ;n++){
                        if(Usuario[n].compareTo(Usuario[n+1])>0){ // compareTo se usa para comparar los valores del string utilizado
                            String Temp2 = Usuario[n];
                            Usuario[n]= Usuario[n+1];
                            Usuario[n+1]=Temp2;   
                        }
                    }
                }
               for(int j = 0; j < 5;j++){
                   System.out.println(Usuario[j]);// se muestran los textos ingresados ordenados
               }
               try {  // Temporalizador para automatizar la salida al menu principal
                   TimeUnit.SECONDS.sleep(3);// se configura el tiempo que va a tomar la aplicacion en hacer esta breve pausa
                    }catch (InterruptedException ex) {
                    Logger.getLogger(Tarea3.class.getName()).log(Level.SEVERE, null, ex);
                    }
               Usuarios();
               break;
           case 3:  // comparando cada valor con el siguiente para ordenar de manera Descendete
                              Limpieza();
               for(int m = 0; m < 5;m++){
                    for(int n = 0; n <= 5 ;n++){
                        if(Usuario[n+1].compareTo(Usuario[n])>0){  // compareTo se usa para comparar los valores del string utilizado
                            String Temp2 = Usuario[n+1];
                            Usuario[n+1]= Usuario[n];
                            Usuario[n]=Temp2;   
                        }
                    }
                }
               for(int j = 0; j < 5;j++){
                   System.out.println(Usuario[j]); // se muestran los textos ingresados ordenados
               }
               try {
                   TimeUnit.SECONDS.sleep(3); // Temporalizador para automatizar la salida al menu principal
                    }catch (InterruptedException ex) {
                    Logger.getLogger(Tarea3.class.getName()).log(Level.SEVERE, null, ex);
                    }
               Usuarios();
               break;
       }
    }
    public static void Contador(){ 
        Limpieza();
        Contador = 0;
        System.out.println("   Contador de Digitos:");// interfaz de menu
        System.out.println();
        System.out.println("   1) Ingresar Numero");
        System.out.println("   2) Mostrar Numero de Digitos");
        System.out.println("   3) Menu principal");
        Scanner entrada2 = new Scanner(System.in);
        int menu2;
        menu2 = entrada2.nextInt();
        switch(menu2){
           case 1:
               Limpieza();
               System.out.println("Ingrese un numero:");
               Scanner entrada3 = new Scanner(System.in);
               Numero = entrada3.nextInt();
               if(Numero > 100000){ // Condicion para evitar que se ingrese un numero mayor que 100000
                   System.out.println("Error, El numero ingresado no es valido, vuelva a empezar");
                   try {
                   TimeUnit.SECONDS.sleep(3); // Temporalizador para automatizar la salida al menu principal
                    }catch (InterruptedException ex) {
                    Logger.getLogger(Tarea3.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }
               Contador();
               break;
           case 2:
               Limpieza();
               while(Numero!=0){ // Condicion que permite la contabilizacion de digitos
                   Numero = Numero / 10;
                   Contador = Contador + 1; // la cuenta de cada digito que existe
               }
               System.out.println("El Numero de Digitos es de:");
               System.out.println(Contador);// Resultado de la cuenta de los digitos
               System.out.println();
               System.out.println("Regresando al menu, Espere");
               try {
               TimeUnit.SECONDS.sleep(4); // Temporalizador para automatizar la salida al menu principal
                } catch (InterruptedException ex) {
               Logger.getLogger(Tarea3.class.getName()).log(Level.SEVERE, null, ex);
                }
               Contador();
               break;
           case 3:
               Cargar();
               break;
       }
           
        
    }    
    public static void Tres_numeros(){
        Limpieza();
        System.out.println("   Tres numeros de Mayor a Menor:");// Interfaz grafica
        System.out.println();
        System.out.println("   1) Ingresar Numeros");
        System.out.println("   2) Mostrar Numeros Ordenados");
        System.out.println("   3) Menu principal");
        Scanner entrada4 = new Scanner(System.in);
        int menu3;
        menu3 = entrada4.nextInt();
        switch(menu3){
           case 1:
               Limpieza();
               for(int m = 0; m < 3; m++){
                   System.out.println("Ingrese un numero:");
                   Scanner entrada5 = new Scanner(System.in);
                   Ordenar[m] = entrada5.nextInt();
                }
               Tres_numeros();
               break;
           case 2:
               for(int x = 0; x < Ordenar.length;x++);{// usando el metodo de bubbleswap para ordenar los valores
                    for(int y = 0; y <= 1;y++){
                        if(Ordenar[y+1]> Ordenar[y]){
                            int Temp = Ordenar[y+1];
                            Ordenar[y+1]= Ordenar[y];
                            Ordenar[y]=Temp;   
                        }
                    }
                }
               System.out.println("Primer Numero:" + Ordenar[0]);// los resultados ordenados
               System.out.println("Segundo Numero:"+ Ordenar[1]);
               System.out.println("Tercer Numero:" + Ordenar[2]);
               System.out.println("Regresando al menu, Espere");
               try {   // Temporalizador para automatizar la salida al menu principal
               TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException ex) {
               Logger.getLogger(Tarea3.class.getName()).log(Level.SEVERE, null, ex);
                }
               Tres_numeros();
               break;
           case 3:
               Cargar();
               break;
       }
    }
    public static void Promedio(){
        Limpieza();
        System.out.println("   Promedios:");
        System.out.println();
        System.out.println("   1) Ingresar Numeros");
        System.out.println("   2) Mostrar Promedios");
        System.out.println("   3) Menu principal");
        Scanner entrada8 = new Scanner(System.in);
        int menu7;
        menu7 = entrada8.nextInt();
        switch(menu7){
           case 1: // Ingreso de los valores de forma matricial
               Limpieza();
               for(int p = 1; p <= 6;p++){
                   for(int q = 1; q <= 4;q++){
                   System.out.println(" Ingrese una Nota en la posicion"+"("+p+","+q+")");
                   Scanner entrada10 = new Scanner(System.in);
                   Promedio[p][q] = entrada10.nextInt();
                   Promedios = Promedios + Promedio[p][q];
                   }
                   Promedio[p][0]= p;
                   Promedio[p][5] = Promedios / 4;
                   Promedios = 0; // limpiando la variable para las siguientes operaciones
               }
               Promedio();
               break;
           case 2:
               Limpieza();
               for(int z = 1; z <= 6;z++){
                   for (int w = 0; w<= 5; w++){
                       System.out.print(" "+Promedio[z][w]+" ");// Mostrando en pantalla los resultados en una linea
                   }
                   System.out.println();//haciendo la separacion entre lineas del resultado
               }
               System.out.println("Regresando al menu, Espere");
               try { // Temporalizador para automatizar la salida al menu principal
               TimeUnit.SECONDS.sleep(154);
                } catch (InterruptedException ex) {
               Logger.getLogger(Tarea3.class.getName()).log(Level.SEVERE, null, ex);
                }
               Promedio();
               break;
           case 3:
               Menu_Principal();
               break;
       }
    }
    }
