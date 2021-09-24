*정렬 알고리즘*
- 특정한 기준에 따라서 데이터를 순서대로 나열한다.

선택정렬
- 처리되지 않은 데이터 중, 가장 작은 데이터를 맨 앞에 있는 데이터와 바꾼다.
- 탐색범위가 매번 줄어든다. 하지만 탐색범위 모두를 탐색해야한다.
- 이중 for문으로 구성이 가능하다.


삽입정렬
- 처리되지 않은 데이터를 하나씩 골라서 적절한 위치에 삽입
- 구현이 더 복잡하지만 선택정렬에 비해서 더 효율적인다.
- 구현방법
 - 처리되지 않은 데이터를 이미 처리된 데이터(왼쪽)와 비교하여 자리를 변경한다.

퀵 정렬
- 기준 데이터를 설정한다. 기준 보다 큰 데이터와 작은 데이터의 위치를 변경한다.
- 일반적인 상황에서 가장 많이 활용되는 정렬 알고리즘 중 하나.
- 병합정렬과 더불어 대부분의 프로그래밍 언어 정렬 라이브러리의 근간이 된다.


> 보통의 라이브러리가 제공하는 정렬을 사용하는 것이 좋다.  
> 