class MaoPao {
	public static void main(String[] args){
	int[] a ={1,3,6,5,9,7,13};
	int s;
	for(int i  = 0; i< 7 ; i++){
		for(int j = 0 ; j < 6-i ; j++ ){
			if(a[i]>a[i+1]){
				s = a[i];	
				a[i]=a[i+1];
				a[i+1]=s;
			}
		}	
	}
	for(int i = 0; i< 7; i++){
		System.out.println(a[i]);
	}

	}
}

