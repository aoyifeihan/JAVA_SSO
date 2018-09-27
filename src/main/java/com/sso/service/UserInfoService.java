package com.sso.service;

import com.sso.domain.*;
import com.sso.dto.UserInfoDTO;

public interface UserInfoService {

	public abstract User getInfo(UserInfoDTO user);

	 
}
