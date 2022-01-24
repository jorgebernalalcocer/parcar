package com.desarrollos.entde;



import java.util.Scanner;

public class Profesor implements Comparable<Profesor> {

    //AtributoS static o atributo de la CLASE
    private static String curso;
    private static double pagoPorHoraExtra;
   
    //Los siguientes son atributos de INSTANCIA:
    private String dni;
    private String nombre;
    private double sueldoBase;
    private int[] horasExtras; //private int[] horasExtras = new int [12];
    private double tipoIRPF;

//Constructor por defecto o constructor vacío.
//El constructor vacío es como si rellenaramos a mano un impreso tradicional vacío.

public Profesor() {
}

//Métodos getter/setter
public int getHorasExtras (int mes ){ //Lo que hay entre paréntesis son parámetros que se le pasa al método
    return horasExtras[mes];
}

public void setHorasExtras (int messi, int horas){ //Las horas extras necesitamos saber de que mes son, por tanto le pasamos como parámetro el mes y las horas.
        this.horasExtras[messi] = horas; //El array horasExtras es igual al parámetro "horas".
        //Como vemos, los parámetros deben de coincidir dentro de su ambito, por lo tanto, si le llamo messi al otro también, aunque haga referencia a MES, puedo llamarlo como quiera.
}
   

public String getDni(){
    return dni;
}

public void setDni(String dni){
    this.dni = dni;
}
public String getNombre(){
    return nombre;
}

public void setNombre(String nombre){
    this.nombre = nombre;
}

public double getSueldoBase(){
    return sueldoBase;
}

public void setSueldoBase(double sueldoBase){
    this.sueldoBase = sueldoBase;
}

public double getTipoIRPF(){
    return tipoIRPF;
}

public void setTipoIRPF(double tipoIRPF){
    this.tipoIRPF = tipoIRPF;
}

//métodos get/set para el atributo static
public static double getPagoPorHoraExtra(){
    return pagoPorHoraExtra;
}

public static void setPagoPorHoraExtra(double pagoPorHoraExtra){
    Profesor.pagoPorHoraExtra = pagoPorHoraExtra;//como pagoPorHoraExtra es un atributo estático va con el nombre de la clase: Profesor.pagoPorHoraExtra
}

public static String getCurso(){
    return curso;
}

public static void setCurso(String curso){
    Profesor.curso = curso; //como curso es un atributo estático va con el nombre de la clase: Profesor.curso
}

//Método para calcular el importe de las horas extras de un profesor en un determinado mes
public double calcularImporteHorasExtras(int mes){ //el int mes es para hacer referencia al mes en cuestión, podría llamarse i o como queramos
    return horasExtras[mes] * Profesor.pagoPorHoraExtra; //como pagoPorHoraExtra es un atributo estático va con el nombre de la clase: Profesor.pagoPorHoraExtra
}

//Método para calcular el sueldo bruto de un mes (sueldo base + complemento por horas extras) calcularSueldoBruto()

    

public double calcularSueldoBruto(int mes){
    return sueldoBase + calcularImporteHorasExtras(mes);
}
//Método para calcular las retenciones por IRPF de un mes. El porcentaje de IRPF se aplica sobre el sueldo bruto calcularRetencionIrpf(mes).

public double calcularRetencionIrpf(int mes){
    return calcularSueldoBruto(mes) * tipoIRPF /100;
}

//Método para calcular el sueldo (sueldo bruto - retenciones) calcularSueldo(mes)

public double calcularSueldo (int mes){
    return calcularSueldoBruto(mes)-calcularRetencionIrpf(mes);
}

//Método de la clase o ESTÁTICO.Este metodo se encarga de rellenar los datos del constructor vacío. Es como cuando vamos a rellenar el impreso vación del nuevo profesor para darlo de alta.
public void leerProfesor(){
    Scanner sc= new Scanner(System.in);
    System.out.println("Profesor: ");
  String  nombre=sc.nextLine();
    System.out.println("DNI: ");
   String dni=sc.nextLine();
    System.out.println("Sueldo Base: ");
   double sueldoBase = sc.nextDouble();
    System.out.println("Tipo de IRPF: ");
   double tipoIRPF = sc.nextDouble();
   int horasExtras= new int [12]; //inicialmente el array está vacío

    //mostrar los datos de un profesor. El número lo escribimos por ocnsola

public String ImprimeProfesor(){
    String resultado = "";
    resultado=resultado+("nombre: ");
    resultado=resultado+(nombre);
    resultado=resultado+("\nDNI: ");
    resultado=resultado+(dni);
    resultado=resultado+("\nSueldo Base: ");
    resultado=resultado+(sueldoBase);
    resultado=resultado+("\nTipo IRPF: ");
    resultado=resultado+(tipoIRPF);
    return resultado;

}

//mostrar la nomina de un profesor en un mes

public String ImprimirNominas(int mes){
    String resultado;
    String nombreMes[]={"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    StringBuilder sb = new StringBuilder();
    sb.append("Nombre: ");
    sb.append(nombre);
    sb.append("\nDNI:");
    sb.append(dni);
    sb.append("\nCurso: ");
    sb.append(curso);
    sb.append(" Nómina més: ");
    sb.append(nombreMes[mes]);
    sb.append("\nSueldo Base: ");
    sb.append(sueldoBase);
    sb.append("\nHoras Extras: ");
    sb.append(getHorasExtras(mes));
    sb.append("\nTipoIRPF: ");
    sb.append(tipoIRPF);
    sb.append("\nSueldo Brudto: "+ calcularSueldoBruto(mes));
    sb.append("\nRetención por IRPF: "+ calcularRetencionIrpf(mes));
    sb.append("\nSueldo Sueldo Neto: "+ calcularSueldo(mes)+"\n");
    resultado=sb.toString();

    return resultado;

    }

    @Override
    public int compareTo(Profesor o) {
        if (this.dni.compareTo(o.dni)<0){
            return -1;

        }
        if (this.dni.compareTo(o.dni)>0){
            return 1;
        }
        else {
            return 0;
        }
    }
    
}

