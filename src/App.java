public class App {
    public static void main(String[] args) throws Exception {
       
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        int n = arr.length;

        mergeSort(arr, 0, n - 1); //Llamada del método de ordamiento MergeSort

        System.out.println("Arreglo ordenado");
        for (int num : arr) {
            System.out.println(num+ " ");
        }



    }

    public static void mergeSort (int [] arr, int left, int right){
        if (left < right ) {
            //encuentra el punto medio del arreglo
            int mid = (left + right) / 2;

            //ordena recursivamente la mitad izquierda
            mergeSort(arr, left, mid);
            //ordena recursivamente la mitad derecha
            mergeSort(arr, mid + 1, right);

            //combina las dos mitades ordenadas
            merge(arr, left, mid, right);
        }
    }
    //paradigma del "divide y venceras"
    private static void merge(int [] arr, int left, int mid, int right){
        // tamaños de los subarreglos a fusionar
        //divide el arreglo en 2 partes
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        //arreglos temporales para almacenar los subarreglos
        //guarda los dos arreglos que resultaron de dividirlo
        int [] tempLeft= new int [sizeLeft];
        int [] tempRight = new int[sizeRight];

        //copia datos a los arreglos temporales
        //almacena los datos del arreglo de la parte izquierda en un arreglo temporal
        for (int i = 0; i < sizeLeft ; i++) {
            tempLeft[i] =arr[left + i];
        }
        //almacena los datos del arreglo de la parte derecha en un arreglo temporal
        for (int j = 0; j < sizeRight; j++) {
            tempRight[j] = arr[mid + 1 + j];
        }

        //fusiona los subarreglos temporales en el arreglo original
        //se reician los contadores para que el proceso no tenga errores
        int i = 0, j = 0;
        int k = left; //indice inicial para el arreglo fusionado

        //combina los subarre
        //proceso de combinación del arreglo
        while (i < sizeLeft && j < sizeRight) {
            if (tempLeft[i] <= tempRight[j]) {
                arr[k] = tempLeft[i];
                i++;
            } else{
                arr[k] = tempRight[j];
                j++;
            }
            k++;
        }

        //copia los elementos restantes del temLeft[] si los hay
        while (i< sizeLeft) {
            arr[k] = tempLeft[i];
            i++;
            k++;
        }

        //copia los elementos restantes de tempRight[] si los hay
        while (j< sizeRight) {
            arr[k] = tempRight[j];
            j++;
            k++;
        }

    }

}