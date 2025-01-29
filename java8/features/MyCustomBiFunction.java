interface customBiFunction {
  Integer add (int x, int y);
}

Integer result = (x,y) -> x+y;

Integer sum = result (3,4);
