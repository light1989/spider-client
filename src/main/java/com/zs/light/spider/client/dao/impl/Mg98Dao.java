package com.zs.light.spider.client.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.zs.light.spider.client.dao.IMg98Dao;
import com.zs.light.spider.client.domain.MgPic;
import com.zs.light.spider.core.model.Url;

@Repository("mg98Dao")
public class Mg98Dao extends SqlMapClientDaoSupport implements IMg98Dao {

	public void insertPic(MgPic mgPic) {
		if(findByaddress(mgPic.getAddress()) == 0){
			super.getSqlMapClientTemplate().insert("mg98.insertPic", mgPic);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Url> findTodoUrl() {
		return super.getSqlMapClientTemplate().queryForList("mg98.findTodoUrl");
	}

	public void updateUrlStatus(Url url) {
		super.getSqlMapClientTemplate().update("mg98.updateUrlStatus", url);
	}

	public void updatePicStatus(MgPic mgPic) {
		super.getSqlMapClientTemplate().update("mg98.updatePicStatus", mgPic);
	}

	public Integer findByaddress(String address) {
		return (Integer) super.getSqlMapClientTemplate().queryForObject("mg98.findByaddress", address);
	}
	
}