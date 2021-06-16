<template>
    <a-layout-header>

        <a-menu
                theme="dark"
                mode="horizontal"
                :style="{ lineHeight: '64px' }"
        >

            <a-menu-item key="/">
                <router-link to="/">
                    返回首页
                </router-link>
            </a-menu-item>


            <a-menu-item key="/about">
                <router-link to="/about">
                    关于我们
                </router-link>
            </a-menu-item>


            <a-sub-menu key="login/register" :style="user.id?{visibility:'hidden'} :{} ">
                <template #title>
                    <span >
                      <span >登陆/注册</span>
                    </span>
                </template>
                <a-menu-item key="login" @click="showLogin()">登陆</a-menu-item>
                <a-menu-item key="register" @click="showRegister()">注册</a-menu-item>
            </a-sub-menu>



            <a-sub-menu key="welcome" :style="user.id?{} :{visibility:'hidden'} ">
                <template #title>
                    <span >
                      <span>欢迎,{{user.realname}}</span>
                    </span>
                </template>
                <a-menu-item key="logout" @click="logout()">注销</a-menu-item>
            </a-sub-menu>


        </a-menu>


    </a-layout-header>



    <a-modal
            v-model:visible="loginVisible"
            title="登录"
            ok-text="确认"
            cancel-text="取消"
            @ok="login"
    >
        <a-form :model="loginUser" :label-col="{ span: 6 }" :wrapper-col="{ span: 18 }">
            <a-form-item label="用户名">
                <a-input v-model:value="loginUser.loginname" />
            </a-form-item>
            <a-form-item label="密码">
                <a-input v-model:value="loginUser.password" type="password"/>
            </a-form-item>
        </a-form>
    </a-modal>



    <a-modal
            v-model:visible="registerVisible"
            title="注册"
            ok-text="确认"
            cancel-text="取消"
            @ok="hideRegister"
    >
        <p>this is register modal</p>
    </a-modal>


</template>

<script>

    import { defineComponent,ref } from 'vue';
    import { message } from 'ant-design-vue';
    import axios from "axios";
    import {computed} from "@vue/reactivity";
    import store from "@/store";

    export default {

        name: "Header",

        setup() {


            /**
             * 计算属性，判断当前有无用户登录
             */
            const user = computed(() => store.state.user);


            /**
             * 展示登陆窗口
             */
            const loginVisible = ref(false);
            const hideLogin = () => {
                loginVisible.value = false;
            };
            const showLogin = ()=> {
                console.log("点击登陆")
                loginVisible.value = true;
            }


            /**
             * 展示注册页面
             */
            const registerVisible = ref(false);
            const showRegister = ()=> {
                registerVisible.value=true;
            }
            const hideRegister = ()=> {
                registerVisible.value=false;
            }


            const loginUser = ref({
                loginname:"admin",
                password:"123"
            });

            const login = () => {
                axios.post("/user/login",loginUser.value).then(resp =>{
                    /**
                     * resp 是 axios 的 http 包装类
                     * 还不是我们后端返回的 commonResp
                     */
                    const data = resp.data;
                    if (data.success) {
                        message.success("登录成功");
                        hideLogin();
                        /**
                         * setUser: vuex 中 mutations中的方法
                         *
                         * 后面的参数，都是我们在 mutations 中自定义方法的参数
                         * state 参数因为是自带的，所以没有必要写
                         */
                        store.commit("setUser",data.content);
                    } else {
                        message.error(data.message);
                    }
                })
            }


            /**
             * 注销界面
             */
            const logout = () => {
                axios.post("/user/logout/"+user.value.id).then(resp=>{
                    const data=resp.data;
                    if (data.success) {
                        message.success("退出成功");
                        /**
                         * router 跳转到首页
                         */
                        /**
                         * 退出登录时
                         * 将 sessionStorage 中对应 user的信息清空
                         * 因为
                         */
                        store.commit("setUser", {});

                    } else {
                        message.error(data.message);
                    }
                })
            }



            return {
                showLogin,
                hideLogin,
                showRegister,
                hideRegister,
                login,
                logout,

                loginVisible,
                registerVisible,

                loginUser,
                user
            }
        },
    }
</script>

<style scoped>
    /*.site-layout-content {*/
    /*    min-height: 280px;*/
    /*    padding: 24px;*/
    /*    background: #fff;*/
    /*}*/
    /*#components-layout-demo-top .logo {*/
    /*    float: left;*/
    /*    width: 120px;*/
    /*    height: 31px;*/
    /*    margin: 16px 24px 16px 0;*/
    /*    background: rgba(255, 255, 255, 0.3);*/
    /*}*/
    /*.ant-row-rtl #components-layout-demo-top .logo {*/
    /*    float: right;*/
    /*    margin: 16px 0 16px 24px;*/
    /*}*/

    /*[data-theme='dark'] .site-layout-content {*/
    /*    background: #141414;*/
    /*}*/

    /*.login-menu {*/
    /*    float: right;*/
    /*    color: white;*/
    /*    padding-left: 10px;*/
    /*}*/

</style>