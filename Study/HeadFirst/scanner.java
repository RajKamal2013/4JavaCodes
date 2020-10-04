import java.util.*;
import java.io.*;

public class scanner {
	public static void main(String[ ] args) {
		String Input = "10 tea 20 coffee 30 tea biscuit";
		Scanner s = new Scanner(Input).useDelimiter("\\s");
		System.out.println(s.nextInt());
		System.out.println(s.next());
		System.out.println(s.nextInt());
		System.out.println(s.next());
		s.close();
	}
}
