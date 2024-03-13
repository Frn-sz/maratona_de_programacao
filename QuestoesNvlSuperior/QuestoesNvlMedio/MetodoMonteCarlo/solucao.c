#include <stdio.h>
#include <time.h>
#include <stdlib.h>

float monte_carlo(int n)
{
  int points_inside = 0;
  int total_points = 0;
  srand(time(NULL));
  for (size_t i = 0; i < n; ++i)
  {
    float x = (float)rand() / (float)RAND_MAX;
    float y = (float)rand() / (float)RAND_MAX;
    if (((x * x) + (y * y)) <= 1)
      points_inside += 1;
    total_points++;
  }
  return 4 * (float)points_inside / total_points;
}

int main(int argc, char const *argv[])
{
  int n = -1;
  while (n < 0)
  {
    printf("Digite o número de pontos: ");
    scanf("%d", &n);
  }

  float pi = monte_carlo(n);
  printf("Aproximação: %.5f", pi);
  return 0;
}
