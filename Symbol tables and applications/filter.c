#include<stdio.h>
#include <ctype.h>




int main(){
	int c;
	FILE *originalFile = fopen("text.txt", "r");
	FILE *newFile = fopen("newtext.txt", "w");
	
	if(!originalFile){
		return 1;
	}
	
	while((c = getc(originalFile)) != EOF){
		
		if(c == '\n'){
			putc('\n', newFile);
		}
		else if(c == ' ') {
			putc(' ', newFile);
		}
		else if(!isalpha(c)){
			putc(' ', newFile);
		} else {
			putc(c, newFile);
		}
	}
	
	fclose(originalFile);
	fclose(newFile);
	
	remove("text.txt");
	rename("newtext.txt", "text.txt");
	
	return 0;
}