#include<stdio.h>
#include <time.h>

void merge_sort(int array[], int start, int end);
void merge(int array[], int p, int q, int r);
char* printArray(int* array, int length);

#define size 200000

int main()
{
        clock_t start, end;
        double elapsed;

        start = clock();

        //int array[] = {7, 52, 8, 4, 100, 2, 103, 102};
        int array[size + 1];
        for (int i = size; i > -1; i--)
        {
                int indexSize = size - i;
                //printf("Value of index: %d, Value of i: %d\n", indexSize, i);
                array[indexSize] = i;
        }

        merge_sort(array, 0, size);
        //printArray(array, size);

        end = clock();
        elapsed = ((double) (end - start)) / CLOCKS_PER_SEC;

        //printf("Start time: %f\n", start);
        //printf("End time: %f\n", end);
        //printf("Clocks per Sec: %d\n", CLOCKS_PER_SEC);

        printf("Processor time taken: %8.50f", elapsed);
}

//http://www.cs.utah.edu/dept/old/texinfo/glibc-manual-0.02/library_19.html

void merge_sort(int array[], int start, int end)
{
        //printf("Array: ");
   //printArray(array, size);
        if (start < end)
        {
                int q = (int)(((float)start + (float)end) / (float)2);
                //printf("%d\n", q);
                merge_sort(array, start, q);
                merge_sort(array, q + 1, end);
                merge(array, start, q, end);
        }
}

void merge(int array[], int p, int q, int r)
{
        int n1 = q - p + 1;
        int n2 = r - q;
        int left[n1 + 1];
        int right[n2 + 1];

        for (int i = 0; i < n1; i++)
        {
                left[i] = array[p + i];
        }

        for (int i = 0; i < n2; i++)
        {
                right[i] = array[q + i + 1];
        }

        left[n1] = 10000;
        right[n2] = 10000;

        int i = 0;
        int j = 0;

        for (int k = p; k <= r; k++)
        {
                //printf("Value of r: %d, Value of left: %d, Value of right: %d\n", r, i, j);
                if ((int)left[i] <= (int)right[j])
                {
                        //printf("Assigning left value: %d\n", left[i]);
                        array[k] = left[i++];
                }
                else
                {
                        //printf("Assigning right value: %d\n", right[j]);
                        array[k] = right[j++];
                }
        }
//      printf("Left Array: ");
//      printArray(left, i);
//      printf("Right Array: ");
//      printArray(right, j);
//      printf("After combination Array: ");
//      printArray(array, r);

}

char* printArray(int* array, int length)
{
          char* value = malloc (sizeof(array));
          for (int i = 0; i < length + 1; i++)
          {
                        printf("%d ", array[i]);
                        //value[i] = '0' + array[i];
          }
          printf("\n");
          //value[length] = '\n';
     return value;
}

