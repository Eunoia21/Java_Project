# JSP_Project
크롤링 프로젝트-yes24 크롤링 프로그램 

# 크롤링 베이스 페이지
- yes24 월별 베스트 셀러 :http://www.yes24.com/24/category/bestseller?CategoryNumber=001&sumgb=09

# 크롤링 Data
- Rank 랭크
- Category 카테고리
- Title 제목
- Author 저자
- Pub 출판사
- Price  가격
- Summary 줄거리
- Grade 평점 
- Pictureurl 이미지

# DB

create table Yes24 (
Rank Number(4) PRIMARY KEY,
Category nvarchar2(1000),
Title NVARCHAR2(1000),
Author  NVARCHAR2(1000),
Pub  NVARCHAR2(1000),
Price  NVARCHAR2(20),
Summary  VARCHAR2(4000),
Grade NVARCHAR2(50),
Pictureurl Nvarchar2(300)
);

create sequence Yes24_sql
start with 1
increment by 1;

-- select * from yes24;

commit;
