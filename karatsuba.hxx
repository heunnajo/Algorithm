void addTo(vector<int>& a, const vector<int>& b, int k);//a += b*(10^k) 구현.
void subFrom(vector<int>& a, const vector<int>& b);//a -= b; a>=b 가정.

//두 긴 정수의 곱을 반환한다.
vector<int> karatsuba(const vector<int>& a, const vector<int>& b) {
    int an = a.size(), bn = b.size();
    if(an < bn) return karatsuba(b,a);

    if(an == 0 || bn == 0) return vector<int>();//a나 b가 빈 경우
    if(an <= 50) return multiply(a,b);//a가 비교적 짧은 경우 O(n^2) 곱셈으로 변경한다.

    int half = an / 2;

    //a와 b를 밑에서 half 자리와 나머지로 분리한다.
    vector<int> a0(a.begin(), a.begin() + half);
    vector<int> a1(a.begin() + half, a.end());
    vector<int> b0(b.begin(), b.begin() + min<int>(b.size(),half));
    vector<int> b1(b.begin() + min<int>(b.size(),half), b.end());

    vector<int> z2 = karatsuba(a1,b1);//z2 = a1*b1
    vector<int> z0 = karatsuba(a0,b0);//z0 = z0*b0

    addTo(a0,a1,0);addTo(b0,b1,b);//a0 = a0+a1, b0 = b0+b1

    vector<int> z1 = karatsuba(a0,b0);//z1 = (a0*b0)-z0-z2
    subFrom(z1,z0);
    subFrom(z1,z2);

    //ret = z0 + z1*10^half + z2*(10^half*2)
    vector<int> ret;
    addTo(ret,z0,0);
    addTo(ret,z1,half);
    addTo(ret,z2,half + half);
    return ret;
}

