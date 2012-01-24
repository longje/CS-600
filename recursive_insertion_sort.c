#include<stdio.h>
#include<time.h>

//void insertion_sort(int array[], int length);
int* insertion_sort(int array[], int length, int arraySize);

char* printArray(int* array, int length);

#define size sizeof(array) / sizeof(array[0])
#define realLen 4500

int main()
{
	//int array[] = {5, 29, 9, 4, 61, 11, 32, 89};
	clock_t start, end;
	double elapsed;

	start = clock();

   int array[realLen];
   for (int i = realLen; i > -1; i--)
   {
      int indexSize = size - i;
      //printf("Value of index: %d, Value of i: %d\n", indexSize, i);
      array[indexSize] = i;
   }
          int arraySize = size; //sizeof(array) / sizeof(array[0]);
          //printf("Initial Array: ");
          //printArray(array, size);
          insertion_sort(array, 0, realLen);
          //printf("Sorted Array: ");
          //printArray(array, size);
          end = clock();
          elapsed = ((double)(end - start)) / (double)CLOCKS_PER_SEC;

          printf("Processor time taken: %8.90f", elapsed);
         // printf("Size of Array %d", size);
}

//http://www.cs.utah.edu/dept/old/texinfo/glibc-manual-0.02/library_19.html

char* printArray(int* array, int length)
{
          char* value = malloc (sizeof(array));
          for (int i = 0; i < length; i++)
          {
                 printf("%d ", array[i]);
                 value[i] = '0' + array[i];
          }
          printf("\n");
          //value[length] = '\n';
     return value;
}

int* insertion_sort(int array[], int length, int arraySize)
{
	if (length >= arraySize - 1)
			return array;

	 //printf("Step %d\n", length);
	 //printf("-------\n");
	 //printArray(array, arraySize);
	 int key = array[length + 1];
	 int i = length;
	 //printf("Key: %d\n", key);
	 while (i >= 0 && array[i] > key)
	 {
			array[i + 1] = array[i];
			i--;
			array[i + 1] = key;
	 }
		//printArray(array, arraySize);
	   //printf("\n");
	return insertion_sort(array, length + 1, arraySize);
}
