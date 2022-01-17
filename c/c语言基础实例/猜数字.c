#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
	srand(time(0));
	int number = rand() % 100 + 1;
	int count = 0;
	int a = 0;
	printf("我想好了快来猜吧\n");
	do {
		printf("猜猜这个一到100的数\n");
		scanf_s("%d", &a);
		count++;
		if (a > number) {
			printf("猜大了\n");
		}
		else if (a < number) {
			printf("猜小了\n");
		}
	} while (a != number);
	printf("你猜了%d次\n", count);
	return 0;
}