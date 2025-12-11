<template>
	<view class="content">
		<view class="box" :style='{"minHeight":"100%","padding":"20rpx","alignItems":"center","background":"url(http://codegen.caihongy.cn/20250213/96639539f2b04e498b639fe8b5fa4998.png) top center/cover","display":"flex","width":"100%","height":"auto"}'>
			<view :style='{"width":"100%","padding":"0 40rpx","position":"relative","display":"block","height":"auto"}'>
				<image :style='{"width":"160rpx","margin":"0 0 20rpx","borderRadius":"8rpx","display":"block","height":"160rpx"}' src="http://codegen.caihongy.cn/20250213/0fadebe6268c4d4c86ff4c54833ae585.png" mode="aspectFill"></image>
				<view v-if="loginType==1" :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="uni-form-item uni-column">
					<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">账号：</view>
					<input v-model="username" :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"60rpx"}' type="text" class="uni-input" name="" placeholder="请输入账号" />
				</view>
				<view v-if="loginType==1" :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="uni-form-item uni-column">
					<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">密码：</view>
					<input v-model="password" password :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"60rpx"}' type="password" class="uni-input" name="" placeholder="请输入密码" />
				</view>
				<view v-if="roleNum>1" :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">用户类型：</view>
					<picker @change="optionsChange" :value="index" :range="options" :style='{"padding":"0 20rpx","lineHeight":"60rpx","fontSize":"28rpx","color":"#000","flex":"1"}'>
						<view class="uni-picker-type">{{options[index]}}</view>
					</picker>
				</view>
				

				
				<button v-if="loginType==1" class="btn-submit" @tap="onLoginTap" type="primary" :style='{"border":"0","padding":"0px","margin":"20rpx 0","color":"#000","borderRadius":"10rpx","background":"#FFD128","width":"100%","lineHeight":"88rpx","fontSize":"32rpx","height":"88rpx"}'>登陆</button>
				<button v-if="loginType==2" class="btn-submit" @tap="onFaceLoginTap" type="primary" :style='{"border":"0","padding":"0px","margin":"20rpx 0","color":"#000","borderRadius":"10rpx","background":"#FFD128","width":"100%","lineHeight":"88rpx","fontSize":"32rpx","height":"88rpx"}'>人脸识别登录</button>
				<view class="links" :style='{"width":"100%","margin":"0","flexWrap":"wrap","display":"flex","height":"auto"}'>
					<view class="link-highlight" @tap="onRegisterTap('yonghu')" :style='{"color":"#000","padding":"0 10rpx","fontSize":"28rpx"}'>注册用户</view>
				</view>
				
				<view class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea1</view>
				<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
				<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
			</view>
		</view>
	</view>
</template>

<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				username: '',
				password: '',
                loginType:1,
				codes: [{
				  num: 1,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 2,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 3,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 4,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}],
				options: [
					'请选择登录用户类型',
				],
                optionsValues: [
					'',
                    'yonghu',
				],
				index: 0,
				roleNum:0,

			}
		},
		onLoad() {
			let options = ['请选择登录用户类型'];
			let menus = menu.list();
			this.menuList = menus;
			for(let i=0;i<this.menuList.length;i++){
				if(this.menuList[i].hasFrontLogin=='是'){
					options.push(this.menuList[i].roleName);
					this.roleNum++;
				}
			}
			if(this.roleNum==1) {
				this.index = 1;
			}	
			this.options = options;
			this.styleChange()
		},
		onShow() {
		},
		mounted() {
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.loginFrom.content.input.backgroundColor
					// })
				})
			},
			onRegisterTap(tableName) {
                uni.setStorageSync("loginTable", tableName);
				this.$utils.jump('../register/register')
			},
			async onLoginTap() {
                if (!this.username) {
					this.$utils.msg('请输入用户名')
					return
				}
                if (!this.password) {
					this.$utils.msg('请输入用户密码')
					return
				}
                if (!this.optionsValues[this.index]) {
					this.$utils.msg('请选择登录用户类型')
					return
				}

				this.loginPost()

			},
			async loginPost() {
				
				let res = await this.$api.login(`${this.optionsValues[this.index]}`, {
					username: this.username,
					password: this.password
				});
				uni.removeStorageSync("useridTag");
				uni.setStorageSync("appToken", res.token);
				uni.setStorageSync("nickname",this.username);
				uni.setStorageSync("nowTable", `${this.optionsValues[this.index]}`);
				res = await this.$api.session(`${this.optionsValues[this.index]}`);
				if(res.data.touxiang) {
				    uni.setStorageSync('headportrait', res.data.touxiang);
				} else if(res.data.headportrait) {
				    uni.setStorageSync('headportrait', res.data.headportrait);
				}
				uni.setStorageSync('userSession',JSON.stringify(res.data))
				// 保存用户id
				uni.setStorageSync("appUserid", res.data.id);
				if(res.data.vip) {
					uni.setStorageSync("vip", res.data.vip);
				}
				uni.setStorageSync("appRole", `${this.options[this.index]}`);
				this.$utils.tab('../index/index');
			},
			optionsChange(e) {
				this.index = e.target.value
			}
		}
	}
</script>

<style lang="scss" scoped>
	page {
		height: 100%;
	}
	
	.content {
		height: 100%;
		box-sizing: border-box;
	}
	
</style>
