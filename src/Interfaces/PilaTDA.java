package Interfaces;

public interface PilaTDA {
    /**
     * Inicializa la pila (con un espacio de 100 elementos).
     */
    public void InicializarPila();

    /**
     * Agrega el elemento otorgado a la pila (Modelo LIFO).
     */
    public void Apilar(int elemento);

    /**
     * Elimina el primer elemento (En orden LIFO) de la pila.
     */
    public void Desapilar();

    /**
     * @return Elmento en el tope de la pila.
     */
    public int Tope();

    /**
     * @return Condicion booleana referente a si la pila contiene elementos.
     */
    public boolean EstaVacia();
}
