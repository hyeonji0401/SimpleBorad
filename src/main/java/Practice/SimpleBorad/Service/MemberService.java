package Practice.SimpleBorad.Service;

import Practice.SimpleBorad.DTO.MemberSaveRequestDTO;
import org.springframework.validation.Errors;

import java.util.Map;

public interface MemberService {

    Long join(MemberSaveRequestDTO memberSaveRequestDTO);


    //회원가입 시, 유효성 및 중복 검사
    Map<String, String> ValidateHandling(Errors errors);
}
