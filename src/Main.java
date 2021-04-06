import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

/**
     Siguiente Elemento Mayor

    A. Estructuras de datos utilizadas en el algoritmo

    Se utiliza un Deque ya que se necesita sus operaciones LIFO (Last In, First Out) para poder llevar a cabo el algoritmo. En esta Deque se van persistiendo los elementos
    ya recorridos/visitados del input array y se los compara con el elemento actual a evaluar, para decidir si aplica SEM o no.
            (Se podría utilizar también un Stack, pero desde Java8 se recomienda usar Deque y se considera Stack una clase legacy).

    Además, se utiliza un array auxiliar para guardar los SEM de cada valor del input array al ir recorriéndolo. Este array luego se imprimirá junto al array input.

    B. Complejidad temporal del algoritmo

    El algoritmo presenta una complejidad temporal de O(n), ya que recorre todo el input array una sola vez. Si bien luego lo recorre para imprimirlo, no son for anidados,
    por lo que la complejidad se mantiene en n (Sería 2n, que es n).

    El algoritmo ya está lo más optimizado posible, ya que es imposible no recorrer todo el array al menos una vez. El caso más "simple", que sería teniendo 2 for anidados
    que recorran el array 1 vez por cada elemento del mismo, tiene una complejidad de O(n^2), por lo que esta complejidad de O(n) lo mejora.

*/

    public static void main(String[] args) {
        //Time complexity: O(n)
        //Space complexity: O(n)

        System.out.println("Elemento SEM");

        //Initialize and populate test array
        int[] array = {4, 37, 2, 5, 25, 5, 7, 1};

        //Use a Deque and an array as auxiliary structures
        Deque<Integer> deque = new ArrayDeque<>();
        int[] auxArray = new int[array.length];

        //Iterate array in reverse order to maintain input order when printing
        for (int i = array.length - 1; i >= 0; i--){

            //Pop values from deque until it's empty or SEM is found
            while (!deque.isEmpty() && deque.peekLast() <= array[i]){
                deque.removeLast();
            }

            //If stack is empty, there is no SEM. If it's not empty, SEM is the top of the stack.
            auxArray[i] = deque.isEmpty() ? -1 : deque.peekLast();
            deque.push(array[i]);
        }

        //Iterate auxiliary array to print array elements and their SEM
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i] + " --> \t" + auxArray[i]);
        }
    }
}
