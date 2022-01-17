#include <stdio.h>
int main()
{
	
	int i, j, k;
	int a;
	scanf_s("%d", &a);
	i = a;
	int cut = 0;
	while (i <= a + 3) {
		j = a;
		while (j <= a + 3) {
			k = a;
			while (k <= a + 3) {
				if (i != j && i != k && j != k) {
					cut++;
					printf("%d%d%d", i, j, k);
					if (cut == 6) {
						printf("\n");
						cut = 0;
					}
					else {
						printf(" ");
					}
				}
				k++;
			}
			j++;
		}
		i++;
	}
	return 0;
}