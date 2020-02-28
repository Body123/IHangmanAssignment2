package eg.edu.alexu.csd.datastructure.hangman.cs;

import java.util.Scanner;

public class gameFlow {

	public static void main(String[] args) {
        
		// TODO Auto-generated method stub
                
		        String arr[]=new String[400];
				String secretWord="";
				String tempWord="";
				Scanner sc = new Scanner(System.in);
                functions obj=new functions();
                obj.readFile(arr);
                obj.setDictionary(arr);
                obj.setMaxWrongGuesses(5);
                
                System.out.println("\t\t\tWelcome in the Game");
                secretWord=obj.selectRandomSecretWord();	
                
			
                    
			while(obj.max!=0) {
				System.out.println("\t\t\tyou have : "+obj.max+" tries");
				System.out.print("Enter your char : ");
				char c = sc.next().charAt(0);
		        try {
					tempWord=obj.guess(c);
					System.out.println(tempWord);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        if(tempWord.equals(secretWord)) {
		        	System.out.println("\t\t\tYou Won");
		        	break;
		        }
		        
		        
			}
			if(obj.max==0) {
				System.out.println("\t\t\tYou lose -_-");
                System.out.println("\t\t\tthe world was "+obj.secretWord);
			}
			
		
	}

}
