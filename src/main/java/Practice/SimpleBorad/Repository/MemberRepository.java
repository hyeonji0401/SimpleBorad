package Practice.SimpleBorad.Repository;

import Practice.SimpleBorad.Domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    //이메일 존재 여부
    boolean existsByEmail(String email);
}
