package sorts;

public class Sort {
	public static void main(String[] args) {
		int[] arr = new int[7];
	}
	//插入排序
	public void insertSort(int[] arr) {
		for (int i = 1; i < arr.length - 1; i++) {
			int j = i; 

			int temp = arr[i];
			while(j > 0 && temp < arr[j - 1]) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
	}	
	//希尔排序
	public static void shellSortSmallToBig(int[] data) {
		int j = 0;
		int temp = 0;
		for (int increment = data.length / 2; increment > 0; increment /= 2) {
			System.out.println("increment:" + increment);
			for (int i = increment; i < data.length; i++) {
				// System.out.println("i:" + i);
				temp = data[i];
				for (j = i - increment; j >= 0; j -= increment) {
					// System.out.println("j:" + j);
					// System.out.println("temp:" + temp);
					// System.out.println("data[" + j + "]:" + data[j]);
					if (temp < data[j]) {
						data[j + increment] = data[j];
					} else {
						break;
					}
				}
				data[j + increment] = temp;
			}
			for (int i = 0; i < data.length; i++)
				System.out.print(data[i] + " ");
		}
	}
	//归并排序
	public void sortArray(int[] array,int m,int n) {
		if(m>0) {
			if(array[n]<array[n-1]) {
				swap(array,n);
			}

			if(n>=m) {
				sortArray(array,m-1,1);
			}
			else {
				sortArray(array,m,n+1);
			}
		}
	}
	void swap(int[] array,int k) {
		int temp = array[k];
		array[k] = array[k-1];
		array[k-1]= temp;
	}
	
	public void showArray(int[]array) {
		for(int i = 0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
	
	public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){//从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }
    
    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi); 
    }

}
