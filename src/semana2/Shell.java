/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semana2;

import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author epimentel
 */
public class Shell {

    /**
     * @param args the command line arguments
     */
    public void mostrarArreglo(int[] arreglos){
        for(int i=0;i<arreglos.length; i++){
            System.out.print("["+arreglos[i]+"]");
        }
        
        System.out.println("");
        System.out.println("");
    }

    public void burbuja1(int[] arreglobur){
        int i,j,temporal;
        for(i=0;i<arreglobur.length;i++){
            for(j=i+1;j<arreglobur.length;j++){
                if(arreglobur[i]>arreglobur[j]){
                    temporal=arreglobur[i];
                    arreglobur[i]=arreglobur[j];
                    arreglobur[j]=temporal;           
                }
            }
        }
        System.out.println("Arreglo ordenado por Burbuja1");
        mostrarArreglo(arreglobur);
    }
    
    public void burbuja2(int[] arreglobur){
        int i,j,temporal;
        for(i=1;i<arreglobur.length;i++){
            for(j=0;j<arreglobur.length-1;j++){
                if(arreglobur[j]>arreglobur[j+1]){
                    temporal=arreglobur[j];
                    arreglobur[j]=arreglobur[j+1];
                    arreglobur[j+1]=temporal;           
                }
            }
        }
        System.out.println("Arreglo ordenado por Burbuja2");
        mostrarArreglo(arreglobur);
    }

    public void shells(int[] arreglo){
        int salto,i,j,k,auxiliar;
        salto = arreglo.length/2;
        while(salto>0){
            for(i=salto;i<arreglo.length; i++){
                j=i-salto;
                while(j>=0){
                    k=j+salto;
                    if (arreglo[j]<=arreglo[k]){
                        j=-1;
                    }else{
                        auxiliar=arreglo[j];
                        arreglo[j]=arreglo[k];
                        arreglo[k]=auxiliar;
                        j=j-salto;
                    }
                }
            }
            salto=salto/2;
        }
        System.out.println("Arreglo ordenado con shell");
        mostrarArreglo(arreglo);
    }
// Método Quicksort
    public void quick(int[] arregloquick, int primero, int ultimo){
        int i,j,pivote,auxiliar;
        i=primero;
        j=ultimo;
        pivote=arregloquick[(primero+ultimo)/2];
        do {
            while(arregloquick[i]<pivote){
                i++;
            }
            while(arregloquick[j]>pivote){
                j--;
            }
            // aqui hacemos el intercambio
            if (i<=j){
                auxiliar=arregloquick[i];
                arregloquick[i]=arregloquick[j];
                arregloquick[j]=auxiliar;
                i++;
                j--;
            }
        }while(i<=j);
        // Realizando la recursividad
        if (primero<j){
            quick(arregloquick,primero,i);
        }
        if(i<ultimo){
            quick(arregloquick,i,ultimo);
        }
        System.out.println("Arreglo ordenado por Quicksort");    
        mostrarArreglo(arregloquick);
    }

// _Método por insercion
    public void insercion(int[] arregloin, int n){       
        int i,j,auxiliar;
        for(i=1;i<n;i++){
            auxiliar=arregloin[i];
            j=i-1;
            while(j>=0 && arregloin[j]>auxiliar){
                arregloin[j+1]=arregloin[j];
                j=j-1;
            }
            arregloin[j+1]=auxiliar;
        }

        System.out.println("Arreglo ordenado por inserción ");
        mostrarArreglo(arregloin);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int [] vector3={5,2,1,8,3,9,7};
        int [] vector4={8,12,3,9,7,23,2};
        Scanner pant=new Scanner(System.in);
        Shell ordenar;
        ordenar = new Shell();
        
        //Mostrar arreglo Shell 01
        System.out.println("Ordenamiento por Burbuja1");
        System.out.println("Vector base");
        ordenar.mostrarArreglo(vector4);
        ordenar.burbuja1(vector4);
        System.out.println("Ordenamiento por Burbuja2");
        System.out.println("Vector base");
        ordenar.mostrarArreglo(vector4);
        ordenar.burbuja2(vector4);
        System.out.println("----------------------");
        System.out.println("");
        
        
        // Mostrar arreglo con Shell
        System.out.println("Ordenamiento por Shell");
        System.out.println("Vector base");
        ordenar.mostrarArreglo(vector3);
        ordenar.shells(vector3);
        System.out.println("----------------------");
        System.out.println("");
        
        
        // Mostrar arreglo con QuickSort
        System.out.println("Ordenamiento por Quicksort");
        System.out.println("Vector base");
        ordenar.mostrarArreglo(vector4);
        ordenar.quick(vector4,0, vector4.length-1);
        System.out.println("----------------------");
        System.out.println("");
        
        
        //Ordenamiento por inserción
        System.out.println("Ordenamiento por Inserción");
        System.out.println("Para este proceso debemos ingresar los elementos del arreglo de uno en uno");
        int tam;
        tam=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el tamaño del Arreglo "));
        int vectorcito[]=new int[tam];
        for (int i=0;i<tam;i++){
            vectorcito[i]=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el elmento del índice  "+i));
            ordenar.insercion(vectorcito, i+1);
        }
    }    
}
