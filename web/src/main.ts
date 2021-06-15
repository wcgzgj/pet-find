import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
// import store from './store'
import axios from 'axios'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';

// 修改axios的baseUrl，这样axios就不用每次都在请求中填写 VUE_APP_SERVER  了
axios.defaults.baseURL=process.env.VUE_APP_SERVER;

const app = createApp(App)
    // app.use(store)
        app.use(router)
        .use(Antd)
        .mount('#app')



