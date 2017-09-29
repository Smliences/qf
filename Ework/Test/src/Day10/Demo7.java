package Day10;

public class Demo7 {
	public static boolean selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			
			int index = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[index]) {
					index = j;
				}

				if (index != i) {
					int temp = arr[index];
					arr[index] = arr[i];
					arr[i] = temp;
				}
				
			}
		}
		return true;
	}
	
	public static boolean maoPaoSort(int[] arr) {
		for (int i =  0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return true;
	}
}
