#include <stdio.h>

int main()
{
	int number, n;
	int inp;
	int finished = 0;
	int cnt = 0;
	scanf_s("%d %d", &number, &n);
	do {
		scanf_s("%d", &inp);
		cnt++;
		if (inp < 0) {
			printf("Game Over!\n");
			finished = 1;
		}
		else if (inp > number) {
			printf("Too big\n");
		}
		else if (inp < number) {
			printf("Too small\n");
		}
		else {
			if (cnt == 1) {
				printf("Bingo!\n");
			}
			else if (cnt <= 3) {
				printf("Lacky you\n");
			}
			else {
				printf("Good Guess!\n");
			}
			finished = 1;
		}
		if (cnt == n) {
			if (!finished) {
				printf("Game Over！\n");
				finished = 1;
			}
		}
	} while (!finished);
	return 0;
}