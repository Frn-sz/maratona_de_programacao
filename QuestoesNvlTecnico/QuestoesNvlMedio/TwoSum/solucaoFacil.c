#include <stdlib.h>
#include <stdio.h>
#define size 10

int *twoSum(int *v, int target, int *pos)
{
    for (size_t i = 0; i < size; i++)
        for (size_t j = 0; j < size; j++)
            if (v[i] + v[j] == target)
            {
                pos[0] = i;
                pos[1] = j;
                return pos;
            }
}

int main(int argc, char const *argv[])
{
    int *v = (int *)malloc(sizeof(int) * size);
    int *pos = (int *)malloc(sizeof(int) * 2);

    for (size_t i = 0; i < size; i++)
        v[i] = i;

    int *r = twoSum(v, 12, pos);

    printf("Posições: {");
    for (size_t i = 0; i < 2; i++)
    {
        printf("%d", r[i]);
        if (i != 1)
            printf(",");
    }
    printf("}");

    return 0;
}
