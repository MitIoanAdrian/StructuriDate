import java.util.Arrays;
import java.util.Scanner;


public class Main {
	
	
	public static int afisMeniu() {
    	System.out.println("\n1.Introducere numar elemente");
    	System.out.println("2.Introducere sir");
    	System.out.println("3.Afisare sir");
    	System.out.println("4.Sortare cu bule");
    	System.out.println("5.Sortare cu selectie");
    	System.out.println("0.terminare program");
    	return (int) Citire.citInt("Ce optiune alegi:");
    	
    }
	
	public static void main(String[] args) {
		int opt=afisMeniu();
		int n = 0;
		int[] sir = new int[100];
		int[] sir_pt_bsort = new int[100];
		int[] sir_pt_psort = new int[100];
		while(opt!=0) {
			switch(opt) {
			  case 1: n=Citire.citInt("da un numar:"); //citire nr elemente sir
			          break;
			  case 2: sir = Citire.citire(n); //citire sir;
			          break;
			  case 3: for (int i = 0; i<n; i++) {
				  	  System.out.print(sir[i] + " "); 
		        		}
			  		  break;
			  case 4: sir_pt_bsort = Sortari.bubbleSort(sir, 0, n-1, 0);
			  		  for (int i = 0; i<n; i++) 
			  			  System.out.print(sir[i] + " ");
			  		  break;
			  case 5: sir_pt_psort = Sortari.selectSort(sir, n-1, 0, n-1);
	  		  		  for (int i = 0; i<n; i++) 
	  		  			  System.out.print(sir[i] + " ");
	  		  		  break;
			  default: System.out.println("Ai gresit optiunea, fii atent");
			}
			opt=afisMeniu();
		}
		System.out.println("program terminat");
	}

	


}
