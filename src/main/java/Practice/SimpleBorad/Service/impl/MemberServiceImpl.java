package Practice.SimpleBorad.Service.impl;

import Practice.SimpleBorad.DTO.MemberFormDTO;
import Practice.SimpleBorad.Domain.Member;
import Practice.SimpleBorad.Repository.MemberRepository;
import Practice.SimpleBorad.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //MemberRepository 생성자를 쓰기 않기 위해서
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Long join(MemberFormDTO memberFormDTO){
        Member member = Member.builder()
                .email(memberFormDTO.getEmail())
                .username(memberFormDTO.getUsername())
                .passward(memberFormDTO.getPassword())
                .build();
        return memberRepository.save(member).getId();
    }
}
