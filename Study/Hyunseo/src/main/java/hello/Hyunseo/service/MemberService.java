package hello.Hyunseo.service;

import hello.Hyunseo.domain.Member;
import hello.Hyunseo.repository.MemberRepository;
import hello.Hyunseo.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    // 테스트 함수 자동 완성 기능 : command+ shift + T
    private final MemberRepository memberRepository ;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    // = new MemoryMemberRepository();


    /*
    * 회원가입
    */
    public Long join(Member member){
        // 같은 이름이 있는 중복회원은 가입 불가
        //return 값 자동완성 키 : command+ option+v

        // 메소드 자동완성 키 : ctrl + T
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        /*
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m-> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        */
        // 반환형이 Optional Member니까 바로 ifPresent 사용해도 됨
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
    * 전체회원조회
    */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
