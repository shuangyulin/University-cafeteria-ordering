package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShitangshangjiaDao;
import com.entity.ShitangshangjiaEntity;
import com.service.ShitangshangjiaService;
import com.entity.vo.ShitangshangjiaVO;
import com.entity.view.ShitangshangjiaView;

@Service("shitangshangjiaService")
public class ShitangshangjiaServiceImpl extends ServiceImpl<ShitangshangjiaDao, ShitangshangjiaEntity> implements ShitangshangjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShitangshangjiaEntity> page = this.selectPage(
                new Query<ShitangshangjiaEntity>(params).getPage(),
                new EntityWrapper<ShitangshangjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShitangshangjiaEntity> wrapper) {
		  Page<ShitangshangjiaView> page =new Query<ShitangshangjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShitangshangjiaVO> selectListVO(Wrapper<ShitangshangjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShitangshangjiaVO selectVO(Wrapper<ShitangshangjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShitangshangjiaView> selectListView(Wrapper<ShitangshangjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShitangshangjiaView selectView(Wrapper<ShitangshangjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
