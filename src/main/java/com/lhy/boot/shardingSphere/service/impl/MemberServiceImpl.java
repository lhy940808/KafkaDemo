package com.lhy.boot.shardingSphere.service.impl;


import com.lhy.boot.shardingSphere.dao.MemberMapper;
import com.lhy.boot.shardingSphere.model.Member;
import com.lhy.boot.shardingSphere.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuhaiyan
 * @date 2020-03-30 18:13
 */
@Service
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public int insert(Member record) {
        return memberMapper.insertSelective(record);
    }

    @Override
    public Member selectByPrimaryKey(Long memberId) {
        return memberMapper.selectByPrimaryKey(memberId);
    }

    @Override
    public int deleteByPrimaryKey(Long memberId) {
        return memberMapper.deleteByPrimaryKey(memberId);
    }
}
