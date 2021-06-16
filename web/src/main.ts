import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
// import store from './store'
import axios from 'axios'
import Antd, {message} from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';

// 修改axios的baseUrl，这样axios就不用每次都在请求中填写 VUE_APP_SERVER  了
axios.defaults.baseURL=process.env.VUE_APP_SERVER;


/**
 * 控制登录 验证才能进入页面
 */
// 首先，需要定义 js/session-storage.js 下的类
declare let SessionStorage: any;
// 然后，才能借着这个工具类，去获取 sessionStorage 中存储的数据
router.beforeEach((to,from,next)=>{
        if(to.meta.needLogin){
                //判断 用户是否登录 用户名密码
                console.log("sessionStorage中存储的变量："+SessionStorage.get("USER").loginname);
                if(SessionStorage.get('USER').loginname){
                        console.log("可以放行");
                        next();
                } else {
                        console.log("不能放行，跳转到首页");
                        message.error("请先登录！");
                        router.push("/");
                }
        }else{
                next();
        }
})



const app = createApp(App)
    // app.use(store)
        app.use(router)
        .use(Antd)
        .mount('#app')



