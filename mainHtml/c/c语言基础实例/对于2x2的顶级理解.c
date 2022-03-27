#include <stdio.h>

int main()
{
	int a, n;
	scanf_s("%d %d", &a, &n);
	int sum = 0;
	int i;
	int t = 0;
	for (i = 0; i < n; i++) {
		t = t * 10 + a;
		sum += t;
	}
	printf("%d\n", sum);
	return 0;
}