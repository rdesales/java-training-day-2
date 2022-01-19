public class TestTwo {

    public static void main(String[] args) {
	firstTask("Happy new year ", 3);
    }


    /**
     * Find out every nth vowel character in the given string
     * @param str The string
     * @param n The interval between vowels
     */
    public static void firstTask(String str, int n) {

	int counter = 0;
	String output = "";
	char currentChar = ' ';
	for(int i = 0; i < str.length(); i++) {
	    //If we found a vowel
	    currentChar = str.charAt(i);
	    if(Character.toString(currentChar).equalsIgnoreCase("a")
	       || Character.toString(currentChar).equalsIgnoreCase("e")
	       || Character.toString(currentChar).equalsIgnoreCase("i")
	       || Character.toString(currentChar).equalsIgnoreCase("o")
	       || Character.toString(currentChar).equalsIgnoreCase("u")) {
		//Which is the number of the vowel?
		if(counter % n == 0)
		    output += currentChar;
		counter++;
	    }
	}
	System.out.println("The vowels every "+n+" vowel are: "+output);
    }

    /**
     * A group of soldiers sitting in circle and have only one sword with them. Instead of
     * gtting caught by enemies they decide to die. So, the plan is every soldier kills
     * the person sitting right to him and passes the sword (to the right). But
     * one soldier instends to get caugth. The problem is to find out where should he sit
     * in the circle so that he wont get killed.
     */
    public static void secondTask(int soldiers, int swordPos) {

    }
}
