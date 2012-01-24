CC = gcc
RM = rm -rf

CFLAGS = "--std=c99"

PROGS = insertion_sort recursive_insertion_sort merge_sort

all:$(PROGS)

insertion_sort: insertion_sort.o
	$(CC) $(CFLAGS) insertion_sort.c -o insertion_sort

recursive_insertion_sort: recursive_insertion_sort.o
	$(CC) $(CFLAGS) recursive_insertion_sort.c -o recursive_insertion_sort

merge_sort: merge_sort.o
	$(CC) $(CFLAGS) merge_sort.c -o merge_sort

clean:
	$(RM) *.o
