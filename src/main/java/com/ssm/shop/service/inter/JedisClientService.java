package com.ssm.shop.service.inter;

public interface JedisClientService {
	String get(String key);
	String set(String key, String value);
	String hget(String hkey, String key);
	long hset(String hkey, String key, String value);
	long del(String key);
	long hdel(String hkey, String key);
	long expire(String key, int second);
}
