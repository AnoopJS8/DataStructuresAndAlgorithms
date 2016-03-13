#include<iostream>
#include<stdio.h>
#include<cstdlib>
#include<string.h>

using namespace std;

//char * insertfunc(int pos,char *str,char *oldstr)
//{
//    int i=0,j;
////    int len1=str->length();
//  //  int len2=oldstr->length();
//    int len1=strlen(str);
//    int len2=strlen(oldstr);
//    //cout<<len1<<len2;
//    char *newstr=(char *)malloc(sizeof(char)*(len1+len2));
//    //for(i=pos;i<len1;i++)
//    //{
//
//    //}
//    j=0;
//    while(j!=len2){
//        newstr[j]=oldstr[j];
//        j++;
//    }
//    cout<<newstr<<endl;
//    //cout<<oldstr<<endl;
//    j=0;
//    while(i!=pos)
//        i++;
//    int kl=0;
//    while(kl<(len1))  //cant use shifting from front as we will lose the next characters
//    {
//        newstr[i+len1]=newstr[i];
//        newstr[i++]=str[j++];
//        kl++;
//    }
//    newstr[len1+len2]='\0';
//    return newstr;
//}

char *insertstring(int pos,char *str, char *ins)
    {
        int i;
        int scoot=strlen(ins);
        //char *p=str+pos;
        int len=strlen(str)+scoot;
        char *p=(char *)malloc(len+1);
        i=0;
        while(*(str+i)!='\0')
        {
            *(p+i)=*(str+i);
            //printf("%c",*(p+i));
            i++;
            //str++;
        }
        //p[i]='\0';
        //cout<<"$"<<p;
        //p=str;
        for (i=(strlen(str)-1); i >= pos; --i) { //T
            p[i+scoot]=p[i];
            p[i]='-';
            //printf("%c ",*p);
            //p++;       //
        }
        //cout<<p<<endl<<i;
        i=i+1;
        while(*ins!='\0'){
            p[i] = *ins;
            ++i;
            ++ins;
        }
        p[len]='\0';
        return p;
    }
int main(){

    string name="Anoop";
    string name1("Jyoti");
    cout<<name<<name1<<endl;
    name.append(name1);
    cout<<name<<endl;
    cout<<name.length()<<endl;
    cout<<name.size()<<endl;
    name.insert(0,"The");
    //cout<<name<<endl;
    char *guess="my_name_is_";
    char *name3="anoop";
    //cout<<strlen(name3);
//    cout<<guess<<endl;
    char *nw=insertstring(11 ,guess,name3);
    cout<<endl<<nw;

}
