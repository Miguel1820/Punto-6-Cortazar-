import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Punto6 {

    // Clase q crea una pila
    static class Pila {
        private List<Object> pila;
        public Pila() {
            pila = new ArrayList<>();
        }

        public void apilar(Object item) {
            pila.add(item);
        }

        public Object desapilar() {
            if (!estaVacia()) {
                return pila.remove(pila.size() - 1);
            } else {
                JOptionPane.showMessageDialog(null, "La pila está vacía");
                return null;
            }
        }

        public boolean estaVacia() {
            return pila.isEmpty();
        }

        public void mostrar() {
            StringBuilder sb = new StringBuilder();
            for (Object item : pila) {
                sb.append(item).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    // obtener la matriz de entrada
    public static int[][] obtenerMatriz(String mensaje) { //los mensajes locmuestro abajo con un metodo
        String entrada = JOptionPane.showInputDialog(mensaje);
        String[] filas = entrada.split(";");
        int[][] matriz = new int[filas.length][];
        for (int i = 0; i < filas.length; i++) {
            String[] elementos = filas[i].split(",");
            matriz[i] = new int[elementos.length];
            for (int j = 0; j < elementos.length; j++) {
                matriz[i][j] = Integer.parseInt(elementos[j].trim());
            }
        }
        return matriz;
    }

    // Suma de filas y promedio
    public static Pila sumaFilasPromedio(int[][] matriz) {
        Pila pilaResult = new Pila();
        for (int i = 0; i < matriz.length; i++) {
            int sumaFila = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                sumaFila += matriz[i][j];
            }
            double promedioFila = sumaFila / (double) matriz[i].length;
            pilaResult.apilar(promedioFila);
        }
        return pilaResult;
    }

    // Suma de columnas y raíz cuadrada
    public static Pila sumaColumnasRaiz(int[][] matriz) {
        Pila pilaResult = new Pila();
        for (int j = 0; j < matriz[0].length; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < matriz.length; i++) {
                sumaColumna += matriz[i][j];
            }
            double raizCuadrada = Math.sqrt(sumaColumna);
            pilaResult.apilar(raizCuadrada);
        }
        return pilaResult;
    }

    // le quedo debiendo la multiplicacion (no me alcanzo el tiempo) :(
       

    //mostamos con JOption en un metodo aparte (mensajes al usuario)
    public static void main(String[] args) {
        // Obtener las matrices de entrada
        int[][] matrizA = obtenerMatriz("Introduce la matriz A (filas separadas por ; y elementos por ,):");
        int[][] matrizB = obtenerMatriz("Introduce la matriz B (filas separadas por ; y elementos por ,):");

        // Suma de filas y promedio
        Pila pilaFilas = sumaFilasPromedio(matrizA);
        JOptionPane.showMessageDialog(null, "Promedios de las filas es:");
        pilaFilas.mostrar();

        // Suma de columnas y raíz cuadrada
        Pila pilaColumnas = sumaColumnasRaiz(matrizA);
        JOptionPane.showMessageDialog(null, "Raíz cuadrada de las sumas de las columnas es:");
        pilaColumnas.mostrar();
        
        }
    }
