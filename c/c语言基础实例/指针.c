#include <stdio.h>

void swab(int* pa, int* pb);
int main()
{
	int a = 5;
	int b = 6;
	swab(&a, &b);
	printf("a = %d, b = %d", a, b);
	return 0;
}
void swab(int *pa, int *pb)
{
	int t = *pa;
	* pa = *pb;
	*pb = t;
}