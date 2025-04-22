package Interfaces;

public interface ColaTDA {
    /**
     *  Inicializa la cola (con un espacio de 100 elementos).
     */
    public void InicializarCola();

    /**
     * Agrega el elemento proporcionado a la cola.
     * @param elemento Elemento a agregar.
     */
    public void Acolar(int elemento);

    /**
     * Elimina el primer elemento en la cola (orden FIFO).
     */
    public void Desacolar();

    /**
     * Devuelve el primer elemento en la cola (orden FIFO).
     * @return Primer elemento de la cola.
     */
    public int Primero();

    /**
     * Devuelve el valor booleano referente a si la cola posee elementos en ella o no.
     * @return Valor booleano referente a si la cola esta vacía.
     */
    public boolean EstaVacia();
}
