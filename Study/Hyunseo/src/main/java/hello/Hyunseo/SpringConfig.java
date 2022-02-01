package hello.Hyunseo;

import hello.Hyunseo.repository.MemberRepository;
import hello.Hyunseo.repository.MemoryMemberRepository;
import hello.Hyunseo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
