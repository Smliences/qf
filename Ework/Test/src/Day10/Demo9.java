package Day10;

public class Demo9 {
	public static String myToString(int[] arr) {
		String arrString = "[";
		for (int i = 0; i < arr.length; i++) {
			arrString += arr[i]; 
			if (i != arr.length - 1)
			arrString += ", ";
		}
		arrString += "]";
		return arrString;
	}
	public static void main(String[] args) {
		int[] arr = {2,1,1,4,23};
		String arrString = myToString(arr);
		System.out.println(arrString);
	}
}
