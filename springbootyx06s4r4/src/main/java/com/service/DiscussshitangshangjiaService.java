package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussshitangshangjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussshitangshangjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussshitangshangjiaView;


/**
 * 食堂商家评论表
 *
 * @author 
 * @email 
 * @date 2025-06-01 22:37:21
 */
public interface DiscussshitangshangjiaService extends IService<DiscussshitangshangjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshitangshangjiaVO> selectListVO(Wrapper<DiscussshitangshangjiaEntity> wrapper);
   	
   	DiscussshitangshangjiaVO selectVO(@Param("ew") Wrapper<DiscussshitangshangjiaEntity> wrapper);
   	
   	List<DiscussshitangshangjiaView> selectListView(Wrapper<DiscussshitangshangjiaEntity> wrapper);
   	
   	DiscussshitangshangjiaView selectView(@Param("ew") Wrapper<DiscussshitangshangjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshitangshangjiaEntity> wrapper);

   	

}

