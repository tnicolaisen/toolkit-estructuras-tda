package Utilidades;
import Interfaces.*;
import Implementaciones.*;
import java.util.Scanner;

public class HerramientasTDA {

    static Scanner sc = new Scanner(System.in);

    // ----------------------------------------------------------------------------------------------------------------
    // CARGA DE DATOS
    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Permite al usuario cargar una pila hasta que se pase como valor "-1".
     * @param pila  La pila que se pretende cargar.
     * @param puedeEstarVacia Determina si la pila puede estar vacía o no.
     */
    public static void Cargar(PilaTDA pila, boolean puedeEstarVacia){
        int entrada;
        // Verifica si la pila puede estar vacía
        if (puedeEstarVacia) {
            // Si puede estar vacía, sólo se agregan los datos hasta que se ingrese -1
            while ((entrada = sc.nextInt()) != -1) {
                pila.Apilar(entrada);
            }
        }
        else {
            // Si no, se espera que se añada al menos un sólo elemento y luego se termina al pasar -1
            while ((entrada = sc.nextInt()) == -1) {
                System.out.println("INFO: La pila no puede estar vacia. Intoduzca al menos un elemento.");
            }
            pila.Apilar(entrada);
            while ((entrada = sc.nextInt()) != -1) {
                pila.Apilar(entrada);
            }
        }
    }

    /**
     * Carga la cola constantemente hasta que el usuario pase -1 por consola.
     * @param cola La cola a cargar.
     * @param puedeEstarVacia Si el usuario desea que la cola pueda estar vacía o no.
     */
    public static void Cargar(ColaTDA cola, boolean puedeEstarVacia){
        int entrada;
        // Verifico si la cola puede estar vacía
        if (puedeEstarVacia){
            // Si puede estar vacía, simplemente dejo de agregar elementos cuando se introduzca -1
            while ((entrada = sc.nextInt()) != -1){cola.Acolar(entrada);}
        } else {
            // Si no, verifico que primero quse agrege un elemento y luego dejo de hacerlo hasta que se introduzca -1.
            while ((entrada = sc.nextInt()) == -1){System.out.println("INFO: La cola no puede estar vacía. Ingrese al menos un elemento:");}
            cola.Acolar(entrada);
            while ((entrada = sc.nextInt()) != -1){cola.Acolar(entrada);}
        }
    }

    // ----------------------------------------------------------------------------------------------------------------
    // IMPRESIÓN DE ESTRUCTURAS DE DATOS
    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Genera un String con los elementos pertenecientes a una pila para que sea mas legible por consola
     * @param pila La pila que se pretende mostrar
     * @return String con los elementos pertenecientes a la pila separados por un espacio.
     */
    public static String StringTDA(PilaTDA pila){
        // Creo una pila auxiliar y el String que se devolverá
        PilaTDA auxiliar = new ImplementacionPila();
        auxiliar.InicializarPila();
        String stringPila = "";

        while (!pila.EstaVacia()) {
            stringPila += " " + pila.Tope();
            auxiliar.Apilar(pila.Tope());
            pila.Desapilar();
        }
        while (!auxiliar.EstaVacia()) {
            pila.Apilar(auxiliar.Tope());
            auxiliar.Desapilar();
        }
        return stringPila;
    }

    /**
     * Devuelve un String legible con todos los elementos de la cola.
     * @param cola La cola que se solicita el string.
     * @return String con los elementos de la cola.
     */
    public static String StringTDA(ColaTDA cola){

        // Creo el String a devolver
        String stringCola = "";
        // Invoco una cola auxiliar
        ColaTDA aux = new ImplementacionCola();
        aux.InicializarCola();
        // Recorro la cola, añadiendo los valores de la misma al String, y la guardo en el auxiliar.
        while (!cola.EstaVacia()){
            stringCola += " " + cola.Primero();
            aux.Acolar(cola.Primero());
            cola.Desacolar();
        }
        // Restauro la cola original
        while (!aux.EstaVacia()){
            cola.Acolar(aux.Primero());
            aux.Desacolar();
        }
        // Retorno el string final
        return stringCola;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // LONGITUD DE ESTRUCTURAS
    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Devuelve el valor entero de la longitud de una pila
     * @param pila Pila a evaluar
     * @return Longitud de la pila
     */
    public static int Longitud(PilaTDA pila){
        //Creo una pila auxiliar para almacenar los valores de la pila original, y cuento su longitud
        PilaTDA auxiliar = new ImplementacionPila();
        auxiliar.InicializarPila();
        int longitud = 0;
        while(!pila.EstaVacia()){
            auxiliar.Apilar(pila.Tope());
            pila.Desapilar();
            longitud++;
        }
        while (!auxiliar.EstaVacia()){
            pila.Apilar(auxiliar.Tope());
            auxiliar.Desapilar();
        }
        return longitud;
    }

    /**
     * Devuelve el entero correspondiente a la longitud de la cola a evaluar.
     * @param cola Cola a evaluar.
     * @return Longitud de la cola evaluada.
     */
    public static int Longitud(ColaTDA cola){
        // Creo una cola auxiliar para rescatar a la cola original
        ColaTDA aux = new ImplementacionCola();
        aux.InicializarCola();
        // Con la ayuda de un contador, voy verificando cuantos elementos tiene la cola (su longitud).
        int longitud = 0;
        while(!cola.EstaVacia()){
            aux.Acolar(cola.Primero());
            cola.Desacolar();
            longitud++;
        }
        // Restauro la cola original
        while (!aux.EstaVacia()){
            cola.Acolar(aux.Primero());
            aux.Desacolar();
        }
        // Retorno la longitud de la cola
        return longitud;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // COMPARACIÓN
    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Compara dos pilas distintas y devuelve si las pilas son iguales (en orden y contenido) o no.
     * @param pila1 Pila 1 a comparar.
     * @param pila2 Pila 2 a comparar.
     * @return Valor booleano que refiere a si ambas pila son iguales.
     */
    public static boolean ContienenLoMismo(PilaTDA pila1, PilaTDA pila2){
        // Primero verifico que las pilas tengan la misma longitud (de caso contrario, claramente ambas pilas son diferentes).
        if (Longitud(pila1) != Longitud(pila2)) {return false;}
        // Luego, usando dos pilas auxiliares para guardar los datos, voy evaluando uno a uno.
        else {
            boolean iguales = true;
            PilaTDA auxiliar1 = new ImplementacionPila();
            PilaTDA auxiliar2 = new ImplementacionPila();
            auxiliar1.InicializarPila();
            auxiliar2.InicializarPila();
            while (!pila1.EstaVacia()) {
                if (pila1.Tope() != pila2.Tope()) {
                    iguales = false;
                }
                auxiliar1.Apilar(pila1.Tope());
                auxiliar2.Apilar(pila2.Tope());
                pila1.Desapilar();
                pila2.Desapilar();
            }
            while (!auxiliar1.EstaVacia()){
                pila1.Apilar(auxiliar1.Tope());
                pila2.Apilar(auxiliar2.Tope());
                auxiliar1.Desapilar();
                auxiliar2.Desapilar();
            }
            return iguales;
        }
    }

    /**
     * Compara dos colas distintas y devuelve si las colas son iguales (en orden y contenido) o no.
     * @param cola1 Cola 1 a comparar.
     * @param cola2 Cola 2 a comparar.
     * @return Valor booleano que refiere a si ambas pila son iguales.
     */
    public static boolean ContienenLoMismo(ColaTDA cola1, ColaTDA cola2){
        if (Longitud(cola1) != Longitud(cola2)) {return false;}
        else {
            boolean iguales = true;
            ColaTDA auxiliar1 = new ImplementacionCola();
            ColaTDA auxiliar2 = new ImplementacionCola();
            auxiliar1.InicializarCola();
            auxiliar2.InicializarCola();
            while (!cola1.EstaVacia()) {
                if (cola1.Primero() != cola2.Primero()) {
                    iguales = false;
                }
                auxiliar1.Acolar(cola1.Primero());
                auxiliar2.Acolar(cola2.Primero());
                cola1.Desacolar();
                cola2.Desacolar();
            }
            while (!auxiliar1.EstaVacia()){
                cola1.Acolar(auxiliar1.Primero());
                cola2.Acolar(auxiliar2.Primero());
                auxiliar1.Desacolar();
                auxiliar2.Desacolar();
            }
            return iguales;
        }
    }

    // ----------------------------------------------------------------------------------------------------------------
    // REORDENAMIENTO DE ELEMENTOS
    // ----------------------------------------------------------------------------------------------------------------

    // INICIO AL FINAL
    // Cola
    /**
     * Reordena los elementos de la cola para que el primer elemento sea el último (orden FIFO).
     * @param cola Cola a reordenar
     */
    public static void InicioAlFinal(ColaTDA cola){
        ColaTDA aux = new ImplementacionCola();
        aux.InicializarCola();
        int primeroCola = cola.Primero();
        cola.Desacolar();
        while (!cola.EstaVacia()) {
            aux.Acolar(cola.Primero());
            cola.Desacolar();
        } while (!aux.EstaVacia()){
            cola.Acolar(aux.Primero());
            aux.Desacolar();
        }
        cola.Acolar(primeroCola);
    }

    // Pila
    /**
     * Reordena los elementos de la pila para que el primer elemento sea el último (orden LIFO).
     * @param pila Cola a reordenar
     */
    public static void InicioAlFinal(PilaTDA pila){
        PilaTDA aux = new ImplementacionPila();
        aux.InicializarPila();
        int topePila = pila.Tope();
        pila.Desapilar();
        while (!pila.EstaVacia()) {
            aux.Apilar(pila.Tope());
            pila.Desapilar();
        }
        pila.Apilar(topePila);
        while (!aux.EstaVacia()){
            pila.Apilar(aux.Tope());
            aux.Desapilar();
        }
    }

    // FINAL AL INICIO
    // Cola
    /**
     * Reordena el último elemento de la cola hacia el primer lugar
     * @param cola Pila a reordenar
     */
    public static void FinalAlInicio(ColaTDA cola){
        ColaTDA aux = new ImplementacionCola();
        aux.InicializarCola();
        int longitud = Longitud(cola);
        for (int i = 0; i < longitud - 1; i++) {
            aux.Acolar(cola.Primero());
            cola.Desacolar();
        } while (!aux.EstaVacia()){
            cola.Acolar(aux.Primero());
            aux.Desacolar();
        }
    }

    // Pila

    /**
     * Reordena el último elemento de la pila hacia el primer lugar
     * @param pila Pila a reordenar
     */
    public static void FinalAlInicio(PilaTDA pila){
        PilaTDA aux = new ImplementacionPila();
        aux.InicializarPila();
        int longitud = Longitud(pila);
        for (int i = 0; i < longitud - 1; i++) {
            aux.Apilar(pila.Tope());
            pila.Desapilar();
        }
        int topePila = pila.Tope();
        pila.Desapilar();
        while (!aux.EstaVacia()){
            pila.Apilar(aux.Tope());
            aux.Desapilar();
        }
        pila.Apilar(topePila);
    }

    // INVERTIR
    // Cola
    /**
     * Invierte todos los elementos de una cola.
     * @param cola Cola a invertir.
     */
    public static void Invertir(ColaTDA cola){
        PilaTDA pila = new ImplementacionPila();
        pila.InicializarPila();
        while (!cola.EstaVacia()){
            pila.Apilar(cola.Primero());
            cola.Desacolar();
        } while (!pila.EstaVacia()){
            cola.Acolar(pila.Tope());
            pila.Desapilar();
        }
    }
    /**
     * Invierte todos los elementos de una pila.
     * @param pila Cola a invertir.
     */
    public static void Invertir(PilaTDA pila){
        ColaTDA cola = new ImplementacionCola();
        cola.InicializarCola();
        while (!pila.EstaVacia()){
            cola.Acolar(pila.Tope());
            pila.Desapilar();
        } while (!cola.EstaVacia()){
            pila.Apilar(cola.Primero());
            cola.Desacolar();
        }
    }
}