<template>
	<div>
		<div class="register-container">
			<el-form v-if="pageFlag=='register'" ref="ruleForm" class="rgs-form animate__animated animate__bounceIn" :model="ruleForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">基于Android的大学食堂点餐app</div>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<el-input  v-model="ruleForm.yonghuzhanghao"  autocomplete="off" placeholder="用户账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<el-input  v-model="ruleForm.yonghuxingming"  autocomplete="off" placeholder="用户姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in yonghuxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<el-input  v-model="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="yonghutouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shitangshangjia'">
						<el-input  v-model="ruleForm.shangjiazhanghao"  autocomplete="off" placeholder="商家账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shitangshangjia'">
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shitangshangjia'">
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shitangshangjia'">
						<el-input  v-model="ruleForm.dianpuming"  autocomplete="off" placeholder="店铺名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shitangshangjia'">
						<el-input  v-model="ruleForm.dianpuweizhi"  autocomplete="off" placeholder="店铺位置"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shitangshangjia'">
						<el-input  v-model="ruleForm.lianxifangshi"  autocomplete="off" placeholder="联系方式"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shitangshangjia'">
						<el-input  v-model="ruleForm.lianxiren"  autocomplete="off" placeholder="联系人"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shitangshangjia'">
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="shitangshangjiatouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shitangshangjia'">
						<el-input type="textarea" v-model="ruleForm.jieshao" autocomplete="off" placeholder="介绍" />
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">注册</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，直接登录</div>
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	import 'animate.css'
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            yonghuxingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='yonghu'){
				this.ruleForm = {
					yonghuzhanghao: '',
					mima: '',
					yonghuxingming: '',
					xingbie: '',
					nianling: '',
					touxiang: '',
					money: '',
				}
			}
			if(this.tableName=='shitangshangjia'){
				this.ruleForm = {
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
					money: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('shitangshangjia' == this.tableName) {
				this.rules.shangjiazhanghao = [{ required: true, message: '请输入商家账号', trigger: 'blur' }]
			}
			if ('shitangshangjia' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('shitangshangjia' == this.tableName) {
				this.rules.dianpuweizhi = [{ required: true, message: '请输入店铺位置', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yonghutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        shitangshangjiatouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
			if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
				this.$message.error(`用户账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `yonghu` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `yonghu` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.shangjiazhanghao) && `shitangshangjia` == this.tableName){
				this.$message.error(`商家账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `shitangshangjia` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `shitangshangjia` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.dianpuweizhi) && `shitangshangjia` == this.tableName){
				this.$message.error(`店铺位置不能为空`);
				return
			}
			if(`shitangshangjia` == this.tableName && this.ruleForm.lianxifangshi &&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
				this.$message.error(`联系方式应输入手机格式`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.register-container {
	position: relative;
	background: url(http://codegen.caihongy.cn/20240908/d034b47ed098416a8fa2a89d739cf12f.jpg) no-repeat center center / 100% 100%;
	background: url(http://codegen.caihongy.cn/20240908/d034b47ed098416a8fa2a89d739cf12f.jpg) no-repeat center center / 100% 100%;
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;
	position: relative !important;
	.rgs-form {
		.rgs-form2 {
		width: 100%;
		}
		border-radius: 30px;
		padding: 30px 80px 30px 80px;
		margin: 20px auto 60px;
		background: #0B0B0B80;
		width: 600px;
		height: auto;
		.title {
			padding: 0;
			margin: 0 0 20px 0;
			color: #fff;
			background: none;
			font-weight: 600;
			width: auto;
			font-size: 26px;
			line-height: 40px;
			text-align: center;
		}
		.list-item {
			padding: 0;
			margin: 0 0 10px;
			width: 100%;
			position: relative;
			height: auto;
			/deep/ .el-form-item__content {
			}
			.el-input {
				width: 100%;
			}
			.el-input /deep/ .el-input__inner {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 40px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px;
				outline: none;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 40px;
			}
			.el-input-number {
				width: 100%;
			}
			.el-input-number /deep/ .el-input__inner {
				text-align: center;
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 40px;
			}
			.el-input-number /deep/ .el-input__inner:focus {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px;
				outline: none;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 40px;
			}
			.el-input-number /deep/ .el-input-number__decrease {
				display: none;
			}
			.el-input-number /deep/ .el-input-number__increase {
				display: none;
			}
			.el-select {
				width: 100%;
			}
			.el-select /deep/ .el-input__inner {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 38px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px;
				outline: none;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 38px;
			}
			.el-date-editor {
				width: 100%;
			}
			.el-date-editor /deep/ .el-input__inner {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px 0 30px;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 38px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px 0 30px;
				outline: none;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 38px;
			}
			.el-date-editor.el-input {
				width: 100%;
			}
			/deep/ .el-upload--picture-card {
				background: transparent;
				border: 0;
				border-radius: 0;
				width: auto;
				height: auto;
				line-height: initial;
				vertical-align: middle;
			}
			/deep/ .upload .upload-img {
				border: 1px solid #e6e6e6;
				cursor: pointer;
				border-radius: 8px;
				color: #999;
				background: none;
				width: 90px;
				font-size: 24px;
				border-width: 1px 1px 1px 10px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 1px solid #e6e6e6;
				cursor: pointer;
				border-radius: 8px;
				color: #999;
				background: none;
				width: 90px;
				font-size: 24px;
				border-width: 1px 1px 1px 10px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 1px solid #e6e6e6;
				cursor: pointer;
				border-radius: 8px;
				color: #999;
				background: none;
				width: 90px;
				font-size: 24px;
				border-width: 1px 1px 1px 10px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload__tip {
				color: #aaa;
				font-size: 15px;
			}
			/deep/ .el-input__inner::placeholder {
				color: #999;
				font-size: 16px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				top: 5px;
				left: 136px;
				position: inherit;
				content: "*";
				order: -1;
			}
			.editor {
				background: #fff;
				width: 100%;
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px;
				margin: 0;
				color: #666;
				background: none;
				flex: 1;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 38px;
			}
			input:focus {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px;
				outline: none;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 38px;
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
			button {
				border: 0px solid #e6e6e6;
				cursor: pointer;
				border-radius: 8px;
				padding: 0;
				margin: 0 0 0 10px;
				color: #fff;
				background: #FCBB78;
				width: 150px;
				font-size: 15px;
				height: 38px;
			}
			button:hover {
				opacity: 0.9;
			}
		}
		.register-btn {
			width: 100%;
		}
		.register-btn1 {
			width: 100%;
		}
		.register-btn2 {
			width: 100%;
		}
		.r-btn {
			border: 0px solid rgba(0, 0, 0, 1);
			cursor: pointer;
			padding: 0 10px;
			margin: 0 0 10px;
			color: #fff;
			font-weight: 600;
			letter-spacing: 10px;
			font-size: 22px;
			border-radius: 8px;
			background: #FCBB78;
			width: 100%;
			min-width: 68px;
			height: 50px;
		}
		.r-btn:hover {
			border: 0px solid rgba(0, 0, 0, 1);
			opacity: 0.9;
		}
		.r-login {
			cursor: pointer;
			padding: 0;
			color: #aaa;
			display: inline-block;
			width: 100%;
			font-size: 15px;
			line-height: 40px;
			text-align: right;
		}
		.r-login:hover {
			opacity: 1;
		}
	}
}
	
	::-webkit-scrollbar {
	  display: none;
	}
</style>
