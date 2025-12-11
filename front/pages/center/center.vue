<template>
	<view class="content">
		<view :style='{"minHeight":"100%","width":"100%","padding":"0","position":"relative","background":"#F6F7F9","height":"auto"}'>
			<view v-if="user&&user.id" :style='{"minHeight":"280rpx","padding":"40rpx 20rpx","margin":"0 0 20rpx 0","borderRadius":"0 0 30rpx 30rpx","background":"#fff","display":"flex","width":"100%","position":"relative","height":"auto"}' @tap="onPageTap('../user-info/user-info')" class="header" v-bind:class="{'status':isH5Plus}">
				<view :style='{"padding":"0","alignItems":"center","flexWrap":"wrap","display":"flex","height":"auto"}' v-if="tableName=='yonghu'" class="userinfo">
					<image :style='{"width":"132rpx","padding":"0","margin":"0 20rpx","borderRadius":"100%","height":"132rpx"}' :src="user.touxiang?baseUrl+user.touxiang:require('../../static/gen/upload.png')"></image>
					<view :style='{"margin":"0px 0 0","alignItems":"center","flexDirection":"column","display":"flex","width":"auto","justifyContent":"center","order":"2"}' class="info">
						<view :style='{"width":"100%","lineHeight":"1.5","fontSize":"28rpx","color":"#666","textAlign":"left"}'>{{user.yonghuzhanghao}}<text v-if="user.vip&& user.vip=='是'">(VIP)</text></view>
					</view>
					
					<view :style='{"margin":"20rpx 0 0","alignItems":"center","background":"none","flexDirection":"column","display":"flex","width":"100%","justifyContent":"center","order":"3"}' class="info">
						<view :style='{"width":"100%","lineHeight":"48rpx","fontSize":"28rpx","alignItems":"center","justifyContent":"center","display":"flex"}' v-if="user.money">
							<span :style='{"color":"#666","whiteSpace":"nowrap"}'>余额：</span>
							<span :style='{"color":"#666","whiteSpace":"nowrap"}'>{{user.money}}</span>
						</view>
						<view :style='{"width":"100%","lineHeight":"48rpx","fontSize":"28rpx","alignItems":"center","justifyContent":"center","display":"flex"}' v-if="user.jf||user.jf==0">
							<span :style='{"color":"#666","whiteSpace":"nowrap"}'>积分：</span>
							<span :style='{"color":"#666","whiteSpace":"nowrap"}'>{{user.jf}}</span>
						</view>
					</view>
					<view :style='{"width":"100%","margin":"30rpx 0 0","alignItems":"center","justifyContent":"space-around","display":"flex","order":"3"}'>
					  <view :style='{"padding":"0 20rpx","margin":"0","borderRadius":"60rpx","background":"#FFD128","display":"flex"}'>
					    <text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#fff"}'></text>
					    <text :style='{"color":"#fff","lineHeight":"60rpx","fontSize":"28rpx"}'>点赞 {{user.thumbsnum}}</text>
					  </view>
					  <view :style='{"padding":"0 20rpx","margin":"0","borderRadius":"60rpx","background":"#0036FF","display":"flex"}'>
					    <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#fff"}'></text>
					    <text :style='{"color":"#fff","lineHeight":"60rpx","fontSize":"28rpx"}'>收藏 {{user.storenum}}</text>
					  </view>
					</view>
				</view>
				<view :style='{"padding":"0","alignItems":"center","flexWrap":"wrap","display":"flex","height":"auto"}' v-if="tableName=='shitangshangjia'" class="userinfo">
					<image :style='{"width":"132rpx","padding":"0","margin":"0 20rpx","borderRadius":"100%","height":"132rpx"}' :src="user.touxiang?baseUrl+user.touxiang:require('../../static/gen/upload.png')"></image>
					<view :style='{"margin":"0px 0 0","alignItems":"center","flexDirection":"column","display":"flex","width":"auto","justifyContent":"center","order":"2"}' class="info">
						<view :style='{"width":"100%","lineHeight":"1.5","fontSize":"28rpx","color":"#666","textAlign":"left"}'>{{user.shangjiazhanghao}}<text v-if="user.vip&& user.vip=='是'">(VIP)</text></view>
						<view :style='{"overflow":"hidden","whiteSpace":"nowrap","color":"#666","textAlign":"left","width":"100%","lineHeight":"1.5","fontSize":"28rpx","textOverflow":"ellipsis"}'>{{user.jieshao}}</view>
					</view>
					
					<view :style='{"margin":"20rpx 0 0","alignItems":"center","background":"none","flexDirection":"column","display":"flex","width":"100%","justifyContent":"center","order":"3"}' class="info">
						<view :style='{"width":"100%","lineHeight":"48rpx","fontSize":"28rpx","alignItems":"center","justifyContent":"center","display":"flex"}'>
							<span :style='{"color":"#666","whiteSpace":"nowrap"}'>联系方式：</span>
							<span :style='{"color":"#666","whiteSpace":"nowrap"}'>{{user.lianxifangshi}}</span>
						</view>
						<view :style='{"width":"100%","lineHeight":"48rpx","fontSize":"28rpx","alignItems":"center","justifyContent":"center","display":"flex"}' v-if="user.money">
							<span :style='{"color":"#666","whiteSpace":"nowrap"}'>余额：</span>
							<span :style='{"color":"#666","whiteSpace":"nowrap"}'>{{user.money}}</span>
						</view>
						<view :style='{"width":"100%","lineHeight":"48rpx","fontSize":"28rpx","alignItems":"center","justifyContent":"center","display":"flex"}' v-if="user.jf||user.jf==0">
							<span :style='{"color":"#666","whiteSpace":"nowrap"}'>积分：</span>
							<span :style='{"color":"#666","whiteSpace":"nowrap"}'>{{user.jf}}</span>
						</view>
					</view>
					<view :style='{"width":"100%","margin":"30rpx 0 0","alignItems":"center","justifyContent":"space-around","display":"flex","order":"3"}'>
					  <view :style='{"padding":"0 20rpx","margin":"0","borderRadius":"60rpx","background":"#FFD128","display":"flex"}'>
					    <text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#fff"}'></text>
					    <text :style='{"color":"#fff","lineHeight":"60rpx","fontSize":"28rpx"}'>点赞 {{user.thumbsnum}}</text>
					  </view>
					  <view :style='{"padding":"0 20rpx","margin":"0","borderRadius":"60rpx","background":"#0036FF","display":"flex"}'>
					    <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#fff"}'></text>
					    <text :style='{"color":"#fff","lineHeight":"60rpx","fontSize":"28rpx"}'>收藏 {{user.storenum}}</text>
					  </view>
					</view>
				</view>
				<view :style='{"padding":"0 0 0 20rpx","alignItems":"center","top":"20rpx","flexDirection":"row","display":"flex","width":"auto","position":"absolute","right":"40rpx","justifyContent":"center","height":"auto"}' class="setting">
					<text class="icon iconfont icon-qita6" :style='{"border":"0","padding":"0 10rpx 0 0","color":"#000","borderRadius":"0","width":"auto","lineHeight":"1.5","fontSize":"44rpx"}'></text>
					<text :style='{"color":"#000","lineHeight":"2","fontSize":"32rpx"}'>设置</text>
				</view>
			</view>
			
			<view v-else :style='{"minHeight":"280rpx","padding":"40rpx 20rpx","margin":"0 0 20rpx 0","borderRadius":"0 0 30rpx 30rpx","background":"#fff","display":"flex","width":"100%","position":"relative","height":"auto"}' @tap="loginClick" class="header" v-bind:class="{'status':isH5Plus}">
				<view :style='{"alignItems":"center","color":"#666","display":"flex","width":"100%","fontSize":"36rpx","justifyContent":"center","height":"100%"}'>登录/注册</view>
			</view>
			
			<view :style='{"width":"100%","background":"none","height":"auto"}' class="list">
				<view :style='{"width":"100%","margin":"40rpx 0","borderRadius":"30rpx","background":"#fff","height":"auto"}' v-if="user&&user.id">
					<view :style='{"padding":"0 20rpx 0 40rpx","color":"#fff","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250214/607fdecc1a9b45e7a35d80592775c303.png) center center/100% 100%","display":"flex","width":"100%","lineHeight":"100rpx","fontSize":"32rpx","fontWeight":"bold","justifyContent":"space-between"}'>
						<view :style='{"color":"#fff","fontSize":"inherit","lineHeight":"inherit"}'>我的订单</view>
						<view :style='{"fontSize":"28rpx","lineHeight":"inherit","color":"#000","fontWeight":"400"}' @tap="onPageTap('../shop-order/shop-order')">查看全部</view>
					</view>
					<view :style='{"width":"100%","padding":"30rpx 0 10rpx","flexWrap":"wrap","display":"flex","height":"auto"}'>
						<view class="list-item" :style='{"padding":"0 0 20rpx","alignItems":"center","flexDirection":"row","display":"flex","width":"calc(100% / 3)","justifyContent":"center","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=未支付')">
							<span class="icon iconfont icon-kuaijiezhifu" :style='{"padding":"0 10rpx 0 0","lineHeight":"1","fontSize":"56rpx","color":"#D8A900"}'></span>
							<view :style='{"color":"#333","lineHeight":"2","fontSize":"28rpx"}' class="title">未支付</view>
						</view>
						<view class="list-item" :style='{"padding":"0 0 20rpx","alignItems":"center","flexDirection":"row","display":"flex","width":"calc(100% / 3)","justifyContent":"center","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=已支付')">
							<span class="icon iconfont icon-zhifudingjin" :style='{"padding":"0 10rpx 0 0","lineHeight":"1","fontSize":"56rpx","color":"#D8A900"}'></span>
							<view :style='{"color":"#333","lineHeight":"2","fontSize":"28rpx"}' class="title">已支付</view>
						</view>
						<view class="list-item" :style='{"padding":"0 0 20rpx","alignItems":"center","flexDirection":"row","display":"flex","width":"calc(100% / 3)","justifyContent":"center","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=已完成')">
							<span class="icon iconfont icon-yanziwancheng" :style='{"padding":"0 10rpx 0 0","lineHeight":"1","fontSize":"56rpx","color":"#D8A900"}'></span>
							<view :style='{"color":"#333","lineHeight":"2","fontSize":"28rpx"}' class="title">已完成</view>
						</view>
						<view class="list-item" :style='{"padding":"0 0 20rpx","alignItems":"center","flexDirection":"row","display":"flex","width":"calc(100% / 3)","justifyContent":"center","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=已取消')">
							<span class="icon iconfont icon-quxiao16" :style='{"padding":"0 10rpx 0 0","lineHeight":"1","fontSize":"56rpx","color":"#D8A900"}'></span>
							<view :style='{"color":"#333","lineHeight":"2","fontSize":"28rpx"}' class="title">已取消</view>
						</view>
						<view class="list-item" :style='{"padding":"0 0 20rpx","alignItems":"center","flexDirection":"row","display":"flex","width":"calc(100% / 3)","justifyContent":"center","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=已退款')">
							<span class="icon iconfont icon-quxiao19" :style='{"padding":"0 10rpx 0 0","lineHeight":"1","fontSize":"56rpx","color":"#D8A900"}'></span>
							<view :style='{"color":"#333","lineHeight":"2","fontSize":"28rpx"}' class="title">已退款</view>
						</view>
						<!-- <view class="list-item" :style='{"alignItems":"center","flex":"1","flexDirection":"column","display":"flex","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=已发货')">
							<span class="icon iconfont icon-menu16" :style='{"color":"#333","lineHeight":"1","fontSize":"36rpx"}'></span>
							<view :style='{"color":"#333","lineHeight":"2","fontSize":"24rpx"}' class="title">已发货</view>
						</view> -->
					</view>
				</view>
				
				<view :style='{"width":"100%","margin":"0 0 40rpx","overflow":"hidden","borderRadius":"30rpx","background":"#fff","height":"auto"}'>
					<view :style='{"padding":"0 20rpx 0 40rpx","color":"#fff","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250214/607fdecc1a9b45e7a35d80592775c303.png) center center/100% 100%","display":"flex","width":"100%","lineHeight":"100rpx","fontSize":"32rpx","fontWeight":"bold","justifyContent":"space-between"}'>
						<view :style='{"color":"#fff","fontSize":"inherit","lineHeight":"inherit"}'>我的服务</view>
					</view>
					<view class="me-menu-view">
						<block v-for="item in menuList" v-bind:key="item.roleName">
							<block v-if="role==item.roleName" v-bind:key="menu.menu" v-for="(menu,index) in item.backMenu">
								<block v-bind:key="child.tableName" v-for=" (child,sort) in menu.child">
									<view class="me-menu-item" v-if="child.tableName!='orders/已发货' && child.tableName!='orders/已退款' &&child.tableName!='orders/已取消' && child.tableName!='orders/未支付' && child.tableName!='orders/已支付' && child.tableName!='orders/已完成' && child.tableName!='exampaper' && child.tableName!='examquestion'&& child.tableName!='hasTranslate' " @tap="onPageTap('../'+child.tableName+'/list?userid='+user.id+'&menuJump='+child.menuJump)" hover-class="hover">
										<view class="me-menu-icon" :class="child.appFrontIcon"></view>
										<view class="text">{{child.menu}}</view>
										<view class="icon iconfont icon-jinru"></view>
									</view>
								</block>
							</block>
						</block>


						<view v-if="user&&user.id" @tap="onPageTap('../shop-recharge/pay-confirm')" class="me-menu-item" hover-class="hover">
							<view class="cuIcon-moneybag me-menu-icon"></view>
							<view class="text">用户充值</view>
							<view class="icon iconfont icon-jinru"></view>
						</view>
						<view v-if="user&&user.id" @tap="onPageTap('../chat/chat')" class="me-menu-item" hover-class="hover">
							<view class="cuIcon-service me-menu-icon"></view>
							<view class="text">投诉反馈</view>
							<view class="icon iconfont icon-jinru"></view>
						</view>
						<view v-if="user&&user.id" @tap="passwordShow()" class="me-menu-item" hover-class="hover">
							<view class="cuIcon-lock me-menu-icon"></view>
							<view class="text">修改密码</view>
							<view class="icon iconfont icon-jinru"></view>
						</view>
					</view>
				</view>
			</view>
			
			<!-- 推荐 -->
			<view style="width: 100%;height: 80px"></view>
		</view>
		<uni-popup class="popup-content" ref="passwordPopup" type="bottom">
			<view class="passwordForm">
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.mima" placeholder="原密码" />
				</view>
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.newmima" placeholder="新密码" />
				</view>
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.newmima1" placeholder="确认密码" />
				</view>
				<view class="passwordBtnView">
					<button class="passwordBtn" @click="updatePassword">更新</button>
				</view>
			</view>
		</uni-popup>
	</view>
</template>
<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				isH5Plus: true,
				user: {},
				tableName:'',
				role: '',
				menuList: [],
				iconArr: [
					'cuIcon-same',
					'cuIcon-deliver',
					'cuIcon-evaluate',
					'cuIcon-shop',
					'cuIcon-ticket',
					'cuIcon-cascades',
					'cuIcon-discover',
					'cuIcon-question',
					'cuIcon-pic',
					'cuIcon-filter',
					'cuIcon-footprint',
					'cuIcon-pulldown',
					'cuIcon-pullup',
					'cuIcon-moreandroid',
					'cuIcon-refund',
					'cuIcon-qrcode',
					'cuIcon-remind',
					'cuIcon-profile',
					'cuIcon-home',
					'cuIcon-message',
					'cuIcon-link',
					'cuIcon-lock',
					'cuIcon-unlock',
					'cuIcon-vip',
					'cuIcon-weibo',
					'cuIcon-activity',
					'cuIcon-friendadd',
					'cuIcon-friendfamous',
					'cuIcon-friend',
					'cuIcon-goods',
					'cuIcon-selection'
				],
				passwordForm: {
					mima: '',
					newmima: '',
					newmima1: '',
				},
			};
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(){
			let menus = menu.list();
			this.menuList = menus;
		},
		async onShow(){
            uni.removeStorageSync("useridTag");
			this.role = uni.getStorageSync("appRole");
			await this.getSession()
			this.getThumbsup()
			this.getStoreup()
			this.tableName = uni.getStorageSync("nowTable");
			let menus = menu.list();
			this.menuList = menus;
			this.$forceUpdate()
		},
		methods: {
			async getSession(){
				let table = uni.getStorageSync("nowTable");
				let res = await this.$api.session(table);
				this.user = res.data;
				this.$forceUpdate()
			},
			async getThumbsup(){
				if(!this.user||!this.user.id){
					return false
				}
				let res = await this.$api.page('storeup',{userid: this.user.id,type: 21})
				this.user.thumbsnum = Number(res.data.total)
				this.$forceUpdate()
			},
			async getStoreup(){
				if(!this.user||!this.user.id){
					return false
				}
				let res = await this.$api.page('storeup',{userid: this.user.id,type: 1})
				this.user.storenum = Number(res.data.total)
				this.$forceUpdate()
			},
			loginClick(){
				uni.navigateTo({
					url: '../login/login'
				});
			},
			onPageTap(url) {
                uni.setStorageSync("useridTag",1);
				uni.navigateTo({
					url: url,
					fail: function() {
						uni.switchTab({
							url: url
						});
					}
				});
			},
			hasTranslate(){
				for(let x in this.menuList){
					if(this.menuList[x].roleName == this.role){
						for(let i in this.menuList[x].backMenu){
							if(this.menuList[x].backMenu[i].child.length) {
								for(let j in this.menuList[x].backMenu[i].child) {
									if(this.menuList[x].backMenu[i].child[j].tableName=='hasTranslate'){
										return true
									}
								}
							}
						}
					}
				}
				return false
			},
			
			preHttp(str) {
			    return str && str.substr(0,4)=='http';
			},
			recommendDetail(id) {
				uni.navigateTo({
					url: `../${this.recommendTable}/detail?id=${id}`,
					fail: function() {
						uni.switchTab({
							url: `../${this.recommendTable}/detail?id=${id}`
						});
					}
				});
			},
			passwordShow() {
				this.passwordForm = {
					mima: '',
					newmima: '',
					newmima1: '',
				}
				this.$forceUpdate()
				this.$refs.passwordPopup.open()
			},
			async updatePassword() {
				if (this.passwordForm.mima == ''){
					this.$utils.msg('原密码不能为空')
					return false
				}
				if (this.passwordForm.newmima == ''){
					this.$utils.msg('新密码不能为空')
					return false
				}
				if (this.passwordForm.newmima1 == ''){
					this.$utils.msg('确认密码不能为空')
					return false
				}
				let password = ''
				if (this.user.mima) {
					password = this.user.mima;
				} else if (this.user.password) {
					password = this.user.password;
				}
				if (this.tableName == 'yonghu') {
				}
				let newpassword = this.passwordForm.mima
				let res = await this.$api.encrypt('des',this.passwordForm.mima)
				newpassword = res.data
				if(password != newpassword){
					this.$utils.msg('原密码不正确')
					return false
				}
				if (this.passwordForm.newmima != this.passwordForm.newmima1){
					this.$utils.msg('两次密码不一致')
					return false
				}
				if (this.passwordForm.mima == this.passwordForm.newmima){
					this.$utils.msg('新密码与原密码相同！')
					return false
				}
				this.user.password = this.passwordForm.newmima
				this.user.mima = this.passwordForm.newmima
				await this.$api.update(this.tableName,this.user)
				this.$utils.msg('修改密码成功,下次登录系统生效')
				this.$refs.passwordPopup.close()
				this.getSession()
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		height: calc(100vh - 94px);
		box-sizing: border-box;
	}
	.passwordForm {
		width: 100%;
		padding: 10px 20px 60px;
		background: #fff;
	
		.passwordInput {
			background: #eee;
			margin: 0 0 10px;
			padding: 0 10px;
	
			input {
				height: 36px;
				line-height: 36px;
				font-size: 14px;
			}
		}
	
		.passwordBtnView {
			width: 100%;
			display: flex;
			align-items: center;
			justify-content: center;
			padding: 10px 0;
	
			.passwordBtn {
				padding: 0 20px;
				width: auto;
				height: 20px;
				line-height: 20px;
				font-size: 14px;
				color: #fff;
				background: #007aff;
				border: none;
				border-radius: 5px;
	
			}
		}
	}
	.me-menu-view {
		padding: 0 24rpx;
		display: flex;
		width: 100%;
		flex-wrap: wrap;
		height: auto;
		.me-menu-item {
			display: flex;
			width: 100%;
			border-color: #ccc;
			border-width: 0;
			align-items: center;
			border-style: solid;
			height: auto;
			.me-menu-icon {
				color: #000;
				font-size: 52rpx;
				line-height: 1;
			}
			.text {
				padding: 0 20rpx;
				color: #000;
				flex: 1;
				width: 100%;
				font-size: 28rpx;
				line-height: 88rpx;
			}
			.icon {
				color: #999;
				display: none;
				width: 28rpx;
				font-size: 28rpx;
				line-height: 28rpx;
			}
		}
	}
</style>
