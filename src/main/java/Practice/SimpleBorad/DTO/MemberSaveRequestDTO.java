package Practice.SimpleBorad.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberSaveRequestDTO {

    //validation(유효성 검사)
    @NotBlank(message = "이메일을 입력해주세요") //공백일 수 없음
    @Email(message = "올바른 이메일 주소를 입력해주세요") //이메일 양식이어야함
    private String email;

    @NotBlank(message = "닉네임을 입력해주세요")
    @Size(min=2, max = 15, message = "닉네임은 2~15자 사이로 입력해주세요") //크기 제한
    private String username;

    @NotBlank(message ="비밀번호를 입력해주세요")
    private String password;
}
