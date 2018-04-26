package com.sso.util;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
/**
 * <p>
 * 读取配置文件类
 * </p>
 * <p>
 * 根据配置文件名和属性key返回属性内容，configUtil.get(configFile, property);
 * </p>
 * @author shengzhi.rensz
 *
 */
public class ConfigUtil {

	private static ConfigUtil initor = new ConfigUtil();   
    
    private static Map<String, Object> configMap = new HashMap<String, Object>();
    
    private ConfigUtil() {}
    private static String configFile;
    
   
	public static String getConfigFile() {
		return configFile;
	}

	public static void setConfigFile(String configFile) {
		ConfigUtil.configFile = configFile;
	}
	/**
     * 获取内容
     * @param property
     * @return
     */
    public static String get(String property) {   
    	 
        return get(configFile, property);   
    }   
  
	/**
     * 获取内容
     * @param configFile
     * @param property
     * @return
     */
    public static String get(String configFile, String property) {   
    	if(!configMap.containsKey(configFile)) {   
           initor.initConfig(configFile);
        }
    	PropertiesConfiguration config = (PropertiesConfiguration) configMap.get(configFile);
    	config.setEncoding("utf8");
    	String value = config.getString(property);
    	//TODO LOG
        return value;   
    }   
    
    /**
     * 载入配置文件，初始化后加入map
     * @param configFile
     */
    private synchronized void initConfig(String configFile) {    
        try {
        	PropertiesConfiguration config = new PropertiesConfiguration();
        	config.setEncoding("utf8");  
        	config.load(configFile);
			configMap.put(configFile, config);
			
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
    }   
}