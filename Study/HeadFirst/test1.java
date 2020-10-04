public class test1 {
	public static void main (String [] args) {
		int a = calculate_area(7,12);
		short b = 12;
		int c = calculate_area(b, 12);
		//int d = calculate_area(54);
	}

	public static int calculate_area(int height, int width) {
		return (height * width);
	}
}
