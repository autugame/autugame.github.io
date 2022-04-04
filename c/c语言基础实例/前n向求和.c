#include <stdio.h>

int main()
{
	int n;
	int i;
	double sum = 0;
	int sign = 1;
	scanf_s("%d", &n);

	for (i = 1; i < n; i++) {
		sum += sign * 1.0 / i;
		sign = -sign;
	}
	printf("f(%d)=%f\n", n, sum);
	return 0;
}