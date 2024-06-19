#include <stdio.h>
#include <stdlib.h>

typedef struct node{
    struct node* left;
    struct node* right;
    struct node* dad;
    int value;
} node;

void insert(node** tree, int value){
    node* y = NULL;
    node* no = malloc(sizeof(node));
    no->value = value;
    node* x = *tree;

    while (x != NULL){
        y = x;
        if (x->value > value){
            x = x->left;
        }else if(x->value < value){
            x = x->right;
        }
    }

    no->dad = y;
    no->left = NULL;
    no->right = NULL;

    if(y == NULL){
        *tree = no;
    }else if (no->value < y->value){
        y->left = no;
    }else if(no->value > y->value){
        y->right = no;
    }
}

void exibir(node** T){

    if(*T != NULL){
        exibir(&(*T)->left);
        printf("%d ", (*T)->value);
        exibir(&(*T)->right);
    }
    
}

node* search(node** tree, int value){
    node* tmp = *tree;
    while(tmp != NULL && tmp->value != value){
        if( value < tmp->value)
            tmp = tmp->left;
        else
            tmp = tmp->right;
    }

    return tmp;
}

node* min(node** tree){
    node* y = *tree;

    while (y->left != NULL)
        y = y->left;

    return y;
}

node* max(node** tree){
    node* y = *tree;

    while (y->right != NULL)
        y = y->right;

    return y;
}

node* sucessor(node** tree){
    node* no = *tree;
    if(no == NULL)
        return NULL;
    if(no->right == NULL)
        return no->dad;
    if(no->right != NULL)
        return min(&(no->right));
}

node* precessor(node** tree){
    node* no = *tree;
    if(no == NULL)
        return NULL;
    if(no->left == NULL)
        return no->dad;
    if(no->left != NULL)
        return max(&(no->left));
}

void remover(node** tree, int value){
    node* no = search(tree, value);
    if (no == NULL)
        return;

    if(no->left == NULL && no->right == NULL){ // remove folha
        if (no->dad == NULL)
            *tree = NULL;
        else if(no->dad->left == no)
            no->dad->left = NULL;
        else if(no->dad->right == no)
            no->dad->right = NULL;
    }else if(no->left != NULL && no->right == NULL){ // remove quando tem filhos à esquerda
            no->left->dad = no->dad;
            if(no->dad == NULL)
                *tree = no->left;
            else if(no->dad->left == no)
                no->dad->left = no->left;
            else if(no->dad->right == no)
                no->dad->right = no->left;
    }else if(no->left == NULL && no->right != NULL){ // remove quando tem filhos à direita
            no->right->dad = no->dad;
            if(no->dad == NULL)
                *tree = no->right;
            else if(no->dad->left == no)
                no->dad->left = no->right;
            else if(no->dad->right == no)
                no->dad->right = no->right;
    }else if(no->left != NULL && no->right != NULL){ // remove quando tem filhos em ambos lados
        node* a = sucessor(&no);
        a->left = no->left;
        no->left->dad = a;

        if(a->right != NULL)
            a->right->dad = no->right;
        
        a->dad->left = a->right;

        if(no->right != a){
            no->right->dad = a;
            a->right = no->right;
        }
        a->dad = no->dad;
        
        if(no->dad == NULL){
            *tree = a;
        }else if(no->dad->left == no)
            no->dad->left = a;
        else if(no->dad->right == no)
            no->dad->right = a;
    }

    free(no);
    return;
}

int main(){
    node* tree = NULL;
    insert(&tree, 10);
    insert(&tree, 7);
    insert(&tree, 11);
    insert(&tree, 15);
    insert(&tree, 5);
    insert(&tree, 13);
    insert(&tree, 1);
    insert(&tree, 0);
    insert(&tree, 2);
    insert(&tree, 16);
    insert(&tree, 14);
    insert(&tree, 18);
    exibir(&tree);

    node* x = search(&tree, 5);
    node* y = search(&tree, 15);
    node* z = search(&tree, 7);

    printf("\nminimo:............%d\n", (min(&tree))->value);
    printf("maximo:............%d\n", (max(&tree))->value);
    printf("precessor de 15:...%d\n", (precessor(&y))->value);
    printf("sucessor de 7:.....%d\n", (sucessor(&z))->value);

    printf("\nRemover 05...");
    remover(&tree, 5);
    exibir(&tree);

    printf("\nRemover 11...");
    remover(&tree, 11);
    exibir(&tree);

    printf("\nRemover 10...");
    remover(&tree, 10);
    exibir(&tree);

    printf("\nRemover 13...");
    remover(&tree, 13);
    exibir(&tree);

    printf("\nRemover 01...");
    remover(&tree, 1);
    exibir(&tree);

    printf("\nRemover 14...");
    remover(&tree, 14);
    exibir(&tree);

    printf("\nRemover 01...");
    remover(&tree, 1);
    exibir(&tree);

    printf("\nRemover 18...");
    remover(&tree, 18);
    exibir(&tree);

    printf("\nRemover 15...");
    remover(&tree, 15);
    exibir(&tree);

    printf("\nRemover 07...");
    remover(&tree, 7);
    exibir(&tree);

    printf("\nRemover 02...");
    remover(&tree, 2);
    exibir(&tree);

    printf("\nRemover 16...");
    remover(&tree, 16);
    exibir(&tree);

    printf("\nRemover 00...");
    remover(&tree, 0);
    exibir(&tree);

    printf("\n ok...\n");
}