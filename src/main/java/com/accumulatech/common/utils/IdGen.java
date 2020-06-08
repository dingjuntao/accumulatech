
package com.accumulatech.common.utils;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.security.SecureRandom;

/**
 * 封装各种生成唯一性ID算法的工具类.
 *
 * @author ThinkGem
 * @version 2013-01-15
 */
@Service
@Lazy(false)
public class IdGen implements SessionIdGenerator {

    private static SecureRandom random = new SecureRandom();

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     * 2019年7月26日13:52:06   弃用UUID，使用snowflake算法生成ID
     */
    public static String uuid() {
    	SnowflakeIdWorker idWorker = SnowflakeIdWorker.getIstance();
		long id = idWorker.nextId();
		return String.valueOf(id);
    }


    @Override
    public Serializable generateId(Session session) {
        return IdGen.uuid();
    }

}
