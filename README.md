✨ 주요 기능
🗂 게시글 기능 (Post)
게시글 작성: 제목, 작성자, 내용을 포함한 게시글 생성
게시글 조회 : 댓글과 같이 조회 될 수 있고 fetch join 으로 N+1 문제 해결
전체 목록 조회
ID로 단건 조회
게시글 수정: 제목/내용 수정 기능
게시글 삭제
게시글 검색: 제목에 키워드 포함 시 검색 가능  >> 향 후 Elasticsearch 으로 검색기능 upgrade 옞ㅇ

💬 댓글 기능 (Comment)
댓글 등록: 게시글에 대한 댓글 작성

🔍 API 문서화 (Swagger)
Swagger UI로 모든 API 문서 자동 생성 : 각 API에 description으로 간단 설명으로 협업 연습 

🧱 기술 스택 및 라이브러리
BE : Spring Boot 3.x, Spring Web, Lombok
DB	H2 (테스트용)
ORM	Spring Data JPA
빌드툴	Gradle
⚙️ 프로젝트 구조 (일부)
src/
├── controller/       # API 요청 처리
├── service/          # 비즈니스 로직
├── repository/       # DB 접근
├── dto/              # 요청/응답 객체
├── entity/           # JPA Entity 클래스
└── resources/
    ├── application.properties
    └── templates/    # (필요 시 HTML 템플릿)\

 🎯 향후 목표
- 검색 기능을 Elasticsearch로 확장해보기
- Spring Security + JWT를 통한 로그인 기능 개발
- 실제 DB(MySQL)로 전환하여 배포 환경 구성
- CI/CD, Docker 등 DevOps 환경 실습

🙋‍♂️ 개발자 정보
이름: 윤준성
학교: 국민대학교 소프트웨어학부
