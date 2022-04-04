#include <stdio.h>

int main()
{
	int n;
	scanf_s("%d", &n);
	int i = 1;
	int first = 1;
	while (i < n) {
		first *= 10;
		i++;
	}
	i = first;
	while (i < first * 10) {
		int t = i;
		int sum = 0;
		do {
			int d = t % 10;
			t /= 10;
			int p = 1;
			int j = 0;
			while (j < n) {
				p *= d;
				j++;
			}
			sum += p;
		} while (t > 0);
		if (sum == i) {
			printf("%d\n", i);
		}
		i++;
	}
	return 0;
}