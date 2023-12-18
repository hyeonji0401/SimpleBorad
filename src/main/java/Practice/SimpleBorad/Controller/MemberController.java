package Practice.SimpleBorad.Controller;

import Practice.SimpleBorad.DTO.MemberSaveRequestDTO;
import Practice.SimpleBorad.Service.MemberService;
import Practice.SimpleBorad.Validator.CheckEmailValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller //컨트롤러이며 Bean에 등혹하기 위해서 씀
@RequiredArgsConstructor //생성자를 통한 memberService 의존 주입 대체
@Slf4j //로그 어노테이션
public class MemberController {

    private final MemberService memberService;
    private final CheckEmailValidator checkEmailValidator;

    @GetMapping("/")
    public String Home() {
        return "home";
    }

    @GetMapping("/members/new")
    public String createMemberForm() {
        return "members/createMemberForm";
    }

    //유효성 검증
    @InitBinder //validator 사용시 검증이 필요한 객체를 가져오기 전에 수행한 메소드 지정
    public void validatorBinder(WebDataBinder binder){
        binder.addValidators(checkEmailValidator);
    }

    @PostMapping("/members/new")
    public String createMember(@Valid MemberSaveRequestDTO memberSaveRequestDTO, Errors errors, Model model){
        //검증
        if(errors.hasErrors()){
            //회원가입 실패 시 입력 데이터 유지
            model.addAttribute("dto", memberSaveRequestDTO);

            //유효성 검사를 통과하지 못한 필드와 메세지 핸들링
            Map<String, String> validatorResult = memberService.ValidateHandling(errors);
            for(String key: validatorResult.keySet()){
                model.addAttribute(key, validatorResult.get(key));
            }

            System.out.println("중복된 이메일이 있습니다");
            //회원가입 페이지로 리턴
            return "/members/createMemberForm";
        }

        Long memberId = memberService.join(memberSaveRequestDTO);

        return "home";
    }
}
