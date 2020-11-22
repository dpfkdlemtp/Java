## [Java] 컴파일, 실행 방법(명령어)

cmd 창에서 자바 파일을 컴파일하고, 실행하는 방법에 대해 알아보자.

먼저, 간단히 Hello world! 라는 문자열을 출력하는 코드를 작성하였다.

파일의 이름은 aa.java이다.

![A](https://github.com/dpfkdlemtp/JavaStudy/blob/image/aajava.png)



경로는 F:\Java\src에 파일을 생성하였다. 

![image-20201122163314758](C:\Users\Hatae\AppData\Roaming\Typora\typora-user-images\image-20201122163314758.png)



이제 cmd 창을 열고, 해당 경로로 설정하여야 한다.

간단하게 해당 폴더의 경로 창에 cmd를 입력하면 해당 경로로 설정된 cmd 창이 열린다.

![image-20201122163400474](C:\Users\Hatae\AppData\Roaming\Typora\typora-user-images\image-20201122163400474.png)



이제, 자바 파일을 컴파일해보자. 자바 파일을 컴파일 하는 명령어는 javac이다. 

javac aa.java 명령어를 통해 aa.java 파일을 컴파일하여 aa.class 파일을 생성한다.

![image-20201122163508801](C:\Users\Hatae\AppData\Roaming\Typora\typora-user-images\image-20201122163508801.png)



잠시 기다리면 aa.claass 파일이 생성된다.

![image-20201122162442212](C:\Users\Hatae\AppData\Roaming\Typora\typora-user-images\image-20201122162442212.png)



생성된 aa.class 파일을 실행하기 위해 java 명령어를 사용한다. 

java aa 명령어를 통해 aa.class 파일을 실행한다.

실행하면, Hello world! 문자열이 출력된다.

![image-20201122162500493](C:\Users\Hatae\AppData\Roaming\Typora\typora-user-images\image-20201122162500493.png)



