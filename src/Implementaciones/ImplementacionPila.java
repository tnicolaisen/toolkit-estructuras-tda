package Implementaciones;
import Interfaces.PilaTDA;

public class ImplementacionPila implements PilaTDA {

    private int cursor;
    private int[] pila;
    private boolean inicializada = false;

    /**
     * Inicializa la pila (con un espacio de 100 elementos).
     */
    @Override
    public void InicializarPila() {
        // Inicializa la pila siempre y cuando no lo haya sido antes.
        if (!inicializada) {
            cursor = 0;
            pila = new int[100];
            inicializada = true;
        } else {
            System.out.println("INFO: No se ha inicializado la pila: La pila ya fue inicializada.");
        }
    }

    /**
     * Agrega el elemento otorgado a la pila (Modelo LIFO).
     */
    @Override
    public void Apilar(int elemento) {
        pila[cursor] = elemento;
        cursor++;
    }

    /**
     * Elimina el primer elemento (En orden LIFO) de la pila.
     */
    @Override
    public void Desapilar() {
        // Se elimina el primer elemento de la pila (segun orden LIFO) siempre y cuando el cursor no se salga de rango.
        if (cursor != 0) {
            int desapilado = pila[cursor - 1];
            cursor--;
            pila[cursor] = 0;
        } else {
            System.out.println("INFO: No se ha podido desapilar la pila porque no posee elementos.");
        }
    }

    /**
     * @return Elemento en el tope de la pila.
     */
    @Override
    public int Tope() {
        // Si la pila no esta vacia, retorna el tope, sino (previniendo que se salga de rango el cursor), devuelve directamente -1
        if (!EstaVacia()){return pila[cursor - 1];} else {
            System.out.println("INFO: La pila no posee elementos, por eso el tope es -1.");
            return -1;
        }
    }

    /**
     * @return Condicion booleana referente a si la pila está vacía.
     */
    @Override
    public boolean EstaVacia() {return (cursor == 0);}

    // NOTA: La siguiente funcion debe ser casteada para funcionar, ya que no existe dentro de la interfaz de pila
    public void MostrarPila() {
        for (int i = cursor - 1; i >= 0; i--) {
            System.out.print(pila[i] + " ");
        }
        System.out.println();
    }
}
