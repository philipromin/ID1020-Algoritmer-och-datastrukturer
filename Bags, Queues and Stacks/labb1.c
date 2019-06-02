/*
PHILIP ROMIN
*/

#include <stdio.h>
#include <stdlib.h>

 /* Med rekursion */
 
void recursion() {
	char a = getc(stdin);
    if (a != '\n') {
       recursion();
	   putchar(a);
    }
}

 /* Med iteration */

void iteration() {
	char arr[50];
	char a = getc(stdin);
	int i = 0;
	
	while (a != '\n'){
		arr[i] = a;
		i++;
		a = getc(stdin);
	};
	
	for (int j = i - 1; j >= 0; j--){
		putchar(arr[j]);
	};
	
}

int main() {
	recursion();
	putchar('\n');	
	iteration();
}


