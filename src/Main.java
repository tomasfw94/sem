import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        //Time complexity: O(n)
        //Space complexity: O(n)

        System.out.println("Elemento SEM");

        //Initialize and populate test array
        int[] array = {4, 37, 2, 5, 25, 5, 7, 1};

        //Use a Stack and an array as auxiliary structures
        Stack<Integer> auxStack = new Stack<>();
        int[] auxArray = new int[array.length];

        //Iterate array in reverse order to maintain input order when printing
        for (int i = array.length - 1; i >= 0; i--){

            //Pop values from stack until it's empty or SEM is found
            while (!auxStack.isEmpty() && auxStack.peek() <= array[i]){
                auxStack.pop();
            }

            //If stack is empty, there is no SEM. If it's not empty, SEM is the top of the stack.
            auxArray[i] = auxStack.empty() ? -1 : auxStack.peek();
            auxStack.push(array[i]);
        }

        //Iterate auxiliary array to print array elements and their SEM
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i] + " --> \t" + auxArray[i]);
        }
    }
}
