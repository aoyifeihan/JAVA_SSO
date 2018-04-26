package com.sso.util;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
/**
 * <p>
 * ��ȡ�����ļ���
 * </p>
 * <p>
 * ���������ļ���������key�����������ݣ�configUtil.get(configFile, property);
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
     * ��ȡ����
     * @param property
     * @return
     */
    public static String get(String property) {   
    	 
        return get(configFile, property);   
    }   
  
	/**
     * ��ȡ����
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
     * ���������ļ�����ʼ�������map
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