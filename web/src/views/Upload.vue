<template>
    <!--志愿者上传页面-->

    <a-layout-content style="padding: 0 50px">
        <a-breadcrumb style="margin: 16px 0">
        </a-breadcrumb>
        <div :style="{ background: '#fff', padding: '24px', minHeight: '280px' }" class="card-display">

            <input type="file" v-on:change="uploadImage" id="file-upload-input">

            <a-image
                    style="margin-top: 20px"
                    :width="200"
                    :src="formState.newPicPath"
            />

            <!--志愿者信息表单-->
            <a-form
                    title="上传表单"
                    style="margin-top: 40px"
            >
                <a-form-item label="发现地址:" name="address">
                    <a-input v-model:value="formState.address" type="text" placeholder="请输入发现地"/>
                </a-form-item>
                <a-form-item :wrapper-col="{ span: 14, offset: 4 }">
                    <a-button type="primary" @click="uploadInfo">确认</a-button>
                    <a-button style="margin-left: 10px" @click="reset">重置</a-button>
                </a-form-item>

            </a-form>


        </div>
    </a-layout-content>

</template>

<script>

    import { message } from 'ant-design-vue';
    import { defineComponent, ref,reactive } from 'vue';
    import axios from "axios";
    import {computed} from "@vue/reactivity";
    import store from "@/store";



    export default {
        name: "Upload",

        setup() {

            const user = computed(() => store.state.user);

            /**
             * 图片上传信息
             */
            const uploadImage = () => {
                let formData = new FormData();
                console.log("当前文件的个数为："+document.querySelector("#file-upload-input").files.length);
                let file = document.querySelector("#file-upload-input").files[0];
                formData.append("file",file)
                console.log("等待上传的文件信息为:"+formData.get("file"));
                axios.post("/pic/uploadPic",formData).then(resp=>{
                    const data = resp.data;
                    if (data.success) {
                        message.success("图片上传成功")
                        formState.value.newPicId=data.content.newPicId;
                        formState.value.newPicPath=data.content.newPicPath;
                        console.log("回显的图片路径为："+formState.value.newPicPath);
                    } else {
                        message.error(data.message);
                    }
                })
            }




            /**
             * 表单信息
             * @type {ToRef<{address: string}>}
             */
            const formState = ref({
                address:"",
                newPicId:"",
                newPicPath:"",
                userId:""
            });

            const uploadInfo = () => {
                if (formState.value.newPicId==null || formState.value.newPicId.length==0) {
                    message.error("请先上传正确的图片");
                    return false;
                }
                if (formState.value.address==null || formState.value.address.length==0) {
                    message.error("请输入发现地址");
                    return false;
                }
                formState.value.userId=user.value.id;

                axios.post("/pic/uploadFindInfo",formState.value).then(resp=>{
                    const data = resp.data;
                    if (data.success) {
                        message.success("查询信息提交成功");
                        reset();
                    } else {
                        message.error("上传错误");
                    }
                })
            }

            //清空表单信息
            const reset = () => {
                formState.value.address="";
                formState.value.newPicPath="";
                formState.value.newPicId="";
                document.querySelector("#file-upload-input").files=[];
            }



            return {
                /**
                 * 图片上传信息
                 */
                headers: {
                    authorization: 'authorization-text',
                },
                uploadImage,


                /**
                 * 表单信息
                 */
                formState,
                uploadInfo,
                reset
            }
        },
    }
</script>

<style scoped>

</style>