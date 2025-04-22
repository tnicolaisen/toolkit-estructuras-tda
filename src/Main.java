import Implementaciones.*;
import Interfaces.*;
import Utilidades.HerramientasTDA;

public class Main {
    public static void main(String[] args) {
        // Creo e inicializo las Estructuras de datos base
        PilaTDA pila = new ImplementacionPila();
        pila.InicializarPila();
        ColaTDA cola = new ImplementacionCola();
        cola.InicializarCola();

        // Carga de datos
        System.out.println("------------------------------------------------------------------");
        System.out.println("Cargue la pila: ");
        HerramientasTDA.Cargar(pila, true);
        System.out.println("Cargue la cola: ");
        HerramientasTDA.Cargar(cola, true);

        // Muestreo de datos
        System.out.println("------------------------------------------------------------------");
        System.out.println("Pila: " + HerramientasTDA.StringTDA(pila));
        System.out.println("Cola: " + HerramientasTDA.StringTDA(cola));

        // Longitud de estructuras
        System.out.println("------------------------------------------------------------------");
        System.out.println("Longitud pila: " + HerramientasTDA.Longitud(pila));
        System.out.println("Longitud cola: " + HerramientasTDA.Longitud(cola));

        // Comparación
        PilaTDA pilaAuxiliar = new ImplementacionPila();
        ColaTDA colaAuxiliar = new ImplementacionCola();
        colaAuxiliar.InicializarCola();
        pilaAuxiliar.InicializarPila();
        for (int i = 1; i < 6; i++){
            pilaAuxiliar.Apilar(i);
            colaAuxiliar.Acolar(i);
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println("Pila es igual a [" + HerramientasTDA.StringTDA(pilaAuxiliar) + "] ?: " + HerramientasTDA.ContienenLoMismo(pila, pilaAuxiliar));
        System.out.println("Cola es iugal a [" + HerramientasTDA.StringTDA(colaAuxiliar) + "] ?: " + HerramientasTDA.ContienenLoMismo(cola, colaAuxiliar));

        // Reordenamiento
        System.out.println("------------------------------------------------------------------");
        System.out.println("Reordenamiento:");

        //      Inicio al final
        HerramientasTDA.InicioAlFinal(cola);
        HerramientasTDA.InicioAlFinal(pila);
        System.out.println("* Inicio al final:");
        System.out.println("    Pila: " + HerramientasTDA.StringTDA(pila));
        System.out.println("    Cola: " + HerramientasTDA.StringTDA(cola));
        System.out.println("* Final al inicio:");
        HerramientasTDA.FinalAlInicio(cola);
        HerramientasTDA.FinalAlInicio(cola);

        //      Final al inicio
        HerramientasTDA.FinalAlInicio(pila);
        HerramientasTDA.FinalAlInicio(pila);
        System.out.println("    Cola: " + HerramientasTDA.StringTDA(cola));
        System.out.println("    Pila: " + HerramientasTDA.StringTDA(pila));
        HerramientasTDA.InicioAlFinal(cola);
        HerramientasTDA.InicioAlFinal(pila);

        //      Invertir
        HerramientasTDA.Invertir(cola);
        HerramientasTDA.Invertir(pila);
        System.out.println("* Invertir:");
        System.out.println("    Cola: " + HerramientasTDA.StringTDA(cola));
        System.out.println("    Pila: " + HerramientasTDA.StringTDA(pila));
        HerramientasTDA.Invertir(cola);
        HerramientasTDA.Invertir(pila);
    }
}