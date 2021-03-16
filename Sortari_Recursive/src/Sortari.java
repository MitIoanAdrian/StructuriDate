import java.util.Arrays;


public class Sortari {
	public static int[] bubbleSort(int arr[], int i, int dim, int z) {  //bubblesort recursiv

	    if(z < dim){
	        if(i<dim && arr[i] < arr[i+1]){
	            int temp = arr[i];
	            arr[i] = arr[i+1];
	            arr[i+1] = temp;
	            return bubbleSort(arr, i+1, dim, z);   //parcurgere sir
	        }
	        else if(i<dim)
	        	return bubbleSort(arr, i+1, dim, z);  //parcurgere sir
	        
	        return bubbleSort(arr, 0, dim, z+1);    //se ia sirul de la inceput pentru a gasi alte elemente 
			   										//neordonate
	    }
	    else
	        return arr;
	}
	
	public static int min_index(int sir[], int minn, int j) {  //gasirea indexului minim pt selectSort
	    if (minn == j) {
	        return minn;
	    }

	    if (sir[minn] > sir[j]) {
	    	minn++;
	    } else {
	    	j--;
	    }

	    return min_index(sir, minn, j);
	}
	
	public static int[] selectSort(int sir[], int dim, int i, int ct) {  //selectSort recursiv
		if(ct==0)
			return sir;
		else {
			int min_i = min_index(sir, i, dim);
			int temp = sir[i];
			sir[i] = sir[min_i];
			sir[min_i] = temp;
			return selectSort(sir, dim, i+1, ct-1);                   //parcurgere sir
		}
		
	}
}
