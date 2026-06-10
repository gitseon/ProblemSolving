#include <iostream>

using namespace std;

int main() {
  int x, y, w, h;
  int min;
  cin >> x >> y >> w >> h;
  //4개의 값을 비교해서 최솟값 찾기 : x, y, h-y, w-x
  //x와 w-x 비교 - x가 최소 : x < w-x
  if (x < w-x) {min = x;} 
  else if (x > w-x) min = w - x;
  
  if (y < h-y) {if (min > y) min = y;} 
  else if (y > h-y) if(min > h- y)min = h- y;
  
  cout << min;
}