package test.dao;

public interface RedisDao
{
    public String get(String key);
 
    public String set(String key, String value);
 
    public String hget(String hkey, String key);
 
    public long hset(String hkey, String key, String value);
}
