package com.sml.demo1;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
	private final static JedisPool POOL;
	static {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(50);
		config.setMaxIdle(10);
		POOL = new JedisPool(config,"120.78.74.205",6379);
	}
	
	public static Jedis getJedis() {
		return POOL.getResource();
	}
}
