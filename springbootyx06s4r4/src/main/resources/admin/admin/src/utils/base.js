const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootyx06s4r4/",
            name: "springbootyx06s4r4",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootyx06s4r4/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于Android的大学食堂点餐app"
        } 
    }
}
export default base
