package com.company;

public class Primos {

    /**
     * @param max Numero que determina el usuario como maximo para la generación de núemros primos
     * @return Devuelve el metodo que realiza el llenado del vector con numeros primos
     */
// Generar números primos de 1 a max
    public static int[] generarPrimos (int max) {
        Primos primo = new Primos();
        int i,j;
        if (max >= 2) {
            int dim = max + 1; //Tamaño del array
            boolean[] esPrimo = new boolean[dim];
            //Inicializar el array
            esPrimo=primo.inicializarArray(dim,esPrimo);

            // Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;

            // Criba
            esPrimo=primo.criba(esPrimo,dim);

            // ¿Cuántos primos hay?
            int cuenta= primo.cuentaPrimos(dim,esPrimo);

            //Rellenar el vector de números primos
            return primo.rellenarVectorPrimos(cuenta,dim,esPrimo);
        }

        else { // en caso de que max < 2
            return new int[0];
            // Vector vacío

        }
    }

    /**
     * @param dim Determina el tamaño del array
     * @param esPrimo Determina si es primo o no
     * @return Devuelve la cuenta de numeros primos
     */
    //¿Cuántos primos hay?
    public int cuentaPrimos(int dim, boolean [] esPrimo) {
        int cuenta = 0;
        for (int i = 0; i < dim; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }return cuenta;
    }


    /**
     * @param cuenta Determina cuantos numeros primos hay
     * @param dim Determina el tamaño del array
     * @param esPrimo Determina si es primo o no
     * @return Devuelve la serie de numeros primos para rellenar el vector con ellos
     */
    // Rellenar el vector de números primos
    public int [] rellenarVectorPrimos(int cuenta, int dim, boolean [] esPrimo){
        int[] primos = new int[cuenta];
        int i;
        int j;
        for (i=0, j=0; i<dim; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }
        return primos;
    }

    /**
     * @param esPrimo Determina si es primo o no
     * @param dim Determina el tamaño del array
     * @return Devuelve si es primo o no mediante un boolean
     */
    public boolean [] criba(boolean [] esPrimo, int dim){
        for (int i=2; i<Math.sqrt(dim)+1; i++) {
            if (esPrimo[i]) {
                //Eliminar los múltiplos de i
                for (int j = 2 * i; j < dim; j += i) {
                    esPrimo[j] = false;
                }
            }
        }return esPrimo;
    }

    /**
     * @param dim Determina el tamaño del array
     * @param esPrimo Determina si es primo o no
     * @return Devuelve la inicialización del array
     */
    public boolean [] inicializarArray(int dim,boolean[] esPrimo){
        //Inicializar el array
        for (int i=0; i<dim; i++) {
            esPrimo[i] = true;
        }


        return esPrimo;
    }

}