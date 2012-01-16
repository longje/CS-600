#include<stdio.h>

void merge_sort(int array[], int start, int end);
void merge(int array[], int p, int q, int r);
char* printArray(int* array, int length);

int main()
{
	int array[] = {7, 5, 8, 4};
	merge_sort(array, 0, 3);
	printArray(array, 4);
}

void merge_sort(int array[], int start, int end)
{
	printf("Array: %s", printArray(array, 4));
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
	printf("Left Array: %s", printArray(left, 4));
	printf("Right Array: %s", printArray(right, 4));
	printf("After combination Array: %s", printArray(array, 4));
}
	
char* printArray(int* array, int length)
{
          char* value = malloc (sizeof(array));
          for (int i = 0; i < length + 1; i++)
          {
                        //printf("%d", array[i]);
                        value[i] = '0' + array[i];
          }
	  //printf("\n");
          value[length] = '\n';
     return value;
}
