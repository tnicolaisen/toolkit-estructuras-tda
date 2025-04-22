package Implementaciones;
import Interfaces.ColaTDA;

public class ImplementacionCola implements ColaTDA {

    private int cursor;
    private int[] cola;
    private boolean inicializada = false;

    @Override
    public void InicializarCola() {
        if (!inicializada) {
            cursor = 0;
            cola = new int[100];
            inicializada = true;
        } else { System.out.println("INFO: La cola ya fue inicializada."); }
    }

    @Override
    public void Acolar(int elemento) {
        cola[cursor] = elemento;
        cursor++;
    }

    @Override
    public void Desacolar() {
        if (!EstaVacia()){
            for (int i = 0; i < cursor - 1; i++) {
                cola[i] = cola[i + 1];
            }
            cursor--;
            cola[cursor] = 0;
        }
    }

    @Override
    public int Primero() {
        return cola[0];
    }

    @Override
    public boolean EstaVacia() {
        return (cursor == 0);
    }
}
