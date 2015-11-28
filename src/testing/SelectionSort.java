package testing;

public class SelectionSort {
	
	public static void main(String[] args) {
		int[] myArray = new int[5];
		myArray[0] = 4;
		myArray[1] = 3;
		myArray[2] = 2;
		myArray[3] = 1;
		myArray[4] = 6;

		
		selectionSort(myArray);
		
		for (int i = 0; i < myArray.length; i++){
			System.out.println(myArray[i]);
		}
	}
	
	public static void selectionSort(int[] myArray){
		// we don't do length-2 if we are using less than
		for (int i = 0; i < myArray.length-1; i++){
			int smallest = myArray[i];
			int index = -1;
			// we don't do length-1 if we are using less than
			for (int j = i; j < myArray.length; j++){
				if (smallest >= myArray[j] && i!=j){
					smallest = myArray[j];
					index = j;
				}
			}
			if (index != -1){
				int temp = myArray[i];
				myArray[i] = smallest;
				myArray[index] = temp;
			}
		}
	}
//	public void selectionSort(int[] val){
//		int indexMin;
//		for (int i = 0; i < val.length; i++){
//			indexMin = i;
//			for (int j = i+1; j < val.length; j++){
//				if (val[j] < val[indexMin]){
//					indexMin = j;
//				}
//			}
//		}
//	}
}
