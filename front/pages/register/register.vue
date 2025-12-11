<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100%","padding":"20rpx","alignItems":"flex-end","background":"url(http://codegen.caihongy.cn/20250213/96639539f2b04e498b639fe8b5fa4998.png) top center/cover","display":"flex","width":"100%","height":"auto"}'>
		<view :style='{"width":"100%","padding":"0 40rpx","position":"relative","display":"block","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 0 20rpx","borderRadius":"8rpx","display":"block","height":"160rpx"}' src="http://codegen.caihongy.cn/20250214/ef2625fb7a48410886b60969e2b67f48.png" mode="aspectFill"></image>
			<view :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">用户账号：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"60rpx"}'  v-model="ruleForm.yonghuzhanghao"  type="text"  class="uni-input" name="" placeholder="用户账号" />
			</view>
			<view :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"60rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">确认密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"60rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">用户姓名：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"60rpx"}'  v-model="ruleForm.yonghuxingming"  type="text"  class="uni-input" name="" placeholder="用户姓名" />
			</view>
            <view :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="">
				<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">性别：</view>
				<picker :style='{"width":"100%","padding":"0 20rpx","margin":"0","flex":"1","display":"flex","height":"auto"}' v-if="tableName=='yonghu'"  @change="yonghuxingbieChange" :value="yonghuxingbieIndex" :range="yonghuxingbieOptions">
					<view>
						<view :style='{"lineHeight":"60rpx","fontSize":"28rpx","color":"#000","flex":"1"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">年龄：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"60rpx"}'  v-model="ruleForm.nianling"  type="text"  class="uni-input" name="" placeholder="年龄" />
			</view>
            <view :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" @tap="yonghutouxiangTap" class="">
				<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">头像：</view>
				<image :style='{"width":"100rpx","margin":"0 0 0 20rpx","borderRadius":"16rpx","display":"block","height":"100rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"100rpx","margin":"0 0 0 20rpx","borderRadius":"16rpx","display":"block","height":"100rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shitangshangjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">商家账号：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"60rpx"}'  v-model="ruleForm.shangjiazhanghao"  type="text"  class="uni-input" name="" placeholder="商家账号" />
			</view>
			<view :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shitangshangjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"60rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shitangshangjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">确认密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"60rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shitangshangjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">店铺名：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"60rpx"}'  v-model="ruleForm.dianpuming"  type="text"  class="uni-input" name="" placeholder="店铺名" />
			</view>
			<view :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shitangshangjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">店铺位置：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"60rpx"}'  v-model="ruleForm.dianpuweizhi"  type="text"  class="uni-input" name="" placeholder="店铺位置" />
			</view>
			<view :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shitangshangjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">联系方式：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"60rpx"}'  v-model="ruleForm.lianxifangshi"  type="text"  class="uni-input" name="" placeholder="联系方式" />
			</view>
			<view :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shitangshangjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">联系人：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"60rpx"}'  v-model="ruleForm.lianxiren"  type="text"  class="uni-input" name="" placeholder="联系人" />
			</view>
            <view :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shitangshangjia'" @tap="shitangshangjiatouxiangTap" class="">
				<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">头像：</view>
				<image :style='{"width":"100rpx","margin":"0 0 0 20rpx","borderRadius":"16rpx","display":"block","height":"100rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"100rpx","margin":"0 0 0 20rpx","borderRadius":"16rpx","display":"block","height":"100rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"padding":"20rpx 0","margin":"0","borderColor":"#fff","background":"rgba(162,162,162,0.5)","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" v-if="tableName=='shitangshangjia'">
				<view :style='{"padding":"0","borderColor":"#fff","color":"#000","borderRadius":"0","borderWidth":"0 2rpx 0 0","width":"140rpx","lineHeight":"60rpx","fontSize":"26rpx","borderStyle":"solid"}' class="label">介绍：</view>
				<textarea :style='{"border":"2rpx solid #3D3D3D","padding":"24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"240rpx"}' v-model="ruleForm.jieshao" placeholder="介绍"></textarea>
			</view>
			<button :style='{"border":"0","padding":"0px","margin":"20rpx 0","color":"#000","borderRadius":"10rpx","background":"#FFD128","width":"100%","lineHeight":"88rpx","fontSize":"32rpx","height":"88rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
			
			<view class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea1</view>
			<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
			<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                yonghuxingbieOptions: [],
                yonghuxingbieIndex: 0,
				ruleForm: {
                yonghuzhanghao: '',
                mima: '',
                yonghuxingming: '',
                xingbie: '',
                nianling: '',
                touxiang: '',
				money: 0,
                shangjiazhanghao: '',
                mima: '',
                dianpuming: '',
                dianpuweizhi: '',
                lianxifangshi: '',
                lianxiren: '',
                touxiang: '',
                jieshao: '',
                discussnum: '',
                storeupnum: '',
				money: 0,
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='yonghu'){
                this.yonghuxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.yonghuxingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

            // 下拉变化
            yonghuxingbieChange(e) {
                    this.yonghuxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.yonghuxingbieOptions[this.yonghuxingbieIndex]
            },
            yonghutouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },
            shitangshangjiatouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				
				if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
					this.$utils.msg(`用户账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `yonghu` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`yonghu` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if(`yonghu` == this.tableName && this.ruleForm.money&&(!this.$validate.isNumber(this.ruleForm.money))){
					this.$utils.msg(`余额应输入数字`);
					return
				}
				if((!this.ruleForm.shangjiazhanghao) && `shitangshangjia` == this.tableName){
					this.$utils.msg(`商家账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `shitangshangjia` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`shitangshangjia` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.dianpuweizhi) && `shitangshangjia` == this.tableName){
					this.$utils.msg(`店铺位置不能为空`);
					return
				}
				if(`shitangshangjia` == this.tableName && this.ruleForm.lianxifangshi&&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
					this.$utils.msg(`联系方式应输入手机格式`);
					return
				}
				if(`shitangshangjia` == this.tableName && this.ruleForm.discussnum&&(!this.$validate.isIntNumer(this.ruleForm.discussnum))){
					this.$utils.msg(`评论数应输入整数`);
					return
				}
				if(`shitangshangjia` == this.tableName && this.ruleForm.storeupnum&&(!this.$validate.isIntNumer(this.ruleForm.storeupnum))){
					this.$utils.msg(`收藏数应输入整数`);
					return
				}
				if(`shitangshangjia` == this.tableName && this.ruleForm.money&&(!this.$validate.isNumber(this.ruleForm.money))){
					this.$utils.msg(`余额应输入数字`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
