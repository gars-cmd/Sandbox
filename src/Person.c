#include <stdio.h>
#include "Person.h"


struct Person
{
    char nom[20];
    char prenom[20];
    char address[100];
    int age;
    int ID;
    int genre;
};

int main(int argc, char const *argv[])
{
    Person user;
    user.age = 24;
    printf("%d",user.age);
    return 0;
}
