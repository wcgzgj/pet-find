<template>
    <!--宠物主人找寻页面-->
    <a-layout-content style="padding: 0 50px">
        <a-breadcrumb style="margin: 16px 0">
        </a-breadcrumb>
        <div :style="{ background: '#fff', padding: '24px', minHeight: '280px' }" class="card-display">


            <input type="file" v-on:change="uploadImage" id="file-upload-input">

            <!--<a-image-->
            <!--        style="margin-top: 20px"-->
            <!--        :width="200"-->
            <!--        :src="formState.newPicPath"-->
            <!--/>-->


            <a-list item-layout="vertical" size="large" :data-source="list">

                <template #renderItem="{ item }">
                    <a-list-item key="item.title">
                        <template #extra>
                            <img
                                    width="200"
                                    alt="pet"
                                    :src="'http://127.0.0.1:9000/disPic/'+item.href"
                            />
                        </template>
                        <a-list-item-meta :description="item.description">
                            <template #title>
                                <a :href="item.href">{{ item.title }}</a>
                            </template>
                        </a-list-item-meta>
                        {{ item.finder }}
                        <br/>
                        {{ item.finderInfo }}
                    </a-list-item>
                </template>
            </a-list>


        </div>
    </a-layout-content>

</template>

<script>

    import { defineComponent,ref } from 'vue';
    import axios from "axios";
    import {message} from "ant-design-vue";


    export default {
        name: "Find",

        setup() {


            /**
             * 图片上传信息
             */
            const list = ref([]);

            const picList = [
                {
                    title: `宠物信息`,
                    description: '宠物发现于:'+'南京市栖霞区',
                    content: '宠物的发现者是：faroz'+"\n"+"发现者信息为:"+"zhan@qq.com",
                }
            ];

            const uploadImage = () => {
                let formData = new FormData();
                console.log("当前文件的个数为："+document.querySelector("#file-upload-input").files.length);
                let file = document.querySelector("#file-upload-input").files[0];
                formData.append("file",file)
                console.log("等待上传的文件信息为:"+formData.get("file"));
                axios.post("/pic/uploadFindPic",formData).then(resp=>{
                    const data = resp.data;
                    if (data.success) {
                        message.success("图片上传成功")
                        const dbList = data.content;
                        if (dbList==null || dbList.length==0) {
                            message.error("错误，未查到宠物信息");
                        }
                        for (let i = 0; i < dbList.length; i++) {
                            let address= dbList[i].address==null?'':dbList[i].address;
                            let realname = dbList[i].user.realname==null?'':dbList[i].user.realname;
                            let email = dbList[i].user.email ==null?'':dbList[i].user.email;
                            let href = dbList[i].path ==null?'':dbList[i].path;
                            console.log("发现者信息为:"+realname+"   "+email);
                            list.value.push({
                                title: `宠物信息`,
                                description: '宠物发现于:'+address,
                                finder: '宠物的发现者是:  '+realname,
                                finderInfo: "发现者邮箱为:  "+email,
                                href: href
                            });

                        }
                        for (let i = 0; i < dbList.length; i++) {
                            console.log("picList中的信息为："+picList[i].address)
                        }
                        // console.log("回显的图片路径为："+formState.value.newPicPath);
                    } else {
                        message.error(data.message);
                    }
                })
            }


            return {
                picList,
                list,
                uploadImage
            };
        },
    }
</script>

<style scoped>

</style>