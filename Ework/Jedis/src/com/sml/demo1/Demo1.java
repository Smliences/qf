package com.sml.demo1;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Demo1 {
	@Test
	public void run1() {
		Jedis jedis = new Jedis("120.78.74.205", 6379);
//		jedis.set("name", "张三");
		System.out.println(jedis.get("name"));
	}
	@Test
	public void run2() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(50);
		config.setMaxIdle(10);
		JedisPool pool = new JedisPool(config,"120.78.74.205",6379);
		Jedis jedis = pool.getResource();
		System.out.println(jedis.get("name"));
		jedis.close();
	} 
}
