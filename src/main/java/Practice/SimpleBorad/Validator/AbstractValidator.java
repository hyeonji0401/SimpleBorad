package Practice.SimpleBorad.Validator;


import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Slf4j
public abstract class AbstractValidator<T> implements Validator {

    @Override
    public boolean supports(Class<?> clazz){
        return true;
    }

    @SuppressWarnings("unchecked") //검증되지 ㅇ낳은 연산자 관련 경고 띄우지 않도록 함
    @Override
    public void validate(Object target, Errors errors){
        try{
            doValidate((T) target, errors);
        }catch(RuntimeException e){
            log.error("중복 검증 에러", e);
            throw e;
        }
    }
    protected abstract void doValidate(final T dto, final Errors errors);
}
