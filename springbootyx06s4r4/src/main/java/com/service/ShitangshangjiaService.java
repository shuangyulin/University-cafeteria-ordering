package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShitangshangjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShitangshangjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShitangshangjiaView;


/**
 * 食堂商家
 *
 * @author 
 * @email 
 * @date 2025-06-01 22:37:20
 */
public interface ShitangshangjiaService extends IService<ShitangshangjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShitangshangjiaVO> selectListVO(Wrapper<ShitangshangjiaEntity> wrapper);
   	
   	ShitangshangjiaVO selectVO(@Param("ew") Wrapper<ShitangshangjiaEntity> wrapper);
   	
   	List<ShitangshangjiaView> selectListView(Wrapper<ShitangshangjiaEntity> wrapper);
   	
   	ShitangshangjiaView selectView(@Param("ew") Wrapper<ShitangshangjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShitangshangjiaEntity> wrapper);

   	

}

