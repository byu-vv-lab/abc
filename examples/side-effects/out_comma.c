int* f()
{
  return (void*)0;
}
 
int main()
{
  int* p;
  int  a[10];
  
  *&p = f();
  &a[11];
   
  int* $sef$0 = f();
  
  *p = *$sef$0;
  5 / 0;
}
