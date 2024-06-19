#include<stdio.h>

int main(){
  char text[20];
  scanf("%s", text);

  for (int i = 0; i < 20; i++){
    if (text[i] == 32)
        continue;
    else if (text[i]+3 <= 'z' && text[i] >= 'a')
        text[i] = text[i]+3;
    else if (text[i]+3 <= 'Z' && text[i]+3 >= 'A')
        text[i] = text[i]+3;
    else if (text[i] == '\0')
        break;
    else
        text[i] = (text[i] + 3) - 26;
  }

  printf("%s\n", text);
}
