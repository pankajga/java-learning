interface CustomBiFunction {
  Integer add (int x, int y);
}

class MyCustomBiFunction {
  
  CustomBiFunction result = (x,y) -> x+y;

  Integer sum = result.add (3,4);
}
