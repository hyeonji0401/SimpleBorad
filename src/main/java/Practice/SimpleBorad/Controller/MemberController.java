package Practice.SimpleBorad.Controller;

import Practice.SimpleBorad.DTO.MemberFormDTO;
import Practice.SimpleBorad.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //컨트롤러이며 Bean에 등혹하기 위해서 씀
@RequiredArgsConstructor //의존관계 관련 어노테이션
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public String Home(){
        return "home";
    }

    @GetMapping("/members/new")
    public String createMemberForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String createMember(MemberFormDTO memberFormDTO){
        Long memberId = memberService.join(memberFormDTO);
        return "home";
    }
}
