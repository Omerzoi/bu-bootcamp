#include <stdio.h>

/* Forward declarations */
void swap(int *a, int *b);
void broken_swap(int a, int b);
void swap_double(double *a, double *b);
void swap_chars(char *a, char *b);

int main()
{
    int x = 35;
    int y = 15;

    printf("----Calling swap()----\n");
    printf("Before swap: x = %d, y = %d\n", x, y);

    swap(&x, &y);

    printf("After swap:  x = %d, y = %d\n", x, y);

    printf("----Calling broken_swap()----\n");
    int n = 10;
    int m = 20;
    printf("Before calling broken_swap function:  n = %d, m = %d\n", n, m);
    broken_swap(n, m);
    printf("After calling broken_swap function:  n = %d, m = %d\n", n, m);
    /*The values of n and m remain unchanged after calling broken_swap because the function parameters are passed by value, not by pointer*/
    printf("The values of n and m DID NOT swap.\n");

    printf("----Calling swap_double()----\n");
    double p = 3.14;
    double q = 2.71;
    printf("Before swap_double: p = %f, q = %f\n", p, q);
    swap_double(&p, &q);
    printf("After swap_double:  p = %f, q = %f\n", p, q);

    printf("----Calling swap_chars()----\n");
    char c1 = 'A';
    char c2 = 'B';
    printf("Before swap_chars: c1 = %c, c2 = %c\n", c1, c2);
    swap_chars(&c1, &c2);
    printf("After swap_chars:  c1 = %c, c2 = %c\n", c1, c2);

    return 0;
}

void swap(int *a, int *b)
{
    int z = *a; /* save the value at a into z variable */
    *a = *b;    /* put b's value into a's location */
    *b = z;     /* put saved value at z variable into b's location */
}

void broken_swap(int a, int b)
{
    /*The a and b are passed by value, so swapping them inside this function won't affect the original variables as they are local copies*/
    int z = a;
    b = a;
    a = z;
}

void swap_double(double *a, double *b)
{
    double z = *a; /* save the value at a into z variable */
    *a = *b;       /* put b's value into a's location */
    *b = z;        /* put saved value at z variable into b's location */
}

void swap_chars(char *a, char *b)
{
    char z = *a; /* save the value at a into z variable */
    *a = *b;     /* put b's value into a's location */
    *b = z;      /* put saved value at z variable into b's location */
}
