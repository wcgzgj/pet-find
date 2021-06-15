<template>
    <!--志愿者上传页面-->

    <a-layout-content style="padding: 0 50px">
        <a-breadcrumb style="margin: 16px 0">
        </a-breadcrumb>
        <div :style="{ background: '#fff', padding: '24px', minHeight: '280px' }" class="card-display">

            <!--上传控件-->
            <!--<a-upload-->
            <!--        v-model:file-list="fileList"-->
            <!--        :multiple="false"-->
            <!--        @beforeUpload="beforeUpload"-->
            <!--        @change="handleChange"-->
            <!--&gt;-->
            <!--    <a-button>-->
            <!--        <upload-outlined></upload-outlined>-->
            <!--        Click to Upload-->
            <!--    </a-button>-->
            <!--</a-upload>-->
            <input type="file" v-on:change="uploadImage" id="file-upload-input">


            <!--志愿者信息表单-->
            <a-form
                    title="登录表单"
                    @ok="upload"
                    style="margin-top: 40px"
            >

                <a-form-item required label="发现地址" name="address">
                    <a-input v-model:value="formState.name" type="text" placeholder="请输入发现地"/>
                </a-form-item>

            </a-form>


        </div>
    </a-layout-content>

</template>

<script>

    import { InboxOutlined,UploadOutlined } from '@ant-design/icons-vue';
    import { message } from 'ant-design-vue';
    import { defineComponent, ref,reactive } from 'vue';
    import axios from "axios";


    export default {
        components: {
            InboxOutlined,
            UploadOutlined
        },
        name: "Upload",

        setup() {

            /**
             * 图片上传信息
             */
            const handleChange = () => {
                if (fileList.value.length==0) {
                    message.error("请选择待上传的图片")
                    return false;
                }
                let formData = new FormData();
                formData.append("file",fileList.value[0]);
                console.log("等待上传的文件信息为:"+formData.get("file"));
                axios.post("/pic/upload",formData).then(resp=>{
                    const data = resp.data;
                    if (data.success) {
                        message.success("图片上传成功")
                    } else {
                        message.error(data.message);
                    }
                })
            };

            const uploadImage = () => {
                let formData = new FormData();
                let file = document.querySelector("#file-upload-input").files[0];
                console.log("获取的文件信息为:"+file);
                formData.append("file",document.querySelector("#file-upload-input").files[0])
                console.log("等待上传的文件信息为:"+formData.get("file"));
                axios.post("/pic/upload",formData).then(resp=>{
                    const data = resp.data;
                    if (data.success) {
                        message.success("图片上传成功")
                    } else {
                        message.error(data.message);
                    }
                })
            }

            const beforeUpload = () => {
                return false;
            }

            const fileList = ref([]);



            /**
             * 表单信息
             * @type {ToRef<{address: string}>}
             */
            const formState = ref({
                address:""
            });

            const update = () => {
                if (fileList.value.length==0) {
                    message.error("错误，请先上传图片");
                    return false;
                }
                axios.post("/")
            }







            return {
                /**
                 * 图片上传信息
                 */
                fileList,
                headers: {
                    authorization: 'authorization-text',
                },
                handleChange,
                beforeUpload,
                uploadImage,


                /**
                 * 表单信息
                 */
                formState,
                update
            }
        },
    }
</script>

<style scoped>

</style>