package com.desarrollos.entde;


import java.util.Scanner;


public class Principal {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
//1.Creamos una lista vacía (Array estático) de la clase profesores.
        Profesor lista[] = new Profesor[0];//esta lista creada posteriormente será la lista vieja, porque cuando demos de alta a un nuevo profesor, la listaNueva se basa en la lista vieja.
        double importe=0;
        String curso;
//asignar el atributo estático Curso. Creamos nuevas variables en esta clase principal para rellenar el contenido de las variables estaticas curso e importe       
        curso=sc.nextLine();
        Profesor.setCurso(curso); //LLAMAMOS A LA CLASE PROFESOR PORQUE porque setCurso es un método estático de la clase profesor.
        System.out.println();
//asignar el atributo estático pagoPorHoraExtra
        System.out.print("Importe Horas Extra: ");
        importe = sc.nextDouble();
        Profesor.setPagoPorHoraExtra(importe);//LLAMAMOS A LA CLASE PROFESOR PORQUE porque setPagoPorHoraExtra es un método estático.
        System.out.println();
//Creamos un menú con las distintas opciones
        boolean salir=false;
        int opcion=0;

        do{
            for (int i = 0; i < 3; i++){
                System.out.println();

                }
            System.out.println(" SELECCIONE UNA OPCION");
            System.out.println("");
            System.out.println("1. ALTA DE UN PROFESOR");
            System.out.println(""); 
            System.out.println("2. BAJA DE UN PROFESOR");
            System.out.println("");
            System.out.println("3. CONSULTA DE DATOS PERSONALES DE UN PROFESOR");
            System.out.println("");
            System.out.println("4. INTRODUCIR HORAS EXTRAORDINARIAS DE UN MES");
            System.out.println("");
            System.out.println("5. LISTADO DE PROFESORES");
            System.out.println("");
            System.out.println("6. LISTADO DE NÓMINAS DE UN MES");
            System.out.println("");
            System.out.println("7. ORDENAR POR NOMBRE UTILIZANDO EL MÉTODO DE LA BURBUJA");
            System.out.println("");
            System.out.println("6. ORDENAR POR DNI UTILIZANDO EL INTERFACE COMPARABLE");
            System.out.println("");
            System.out.println("0. SALIR DEL PROGRAMA");
            System.out.println("");
            System.out.print("OPCIÓN SELECCIONADA:");

            opcion =  sc.nextInt();
            System.out.println();

            int i; //Declaramos la i para los bucles
            
            switch (opcion){

            case 1: //Alta de profesor.
    /*Método que permite introducir los datos de un nuevo
profesor por teclado. A este método se le llama desde el main mediante una
instancia de la clase Profesor que se ha creado llamando al constructor vacío.
El número de profesor es el correspondiente al último elemento de la lista ya
que el método de la clase desconoce que los profesores se almacenan en una
lista.*/
            Profesor p = new Profesor(); //instanciamos el nuevo profesor del constructor vacío
            p.leerProfesor(); //el objeto vacío "P" me lo rellenas con el método leerProfesor() para rellenar su ficha
            lista= Principal.altaProfesor(lista,p);//Este método me DEVUELVE la listaNueva, por tanto lista = listaNueva.
            //método estatico de la case principal para dar de alta a un nuevo profesor dentro de un array listaNueva. (no hace falta poner el nombre de la clase porque está dentro de la clase). 

            //A este método altaProfesor le paso las direcciones de memoria donde está la lista vieja, y la dirección donde esta el objeto p, que es el objeto nuevo. 
            break;

            case 2: //Baja del profesor
                do{//simplemente quita un objeto de la lista
                System.out.print("Numero del profesor: ");
                i = sc.nextInt();
            }while (i<0 || i>=lista.length);
                lista= Principal.bajaProfesor(i, lista);//No haría falta decir de qué clase es porque este método estático está dentro de la clase principal.
                //A este método le pasamos por parámetro la dirección de memoria de i (el ínidice del profesor que queremos borrar) y lista.
                //el método baja profesor devuelve una lista con un profesor eliminado.
            break;

            case 3: //Consulta del profe
                do{
                    System.out.print("Número del profesor: ");
                    i = sc.nextInt();
            }while (i<1 || i>lista.length );
                i=i-1;//Corregimos el indice para el array con un menos uno
                System.out.println(lista[i].ImprimeProfesor());
            break;

            case 4: //Introducir horas extraodinarias de un mes
//Introducimos un mes y posteriormente recorremos todos los prfoesores colacando 
//sus horas realizadas en ese mes
                int mes;
                sc.nextLine();
                do{// introduce el mes
                    System.out.print("Que mes quieres saber la nómina: ");
                    mes = sc.nextInt();
                }while(mes<1 || mes>12);
                System.out.println();
                mes=mes-1;//Corregimos el indice para el array con un menos uno
                    for(i=0; i<lista.length; i++){
                        int horas; 
                        System.out.print("Nombre Profesor: ");
                        System.out.println(lista[i].getNombre()); //mostramos uno a uno el profesor con su índice y el nombre.
                        System.out.print("Horas realizadas: ");
                        horas = sc.nextInt(); //pedimos el entero de horas extras
                        lista[i].setHorasExtras(mes,horas);
                        System.out.println();
                    }
                break;
   
                case 5: //Listado de datos personales de todos los profesores
                    for (i=0; i<lista.length; i++){
                        System.out.println("número de profesores: "+ (i+1));
                        System.out.println(lista[i].ImprimeProfesor());
                        System.out.println();
                    }
                break;

                case 6: //Listado de nominas de un mes
                    do{//introduce el mes
                        System.out.print("Nominas del mes: ");
                        mes = sc.nextInt();                     

                    }while (mes<1 || mes>12);
                    System.out.println();
                    mes = mes -1; //corregimos el indice para el array
                    for (i=0; i<lista.length; i++){
                        System.out.println("Número profesor: " + (i+1));
                        System.out.println(lista[i].ImprimirNominas(mes));

                    }
                    break;
                case 7: 
                        Principal.burbuja(lista);
                    break;
                case 8:
                        Arrays.sort(lista);
                    break;

                default: salir=true; 
                }
            }while (salir==false);
        }

//Metodo para dar de baja un prfoesor de la lista

public static Profesor[] bajaProfesor(int indice, Profesor lista[]) { 
    Profesor listaNueva[]= new Profesor[lista.length-1];
    for(int i=0; i<lista.length; i++){
        if(i<indice){ //Si i es menor que indice copia la lista
            listaNueva[i]=lista[i];
        }

        else if(i>indice){//si coinciden los indices no copia, si es mayor entonces toma el valor de i en la lista, y a la nueva lista le resta 1.
            listaNueva[i-1]=lista[i];
        
        }
        return listaNueva;

    }
//Método getter para dar de alta un prfoesor nuevo en la lista
//creamos una nueva lista, copiamos los datos de la antigua y añadimos el nuevo profesor. ESTO ES porque los arrays estaticos no se pueden modificar, los que se modifican son los Arrays List
    public static Profesor[] altaProfesor(Profesor lista[], Profesor p){ //le pasamos los parametros lista vieja y el objeto p
        Profesor listaNueva[] =  new Profesor[lista.length+1];//Se CREA el array listaNueva copiando la lista anterior +1 elemento nuevo, que es el nuevo profesor al que se le da de alta
        if (lista.length==0){ //si la lista es de 0 personas, se crea una lista nueva con la dirección de memoria p.
            listaNueva[0]=p;

        }
        else{//Si no...
            for(int i=0; i<lista.length;i++){
                listaNueva[i]=lista[i]; //Aquí esta recorriendo los valores de la lista vieja y copiandolos uno a uno a través del bucle
            }
            listaNueva[lista.length]=p; //Aquí establece que la última casilla del array listaNueva es el nuevo profesor al que hemos dado de alta.
        }
        return listaNueva; //devolvemos la listaNueva creada
    }
//Método para pedir el importe de la hora extra
public static double leerImporteHorasEXtras(){
    double importe;
    System.out.print("Introduce el importe a pagar por cada hora extra: ");
    importe = sc.nextDouble();
    return importe;
}

}
