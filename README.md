# mop-api
> MoP(Meeting of People) API 서버  

## Fuction
* 도메인 별 CRUD
* JWT 인증

## Usage
* Spring Boot
* Maven(Build Tool)
* Spring Data JPA, QueryDSL
* H2(Test), MySQL(RDBMS), Redis(Cache)
* JWT(Authorization)
* AOP(Request Logging, Exception Logging)
* Jenkins 연동
* AWS S3 연동(Image Upload)
* ETC..

## Refactoring
> [1] 객체 간 결합도(~ing)
* AS-IS
  * 객체 간 강결합
* TO-BE
  * 객체 간 약결합
  * 같은 도메인
    * 함께 생성되고 함께 삭제
    * 강결합 상관없다.
  * 다른 도메인
    * 연관 객체의 ID 값과 Respository를 이용  
    
<br>

> [2] 객체, 패키지간 의존성(~ing)
* AS-IS
  * 일부 객체, 패키지 순환 참조
* TO-BE
  * 의존성 역전, 중간 객체 등을 통해 순환 참조 해결



