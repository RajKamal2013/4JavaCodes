public class PhraseOMatic {
	public static void main (String[] args) {
		String[] Wordlist1 = {"Hell", "Heaven", "Life", "Death", "Day", "Night", "Men", "Women"};
		String[] Wordlist2 = {"C", "C++", "Java", "Python", "Scala", "Haskell", "Perl", "Bash"};
 		String[] Wordlist3 = {"Iphone", "Ipad", "Macbook", "Ipod", "Shuffle", "Beats"};

		int length1 = Wordlist1.length;
		int length2 = Wordlist2.length;
		int length3 = Wordlist3.length;

		int rand1 = (int) (Math.random() * length1);	
		int rand2 = (int) (Math.random() * length2);	
		int rand3 = (int) (Math.random() * length3);

		String Phrase = Wordlist1[rand1] + Wordlist2[rand2] + Wordlist3[rand3];

		System.out.println("What we need is " + Phrase);
	}
}

