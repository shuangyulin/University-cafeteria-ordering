package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.entity.TokenEntity;
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

import com.entity.ShitangshangjiaEntity;
import com.entity.view.ShitangshangjiaView;

import com.service.ShitangshangjiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 食堂商家
 * 后端接口
 * @author 
 * @email 
 * @date 2025-06-01 22:37:20
 */
@RestController
@RequestMapping("/shitangshangjia")
public class ShitangshangjiaController {
    @Autowired
    private ShitangshangjiaService shitangshangjiaService;

    @Autowired
    private StoreupService storeupService;





    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		// 根据登录查询用户信息
        ShitangshangjiaEntity u = shitangshangjiaService.selectOne(new EntityWrapper<ShitangshangjiaEntity>().eq("shangjiazhanghao", username));
        // 当用户不存在或des方式验证密码不通过时
        if(u==null || !u.getMima().equals(EncryptUtil.desEncrypt(password))) {
            //账号或密码不正确提示
			return R.error("账号或密码不正确");
		}
        // 获取登录token
		String token = tokenService.generateToken(u.getId(), username,"shitangshangjia",  "食堂商家" );
        //返回token
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ShitangshangjiaEntity shitangshangjia){
    	//ValidatorUtils.validateEntity(shitangshangjia);
        //根据登录账号获取用户信息判断是否存在该用户，否则返回错误信息
    	ShitangshangjiaEntity u = shitangshangjiaService.selectOne(new EntityWrapper<ShitangshangjiaEntity>().eq("shangjiazhanghao", shitangshangjia.getShangjiazhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
        //判断是否存在相同商家账号，否则返回错误信息
        if(shitangshangjiaService.selectCount(new EntityWrapper<ShitangshangjiaEntity>().eq("shangjiazhanghao", shitangshangjia.getShangjiazhanghao()))>0) {
            return R.error("商家账号已存在");
        }
		Long uId = new Date().getTime();
		shitangshangjia.setId(uId);
        //设置登录密码des方式加密
        shitangshangjia.setMima(EncryptUtil.desEncrypt(shitangshangjia.getMima()));
        //保存用户
        shitangshangjiaService.insert(shitangshangjia);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        ShitangshangjiaEntity u = shitangshangjiaService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据登录账号判断是否存在用户信息，否则返回错误信息
        ShitangshangjiaEntity u = shitangshangjiaService.selectOne(new EntityWrapper<ShitangshangjiaEntity>().eq("shangjiazhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        //重置密码为123456，并使用des方式加密
        u.setMima(EncryptUtil.desEncrypt("123456"));
        shitangshangjiaService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShitangshangjiaEntity shitangshangjia,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShitangshangjiaEntity> ew = new EntityWrapper<ShitangshangjiaEntity>();


        //查询结果
		PageUtils page = shitangshangjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shitangshangjia), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShitangshangjiaEntity shitangshangjia, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShitangshangjiaEntity> ew = new EntityWrapper<ShitangshangjiaEntity>();

        //查询结果
		PageUtils page = shitangshangjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shitangshangjia), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShitangshangjiaEntity shitangshangjia){
       	EntityWrapper<ShitangshangjiaEntity> ew = new EntityWrapper<ShitangshangjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shitangshangjia, "shitangshangjia")); 
        return R.ok().put("data", shitangshangjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShitangshangjiaEntity shitangshangjia){
        EntityWrapper< ShitangshangjiaEntity> ew = new EntityWrapper< ShitangshangjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shitangshangjia, "shitangshangjia")); 
		ShitangshangjiaView shitangshangjiaView =  shitangshangjiaService.selectView(ew);
		return R.ok("查询食堂商家成功").put("data", shitangshangjiaView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShitangshangjiaEntity shitangshangjia = shitangshangjiaService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shitangshangjia,deSens);
        return R.ok().put("data", shitangshangjia);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShitangshangjiaEntity shitangshangjia = shitangshangjiaService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shitangshangjia,deSens);
        return R.ok().put("data", shitangshangjia);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShitangshangjiaEntity shitangshangjia, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(shitangshangjiaService.selectCount(new EntityWrapper<ShitangshangjiaEntity>().eq("shangjiazhanghao", shitangshangjia.getShangjiazhanghao()))>0) {
            return R.error("商家账号已存在");
        }
        //ValidatorUtils.validateEntity(shitangshangjia);
        //验证账号唯一性，否则返回错误信息
        ShitangshangjiaEntity u = shitangshangjiaService.selectOne(new EntityWrapper<ShitangshangjiaEntity>().eq("shangjiazhanghao", shitangshangjia.getShangjiazhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	shitangshangjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		shitangshangjia.setId(new Date().getTime());
        //密码使用des方式加密
        shitangshangjia.setMima(EncryptUtil.desEncrypt(shitangshangjia.getMima()));
        shitangshangjiaService.insert(shitangshangjia);
        return R.ok().put("data",shitangshangjia.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShitangshangjiaEntity shitangshangjia, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(shitangshangjiaService.selectCount(new EntityWrapper<ShitangshangjiaEntity>().eq("shangjiazhanghao", shitangshangjia.getShangjiazhanghao()))>0) {
            return R.error("商家账号已存在");
        }
        //ValidatorUtils.validateEntity(shitangshangjia);
        //验证账号唯一性，否则返回错误信息
        ShitangshangjiaEntity u = shitangshangjiaService.selectOne(new EntityWrapper<ShitangshangjiaEntity>().eq("shangjiazhanghao", shitangshangjia.getShangjiazhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	shitangshangjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		shitangshangjia.setId(new Date().getTime());
        //密码使用des方式加密
        shitangshangjia.setMima(EncryptUtil.desEncrypt(shitangshangjia.getMima()));
        shitangshangjiaService.insert(shitangshangjia);
        return R.ok().put("data",shitangshangjia.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShitangshangjiaEntity shitangshangjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shitangshangjia);
        //验证字段唯一性，否则返回错误信息
        if(shitangshangjiaService.selectCount(new EntityWrapper<ShitangshangjiaEntity>().ne("id", shitangshangjia.getId()).eq("shangjiazhanghao", shitangshangjia.getShangjiazhanghao()))>0) {
            return R.error("商家账号已存在");
        }
	    ShitangshangjiaEntity shitangshangjiaEntity = shitangshangjiaService.selectById(shitangshangjia.getId());
        //如果密码不为空，则判断是否和输入密码一致，不一致则重新设置
        if(StringUtils.isNotBlank(shitangshangjia.getMima()) && !shitangshangjia.getMima().equals(shitangshangjiaEntity.getMima())) {
            //密码使用des方式加密
            shitangshangjia.setMima(EncryptUtil.desEncrypt(shitangshangjia.getMima()));
        }
        //全部更新
        shitangshangjiaService.updateById(shitangshangjia);
        if(null!=shitangshangjia.getShangjiazhanghao())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(shitangshangjia.getShangjiazhanghao());
            tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", shitangshangjia.getId()));
        }
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shitangshangjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
