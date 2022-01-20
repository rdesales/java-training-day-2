public class TestTwo {

    public static void main(String[] args) {
	firstTask("Happy new year ", 3);
	for(int i = 1; i <= 20; i++)
	    secondTask(i);
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
    public static void secondTask(int soldiers) {

	/**
	 * Explanation:
	 * Fact 0) each round kills a half of the soldiers alive. In fact, those soldiers are
	 * who are placed in even locations (starting the counting at 1).
	 *
	 * Fact 1[-I came across this doing many executions-]) when the number of soldiers is a
	 * power of 2 (n = 2^k for some k \in Z), then the soldier with the
	 * sword at the beginning of the execution will survive.
	 * - When the round with the n soldiers starts, the n-1th soldier kills the nth
	 *   soldier, then the soldier with the sword in the begining gets the sword
	 *   (i.e. isn't killed and continues to the next round).
	 * - When the round with the n/2 soldiers starts, the n-3th soldier (following
	 *   the original enumeration) kills the n-1th soldier, then the first soldier
	 *   gets the sword and continues alive.
	 * - This pattern continues till we reach the case  n/2 = 2. So, as we conjectured
	 *   the first soldier has the sword then, so he kills the other soldier and
	 *   he's the remaining soldier.
	 * Mathematically speaking: this is because when we kill a half of the soldiers
	 * (dividing n by 2),the remaining ones are still a power of two. Then, if we repeat
	 * this procedure till we get 2 soldiers then 2/2 = 1, what it means that the
	 * first soldier will survive.
	 * Then, for n = 2^i for any i \in Z, f(n) = 1 where f(n) is the function that
	 * given n soldiers says what's "the safe place".
	 *
	 * Fact 2) Every number can be represented as a power of 2 plus anoter number
	 * (let's call it k). We can think it taking its binary representation, then
	 * considering the largest power and the rest of the binary representation as a
	 * unique number.
	 * So for every n \in Z, n = 2^p + q, with 0<= k < 2^p and p,q \n Z^+
	 *
	 * Then we can think that q is the number of soldiers that must be killed so in order to
	 * the soldier in the place after q executions (2q places in the original enumeration)
	 * could survive, because in that moment
	 * we have a number that is a power of 2, then following the
	 * previous observations, he'll be the last remaining soldier.
	 *
	 * Finally, we can say thay f(n) = 2(n - 2^i) + 1 with 2^i being the
	 * greatest power of 2 for some i \in Z
	 * ****The last +1 is because the first number of the enumeration, which is 1, but if 0
	 * is the first number, the result is only 2(n - 2^i)
	 */

	int pow  = 1;
	int q = 0;
	int safePlace = 0;

	//First, we get the greatest power of 2 smaller than n
	while( pow < soldiers )
	    pow = pow << 1;
	//Hahahha cannot avoid this line xd
	pow = pow >> 1;
	System.out.println("pow: " + pow);
	//Then we can get q, which is the number of soldiers that must die before we get a power of 2
	q = soldiers - pow;
	System.out.println("q: " + q);
	//And finally we can get the safe place, adding 1 because our enumeration starts from 1
	System.out.println("The safe place for "+soldiers+" soldiers is: "+((2*q) + 1) + "\n----------------");
    }
}
