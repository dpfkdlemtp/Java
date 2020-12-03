# GC(Garbage Collection)

- GC

Java Application에서 사용하지 않는 메모리를 자동으로 수거하는 기능을 한다. C언어는 malloc, free 등을 이용해서 메모리를 할당하고, 메모리를 다시 수거해야하지만 Java에서는 GC가 알아서 수거한다.

- Stop-the-world

GC를 실행하기 위해 JVM이 어플리케이션 실행을 멈춘다. 이를 Stop-the-world라 한다. GC 튜닝이란, 이 Stop-the-world의 시간을 줄이는 것이다.



- Generational GCs

대부분의 객체는 오랜 시간동안 살아있지 않는다.

오래된 객체에서 새로운 객체로의 참조는 아주 적게 존재한다.

이러한 두 가지 조건하에 가비지 컬렉터를 효율적으로 동작시키기 위해 HotSpot VM에서는 메모리를 크게 2개의 물리적 공간으로 나누었다. 그 영역이 Young / Old 이다. 이러한 방식의 운영을 Generational GC라고 한다.

- Hotspot Heap Structure

GC의 동작방식을 이해하기 위해서는 자바의 메모리 영역에 대한 이해가 필요하다.

자바의 메모리 영역은 크게 Young, Old, Perm 3가지로 구분된다.

> ​	Young: 생성된지 얼마 안 된 객체들이 저장되는 장소, 대부분의 객체가 이 영역에서 생성되었다가 Minor GC를 통해 사용되지 않는 객체가 제거된다.
>
> ​	Old: 생성된지 오래된 객체들이 저장되는 장소, Young 영역에서 살아남은 객체가 이곳으로 옮겨지고 Full GC를 통해 사용되지 않는 객체가 제거된다.
>
> ​	Perm: 프로그램 코드가 올라가는 부분, Code가 모두 로딩되고 나면 거의 일정한 수치를 유지한다. 여기서 GC가 발생하면 Major Gc에 포함된다.



![img](https://mblogthumb-phinf.pstatic.net/MjAxNzAzMjZfMTA4/MDAxNDkwNTA4MTk1NzUy.czFSrJh0LAEEWTIVnhOBgIeDBwInCBaSvsejc6Ge234g.1QuznryvdmdF2kkj2I2zckkk7qlONFNoqvFePyuvvN8g.PNG.kbh3983/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2017-03-26_%EC%98%A4%ED%9B%84_3.02.50.png?type=w800)





- JVM Memory Structure

힙을 포함한 전체 메모리 구조는 다음과 같다.

![img](https://mblogthumb-phinf.pstatic.net/MjAxNzA0MDFfNjIg/MDAxNDkxMDE5MTk2NTcw.WOdqWesEJyNQlOUvXIxlFThkwVyqPLj2Re5gP9E42tgg.n7CO3_kMib5r508vS84l4vMPEDqOCNZ3twrrQOgJx_og.PNG.kbh3983/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2017-04-01_%EC%98%A4%ED%9B%84_12.59.47.png?type=w800)

[그림출처][https://m.blog.naver.com/PostView.nhn?blogId=kbh3983&logNo=220967456151&proxyReferer=https:%2F%2Fwww.google.com%2F]



- Mnior GC

Young 영역에 GC가 발생할 경우 이를 Minor GC라고 한다. Young 영역은 Eden과 Survivor라는 영역으로 나누어진다.

> Eden: 객체가 생성되자마자 저장되는 곳
>
> Survivor: 한 번의 Minor GC를 경험한 객체들이 젖아되는 곳이다. Survivor1, Survivor2가 존재한다.

Minor GC가 발생하면 Eden과 Survivor1에 살아있는 객체를 Survivor2로 복사한다. 그리고 Survivor1과 Eden을 Clear 한다. 결과적으로 한 번의 Minor GC에서 살아남은 객체만 Survivor2영역에 남는다. 그리고 다음번 Minor GC가 발생하면 같은 방식으로 Eden과 Survivor2 영역에서 살아있는 객체를 Survivor1로 복사하고 클리어한다. 결과적으로 Survivor1에만 살아있는 객체가 남는다. 이렇게 반복적으로 Survivor1, Survivor2를 왔다갔다 하다가, Survivor 영역에서 오래 살아남은 객체는 Old 영역으로 옮겨진다.

*Survivor 두 영역중 하나는 반드시 비어있다. 만약 두 영역에 모두 데이터가 존재하거나 사용량이 0이라면 정상적인 상황이 아니다.



- Full Gc

Old 영역에서 발생하는 GC를 Full GC라고 한다. GC를 수행하는 알고리즘도 여러가지가 존재하는데, GC 알고리즘에 따라서 Full GC의 절차가 달라진다. 아래와 같은 알고리즘들이 존재한다.

Serial GC, Parallel GC, Parallel Old GC, Concurrent Mark & Sweep GC(CMS) 등

대표적으로 Mark & Sweep 알고리즘은 객체들의 레퍼런스를 쭉 따라가면서 사용하는 객체들을 Mark 한 뒤, 다음번 작업에서 사용하는 객체들만 압축해서 모아놓고 나머지는 Claer 시킨다.

*Full GC는 속도가 매우 느리고, Full GC가 발생하는 순간 자바 어플리케이션이 멈춘다.(Stop-the-world) 따라서 Full GC는 성능과 안정성에 아주 큰 영향을 미친다.


- Card Table

Old 영역에 Card table을 두고 Old 영역의 객체가 Young 영역의 객체를 참조하는 경우, 카드 테이블에 표시한다. Minor GC를 실행할 때에는 Old 영역의 모든 객체의 참조를 확인하지 않고, 카드 테이블을 확인한다.


- GC와 성능

Minor GC의 경우 보통 0.5초 내에 끝나기 때문에 문제가 되지 않는다. 하지만, Full GC가 발생해서 3초 정도 멈춰있는 동안 사용자의 요청이 큐에 쌓이게 된다. Full GC가 끝난 후 요청을 한꺼번에 처리하게 되면 과부하가 발생할 수 있다.

