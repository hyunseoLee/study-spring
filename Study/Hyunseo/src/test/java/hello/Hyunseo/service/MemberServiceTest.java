package hello.Hyunseo.service;

import hello.Hyunseo.domain.Member;
import hello.Hyunseo.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    // Ctrl+R : 이전 실행했던 내용을 그대로 다시 실행시켜줌
    MemberService memberService ; // =  new MemberService();
    MemoryMemberRepository memberRepository; //  = new MemoryMemberRepository();
    @BeforeEach
    public void beforeEach(){
        // DI..?
        memberRepository= new MemoryMemberRepository();
        memberService= new MemberService(memberRepository);
    }

    @AfterEach /*TEST가 끝날때마다 실행됨*/
    public void afterEach(){
        memberRepository.clearStore();
    }


    @Test
    //test 함수는 한글로적어도 무방
    /*테스트패턴 추천
    * given : 상황이 주어졌을때
    * when  : 실행했을때
    * then  : 나와야하는 결과값
    * */
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId= memberService.join(member);
        
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());



    }

    @Test
    public void 중복_회원_예약(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2);
//            fail();
//        }catch(IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        //then
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}