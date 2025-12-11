package com.dao;

import com.entity.DiscussshitangshangjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshitangshangjiaVO;
import com.entity.view.DiscussshitangshangjiaView;


/**
 * 食堂商家评论表
 * 
 * @author 
 * @email 
 * @date 2025-06-01 22:37:21
 */
public interface DiscussshitangshangjiaDao extends BaseMapper<DiscussshitangshangjiaEntity> {
	
	List<DiscussshitangshangjiaVO> selectListVO(@Param("ew") Wrapper<DiscussshitangshangjiaEntity> wrapper);
	
	DiscussshitangshangjiaVO selectVO(@Param("ew") Wrapper<DiscussshitangshangjiaEntity> wrapper);
	
	List<DiscussshitangshangjiaView> selectListView(@Param("ew") Wrapper<DiscussshitangshangjiaEntity> wrapper);

	List<DiscussshitangshangjiaView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshitangshangjiaEntity> wrapper);

	
	DiscussshitangshangjiaView selectView(@Param("ew") Wrapper<DiscussshitangshangjiaEntity> wrapper);
	

}
