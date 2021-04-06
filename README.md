# Siguiente Elemento Mayor

# A. Estructuras de datos utilizadas en el algoritmo

Se utiliza un Deque ya que se necesita sus operaciones LIFO (Last In, First Out) para poder llevar a cabo el algoritmo. En esta Deque se van persistiendo los elementos
ya recorridos/visitados del input array y se los compara con el elemento actual a evaluar, para decidir si aplica SEM o no.
(Se podría utilizar también un Stack, pero desde Java8 se recomienda usar Deque y se considera Stack una clase legacy).

Además, se utiliza un array auxiliar para guardar los SEM de cada valor del input array al ir recorriéndolo. Este array luego se imprimirá junto al array input.

# B. Complejidad temporal del algoritmo

El algoritmo presenta una complejidad temporal de O(n), ya que recorre todo el input array una sola vez. Si bien luego lo recorre para imprimirlo, no son for anidados,
por lo que la complejidad se mantiene en n (Sería 2n, que es n).

El algoritmo ya está lo más optimizado posible, ya que es imposible no recorrer todo el array al menos una vez. El caso más "simple", que sería teniendo 2 for anidados
que recorran el array 1 vez por cada elemento del mismo, tiene una complejidad de O(n^2), por lo que esta complejidad de O(n) lo mejora.
