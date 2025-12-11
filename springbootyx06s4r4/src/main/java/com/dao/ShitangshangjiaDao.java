package com.dao;

import com.entity.ShitangshangjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShitangshangjiaVO;
import com.entity.view.ShitangshangjiaView;


/**
 * 食堂商家
 * 
 * @author 
 * @email 
 * @date 2025-06-01 22:37:20
 */
public interface ShitangshangjiaDao extends BaseMapper<ShitangshangjiaEntity> {
	
	List<ShitangshangjiaVO> selectListVO(@Param("ew") Wrapper<ShitangshangjiaEntity> wrapper);
	
	ShitangshangjiaVO selectVO(@Param("ew") Wrapper<ShitangshangjiaEntity> wrapper);
	
	List<ShitangshangjiaView> selectListView(@Param("ew") Wrapper<ShitangshangjiaEntity> wrapper);

	List<ShitangshangjiaView> selectListView(Pagination page,@Param("ew") Wrapper<ShitangshangjiaEntity> wrapper);

	
	ShitangshangjiaView selectView(@Param("ew") Wrapper<ShitangshangjiaEntity> wrapper);
	

}
