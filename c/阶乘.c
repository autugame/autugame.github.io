#include <stdio.h>
#include <stdlib.h>

int main()
{
	int n;
	scanf_s("%d", &n);
	int fact = 1;

	for (int i = 1; i <= n; i++) {
		fact *= i;
	}
	printf("%d", fact);
	return 0;
}