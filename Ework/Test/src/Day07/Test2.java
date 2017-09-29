package Day07;

public class Test2 {
	public static void main(String[] args) {
		int[] arr = {9,8,7,6,5,4,3,1,2};
		SelectSort(arr);
		printIntFromArray(arr);
	}
	//升序
	public static boolean MaoPao(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
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
	//降序
	public static boolean SelectSort(int[] arr) {
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
/*		for (int i = 0; i < arr.length - 1; i++) {
			int index = i; 
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[index] < arr[j]) {
					index = j;
				}
			}
			
			if (index != i) {
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}
		}
		
		return true; 
	}*/
	public static boolean printIntFromArray(int[] arr) {
		if (null == arr) {
			System.out.println("传入参数不合法");
			return false;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("array[" + i + "] = " + arr[i]);
		}
		return true;
	}
}

