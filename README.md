# security
스프링 시큐리티

# 스프링 시큐리티
* 라이브러리를 처음 임포트하면 모든 사용자 요청에 인증 요구
![](imgs/import_library.png)

<br>

* 계정과 비밀번호는 base64인코딩을 하여 헤더에 포함시켜 서버에 전달
![](imgs/header_security.png)

# 인증없이 특정 페이지 접근 허용
* authorizeRequests().anyMatchers().permitAll()
```java
@Override
protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/index", "/css/*", "/js/*").permitAll()

    ...
}
```

# Role and Permission
* Enum으로 Role과 Permission을 생성
* Role에 Permission을 적용

# Role 적용
```java
* hasRole 메소드 사용
@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/index", "/css/*", "/js/*").permitAll()
                    .antMatchers("/api/**").hasRole(STUDENT.name())
    ...
}
```

# Controller 메소드에 인가 설정
* WebConfiguration 함수에 Global설정 
```java
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    ...
}
```

<br>

* Controller 각 함수에 PreAuthorized 어노테이션 설정
```java
public class StudentManagement_Controller {
    private final StudentService studentService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMINE', 'ROLE_MANAGER')")
    public List<StudentResponseAllDto> listAll(){
        ...
    }

    @PostMapping(path = "{name}")
    @PreAuthorize("hasAuthority('student:write')")
    public Long save(@PathVariable("name") String name){
        ...
    }

    @PutMapping
    @PreAuthorize("hasAuthority('student:write')")
    public Long update(@RequestBody StudentRequestUpdateDto requestUpdateDto){
        ...
    }

    @DeleteMapping(path = "{student_id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void delete(@PathVariable("student_id") Long student_id){
        ...
    }
}

```

# 참고자료
* [1] data.sql, schema.sql: https://www.baeldung.com/spring-boot-data-sql-and-schema-sql
* [2] 강의영상: https://www.youtube.com/watch?v=her_7pa0vrg