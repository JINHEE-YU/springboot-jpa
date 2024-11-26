# 프로젝트 설명
Springboot를 이용하여 PostgreSQL과 JPA방식으로 연동하여 기본적인 동작을 수행하는 프로젝트 구축

# Docker
## Postgresql(TimescaleDB)
해당 컨테이너는 TimescaleDB로, PostgreSQL을 기반의 오픈소스 시계열(Time-series) RDBMS이다.
* TimescaleDB 실행 : `docker-compose -f postgre-compose.yml up`

## 접속정보
* url: jdbc:postgresql://localhost:54321/postgres
* username: postgres
* password: mypostgre

## URI 목록
  
| Method | URI          | Explanation                  |
| ------ | ------------ | ---------------------------- |
| GET    | /jpa/person/ | Person 테이블 목록 전체 조회 |
| POST   | /jpa/person/ | Person 데이터 Upsert         |
