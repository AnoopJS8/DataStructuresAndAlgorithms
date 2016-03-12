#include<iostream>
#include<string>

using namespace std;

class Father{
protected:
    int height;
public:
    Father(int h){
        cout<<"Consttructor Father is called"<<endl;
        height=h   ;
    }

    virtual void displayVirtual(){
    cout<<"Hey I am in Father"<<endl;
    }
};

class Mother{
protected:
    string skincolor;
public:
    Mother(string sc){
        cout<<"Consttructor Mother is called"<<endl;
        skincolor=sc;

    }

};


class Child : public Father{//,public Mother {
public:
    //Child(int x,string color) : Father(x),Mother(color){
   Child(int x):Father(x){
    cout<<"Child class constructor"<<endl;
    }

void display(){
  //  cout<<"Height is"<<height<<"Skin Color is"<<skincolor<<endl;
}
void displayVirtual(){
    cout<<"Hey I am in Child"<<endl;
}
};

//};

class GrandChild : public Child{
public:
GrandChild(int x):Child(x){
}
void displayVirtual(){
    cout<<"Hey I am in Child"<<endl;
}
};

void displayAll(Father *f){
    f->displayVirtual();
}
int main(){
// Child child;//(26,"brown");
 GrandChild gc;
 //child.displayVirtual();
 displayAll(child);
 displayAll(gc);


}
