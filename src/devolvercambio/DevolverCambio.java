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

    public int[] devolverCambioVoraz(double[] monedas, int[] cantidadesMonedas, double cantidad) {
        return voraz(monedas, cantidadesMonedas, cantidad);
    }

    private int[] voraz(double[] monedas, int[] cantidadMonedas, double cantidad) {
        int factorMoneda = 0;
        int resultado = 0;
        int maximoValor = 0;
        int[] resultadoTipos = new int[monedas.length];
        
        inicializarArray(resultadoTipos);

        int[] cantidadesOrdenadas = cantidadMonedas.clone();
        double[] monedasOrdenadas = monedas.clone();

        //Reordenamos las monedas de mayor a menor
        this.quickSort(monedasOrdenadas, cantidadesOrdenadas, 0, monedasOrdenadas.length - 1);

        //for (int x = 0; x < monedasOrdenadas.length; x++) {
          //  System.out.println("Array Ordenado en " + x + " -> " + monedasOrdenadas[x] + " | cantidad -> " + cantidadesOrdenadas[x]);
        //}

        //Hay que empezar por las monedas mayores ya que si no es mas dificil ncontrar solucion
        for (int i = 0; i < monedasOrdenadas.length; i++) {
            if (cantidad > 0 && cantidadesOrdenadas[i] > 0) {
                System.err.println("Paso Antes " + i + "\n    factor: " + factorMoneda + "\n    cantidad: " + cantidad + "\n    resultado: " + resultado);
                //Calculamos cuantas monedas tenemos que usar para acercarnos al resultado lo más posible
                //con el menor numero de monedas posibles.
                factorMoneda = (int)(cantidad / monedasOrdenadas[i]);
                maximoValor = (factorMoneda < cantidadesOrdenadas[i]) ? factorMoneda : cantidadesOrdenadas[i];
                resultado += maximoValor;
                resultadoTipos[resultadoTipos.length-i-1] += maximoValor;
                System.out.println("Maximo valor: " + maximoValor + " | monedasOrdenadas en " + i + "  " + monedasOrdenadas[i]);
                cantidad -= maximoValor * monedasOrdenadas[i];
                cantidadesOrdenadas[i] -= maximoValor;
                System.err.println("Paso Despues " + i + "\n    factor: " + factorMoneda + "\n    cantidad: " + cantidad + "\n    resultado: " + resultado + "\n    maximoValor: " + maximoValor);
            }
        }

        System.err.println("Paso FINAL" + "\n    factor: " + factorMoneda + "\n    cantidad: " + cantidad + "\n    resultado: " + resultado);
        return resultadoTipos;
    }
    
    private void inicializarArray(int[] array) {
        for(int i = 0; i < array.length; i++)
            array[i]=0;
    }

    public int[] devolverCambioBackTracking(double[] monedas, int[] cantidadesMonedas, double cantidad) {
        int minimo = Integer.MAX_VALUE;
        int[] resultadoTipos = new int[monedas.length];
        int[] minimoActual = new int[monedas.length];
        double[] monedasRef = monedas.clone();
        
        int factor = 100;
        long parteEntera = (long)cantidad;
        /*while(cantidad*factor-parteEntera!=0)
        {
            factor *= 10;
            parteEntera = (long)(cantidad*factor);
        }*/ 
        for(int i=0; i<monedasRef.length; i++) monedasRef[i] *= factor;
        cantidad *= factor;
        
        inicializarArray(resultadoTipos);
        
        for (int i = 0; i < monedas.length; i++) {
            if(monedasRef[i]>cantidad) break;
            mostrarMensaje("Backtracking: Probando con monedas de "+monedasRef[i]+
                    " cent. como raíz.");
            resultadoTipos = backtracking(i, monedasRef, cantidadesMonedas, cantidad);
            mostrarMensaje("Backtracking:\tMejor combinación encontrada:\n"
                    + arrayToString(resultadoTipos));
            if(valorDeArray(resultadoTipos) < minimo && 
                    solucionValida(resultadoTipos))
            {
                mostrarMensaje("Backtracking:\tEncontrado nuevo mínimo.");
                minimo = valorDeArray(resultadoTipos);
                minimoActual = resultadoTipos.clone();
            }
            inicializarArray(resultadoTipos);
            mostrarMensaje("Backtracking:\tSolución actual:\n\t\t"+
                    arrayToString(minimoActual));
        }
        mostrarMensaje("Backtracking:\tMínimo número total de monedas: "+minimo);
        return minimoActual;
    }
    
    private boolean solucionValida(int[] valores)
    {
        for(int i=0; i<valores.length; i++) if(valores[i] != 0) return true;
        return false;
    }
    
    private int valorDeArray(int[] array)
    {
        int sum = 0;
        for(int i=0; i<array.length; i++)
            sum += array[i];
        return sum;
    }
    
    public int[] devolverCambioDinamico(double[] monedas, int[] cantidadMonedas,
            int m, double n) {
        int[] resultadoTipos = new int[monedas.length];
        inicializarArray(resultadoTipos);
        dinamico(monedas, cantidadMonedas, m, n, resultadoTipos);
        return resultadoTipos;
    }

    private int[] backtracking(int idxMoneda, double[] monedas, 
            int[] cantidadesMonedas, double cantidad) {
        int resultado;
        int[] resultadoTipos = new int[monedas.length];
        long parteEntera = (long)cantidad;
        //Suprime decimales anómalos
        cantidad = cantidad - (cantidad-parteEntera);
        if(cantidad > 10 && cantidad % 10 == 9)
            cantidad++;
        //Si ya no hay nada que devolver
        if(cantidad == 0) 
        {
            resultadoTipos[idxMoneda] = 0;
            return resultadoTipos;
        }
        //Si la cantidad a devolver es múltiplo del valor de la moneda actual
        if(cantidad%monedas[idxMoneda] == 0 && 
                cantidad/monedas[idxMoneda] <= cantidadesMonedas[idxMoneda])
        {
            mostrarMensaje("Backtracking:\tEncontrada solución en "+
                    monedas[idxMoneda]+": "+(int)(cantidad/monedas[idxMoneda]));
            resultadoTipos[idxMoneda] = (int)(cantidad/monedas[idxMoneda]);
            mostrarMensaje("\t\t\tCombinación: "+arrayToString(resultadoTipos));
            return resultadoTipos;
        }
        else{ resultado = Integer.MAX_VALUE;}
            mostrarMensaje("Backtracking:\tCalculando posibilidades con "+
                    monedas[idxMoneda]);
            int factorMoneda = (int)(cantidad/monedas[idxMoneda]);
            int maximas_monedas = (factorMoneda<cantidadesMonedas[idxMoneda])?
                    factorMoneda : cantidadesMonedas[idxMoneda];
            mostrarMensaje("Backtracking:\tMáximo de monedas: "+maximas_monedas
                    +"; la cantidad a cambiar es "+cantidad);
            int mejor_x = -1;
            int[] resultadoProvisional = new int[resultadoTipos.length];
            //Comprueba todas las posibles combinaciones hasta encontrar una 
            //válida
            for(int x=1; x<=maximas_monedas; x++)
            {
                for(int i=0; i<monedas.length; i++)
                {
                    //Limita la posibilidad de usar la moneda actual como hijo
                    //evitando corrupción en el proceso
                    int cantidadReal = cantidadesMonedas[idxMoneda];
                    cantidadesMonedas[idxMoneda] = 0;
                    int temp = Integer.MAX_VALUE;
                    //Si el hijo es viable
                    if(i != idxMoneda &&
                            cantidadesMonedas[i] > 0
                            && monedas[i] <= cantidad-x*monedas[idxMoneda])
                    {
                        mostrarMensaje("Backtracking:\tComprobando con "+x+" monedas"
                            + " de "+monedas[idxMoneda]+" y monedas de "+
                            monedas[i]);
                        resultadoProvisional = backtracking(i, monedas, cantidadesMonedas, 
                                cantidad-x*monedas[idxMoneda]);
                        mostrarMensaje("\t\t\tCombinación: "+
                                arrayToString(resultadoProvisional));
                    }
                    cantidadesMonedas[idxMoneda] = cantidadReal;
                    if(valorDeArray(resultadoProvisional) < resultado
                            && solucionValida(resultadoProvisional)){ 
                        resultado = valorDeArray(resultadoProvisional);
                        mejor_x = x;
                        mostrarMensaje("Backtracking:\tNuevo mínimo "
                                + "encontrado: "+resultado+"\n"
                                + "\t\t\tMejor caso: "+mejor_x);
                        resultadoTipos = resultadoProvisional.clone();
                    }
                }
            }
            if(resultado < Integer.MAX_VALUE)
            {
                resultado += mejor_x;
                resultadoTipos[idxMoneda] = mejor_x;
            }
            mostrarMensaje("Bactracking:\tMejor caso encontrado para monedas de "
                    + monedas[idxMoneda]+": "+resultado+"\n"
                    + "\t\t\tCombinación: "+arrayToString(resultadoTipos));
            return resultadoTipos;
    }

    
    private String arrayToString(int[] array)
    {
        String str = "";
        for(int i=0; i<array.length; i++)
            str+=array[i]+", ";
        return str;
    }

    private int dinamico(double[] monedas, int[] cantidadMonedas, int m, 
            double n, int[] resultadoTipos) {
        int i, j, x = 0, y = 0;
        //Tabla de n+1 filas. Necesaria porque evaluamos el caso n = 0.
        int[][] tabla = null;
        int factor = 1;
        long parteEntera = (long)n;
        while(n*factor-parteEntera!=0)
        {
            factor *= 10;
            parteEntera = (long)(n*factor);
        }
        tabla = new int[m][(int)(n*factor+1)];
        double[] monedasRef = monedas.clone();
        if(factor > 1)
        {
            mostrarMensaje("Dinámica:\tCreando equivalencia entera.");
            for(i=0; i<monedasRef.length; i++) monedasRef[i] *= factor;
        }
        mostrarMensaje("Dinámica:\tCreada tabla de " + (n + 1) + "x" + m + ".");
        //Llenar las entradas para el caso n=0.
        for (i = 0; i < monedas.length; i++) {
            mostrarMensaje("Dinámica:\tCreando caso base.");
            tabla[i][0] = 0;
        }

        //Llenamos el resto de entradas con una aproximacion de abajo a arriba.
        for (i = 0; i < tabla.length; i++) {
            for (j = 1; j < tabla[i].length; j++) {
                double valRef = monedasRef[i];
                mostrarMensaje("Dinámica:\tevaluando caso: (" + i + "," + j + ")");
                if (i == 0 && j < valRef) {
                    mostrarMensaje("\t\t\t->Sin solución.");
                    tabla[i][j] = 0;
                } else if (i == 0) {
                    mostrarMensaje("\t\t\t->Tomando valor de (" + i + ","
                            + (j - valRef) + ").");
                    tabla[i][j] = 1 + tabla[i][(int)(j - valRef)];
                } else if (j < valRef) {
                    mostrarMensaje("\t\t\t->Tomando valor de (" + (i - 1) + ","
                            + j + ").");
                    tabla[i][j] = tabla[i - 1][j];
                } else {
                    mostrarMensaje("\t\t\t->Determinando mínimo entre (" + i + ","
                            + (int)(j - valRef) + ") y (" + (i - 1) + ","
                            + j + ").");
                    if (tabla[i - 1][j] < 1 + tabla[i][(int)(j - valRef)]) {
                        mostrarMensaje("\t\t\t->Tomando valor de (" + (i - 1) + ","
                                + j + ").");
                        tabla[i][j] = tabla[i - 1][j];
                    } else {
                        mostrarMensaje("\t\t\t->Tomando valor de (" + i + ","
                                + (int)(j - valRef) + ").");
                        tabla[i][j] = 1 + tabla[i][(int)(j - valRef)];
                    }
                    if(monedas[i] > n && i>0) tabla[i][j] = tabla[i-1][j];
                }
                escribirTabla(tabla);
                System.out.println();
            }
        }
        i = tabla.length-1;
        j = tabla[i].length-1;
        int referencia = j;
        mostrarMensaje("Backtracking:\tGenerando desglose.");
        if(factor == 0) mostrarMensaje("Backtracking:\t\tAYUDA, EL FACTOR ES 0");
        n*=factor;
        while(i > -1 && j>-1 && n>0)
        {
            mostrarMensaje("\t\t->Evaluando monedas de "+monedasRef[i]+".\n"
                    + "\t\t\tValor a cambiar: "+n+
                    "\t\t\tPosición actual ("+i+","+j+")");
            if(tabla[i][j] == 0)
            {
                mostrarMensaje("\t\t\tEncontrado último componente de la"
                        + " solución.");
                resultadoTipos[i] = tabla[i][referencia];
                break;
            }
            else
            if((int)(n/monedasRef[i]) == tabla[i][j] && n%monedasRef[i] == 0)
            {
                mostrarMensaje("\t\t\tEncontrada solución total.");
                resultadoTipos[i] = tabla[i][j];
                n=0;
                break;
            }
            else
            if(i>0)
                if(monedasRef[i]>n){ 
                    mostrarMensaje("\t\t\tEl valor de la moneda excede la"
                            + " cantidad a cambiar.");
                    referencia = j;
                    i--;}
                else
                if(tabla[i][j] == tabla[i-1][j] && 
                        tabla[i][j-1] == tabla[i-1][j-1])
                {
                    mostrarMensaje("\t\t\tEncontrado valor de cambio de caso.");
                    n+=resultadoTipos[i] * monedasRef[i];
                    resultadoTipos[i] = tabla[i][referencia] - tabla[i][j];
                    referencia = j;
                    n -= resultadoTipos[i] * monedasRef[i];
                    i--;
                }
                else{
                    if(tabla[i][j] < tabla[i][referencia])
                    {
                        mostrarMensaje("\t\t\tActualizando valor total.");
                        int dif = tabla[i][referencia] - tabla[i][j];
                        if(dif * monedasRef[i] <= n)
                        {
                            n -= dif*monedasRef[i];
                            resultadoTipos[i] += dif;
                        }                            
                    }
                    j--;
                    }
            else j--;
            mostrarMensaje("\t\t\tCantidad actual: "+resultadoTipos[i]);
        }
        //Como viene siendo habitual en estos casos, el ultimo elemento de la tabla es la solucion deseada.
        return tabla[tabla.length-1][tabla[0].length-1];
    }

    private void escribirTabla(int[][] tabla) {
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
