package Practice.SimpleBorad.Domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //JPA가 관리
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본 키 생성을 데이터베이스에 위임
    private Long id;

    @Column(nullable = false, unique = true) //null 여부 허용, 한 컬럼에 유니크 제약
    private String email;

    @Column
    private String username;

    @Column(nullable = false)
    private String password;
}
