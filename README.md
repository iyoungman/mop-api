# Product Name
> MoP(Meeting of People) API 서버  

## Motivation
기존 동호회 관련 어플리케이션은 다양한 동호회 분류와 채팅, 게시판 기능에 집중되어 있었다. 하지만 자전거 동호회, 산악 동호회 같이 안정성과 편의성을 이유로 
서로의 위치를 실시간으로 파악하는 것이 중요한 동호회를 대상으로 어플리케이션 내에서 회원들간의 위치정보 공유를 주 기능으로 하여 지원한다면 좀 더 편리한 동호회 활동을 할 수 있다고 생각하였다. 
또한, 기존 대부분의 동호회 어플리케이션에서 목록 형식으로 구현된 일정을 보기 쉬운 달력 UI로 구현하였다.

## Fuction
* 도메인 별 CRUD
* JWT 인증

## Specification
* Spring Boot
* Maven(Build Tool)
* Spring Data JPA, QueryDSL
* H2(Test), MySQL(RDBMS), Redis(Cache)
* JWT(Authorization)
* AOP(Request Logging, Exception Logging)
* Jenkins 연동
* ETC..

## Test
* BDD(Behaviour-Driven Development)
* JUnit + Mockito 
