package com.lhy.boot.shardingSphere.api;

import com.lhy.boot.shardingSphere.model.Member;
import com.lhy.boot.shardingSphere.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author liuhaiyan
 * @date 2020-03-30 18:15
 */

@RequestMapping("/member")
@RestController
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @RequestMapping("/add")
    public Member add() {
        Member member = new Member();
        //member.setMemberId(IdWorker.getLongId()); 不用手动设置主键id，新增时，sharding-jdbc会自动赋值，因为在配置文件中配置了该列使用SNOWFLAKE算法生成值
        member.setMemberName("张三");
        member.setNickName("闪耀的瞬间");
        member.setAccountNo(member.getMemberId() + "");
        member.setPassword("123465");
        member.setAge(27);
        member.setBirthDate(new Date());
        member.setEblFlag("1");
        member.setDelFlag("0");
        member.setDescription("xxx");
        member.setCreateTime(new Date());
        member.setUpdateTime(new Date());
        memberService.insert(member);
        return member;
    }

    @RequestMapping("/findById")
    public Member findById(Long memberId) {
        return memberService.selectByPrimaryKey(memberId);
    }

    @RequestMapping("/delete")
    public String delete(Long memberId) {
        memberService.deleteByPrimaryKey(memberId);
        return "success";
    }
}