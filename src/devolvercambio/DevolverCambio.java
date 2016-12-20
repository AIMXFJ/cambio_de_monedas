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

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String mensaje) {
        System.err.println(mensaje);
    }

    public int devolverCambioVoraz(double[] monedas, int[] cantidadesMonedas, double cantidad) {
        return voraz(monedas, cantidadesMonedas, cantidad);
    }

    private int voraz(double[] monedas, int[] cantidadMonedas, double cantidad) {
        double factorMoneda = 0;
        int resultado = 0;
        double maximoValor = 0;

        int[] cantidadesOrdenadas = cantidadMonedas.clone();
        double[] monedasOrdenadas = monedas.clone();

        //Reordenamos las monedas de mayor a menor
        this.quickSort(monedasOrdenadas, cantidadesOrdenadas, 0, monedasOrdenadas.length - 1);

        for (int x = 0; x < monedasOrdenadas.length; x++) {
            System.out.println("Array Ordenado en " + x + " -> " + monedasOrdenadas[x] + " | cantidad -> " + cantidadesOrdenadas[x]);
        }

        //Hay que empezar por las monedas mayores ya que si no es mas dificil ncontrar solucion
        for (int i = 0; i < monedasOrdenadas.length; i++) {
            if (cantidad > 0 && cantidadesOrdenadas[i] > 0) {
                System.err.println("Paso " + i + "\n    factor: " + factorMoneda + "\n    cantidad: " + cantidad + "\n    resultado: " + resultado);
                //Calculamos cuantas monedas tenemos que usar para acercarnos al resultado lo más posible
                //con el menor numero de monedas posibles.
                factorMoneda = cantidad / monedasOrdenadas[i];
                maximoValor = (factorMoneda < cantidadesOrdenadas[i]) ? factorMoneda : cantidadesOrdenadas[i];
                resultado += maximoValor;
                cantidad -= maximoValor * monedasOrdenadas[i];
                cantidadesOrdenadas[i] -= maximoValor;
                System.err.println("Paso " + i + "\n    factor: " + factorMoneda + "\n    cantidad: " + cantidad + "\n    resultado: " + resultado + "\n    maximoValor: " + maximoValor);
            }
        }

        System.err.println("Paso FINAL" + "\n    factor: " + factorMoneda + "\n    cantidad: " + cantidad + "\n    resultado: " + resultado);
        return resultado;
    }

    public int devolverCambioBackTracking(double[] monedas, int[] cantidadesMonedas, double cantidad) {
        double minimo = Integer.MAX_VALUE;
        for (int i = 0; i < monedas.length; i++) {
            double valor = backtracking(i, monedas, cantidadesMonedas, cantidad);
            minimo = (valor < minimo && valor > -1) ? valor : minimo;
        }
        return (int) minimo;
    }

    public int devolverCambioDinamico(double[] monedas, int[] cantidadMonedas, int m, double n) {
        return (int) dinamico(monedas, cantidadMonedas, m, n);
    }

    private int backtracking(int idxMoneda, double[] monedas, int[] cantidadesMonedas, double cantidad) {
        //No hay que devolver nada
        if (cantidad == 0) {
            return 0;	//Devuelve 0 como cantidad de monedas
        }	//Comprobar si se puede llegar a devolver cambio
        if (idxMoneda < monedas.length && cantidad > 0) {
            //Toma un maximo numero de monedas a analizar, dependiente de la cantidad a devolver
            double factorMoneda = cantidad / monedas[idxMoneda];
            //Toma como maximo el minimo entre el numero de monedas que se podrian utilizar de ese tipo y las que hay realmente
            double maximo_valor = (factorMoneda < cantidadesMonedas[idxMoneda]) ? factorMoneda : cantidadesMonedas[idxMoneda];
            //Establece un coste minimo preliminar
            double minimo_coste = Integer.MAX_VALUE;
            //Itera por todas las posibles combinaciones de monedas
            for (int x = 1; x <= maximo_valor; x++) {
                //Si hace falta devolver mas
                if (cantidad >= x * monedas[idxMoneda]) {
                    //cantidadesMonedas[idxMoneda] -= x * monedas[idxMoneda];
                    //Obtiene la mejor combinacion con el resto de monedas
                    double res = -1;
                    for (int i = 0; i < monedas.length; i++) {
                        double temp = -1;
                        int cantidadReal = cantidadesMonedas[idxMoneda];
                        cantidadesMonedas[idxMoneda] = 0;
                        if (i != idxMoneda) {
                            temp = paso_intermedio_backtracking(i, monedas,
                                    cantidadesMonedas, cantidad - x * monedas[idxMoneda]);
                        }
                        if (temp > -1) {
                            if (res > -1) {
                                res = (temp < res) ? temp : res;
                            } else {
                                res = temp;
                            }
                        }
                        cantidadesMonedas[idxMoneda] = cantidadReal;
                    }
                    //Comprueba si hay solucion
                    if (res != -1) //Si la hay, comprueba si mejora la actual
                    {
                        minimo_coste = (res + x < minimo_coste) ? res + x : minimo_coste;
                    } else if (x * monedas[idxMoneda] == cantidad) {
                        minimo_coste = (x < minimo_coste) ? x : minimo_coste;
                    }
                }
            }
            //Devuelve la solucion, de haberla, o -1
            return (int) ((minimo_coste == Integer.MAX_VALUE) ? -1 : minimo_coste);
        }
        //No existe solucion; devuelve -1
        return -1;
    }

    private int paso_intermedio_backtracking(int idxMoneda, double[] monedas, int[] cantidadesMonedas, double cantidad) {
        //No hay que devolver nada
        if (cantidad == 0) {
            return 0;	//Devuelve 0 como cantidad de monedas
        }	//Comprobar si se puede llegar a devolver cambio
        if (idxMoneda < monedas.length && cantidad > 0) {
            //Toma un maximo numero de monedas a analizar, dependiente de la cantidad a devolver
            double factorMoneda = cantidad / monedas[idxMoneda];
            //Toma como maximo el minimo entre el numero de monedas que se podrian utilizar de ese tipo y las que hay realmente
            double maximo_valor = (factorMoneda < cantidadesMonedas[idxMoneda]) ? factorMoneda : cantidadesMonedas[idxMoneda];
            //Establece un coste minimo preliminar
            double minimo_coste = Integer.MAX_VALUE;
            //Itera por todas las posibles combinaciones de monedas
            for (int x = 0; x <= maximo_valor; x++) {
                //Si hace falta devolver mas
                if (cantidad >= x * monedas[idxMoneda]) {
                    //Obtiene la mejor combinacion con el resto de monedas
                    int res = -1;
                    for (int i = 0; i < monedas.length; i++) {
                        int temp = -1;
                        int cantidadReal = cantidadesMonedas[idxMoneda];
                        cantidadesMonedas[idxMoneda] = 0;
                        if (i != idxMoneda) {
                            temp = backtracking(i, monedas,
                                    cantidadesMonedas, cantidad - x * monedas[idxMoneda]);
                        }
                        if (temp > -1) {
                            if (res > -1) {
                                res = (temp < res) ? temp : res;
                            } else {
                                res = temp;
                            }
                        }
                        cantidadesMonedas[idxMoneda] = cantidadReal;
                    }
                    //Comprueba si hay solucion
                    if (res != -1) //Si la hay, comprueba si mejora la actual
                    {
                        minimo_coste = (res + x < minimo_coste) ? res + x : minimo_coste;
                    } else if (x * monedas[idxMoneda] == cantidad) {
                        minimo_coste = (x < minimo_coste) ? x : minimo_coste;
                    }
                }
            }
            //Devuelve la solucion, de haberla, o -1
            return (int) ((minimo_coste == Integer.MAX_VALUE) ? factorMoneda : minimo_coste);
        }
        //No existe solucion; devuelve -1
        return -1;
    }

    private double dinamico(double[] monedas, int[] cantidadMonedas, int m, double n) {
        int i, j, x = 0, y = 0;
        //Tabla de n+1 filas. Necesaria porque evaluamos el caso n = 0.
        double[][] tabla = new double[m][(int)n + 1];
        mostrarMensaje("Dinámica:\tCreada tabla de " + (n + 1) + "x" + m + ".");
        //Llenar las entradas para el caso n=0.
        for (i = 0; i < monedas.length; i++) {
            mostrarMensaje("Dinámica:\tCreando caso base.");
            tabla[i][0] = 0;
        }

        //Llenamos el resto de entradas con una aproximacion de abajo a arriba.
        for (i = 0; i < tabla.length; i++) {
            for (j = 0; j < tabla[i].length; j++) {
                mostrarMensaje("Dinámica:\tevaluando caso: (" + i + "," + j + ")");
                if (i == 0 && j < monedas[i]) {
                    mostrarMensaje("\t\t\t->Sin solución.");
                    tabla[i][j] = 0;
                } else if (i == 0) {
                    mostrarMensaje("\t\t\t->Tomando valor de (" + i + ","
                            + (j - monedas[i]) + ").");
                    tabla[i][j] = 1 + tabla[i][j - (int)monedas[i]];
                } else if (j < monedas[i]) {
                    mostrarMensaje("\t\t\t->Tomando valor de (" + (i - 1) + ","
                            + j + ").");
                    tabla[i][j] = tabla[i - 1][j];
                } else {
                    mostrarMensaje("\t\t\t->Determinando mínimo entre (" + i + ","
                            + (j - monedas[i]) + ") y (" + (i - 1) + ","
                            + j + ").");
                    if (tabla[i - 1][j] < 1 + tabla[i][j - (int)monedas[i]]) {
                        mostrarMensaje("\t\t\t->Tomando valor de (" + (i - 1) + ","
                                + j + ").");
                        tabla[i][j] = tabla[i - 1][j];
                    } else {
                        mostrarMensaje("\t\t\t->Tomando valor de (" + i + ","
                                + (j - monedas[i]) + ").");
                        tabla[i][j] = 1 + tabla[i][j - (int)monedas[i]];
                    }

                }
                escribirTabla(tabla);
                System.out.println();
            }
        }
        //Como viene siendo habitual en estos casos, el ultimo elemento de la tabla es la solucion deseada.
        return tabla[m - 1][(int)n];
    }

    private void escribirTabla(double[][] tabla) {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.print(tabla[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void quickSort(double[] array, int[] cantidades, int low, int high) {
        if (array == null || array.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        // pick the pivot
        int middle = low + (high - low) / 2;
        double pivot = array[middle];
        int cantidadPivot = cantidades[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (array[i] > pivot) {
                i++;
            }

            while (array[j] < pivot) {
                j--;
            }

            if (i <= j) {
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                int tempCant = cantidades[i];
                cantidades[i] = cantidades[j];
                cantidades[j] = tempCant;

                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j) {
            quickSort(array, cantidades, high, j);
        }

        if (high > i) {
            quickSort(array, cantidades, i, low);
        }
    }
}
