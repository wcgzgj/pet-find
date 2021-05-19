<template>
    <el-container class="home-container">

        <el-main class="upload-main">

            <div class="upload-main-font">
                请上传照片
            </div>

            <el-upload
                    class="upload-demo"
                    drag
                    action="#"
                    :before-upload="beforeupload"
                    :http-request="uploadHttpRequest"
                    limit="1"
                    :file-list="fileList"
                    multiple>
                <i class="el-icon-upload"></i>
                <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                <template #tip>
                    <div class="el-upload__tip">
                        只能上传 jpg/png 文件，且不超过 500kb
                    </div>
                </template>
            </el-upload>

            <div class="show-fonud-pic">
                有您的宝贝吗？
                <br/>
                <i class="el-icon-bottom"></i>
            </div>


            <el-carousel :interval="2000" type="card" height="200px">
                <el-carousel-item v-for="item in 6" :key="item" >
                    <h3 class="medium">{{ item }}</h3>
                </el-carousel-item>
            </el-carousel>

        </el-main>
    </el-container>
</template>


<script>
    import { defineComponent,onMounted,ref } from 'vue';
    import axios from 'axios'

    export default {
        name: "FindView",

        setup() {

            const fileList=[];

            const uploadHttpRequest = (req) => {
                let formData = new FormData();
                formData.append("pic",req.file)
                axios.post("/pic/save",formData).then((resp)=> {
                    const data = resp.data
                    if (data.success) {
                        console.log("图片上传成功！")
                    } else {
                        console.log("图片上传失败！")
                    }
                })
            }


            onMounted(()=>{
            })

            return {
                uploadHttpRequest,
                fileList
            }
        }

    }
</script>

<style scoped>
    .upload-main {
        display: flex;
        flex-direction: column;
        align-items: center;

    }


    .upload-main-font {
        margin: 50px;
        font-size: 40px;
        font-family: Apple Chancery, cursive;
    }

    .home-container {
        background-color: #87cefa;
    }

    .show-fonud-pic {
        margin-top: 40px;
        text-align: center;
    }

    .el-carousel__item h3 {
        color: #475669;
        font-size: 14px;
        opacity: 0.75;
        line-height: 200px;
        margin: 0;
    }

    .el-carousel__item:nth-child(2n) {
        background-color: #99a9bf;
    }

    .el-carousel__item:nth-child(2n+1) {
        background-color: #d3dce6;
    }

</style>