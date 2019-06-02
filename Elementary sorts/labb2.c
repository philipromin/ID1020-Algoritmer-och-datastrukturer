#include <stdio.h>
#include <stdlib.h>

void swap(int *arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void sortNegatives(int *arr, int length){
    // Invariant:
	// At the start of every iteration of the outer loop (i), 
	// the subarray until arr[i] has all
	// elements < 0 at the start of the array. 
    for(int i = 0; i < length - 1; i++){
        for(int j = i + 1; j < length; j++){
            if(arr[i] >= 0 && arr[j] < 0){
                swap(arr, i, j);
            }
        }
    }
}

int main(){
    int arr[] = {1, -5, 2, -1, 7, -6};
    sortNegatives(arr, 6);
    for(int i = 0; i < 6; i++){
        printf("%d\n", arr[i]);
    }
}