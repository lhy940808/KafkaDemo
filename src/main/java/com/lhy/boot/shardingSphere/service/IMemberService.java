package com.lhy.boot.shardingSphere.service;

import com.lhy.boot.shardingSphere.model.Member;

/**
 * @author liuhaiyan
 * @date 2020-03-30 18:13
 */
public interface IMemberService {

    int insert(Member record);

    Member selectByPrimaryKey(Long memberId);

    int deleteByPrimaryKey(Long memberId);
}