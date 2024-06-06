#include <iostream>

using namespace std;

int main() {
  int N;
  int K;
  cin >> N >> K;
  int A;
  int B;
  for (int i = 1; i <= N; i++){
    cin >> A >> B;
    K += A -= B;
    if (K == 0 || i == N) cout << "비와이";
  }
}