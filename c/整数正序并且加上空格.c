#include <stdio.h>

int main()
{
	int x;
	x = 70000;
	//scanf_s("%d", &x);
	int mask = 1;
	int cnt = 0;
	int a = x;
	while (a > 9) {
		a /= 10;
		mask *= 10;
	}
	do {
		int d = x / mask;
		printf("%d", d);
		if (mask > 9) {
			printf(" ");
		}
		x %= mask;
		mask /= 10;
	} while (mask > 0);
	return 0;
}