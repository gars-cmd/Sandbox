#include <stdio.h>
#include "Person.h"
#include <string.h>

int main(int argc, char const *argv[])
{
    
    Person user;
    user.age = 24;
    char new_address[] = "130 route de la reine";
    strcpy (user.address,new_address);
    printf("%d",user.age);
    return 0;
}
