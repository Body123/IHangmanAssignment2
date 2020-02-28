/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.datastructure.hangman.cs;

/**
 *
 * @author sakr
 */
         
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
public class functions implements IHangman {
	public static String dictionary[]=new String[400];
	public static char tempArr[];
	public static String secretWord="";		//members of class
	public static int max;
	
	
	public  void readFile(String arr[]) {
		BufferedReader reader = null;
		try {
			BufferedReader obj = new BufferedReader(new FileReader("bn.txt") );
			for (int i=0;i<400 ;i++) {
				arr[i]=obj.readLine();
			}
			obj.close();
		} catch (Exception e) {  //if the file isn't exist
			e.printStackTrace();
		}
	}
	@Override
	public void setDictionary(String[] words) {
		this.dictionary=words;		// to set dictionary
		
	}

	@Override
	public String selectRandomSecretWord() {
		int indicator =5;
		int counter =0;
		// TODO Auto-generated method stub
		Random rand = new Random(); 
        int x =1+( rand.nextInt(399));		//to generate rundom word
        this.secretWord=dictionary[x];
   /*       while(indicator==5) {
            //System.out.println(this.secretWord);
        	 for(int i=0; i<(this.secretWord.length());i++) {
             	if(Character.toLowerCase(this.secretWord.charAt(i))>='a'&&Character.toLowerCase(this.secretWord.charAt(i))<='z') {
             		counter++;
             	}
             	
             } 
                 
        	 if(counter==this.secretWord.length()) {		//this was to change the word from dectionary if it had buggy word but it wasn't needed in pdf
        		 indicator=10;
        	 }
        	 else {
                         counter=1;
        		 indicator =5;
        		 x =1+( rand.nextInt(399));
        		 this.secretWord=dictionary[x];
        	 }
        }*/
                int y=this.secretWord.length();
                tempArr=new char[y];		// empty array that will be put in it the correct gues
                for(int i=0; i<y;i++) {
    		this.tempArr[i]='-';
    	}
                
       return this.secretWord.toLowerCase() ;
	}

	@Override
	public String guess(Character c) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println(this.secretWord);
		int indicator=5;
		for(int i=0; i<(this.secretWord.length());i++) {
         	if(!Character.isLetter(this.secretWord.charAt(i))) {
         		throw new Exception("buggy word ");  //for buggy word
         	}
         	
         }
		
		for(int i=0; i<this.secretWord.length();i++) {
			if(Character.toLowerCase(c)==Character.toLowerCase(this.secretWord.charAt(i))) {
				this.tempArr[i]=Character.toLowerCase(c);		//to compare caracters
				indicator=10;
			}
		}
		if(indicator==5) {
			this.max--;
			
		}
		indicator=5;
		String str1 = String.valueOf(tempArr);
		if(this.max==0) {
			System.out.println(str1);
			throw new Exception("you didn't have any trial"); //Exception as in pdf
		}
		//System.out.println(str1);
		return str1;
		 
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		// TODO Auto-generated method stub
		this.max=max;  //set max number of trials
		
	}

}

