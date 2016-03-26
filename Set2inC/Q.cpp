#include<iostream>

using namespace std;

class Queue{
    int _front;
    int _rear;
    int *_array;
    int _size;

public:
    Queue();
    ~Queue();
    int _empty();
    int _sizeQ();
    int _full();
    int _frontElement();
    int _rearElement();
    int _deque();
    int _enqueue(int data);
};

Queue::Queue()
{
    _front=_rear=-1;
    _size=0;
    _array=new int[20];
}

Queue::~Queue()
{
    delete _array;
}

int Queue::_empty()
{
    if(_front==-1 && _rear==-1)
    {
        return 1;
    }
    return 0;
}
int Queue::_full()
{
    if(_size==20)
        return 1;
    return 0;
}
int Queue::_frontElement()
{
    return this->_array[_front];
}
int Queue::_rearElement()
{
    return this->_array[_rear];
}
int Queue::_sizeQ()
{
    return this->_size;
}

int Queue::_enqueue(int _data)
{
    if(this->_front==-1)
        {_front=0;_rear=0;}
    else
        _rear++;

    this->_array[_rear]=_data;
    this->_size++;
}

int main()
{
    Queue q;
    q._enqueue(3);
    q._enqueue(4);
    cout<<q._frontElement()<<endl;
    cout<<q._rearElement()<<endl;
    cout<<q._sizeQ()<<endl;

}
