package Practice.SimpleBorad.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberFormDTO {

    //외부로부터 전달받기 위한 DTO
    private String email;
    private String username;
    private String password;
}
