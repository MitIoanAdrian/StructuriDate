import java.util.Scanner;

public class Citire {
	public static int[] citire(int n)
	{
		int[] sir = new int[100];
		for(int i=0; i<n; i++)
			sir[i]=citInt("Da un numar:");
		return sir;
			
	}
	
	public static int citInt(String sir) {	//metoda de citire de la tastaura a unui int
		System.out.print(sir);
		try	{									//try pt. prinderea unor erori
			  Scanner scn = new Scanner(System.in);
			  int intregI=scn.nextInt();
			  return intregI;
	
		}
		catch(Exception exp) {
			 System.out.println("ai gresit!!, da numar intreg");
			 return citInt(sir);		//apel recursiv pt. orice eroare
		}
		
	}
}
