#include <stdio.h>

/* Forward declaration of the print_math function */
void print_math(int a, int b);

int main()
{

    int a;
    int b;
    printf("Enter first integer: ");

    // Validate and assign the input for the first integer to avoid crashes or unexpected behavior
    if (scanf("%d", &a) != 1)
    {
        printf("Invalid input for first integer. Aborting...\n");
        return 1;
    }
    printf("Enter second integer: ");

    // Let's validate and assign the input for the second integer to avoid crashes or unexpected behavior
    if (scanf("%d", &b) != 1)
    {
        printf("Invalid input for second integer. Aborting...\n");
        return 1;
    }

    print_math(a, b);
    return 0;
}

void print_math(int a, int b)
{
    printf("Sum: %d\n", a + b);
    printf("Product: %d\n", a * b);
}