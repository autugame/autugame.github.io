#include <stdio.h>
#include <stdlib.h>

int main()
{
	int x;
	scanf_s("%d", &x);
	int digit;
	int ret = 0;
	while (x > 0) {
		digit = x % 10;
		ret = ret * 10 + digit;
		x /= 10;
	}
	printf("%d", ret);
	return 0;
}