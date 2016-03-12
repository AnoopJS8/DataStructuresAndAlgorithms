#include<iostream>
#include<string>

using namespace std;

class HumanBeing{
    string name;
public :
    HumanBeing *humn;
    HumanBeing();
    void introduce();//{
       // cout << "Hi my name is"<<name;
 //   }
};

HumanBeing::HumanBeing(){
    cout<<"Human created"<<endl;
}
void HumanBeing::introduce(){
  //  HumanBeing::name="Anoop";
    cout<<name<<endl;
}
int main(){
    HumanBeing anoop;
  //  anoop.name;

    anoop.introduce();

return 0;
}

