package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussshitangshangjiaEntity;
import com.entity.view.DiscussshitangshangjiaView;

import com.service.DiscussshitangshangjiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 食堂商家评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-06-01 22:37:21
 */
@RestController
@RequestMapping("/discussshitangshangjia")
public class DiscussshitangshangjiaController {
    @Autowired
    private DiscussshitangshangjiaService discussshitangshangjiaService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussshitangshangjiaEntity discussshitangshangjia,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussshitangshangjiaEntity> ew = new EntityWrapper<DiscussshitangshangjiaEntity>();


        //查询结果
		PageUtils page = discussshitangshangjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshitangshangjia), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussshitangshangjiaEntity discussshitangshangjia, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussshitangshangjiaEntity> ew = new EntityWrapper<DiscussshitangshangjiaEntity>();

        //查询结果
		PageUtils page = discussshitangshangjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshitangshangjia), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussshitangshangjiaEntity discussshitangshangjia){
       	EntityWrapper<DiscussshitangshangjiaEntity> ew = new EntityWrapper<DiscussshitangshangjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussshitangshangjia, "discussshitangshangjia")); 
        return R.ok().put("data", discussshitangshangjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussshitangshangjiaEntity discussshitangshangjia){
        EntityWrapper< DiscussshitangshangjiaEntity> ew = new EntityWrapper< DiscussshitangshangjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussshitangshangjia, "discussshitangshangjia")); 
		DiscussshitangshangjiaView discussshitangshangjiaView =  discussshitangshangjiaService.selectView(ew);
		return R.ok("查询食堂商家评论表成功").put("data", discussshitangshangjiaView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussshitangshangjiaEntity discussshitangshangjia = discussshitangshangjiaService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussshitangshangjia,deSens);
        return R.ok().put("data", discussshitangshangjia);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussshitangshangjiaEntity discussshitangshangjia = discussshitangshangjiaService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussshitangshangjia,deSens);
        return R.ok().put("data", discussshitangshangjia);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussshitangshangjiaEntity discussshitangshangjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussshitangshangjia);
        discussshitangshangjiaService.insert(discussshitangshangjia);
        return R.ok().put("data",discussshitangshangjia.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussshitangshangjiaEntity discussshitangshangjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussshitangshangjia);
        discussshitangshangjiaService.insert(discussshitangshangjia);
        return R.ok().put("data",discussshitangshangjia.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussshitangshangjiaEntity discussshitangshangjia = discussshitangshangjiaService.selectOne(new EntityWrapper<DiscussshitangshangjiaEntity>().eq("", username));
        return R.ok().put("data", discussshitangshangjia);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussshitangshangjiaEntity discussshitangshangjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussshitangshangjia);
        //全部更新
        discussshitangshangjiaService.updateById(discussshitangshangjia);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussshitangshangjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussshitangshangjiaEntity discussshitangshangjia, HttpServletRequest request,String pre){
        EntityWrapper<DiscussshitangshangjiaEntity> ew = new EntityWrapper<DiscussshitangshangjiaEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");

		PageUtils page = discussshitangshangjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshitangshangjia), params), params));
        return R.ok().put("data", page);
    }








}
