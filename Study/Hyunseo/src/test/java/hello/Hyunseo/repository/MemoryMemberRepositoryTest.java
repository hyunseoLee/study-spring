package hello.Hyunseo.repository;

import hello.Hyunseo.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    /*
     * TEST는 순서에 의존관계없이 설계되어야한다.
     * 그러기 위해서 하나의 테스트가 끝날때마다 공용데이터는 삭제해줘야한다.
     */
    @AfterEach /*TEST가 끝날때마다 실행됨*/
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result=  repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
        //Assertions.assertEquals(member,result);

        //System.out.println("result = " + (result==member));
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        //쉽게 rename 하는 법 : shift+F6
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2= new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
