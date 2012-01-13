#include<stdio.h>

void insertion_sort(int array[]);
void printArray(int array[], int length);
#define size 6

int main()
{
	int array[size] = {5, 2, 4, 6, 1, 3};
	printArray(array, size);
	insertion_sort(array);
}

void printArray(int array[], int length)
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
		printArray(array, size);
		int key = array[j];
		int i = j - 1;
		while (i >= 0 && array[i] > key)
		{
			array[i + 1] = array[i];
			i--;
		}
		array[i + 1] = key;
		printArray(array, size);
	}
	printArray(array, size);
}
