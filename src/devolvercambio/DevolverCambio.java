/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devolvercambio;

/**
 *
 * @author AIMX
 */
public class DevolverCambio {

    /**
     * @param args the command line arguments
     */
    public DevolverCambio() {

    }

    public int devolverCambioBackTracking(int[] monedas, int[] cantidadesMonedas, int cantidad) {
        return backtracking(0, monedas, cantidadesMonedas, cantidad);
    }

    public int devolverCambioDinamico(int[] monedas, int[] cantidadMonedas, int m, int n) {
        return dinamico(monedas, cantidadMonedas, m, n);
    }

    private int backtracking(int idxMoneda, int[] monedas, int[] cantidadesMonedas, int cantidad) {
        //No hay que devolver nada
        if (cantidad == 0) {
            return 0;	//Devuelve 0 como cantidad de monedas
        }	//Comprobar si se puede llegar a devolver cambio
        if (idxMoneda < monedas.length && cantidad > 0) {
            //Toma un maximo numero de monedas a analizar, dependiente de la cantidad a devolver
            int factorMoneda = cantidad / monedas[idxMoneda];
            //Toma como maximo el minimo entre el numero de monedas que se podrian utilizar de ese tipo y las que hay realmente
            int maximo_valor = (factorMoneda < cantidadesMonedas[idxMoneda]) ? factorMoneda : cantidadesMonedas[idxMoneda];
            //Establece un coste minimo preliminar
            int minimo_coste = Integer.MAX_VALUE;
            //Itera por todas las posibles combinaciones de monedas
            for (int x = 0; x < maximo_valor; x++) {
                //Si hace falta devolver mas
                if (cantidad >= x * monedas[idxMoneda]) {
                    cantidadesMonedas[idxMoneda] -= x * monedas[idxMoneda];
                    //Obtiene la mejor combinacion con el resto de monedas
                    int res = backtracking(idxMoneda + 1, monedas, cantidadesMonedas, cantidad);
                    //Comprueba si hay solucion
                    if (res != -1) //Si la hay, comprueba si mejora la actual
                    {
                        minimo_coste = (res + x < minimo_coste) ? res + x : minimo_coste;
                    }
                }
            }
            //Devuelve la solucion, de haberla, o -1
            return (minimo_coste == Integer.MAX_VALUE) ? -1 : minimo_coste;
        }
        //No existe solucion; devuelve -1
        return -1;
    }

    private int dinamico(int[] monedas, int[] cantidadMonedas, int m, int n) {
        int i, j, x, y;
        //Tabla de n+1 filas. Necesaria porque evaluamos el caso n = 0.
        int[][] tabla = new int[n + 1][m];

        //Llenar las entradas para el caso n=0.
        for (i = 0; i < m; i++) {
            tabla[0][i] = 1;
        }

        //Llenamos el resto de entradas con una aproximacion de abajo a arriba.
        for (i = 0; i < m; i++) {
            //Rellena todos los casos que tenga sentido rellenar
            for (j = 0; j < cantidadMonedas[i]; j++) {
                // Cuenta de las soluciones que incluyen monedas[j]
                x = (j - monedas[i] >= 0) ? tabla[i][j-monedas[i]] : 0;
                //Cuenta de las soluciones que no incluyen monedas[j]
                y = (j >= 1) ? tabla[i][j - 1] : 0;
                // Cuenta de todas las soluciones
                tabla[i][j] = x + y;
            }
            //Rellena los casos imposibles con lo que hubiese en los anteriores para poder situar el resultado al final
            for (j = cantidadMonedas[i]; j < m; j++) {
                tabla[i][j] = (j - 1 >= 0) ? tabla[i][j - 1] : 0;
            }
        }
        //Como viene siendo habitual en estos casos, el ultimo elemento de la tabla es la solucion deseada.
        return tabla[n][m - 1];
    }
}
