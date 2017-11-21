<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.youzan.beauty.spa.member.dal.mapper.MemberCardMapper">

    <sql id="table">
        `member_card`
    </sql>

    <sql id="insertColumns">
        <#list userList as user>
            `${user}`,
        </#list>
        `kdt_id`,
        `dept_id`,
        `user_id`,
        `card_id`,
        `prepaid_id`,
        `card_alias`,
        `card_type`,
        `card_name`,
        `card_no`,
        `price`,
        `begin_time`,
        `end_time`,
        `source_id`,
        `source_data`,
        `source_type`,
        `created_at`
    </sql>
</mapper>