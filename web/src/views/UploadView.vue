<template>
    <el-container class="home-container">
        <el-main class="upload-main">



            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                <el-form-item>
                    <div class="upload-main-font">
                        请上传照片
                    </div>

                    <el-upload
                            class="upload-demo"
                            drag
                            action="/upload"
                            :before-upload="beforeupload"
                            :http-request="uploadHttpRequest"
                            limit="1"
                            :file-list="fileList"
                            auto-upload="false"
                            multiple>
                        <i class="el-icon-upload"></i>
                        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                        <template #tip>
                            <div class="el-upload__tip">
                                只能上传 jpg/png 文件，且不超过 500kb
                            </div>
                        </template>
                    </el-upload>
                </el-form-item>
                <el-form-item label="联系电话" prop="phone">
                    <el-input v-model="ruleForm.phone"></el-input>
                </el-form-item>
                <el-form-item label="发现地址" prop="address">
                    <el-input v-model="ruleForm.address"></el-input>
                </el-form-item>

                <el-form-item>
                    <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                    <el-button @click="resetForm('ruleForm')">重置</el-button>
                </el-form-item>
            </el-form>


        </el-main>

    </el-container>
</template>

<script>
    export default {
        name: "UploadView",

        data() {
            return {
                ruleForm: {
                    phone: '',
                    address: ''
                },
                rules: {
                    phone: [
                        { required: true, message: '请输入联系电话', trigger: 'blur' },
                        { min: 11, max: 11, message: '电话号码应为11位', trigger: 'blur' }
                    ],
                    address: [
                        { required: true, message: '请输入发现地址', trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        alert('submit!');
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
}
</script>

<style scoped>
    .home-container {
        background-color: #87cefa;
    }

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

</style>