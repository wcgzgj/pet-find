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

            <!--vue 展示系统目录中的图片资源    需要使用 require 函数-->
            <!--<el-image :src="require('/Users/faro_z/Pictures/风之谷/地下河流.jpg')"/>-->

            <!--我发现轮播图的展示效果不太好，所以弃用了-->
            <!--<el-carousel :interval="2000" type="card" height="200px">-->
            <!--    <el-carousel-item v-for="pic in picPaths" :key="pic" >-->
            <!--        <h3 class="medium">{{ pic.path }}</h3>-->
            <!--        &lt;!&ndash;<el-image :src="pic.path"></el-image>&ndash;&gt;-->
            <!--        &lt;!&ndash;{{pic.path}}&ndash;&gt;-->
            <!--    </el-carousel-item>-->
            <!--</el-carousel>-->


            <el-card :body-style="{ padding: '0px' }">
                <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
                <div style="padding: 14px;">
                    <span>好吃的汉堡</span>
                    <div class="bottom">
                        <time class="time">{{ currentDate }}</time>
                        <el-button type="text" class="button">操作按钮</el-button>
                    </div>
                </div>
            </el-card>
            <el-card :body-style="{ padding: '0px' }">
                <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
                <div style="padding: 14px;">
                    <span>好吃的汉堡</span>
                    <div class="bottom">
                        <time class="time">{{ currentDate }}</time>
                        <el-button type="text" class="button">操作按钮</el-button>
                    </div>
                </div>
            </el-card>




            <!--下面，是获取本地路径的图片的方法，需要使用 require 函数-->
            <!--<el-image :src="require('/Users/faro_z/文件/坚果云/编程代码存储路径/java/项目开发/宠物识别/static/upload/56925777391915008.jpg')"></el-image>-->

        </el-main>
    </el-container>
</template>


<script>
    import { defineComponent,onMounted,ref } from 'vue';
    import axios from 'axios';
    import { ElMessage } from 'element-plus'

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


            const picPaths = ref([]);

            const getAllPicPath = () => {
                axios.get("/pic/list").then(resp => {
                    const data = resp.data;
                    if (data.success) {
                        picPaths.value=data.content;
                        console.log("获取的图片路径为:"+picPaths.value);
                    } else {
                        ElMessage.error("图片路径获取失败！");
                    }
                })
            }

            onMounted(()=>{
                getAllPicPath();
            })

            return {
                uploadHttpRequest,
                fileList,
                picPaths
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