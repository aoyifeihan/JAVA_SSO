package com.sso.dao;

import java.util.List;

import com.sso.domain.HouseDataConfig;
import com.sso.util.data.DataSource;

public interface  HouseDataConfigDao {
	@DataSource("fangjiaSource1")
	public abstract List<HouseDataConfig> queryAllHouseDataConfig();
}
