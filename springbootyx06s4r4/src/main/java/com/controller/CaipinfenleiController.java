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

import com.entity.CaipinfenleiEntity;
import com.entity.view.CaipinfenleiView;

import com.service.CaipinfenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 菜品分类
 * 后端接口
 * @author 
 * @email 
 * @date 2025-06-01 22:37:20
 */
@RestController
@RequestMapping("/caipinfenlei")
public class CaipinfenleiController {
    @Autowired
    private CaipinfenleiService caipinfenleiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CaipinfenleiEntity caipinfenlei,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CaipinfenleiEntity> ew = new EntityWrapper<CaipinfenleiEntity>();


        //查询结果
		PageUtils page = caipinfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caipinfenlei), params), params));
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
    public R list(@RequestParam Map<String, Object> params,CaipinfenleiEntity caipinfenlei, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CaipinfenleiEntity> ew = new EntityWrapper<CaipinfenleiEntity>();

        //查询结果
		PageUtils page = caipinfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caipinfenlei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CaipinfenleiEntity caipinfenlei){
       	EntityWrapper<CaipinfenleiEntity> ew = new EntityWrapper<CaipinfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( caipinfenlei, "caipinfenlei")); 
        return R.ok().put("data", caipinfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CaipinfenleiEntity caipinfenlei){
        EntityWrapper< CaipinfenleiEntity> ew = new EntityWrapper< CaipinfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( caipinfenlei, "caipinfenlei")); 
		CaipinfenleiView caipinfenleiView =  caipinfenleiService.selectView(ew);
		return R.ok("查询菜品分类成功").put("data", caipinfenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CaipinfenleiEntity caipinfenlei = caipinfenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(caipinfenlei,deSens);
        return R.ok().put("data", caipinfenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CaipinfenleiEntity caipinfenlei = caipinfenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(caipinfenlei,deSens);
        return R.ok().put("data", caipinfenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CaipinfenleiEntity caipinfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caipinfenlei);
        caipinfenleiService.insert(caipinfenlei);
        return R.ok().put("data",caipinfenlei.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CaipinfenleiEntity caipinfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caipinfenlei);
        caipinfenleiService.insert(caipinfenlei);
        return R.ok().put("data",caipinfenlei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CaipinfenleiEntity caipinfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caipinfenlei);
        //全部更新
        caipinfenleiService.updateById(caipinfenlei);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        caipinfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
