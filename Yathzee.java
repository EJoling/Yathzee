import java.util.Scanner;

public class Yathzee {

	public static void main(String[] args) {
		
		YahtzeeSpel spel = new YahtzeeSpel();
		spel.spelen();
		
	}//end main	
}//end class Yathzee

class YahtzeeSpel {
	
	
	void spelen() {
		int stoppen = 0;
		
		while(stoppen == 0) {
			System.out.println("Druk op Enter om te spelen, q om te stoppen");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();	
			
				switch(input) {
				case "":
					System.out.println("Yay werkt");
					break;
				case "q":
					System.out.println("Spel is gestopt");
					stoppen ++;
					break;
			
				}//end switch
		}//end while
	}//end methode spelen
	
}//end class YahtzeeSpel
