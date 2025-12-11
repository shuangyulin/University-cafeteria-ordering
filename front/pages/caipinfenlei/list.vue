<template>
<!-- category 1 -->
	<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
		<view class="content">
			<view :style='{"minHeight":"100%","width":"100%","padding":"20rpx 20rpx 198rpx","position":"relative","background":"#F6F7F9","height":"auto"}'>
				<view class="cu-bar bg-white search" :style='{"width":"100%","padding":"0","background":"none","display":"flex","height":"auto","order":"1"}'>
					<view :style='{"margin":"0","flex":"1","position":"relative"}' class="search-form round">
						<text class="icon iconfont icon-fangdajing07" :style='{"color":"#FFD128","left":"0px","textAlign":"center","width":"80rpx","fontSize":"40rpx","lineHeight":"80rpx","position":"absolute","right":"0px"}'></text>
						<input placeholder-style="color: #333" :style='{"border":"2rpx solid #FFD128","padding":"12rpx 20rpx 12rpx 80rpx","color":"#333","borderRadius":"0","background":"#fff","width":"100%","lineHeight":"56rpx","fontSize":"28rpx","height":"80rpx"}' v-model="searchForm.caipinfenlei" type="text" placeholder="菜品分类" ></input>
					</view>
					<button :style='{"border":"0","padding":"0px","margin":"0","color":"#fff","borderRadius":"0","background":"#FFD128","width":"136rpx","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="search" class="cu-btn shadow-blur round">搜索</button>
				</view>
			

				<view :style='{"padding":"20rpx","margin":"20rpx 0 0","borderRadius":"20rpx 20rpx 0 0","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between"}'>
					<view @click="sortClick('addtime')" :style='{"border":"0","padding":"0 12rpx","margin":"0 8rpx 0 0","outline":"0","borderRadius":"8rpx","background":"none","display":"flex"}'>
						<text :style='{"color":"#000","lineHeight":"48rpx","fontSize":"24rpx"}'>按日期</text>
						<text v-if="listSort!='addtime'" class="icon iconfont icon-shijian18" :style='{"margin":"0 0 0 8rpx","lineHeight":"48rpx","fontSize":"24rpx","color":"#000"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='asc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 0 0 8rpx","lineHeight":"48rpx","fontSize":"24rpx","color":"#000"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='desc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 0 0 8rpx","lineHeight":"48rpx","fontSize":"24rpx","color":"#000"}'></text>
					</view>
				</view>
				<view :style='{"width":"100%","background":"none","height":"auto"}'>
			
			
			
					<!-- 样式5 -->
					<view class="list-box6" :style='{"padding":"20rpx 0","margin":"0","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
						<block v-for="(list,indexOut) in lists" :key="indexOut">
							<block v-for="(product,index) in list" :key="index">
								<view @tap="onDetailTap(product)" v-if="index%6==0" class="list-item" :style='{"boxShadow":"none","padding":"20rpx","margin":"0 0 20rpx","borderRadius":"20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"49%","height":"auto"}'>
									<view :style='{"padding":"0 20rpx 0 0","order":"5"}'>
										<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
										<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.addtime.replace(/\-/g,'-').replace(/\:/g,':')}}</text>
									</view>
									<!-- #ifdef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"10rpx 0 0","justifyContent":"space-between","display":"flex","height":"auto","order":"11"}'>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','修改')) || (!userid && isAuthFront('caipinfenlei','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','删除')) || (!userid && isAuthFront('caipinfenlei','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
									<!-- #ifndef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"10rpx 0 0","justifyContent":"space-between","display":"flex","height":"auto","order":"11"}'>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','修改')) || (!userid && isAuthFront('caipinfenlei','修改'))" @tap.stop.proevent="onUpdateTap(product)">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','删除')) || (!userid && isAuthFront('caipinfenlei','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
								</view>
								<view @tap="onDetailTap(product)" v-if="index%6==1" class="list-item" :style='{"boxShadow":"none","padding":"20rpx","margin":"0 0 20rpx","borderRadius":"20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"49%","height":"auto"}'>
									<view :style='{"padding":"0 20rpx 0 0","order":"5"}'>
										<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
										<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.addtime.replace(/\-/g,'-').replace(/\:/g,':')}}</text>
									</view>
									<!-- #ifdef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"10rpx 0 0","justifyContent":"space-between","display":"flex","height":"auto","order":"11"}'>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','修改')) || (!userid && isAuthFront('caipinfenlei','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','删除')) || (!userid && isAuthFront('caipinfenlei','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
									<!-- #ifndef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"10rpx 0 0","justifyContent":"space-between","display":"flex","height":"auto","order":"11"}'>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','修改')) || (!userid && isAuthFront('caipinfenlei','修改'))" @tap.stop.proevent="onUpdateTap(product)">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','删除')) || (!userid && isAuthFront('caipinfenlei','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
								</view>
								<view @tap="onDetailTap(product)" v-if="index%6==2" class="list-item" :style='{"boxShadow":"none","padding":"20rpx","margin":"0 0 20rpx","borderRadius":"20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"49%","height":"auto"}'>
									<view :style='{"padding":"0 20rpx 0 0","order":"5"}'>
										<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
										<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.addtime.replace(/\-/g,'-').replace(/\:/g,':')}}</text>
									</view>
									<!-- #ifdef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"10rpx 0 0","justifyContent":"space-between","display":"flex","height":"auto","order":"11"}'>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','修改')) || (!userid && isAuthFront('caipinfenlei','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','删除')) || (!userid && isAuthFront('caipinfenlei','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
									<!-- #ifndef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"10rpx 0 0","justifyContent":"space-between","display":"flex","height":"auto","order":"11"}'>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','修改')) || (!userid && isAuthFront('caipinfenlei','修改'))" @tap.stop.proevent="onUpdateTap(product)">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','删除')) || (!userid && isAuthFront('caipinfenlei','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
								</view>
								<view @tap="onDetailTap(product)" v-if="index%6==3" class="list-item" :style='{"boxShadow":"none","padding":"20rpx","margin":"0 0 20rpx","borderRadius":"20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"49%","height":"auto"}'>
									<view :style='{"padding":"0 20rpx 0 0","order":"5"}'>
										<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
										<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.addtime.replace(/\-/g,'-').replace(/\:/g,':')}}</text>
									</view>
									<!-- #ifdef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"10rpx 0 0","justifyContent":"space-between","display":"flex","height":"auto","order":"11"}'>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','修改')) || (!userid && isAuthFront('caipinfenlei','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','删除')) || (!userid && isAuthFront('caipinfenlei','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
									<!-- #ifndef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"10rpx 0 0","justifyContent":"space-between","display":"flex","height":"auto","order":"11"}'>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','修改')) || (!userid && isAuthFront('caipinfenlei','修改'))" @tap.stop.proevent="onUpdateTap(product)">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','删除')) || (!userid && isAuthFront('caipinfenlei','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
								</view>
								
								<view @tap="onDetailTap(product)" v-if="index%6==4" class="list-item" :style='{"boxShadow":"none","padding":"20rpx","margin":"0 0 20rpx","borderRadius":"20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"49%","height":"auto"}'>
									<view class="list-item-body" :style='{"width":"calc(100% - 100rpx)","padding":"0","margin":"0","flexWrap":"wrap","display":"flex","height":"auto"}'>
										<view :style='{"padding":"0 20rpx 0 0","order":"5"}'>
											<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
											<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
										</view>
									</view>
									<!-- #ifdef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"10rpx 0 0","justifyContent":"space-between","display":"flex","height":"auto","order":"11"}'>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','修改')) || (!userid && isAuthFront('caipinfenlei','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','删除')) || (!userid && isAuthFront('caipinfenlei','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
									<!-- #ifndef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"10rpx 0 0","justifyContent":"space-between","display":"flex","height":"auto","order":"11"}'>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','修改')) || (!userid && isAuthFront('caipinfenlei','修改'))" @tap.stop.proevent="onUpdateTap(product)">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','删除')) || (!userid && isAuthFront('caipinfenlei','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
								</view>
								<view @tap="onDetailTap(product)" v-if="index%6==5" class="list-item" :style='{"boxShadow":"none","padding":"20rpx","margin":"0 0 20rpx","borderRadius":"20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"49%","height":"auto"}'>
									<view class="list-item-body" :style='{"width":"calc(100% - 100rpx)","padding":"0","margin":"0","flexWrap":"wrap","display":"flex","height":"auto"}'>
										<view :style='{"padding":"0 20rpx 0 0","order":"5"}'>
											<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
											<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
										</view>
									</view>
									<!-- #ifdef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"10rpx 0 0","justifyContent":"space-between","display":"flex","height":"auto","order":"11"}'>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','修改')) || (!userid && isAuthFront('caipinfenlei','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','删除')) || (!userid && isAuthFront('caipinfenlei','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
									<!-- #ifndef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"10rpx 0 0","justifyContent":"space-between","display":"flex","height":"auto","order":"11"}'>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','修改')) || (!userid && isAuthFront('caipinfenlei','修改'))" @tap.stop.proevent="onUpdateTap(product)">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#FFD128","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"display":"flex"}' v-if="(userid && isAuth('caipinfenlei','删除')) || (!userid && isAuthFront('caipinfenlei','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#959595","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
								</view>
							</block>
						</block>
					</view>


			
			
			
			
				</view>
				<button :style='{"border":"0","boxShadow":"none","color":"rgb(255, 255, 255)","bottom":"128rpx","right":"128rpx","outline":"none","borderRadius":"100%","background":"#FFD128","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"fixed","height":"80rpx","zIndex":"999"}' v-if="userid && isAuth('caipinfenlei','新增')" class="add-btn" @click="onAddTap()">新增</button>
				<button :style='{"border":"0","boxShadow":"none","color":"rgb(255, 255, 255)","bottom":"128rpx","right":"128rpx","outline":"none","borderRadius":"100%","background":"#FFD128","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"fixed","height":"80rpx","zIndex":"999"}' v-if="!userid && isAuthFront('caipinfenlei','新增')" class="add-btn" @click="onAddTap()">新增</button>
			</view>
		</view>
	</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				list: [],
				lists: [],
                userid: '',
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 5, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				searchForm:{
					caipinfenlei: '',
				},
				CustomBar: '0',
				listSort: 'id',
				listOrder: 'desc',
				screenBoxShow: false,
			};
		},
		watch: {
		},
		mounted() {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onShow() {
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		async onLoad(options) {
            if(options.userid) {
                this.userid=options.userid;
            } else {
                this.userid = "";
            }
			this.hasNext = true
			// 重新加载数据
			// if (this.mescroll) this.mescroll.resetUpScroll()
		},
		components: {
		},
		methods: {
			screenReset(){
				this.searchForm = {}
				this.search()
				this.$forceUpdate()
			},
			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			sortClick(type){
				if(this.listSort==type){
					if(this.listOrder == 'desc'){
						this.listOrder = 'asc'
					}else{
						this.listOrder = 'desc'
					}
				}else{
					this.listSort = type
					this.listOrder = 'desc'
				}
				this.search()
			},
            priceChange(price) {
                return Number(price).toFixed(2);
            },
            preHttp(str) {
                return str && str.substr(0,4)=='http';
            },
			//类别搜索
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size,
				}
				params['sort'] = this.listSort;
				params['order'] = this.listOrder;

				if(this.searchForm.caipinfenlei){
					params['caipinfenlei'] = '%' + this.searchForm.caipinfenlei + '%'
				}
				let user = uni.getStorageSync("appUserid")?JSON.parse(uni.getStorageSync('userSession')):{}
                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`caipinfenlei`, params);
                } else {
                    res = await this.$api.list(`caipinfenlei`, params);
                }

				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				this.$forceUpdate()
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			// 详情
			onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			onUpdate(e){
				this.onUpdateTap(e.currentTarget.dataset.row)
			},
			// 修改
			onUpdateTap(row){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update?id=${row.id}`)
			},
			// 添加
			onAddTap(){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update`)
			},
			onDelete(e){
				this.onDeleteTap(e.currentTarget.dataset.row.id)
			},
			onDeleteTap(id){
				var _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认删除',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.del('caipinfenlei', JSON.stringify([id]));
							_this.$utils.msg('删除成功');
							_this.hasNext = true
							// 重置分页参数页数为1
							_this.search()
						}
					}
				});
			},
			// 搜索
			async search(){
				this.mescroll.num = 1
				let searchForm = {
					page: this.mescroll.num,
					limit: this.mescroll.size,
				}
				searchForm['sort'] = this.listSort;
				searchForm['order'] = this.listOrder;

				if(this.searchForm.caipinfenlei){
					searchForm['caipinfenlei'] = '%' + this.searchForm.caipinfenlei + '%'
				}
                let res = {};
                if(this.userid) {
                    res = await this.$api.page(`caipinfenlei`, searchForm);
                } else {
                    res = await this.$api.list(`caipinfenlei`, searchForm);
                }
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
				this.screenBoxShow = false
			}
		}
	};
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.category-one .tab {
		cursor: pointer;
		padding: 0 30rpx;
		color: #959595;
		background: none;
		display: inline-block;
		width: auto;
		font-size: 28rpx;
		line-height: 80rpx;
	}
	
	.category-one .tab.active {
		cursor: pointer;
		padding: 0 30rpx;
		color: #FFD128;
		background: none;
		display: inline-block;
		width: auto;
		font-size: 28rpx;
		line-height: 80rpx;
	}
</style>
