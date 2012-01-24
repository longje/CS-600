#include<stdio.h>
#include<time.h>

void insertion_sort(int array[], int length);
char* printArray(int* array, int length);

#define size sizeof(array) / sizeof(array[0])

int main()
{
    // int array[] = {5, 2, 9, 4, 6, 1, 3, 8};
	clock_t start, end;
	double elapsed;
	start = clock();

   int array[1900];
   for (int i = 1899; i > -1; i--)
   {
      int indexSize = size - i;
      array[indexSize] = i;
   }
   
	int arraySize = size; //sizeof(array) / sizeof(array[0]);
    insertion_sort(array, size);

	end = clock();
	elapsed = ((double)(end - start)) / (double)CLOCKS_PER_SEC;

	printf("Processor time taken: %8.90f", elapsed);
}

//http://www.cs.utah.edu/dept/old/texinfo/glibc-manual-0.02/library_19.html

char* printArray(int* array, int length)
{
	  char* value = malloc (sizeof(array));
	  for (int i = 0; i < length + 1; i++)
	  {
					printf("%d ", array[i]);
					value[i] = '0' + array[i];
	  }
	  printf("\n");
     return value;
}

void insertion_sort(int array[], int length)
{
	  for( int j = 1; j < length; j++)
	  {
		 int key = array[j];
		 int i = j - 1;

		 while (i >= 0 && array[i] > key)
		 {
				array[i + 1] = array[i];
				i--;
				array[i + 1] = key;
		 }
	}
}
