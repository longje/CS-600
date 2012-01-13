#include<stdio.h>

void insertion_sort(int array[]);
void printArray(int array[]);
#define size 6

int main()
{
	int array[size] = {5, 2, 4, 6, 1, 3};
	printArray(array);
	insertion_sort(array);
}

void printArray(int array[])
{
	for (int i = 0; i < size; i++)
	{
		printf(" %d ", array[i]);
	}
	printf("\n");
}

void insertion_sort(int array[])
{
	for( int j = 1; j < size; j++)
	{
		printArray(array);
		int key = array[j];
		int i = j - 1;
		while (i >= 0 && array[i] > key)
		{
			array[i + 1] = array[i];
			i--;
		}
		array[i + 1] = key;
		printArray(array);
	}
	printArray(array);
}
