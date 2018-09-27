package sso;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.sso.dto.ResponseDTO;
import com.sso.dto.TokenDTO;
import com.sso.dto.UserInfoDTO;
import com.sso.web.LoginController;


//让测试运行于Spring环境  
@RunWith(SpringJUnit4ClassRunner.class)  
//引入Spring配置  

@ContextConfiguration(locations = { "classpath*:web.xml","classpath*:spring-*.xml"})  

public class TestLoginControll {

	@Test
	public void test() {

		LoginController control = new LoginController();
		UserInfoDTO dto = new UserInfoDTO();
		dto.setUsername("admin");
		dto.setPassword("admin");
		try {
			String json = control.checkIn(dto);
			System.out.println(json);
			

			ResponseDTO<TokenDTO> req = JSON.parseObject(json, ResponseDTO.class);
			TokenDTO token1 = req.getData();
			System.out.println(token1.getToken());
		} catch (Exception e) {

			e.printStackTrace();
		}
		fail("Not yet implemented");
	}

}
