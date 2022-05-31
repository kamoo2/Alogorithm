# 정렬 

## 1. 정렬 조건이 필요하다.  

- 내가 정렬해야 할 원소를 오름차순 또는 내림차순 정렬 할려면 어떻게 해야할까 ? 
  - 원소를 하나의 클래스로 구현하고 이 클래스의 정렬 방법을 재정의 해줘야 한다. 


### Comparable과 Comparator

```java
static class Elem implements Comparable<Elem> {
    // Elem의 필드 정의 
    
    @Override
    public int compareTo(Elem o) {
        return this.필드 - o.필드;
    }
}
```

```java
static class Elem implements Comparator<Elem>{
    // Elem의 필드 정의
    
    @Override
    public int compare(Elem o1,Elem o2){
        return o1.필드 - o2.필드;
    }
}
```

- return 값에 따라서 정렬 순서가 바뀐다. 
- 음수 : 내가 먼저  
- 양수 : 쟤가 먼저 
- 0 : 같은 숫자

## 2. 시간 복잡도는 약 O(NlogN) 이다.
- 예를 들어 10만개의 원소를 정렬한다고 하면 10만 X 16.xx = 160만의 연산이 필요하므로 1초 안에 충분히 가능

### 자바의 Arrays.sort(arr)

1. Primitive 원소 정렬
   1. Dual-Pivot Quick Sort
   2. 최선 O(N)
   3. 최악 O(N^2)
   4. 평균 O(NlogN)
   5. In-place Sort
2. Object 원소 정렬
   1. Tim Sort 
   2. 최선 O(N)
   3. 최악 O(NlogN)
   4. 평균 O(NlogN)
   5. Stable Sort

## 3. In-place와 Stable 여부를 알아야 한다.

1. 정렬 알고리즘이 In-place 한가 ? 
- 정렬하는 과정에서 N에 비해 무시할 만한 개수의 메모리를 추가적으로 사용하는가 ? 
- 10만개를 정렬하고자 할때 메모리를 10개정도 더쓴다 ? 
- 무시 가능한 개수 이므로 In-place하다

2. 정렬 알고리즘이 Stable 한가 ? 
- 동등한 위상의 원소들의 순서 관계가 보존되는가 ? 

## 4. 정렬의 특성 
- 같은 정보들은 인접해 있을 것 
- 각 원소마다, 가장 가까운 원소는 자신의 양 옆 중에 있다. 
- 

## 백준 정렬 문제 
1. 1015 - 수열 정렬 ✅
2. 1181 - 단어 정렬 ✅
3. 10825 - 국영수 ✅
4. 11652 - 카드 ✅
5. 15970 - 화살표 그리기 ✅
6. 20291 - 파일 정리 ✅