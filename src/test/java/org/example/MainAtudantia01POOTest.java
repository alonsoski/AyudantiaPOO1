package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//import static org.example.Main.esPalindromo;
import static org.example.MainAtudantia01POO.*;
public class MainAtudantia01POOTest {
    @Test
    void mayorPuntajeTest(){
        int[][] puntajesIngresados = puntajes();
        String[] rP = {"Jugador 1 ganó.","Jugador 2 ganó.","Empate."};
        String[] resultadosEsperados= {rP[0],rP[1],rP[0],rP[1],rP[2],rP[2],rP[2]};
        for (int i = 0; i <puntajesIngresados.length ; i++) {
            String resultadoObtenido= mayorPuntaje(puntajesIngresados[i]);
            Assertions.assertEquals(resultadoObtenido,resultadosEsperados[i]);
        }


    }

    private int[][] puntajes() {
        int[][] puntajes = new int[7][2];
        puntajes[0]=new int[]{15,14};//g1
        puntajes[1]=new int[]{21,14};//g2
        puntajes[2]=new int[]{15,21};//g1
        puntajes[3]=new int[]{13,14};//g2
        puntajes[4]=new int[]{15,15};//e
        puntajes[5]=new int[]{21,22};//e
        puntajes[6]=new int[]{23,22};//e
        return puntajes;
    }

    @Test
    void palabraNoVaciaSinDigitoTest(){
    String[] palabrasIngresadas={"ASklnfd","asdnk12","kjsn","   ","wqe qwe"};
    boolean[] resultadosEsperados={true,false,true,false,true};
        for (int i = 0; i <palabrasIngresadas.length ; i++) {
            boolean resultadoObtenido = palbraNoVaciaSinDigitos(palabrasIngresadas[i]);
            Assertions.assertEquals(resultadoObtenido,resultadosEsperados[i]);
        }

    }

    @Test
    void transponerMatrizTest(){
        int[][][] matricesIngresadas= creacionDeMatricesIngresadasT();
        int[][][] matricesEsperadas = creacionMatricesEsperadasT();

        for (int i = 0; i < matricesIngresadas.length ; i++) {
            for (int j = 0; j < matricesIngresadas[i].length ; j++) {
                for (int k = 0; k <matricesIngresadas[i][j].length ; k++) {
                    int resultadoObtenido=transponerMatriz(matricesIngresadas[i])[j][k];
                    Assertions.assertEquals(resultadoObtenido, matricesEsperadas[i][j][k]);
                }
            }
        }
    }


    private int[][][] creacionMatricesEsperadasT() {
        int[][][] matriz= new int[2][3][3];
        int[][] m1= new int[3][3];
        m1[0]=new int[]{1,4,7};
        m1[1]=new int[]{2,5,8};
        m1[2]=new int[]{3,6,9};
        matriz[0]=m1;
        int[][] m2= new int[3][3];
        m2[0]=new int[]{10,4,12};
        m2[1]=new int[]{11,5,3};
        m2[2]=new int[]{12,6,4};
        matriz[1]=m2;
        return matriz;
    }

    private int[][][] creacionDeMatricesIngresadasT() {
        int[][][] matriz= new int[2][3][3];
        int[][] m1= new int[3][3];
        m1[0]=new int[]{1,2,3};
        m1[1]=new int[]{4,5,6};
        m1[2]=new int[]{7,8,9};
        matriz[0]=m1;
        int[][] m2= new int[3][3];
        m2[0]=new int[]{10,11,12};
        m2[1]=new int[]{4,5,6};
        m2[2]=new int[]{12,3,4};
        matriz[1]=m2;
        return matriz;
    }

    @Test
    void calcularPromedioTest(){
        //{0.25, 0.25, 0.25, 0.15, 0.10}
        double[][] notasIngresadas =crearMatrizNotas();
        double[] promediosEsperados={41.5,40.8,26.85};
        for (int i = 0; i <notasIngresadas.length ; i++) {
            double resultadoObtenido = calcularPromedio(notasIngresadas[i]);
            Assertions.assertEquals(promediosEsperados[i],resultadoObtenido);
        }
    }

    private double[][] crearMatrizNotas() {
        double[][] notas = new double[3][5];
        notas[0]= new double[] {20,40,60,70,10};
        notas[1]= new double[]{40,45,53,30,18};
        notas[2]= new double[]{10,23,10,70,56};
        return notas;
    }

    @Test
    void esPalindromoTest(){
        String[] palabrasIngresadas = {
                "anita lava la tina",
                "afa",
                "dsjdsf"
        };

        boolean[] resultadosEsperados = {
                true,
                true,
                false
        };

        for (int i = 0; i < palabrasIngresadas.length ; i++) {
            //boolean valorObtenido = esPalindromo(palabrasIngresadas[i]);
            Assertions.assertEquals(esPalindromo(palabrasIngresadas[i]), resultadosEsperados[i]);
            //Assertions.assertEquals(valorObtenido, resultadosEsperados[i]);
            //Assertions.assertTrue(esPalindromo(palindromos[i]));
        }

    }

//-----------------------------------------------------
//-----------------------------------------------------
//-----------------------------------------------------
    @Test
    void promedioTemperaturaSemanaTest(){
        int[][][] mHoras= creacionDeMatrizIngresadaHoras();
        double[] promediosEsperados ={26,16,20};
        for (int i = 0; i <mHoras.length ; i++) {
            Assertions.assertEquals(promedioTemperaturaSemana(mHoras[i]),promediosEsperados[i]);
        }

    }
    @Test
    void horaYDiaMasAltaTest(){
        int[][][] mHoras=creacionDeMatrizIngresadaHoras();
        int[][] mEsperados = creacionArrayEsperadosHoras();
        for (int i = 0; i <mHoras.length ; i++) {
            for (int j = 0; j <mHoras[i].length; j++) {
                Assertions.assertEquals(horaYDiaMasAlta(mHoras[i])[j],mEsperados[i][j]);
            }
            //Assertions.assertEquals(horaYDiaMasAlta(mHoras[i]),mEsperados[i]);
        }
    }

    private int[][] creacionArrayEsperadosHoras() {
        int[][] matrizR=new int[3][2];
        matrizR[0]=new int[]{0,0};
        matrizR[1]=new int[]{0,1};
        matrizR[2]=new int[]{1,0};
        return matrizR;
    }

    private int[][][] creacionDeMatrizIngresadaHoras() {
        int[][][] matrizH=new int[3][2][2];
        matrizH[0][0]=new int[]{30,26};
        matrizH[0][1]=new int[]{21,29};

        matrizH[1][0]=new int[]{10,23};
        matrizH[1][1]=new int[]{15,18};

        matrizH[2][0]=new int[]{20,0};
        matrizH[2][1]=new int[]{31,30};
        return matrizH;
    }


}
