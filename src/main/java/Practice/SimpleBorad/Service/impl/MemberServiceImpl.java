package Practice.SimpleBorad.Service.impl;

import Practice.SimpleBorad.DTO.MemberSaveRequestDTO;
import Practice.SimpleBorad.Domain.Member;
import Practice.SimpleBorad.Repository.MemberRepository;
import Practice.SimpleBorad.Service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor //생성자를 통한 memberRepository 의존성 주입 대신
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Long join(MemberSaveRequestDTO memberSaveRequestDTO) {
        Member member = Member.builder()
                .email(memberSaveRequestDTO.getEmail())
                .username(memberSaveRequestDTO.getUsername())
                .password(memberSaveRequestDTO.getPassword())
                .build();

        return memberRepository.save(member).getId();
    }
    @Transactional(readOnly = true) //조회용
    @Override
    public Map<String, String> ValidateHandling(Errors errors){
        Map<String, String> validatorResult = new HashMap<>();

        //유효성 및 중복 검사에 실패한 필드 목록을 받음
        for(FieldError error : errors.getFieldErrors()){
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }


}
