<template>
    <!--宠物主人找寻页面-->
    <a-layout-content style="padding: 0 50px">
        <a-breadcrumb style="margin: 16px 0">
        </a-breadcrumb>
        <div :style="{ background: '#fff', padding: '24px', minHeight: '280px' }" class="card-display">



            <!--志愿者信息表单-->
            <a-form
                    name="custom-validation"
                    ref="formRef"
                    :model="formState"
                    :rules="rules"
                    v-bind="layout"
                    @finish="handleFinish"
                    @finishFailed="handleFinishFailed"
            >

                <!--上传控件-->
                <a-upload-dragger
                        v-model:fileList="fileList"
                        name="file"
                        :multiple="true"
                        action="https://www.mocky.io/v2/5cc8019d300000980a055e76"
                        @change="handleChange"
                        style="margin-bottom: 40px"
                >
                    <p class="ant-upload-drag-icon">
                        <inbox-outlined></inbox-outlined>
                    </p>
                    <p class="ant-upload-text">点击上传照片</p>
                    <p class="ant-upload-hint">
                        您的宝贝什么样，给我们点线索吧
                    </p>
                </a-upload-dragger>


                <a-form-item :wrapper-col="{ span: 14, offset: 4 }">
                    <a-button type="primary" html-type="submit">提交</a-button>
                    <a-button style="margin-left: 10px" @click="resetForm">重置</a-button>
                </a-form-item>
            </a-form>



            <a-list item-layout="vertical" size="large" :data-source="listData">

                <template #renderItem="{ item }">
                    <a-list-item key="item.title">
                        <template #extra>
                            <img
                                    width="200"
                                    alt="logo"
                                    src="https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png"
                            />
                        </template>
                        <a-list-item-meta :description="item.description">
                            <template #title>
                                <a :href="item.href">{{ item.title }}</a>
                            </template>
                            <template #avatar><a-avatar :src="item.avatar" /></template>
                        </a-list-item-meta>
                        {{ item.content }}
                    </a-list-item>
                </template>
            </a-list>


        </div>
    </a-layout-content>

</template>

<script>

    import { StarOutlined, LikeOutlined, MessageOutlined } from '@ant-design/icons-vue';
    import { defineComponent } from 'vue';
    const listData = [];

    for (let i = 0; i < 23; i++) {
        listData.push({
            href: 'https://www.antdv.com/',
            title: `ant design vue part ${i}`,
            avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
            description:
                'Ant Design, a design language for background applications, is refined by Ant UED Team.',
            content:
                'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
        });
    }

    export default {
        components: {
            StarOutlined,
            LikeOutlined,
            MessageOutlined,
        },
        name: "Find",

        setup() {
            const pagination = {
                onChange: page => {
                    console.log(page);
                },
                pageSize: 3,
            };
            const actions = [
                {
                    type: 'StarOutlined',
                    text: '156',
                },
                {
                    type: 'LikeOutlined',
                    text: '156',
                },
                {
                    type: 'MessageOutlined',
                    text: '2',
                },
            ];
            return {
                listData,
                pagination,
                actions,
            };
        },
    }
</script>

<style scoped>

</style>