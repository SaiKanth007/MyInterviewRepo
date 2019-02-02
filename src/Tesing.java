
public class Tesing {

	public static void main(String[] args) {
		// stackOverFlowMethod(); // causes stack over flow error
		//remove all characters other than alphabets from the given string
		System.out.println("Sai".replaceAll("[^a-bA-Z]",""));

		outOfMemoryMethod();
		
		int[] temp = new int[9];
		for(int i=0;i<temp.length;i++) {
			temp[i]=i++;
		}
		for(int i=0;i<temp.length;i++) {
			System.out.print (temp[i] + " ");
		}
	}

	public static void stackOverFlowMethod() {
		stackOverFlowMethod();
	}

	public static void outOfMemoryMethod() {
		int index = (70000 * 70000);
		//int[] array = new int[index];
	}
	
	//https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/

}
