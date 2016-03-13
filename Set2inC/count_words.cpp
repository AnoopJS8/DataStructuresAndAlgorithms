#include<stdio.h>

unsigned countWords(char *str)
{
    bool escape=true;
    unsigned wc=0;

    while(*str)
    {
        if ( *str == ' ' || *str=='\t' || *str=='\n') // If next character is a separator, set the state as OUT
        {
            escape=true;

        }else if(escape==true)// If next character is not a word separator and state is OUT, // then set the state as IN and increment word count
        {
            escape=false;
            wc++;
        }
        str++;
    }
    return wc;
}
int main(void)
{
    //char str[] = "One two          three\n  four\nfive  ";
    char str[] = "   ";
    printf("No of words: %u\n", countWords(str));
    return 0;
}


/*
#include<stdio.h>

#define OUT 0
#define IN 1

unsigned countWords(char *str)
{
    int state=OUT;
    unsigned wc=0;

    while(*str)
    {
        if ( *str == ' ' || *str=='\t' || *str=='\n') // If next character is a separator, set the state as OUT
        {
            state=OUT;

        }else if(state==OUT)// If next character is not a word separator and state is OUT, // then set the state as IN and increment word count
        {
            state=IN;
            wc++;
        }
        str++;
    }
    return wc;
}
int main(void)
{
    //char str[] = "One two          three\n  four\nfive  ";
    char str[] = " ";
    printf("No of words: %u\n", countWords(str));
    return 0;
}



*/
