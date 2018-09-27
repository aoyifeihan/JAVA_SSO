package com.sso.util.security;


import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SqlInjectInterceptor implements HandlerInterceptor{  

    @Override  
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)  
            throws Exception {  
        // TODO Auto-generated method stub  

    }  

    @Override  
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)  
            throws Exception {  
        // TODO Auto-generated method stub  

    }  

    @Override  
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {  
        Enumeration<String> names = arg0.getParameterNames();  
        while(names.hasMoreElements()){  
            String name = names.nextElement();  
            String[] values = arg0.getParameterValues(name);  
            for(String value: values){
                //sqlע��ֱ������
                if(judgeSQLInject(value.toLowerCase())){  
                    arg1.setContentType("text/html;charset=UTF-8");  
                    arg1.getWriter().print("�������зǷ������ַ�,�ѽ�ֹ�������ʣ�");  
                    return false;  
                }
                //��վxss����
                clearXss(value);
            }  
        }  
        return true;  
    }  

    /** 
     * �жϲ����Ƿ��й����� 
     * @param value 
     * @return 
     */  
    public boolean judgeSQLInject(String value){  
        if(value == null || "".equals(value)){  
            return false;  
        }  
        String xssStr = "and|or|select|update|delete|drop|truncate|%20|=|-|--|;|'|%|#|+|,|//|/| |\\|!=|(|)";  
        String[] xssArr = xssStr.split("\\|");  
        for(int i=0;i<xssArr.length;i++){  
            if(value.indexOf(xssArr[i])>-1){  
                return true;  
            }  
        }  
        return false;  
    }

    /**
     * �����վxss�ַ�ת��
     *
     * @param value
     * @return
     */
    private String clearXss(String value) {
        if (value == null || "".equals(value)) {
            return value;
        }
        value = value.replaceAll("<", "<").replaceAll(">", ">");
        value = value.replaceAll("\\(", "(").replace("\\)", ")");
        value = value.replaceAll("'", "'");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
                "\"\"");
        value = value.replace("script", "");
        return value;
    }
}
