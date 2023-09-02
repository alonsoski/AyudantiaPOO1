package org.example;
import java.lang.Math;
import java.util.Scanner;
public class MainAtudantia01POO {

    public static void impresionTemperaturas(int[][] temp){
        for (int i = 0; i < temp.length ; i++) {
            System.out.println();
            for (int j = 0; j <temp[i].length ; j++) {
                System.out.print("["+temp[i][j]+"]");
            }
        }
    }
    public static void temperaturas(){
        int[][] temperaturas=creacionDeTemperaturas();
        //impresionTemperaturas(temperaturas);
        menuTemperaturas(temperaturas);

    }

    private static void menuTemperaturas(int[][] temperaturas) {
        int eleccion = 0;
        do {
            System.out.println("que quiere hacer");
            System.out.println("1.-Mostrar dia mas caluroso.");
            System.out.println("2.-Mostrar dia mas frio.");
            System.out.println("3.-Mostrar hora y dia de la temperatura mas baja.");
            System.out.println("4.-Mostrar hora y día de la temperatura más alta.");
            System.out.println("5.-Promedio de la temperatura de la semana");
            System.out.println("6.Salir-");
            eleccion=ingresoEleccion();
        }while (eleccion<1 || eleccion>6);
        mostrarInfo(temperaturas,eleccion);
    }

    private static void mostrarInfo(int[][] temperaturas, int eleccion) {
        switch (eleccion){
            case 1:
                diaMasCaluroso(temperaturas);
                menuTemperaturas(temperaturas);
                break;
            case 2:
                diaMasFrio(temperaturas);
                menuTemperaturas(temperaturas);
                break;
            case 3:
                horaYDiaMasBaja(temperaturas);
                menuTemperaturas(temperaturas);
                break;
            case 4:
                horaYDiaMasAlta(temperaturas);
                menuTemperaturas(temperaturas);
                break;
            case 5:
                promedioTemperaturaSemana(temperaturas);
                menuTemperaturas(temperaturas);
                break;
            case 6:
                System.out.println("Ok, adios");
                break;
        }
    }

    public static int promedioTemperaturaSemana(int[][] temperaturas) {
        int acumulador=0;
        double promedio=0;
        int horas=0;
        for (int i = 0; i <temperaturas.length ; i++) {
            for (int j = 0; j <temperaturas[i].length ; j++) {
                acumulador+=temperaturas[i][j];
                horas++;
            }

        }
        System.out.println("el promedio es"+((float)acumulador/horas)+"°C");
        return ((int)acumulador/horas);
    }

    public static int[] horaYDiaMasAlta(int[][] temperaturas) {
        int[] diaYhoraCal={0,0};
        int temperaturaMCal=0;
        for (int i = 0; i <temperaturas.length ; i++) {
            for (int j = 0; j <temperaturas[i].length ; j++) {
                if(temperaturas[i][j]>temperaturaMCal){
                    temperaturaMCal=temperaturas[i][j];
                    diaYhoraCal= new int[]{i,j};
                }
            }
        }
        interpretacionDeDiaYhoraC(diaYhoraCal);
        return diaYhoraCal;
    }

    private static void interpretacionDeDiaYhoraC(int[] diaYhoraCal) {
        String[] dias={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        System.out.println("la hora mas calurosa fue las "+diaYhoraCal[1]+":00 del "+dias[diaYhoraCal[0]]);
    }

    private static void horaYDiaMasBaja(int[][] temperaturas) {
        int[] diaYhoraFria={0,0};
        int temperaturaMFria=32;
        for (int i = 0; i <temperaturas.length ; i++) {
            for (int j = 0; j <temperaturas[i].length ; j++) {
                if(temperaturas[i][j]<temperaturaMFria){
                    temperaturaMFria=temperaturas[i][j];
                    diaYhoraFria= new int[]{i,j};
                }
            }
        }
        interpretacionDeDiaYhoraF(diaYhoraFria);
    }

    private static void interpretacionDeDiaYhoraF(int[] diaYhoraFria) {
        String[] dias={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        System.out.println("la hora mas fria fue las "+diaYhoraFria[1]+":00 del "+dias[diaYhoraFria[0]]);
    }

    private static void diaMasFrio(int[][] temperaturas) {
        int diaMasFrio= 0;
        double temperatura=32;
        for (int i = 0; i <temperaturas.length ; i++) {
            int acumulador=0;
            for (int j = 0; j <temperaturas[i].length ; j++) {
                acumulador+=temperaturas[i][j];
            }
            if (((double) acumulador /temperaturas[i].length)<temperatura){
                temperatura=((double) acumulador /temperaturas[i].length);
                diaMasFrio=i;
            }
        }
        interpretacionDeDiaF(diaMasFrio);
    }

    private static void interpretacionDeDiaF(int diaMasFrio) {
        String[] dias={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        System.out.println("el dia mas frio fue el:"+dias[diaMasFrio]);
    }

    private static void diaMasCaluroso(int[][] temperaturas) {
        int diaMasCaluroso= 0;
        double temperatura=0;
        for (int i = 0; i <temperaturas.length ; i++) {
            int acumulador=0;
            for (int j = 0; j <temperaturas[i].length ; j++) {
                acumulador+=temperaturas[i][j];
            }
            if (acumulador>temperatura){
                temperatura=acumulador;
                diaMasCaluroso=i;
            }
        }
        interpretacionDeDiaC(diaMasCaluroso);
    }

    private static void interpretacionDeDiaC(int diaMasCaluroso) {
        String[] dias={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        System.out.println("el dia mas caluroso fue el:"+dias[diaMasCaluroso]);
    }

    private static int ingresoEleccion() {
        int eleccion=0;
        Scanner t = new Scanner(System.in);
        try {
            eleccion=t.nextInt();
        }catch (Exception e){
            t.nextLine();
        }
        if (eleccion<1 || eleccion>6){
            System.out.println("eso no se puede");
        }
        return eleccion;
    }

    private static int[][] creacionDeTemperaturas() {
        int[][] temperaturas= new int[7][24];
        for (int i = 0; i <temperaturas.length ; i++) {
            for (int j = 0; j <temperaturas[i].length ; j++) {
                int temperatura = (int)((Math.random())*21)+10;//rango 10-30
                temperaturas[i][j]=temperatura;
            }
        }
        return temperaturas;
    }
//-----------------------------------------------------------
//-----------------------------------------------------------
//--------------------Arreglo de metodos---------------------
//-----------------------------------------------------------
//-----------------------------------------------------------
//-----------------------------------------------------------
//-----------------------------------------------------------
//-----------------------------------------------------------
    public static boolean esPalindromo(String palabraIngresada) {
        palabraIngresada = palabraIngresada.replace(" ", "");
        StringBuilder stringBuilderA = new StringBuilder(palabraIngresada);
        String palabraInvertida = stringBuilderA.reverse().toString();
        return palabraIngresada.equalsIgnoreCase(palabraInvertida);
    }
    public static double calcularPromedio(double [] notas) {
        double [] ponderacionNotas = {0.25, 0.25, 0.25, 0.15, 0.10};
        double promedio = 0;
        for (int i = 0; i < notas.length; i++) {
            promedio += (notas[i] * ponderacionNotas[i]);
        }
        return promedio;
    }
    public static String mayorPuntaje(int [] puntajes) {
        int jugador1 = 20 - puntajes[0];
        int jugador2 = 20 - puntajes[1];
        if((jugador1 < 0 && jugador2 < 0) || jugador1 == jugador2) {
            return "Empate.";
        } else if((jugador1 < 0 || jugador2 < jugador1) && jugador2 >= 0) {
            return "Jugador 2 ganó.";
        } else {
            return "Jugador 1 ganó.";
        }
    }
    public static int[][] transponerMatriz (int[][] a) {
        int[][] t = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                t[j][i] = a[i][j];
            }
        }
        return t;
    }
    public static boolean palbraNoVaciaSinDigitos(String palabraIngresada) {
        for (int i = 0; i < palabraIngresada.length(); i++) {
            if (Character.isDigit(palabraIngresada.charAt(i)) || palabraIngresada.isBlank()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        temperaturas();

    }
}