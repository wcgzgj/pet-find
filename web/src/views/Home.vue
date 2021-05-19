<template>
  <el-container class="home-container">


    <el-row style="width: 100%">
      <el-col :span="12" class="btn-col">
        <router-link to="/find">
          <el-button type="primary" class="cus-btn">找寻</el-button>
        </router-link>
      </el-col>
      <el-col :span="12" class="btn-col">
        <router-link to="/upload">
          <el-button type="primary" class="cus-btn">上传</el-button>
        </router-link>
      </el-col>
    </el-row>

  </el-container>

</template>

<script>

import { defineComponent,onMounted,ref } from 'vue';
import axios from 'axios'

export default defineComponent({
  name: 'Home',
  components: {},

    setup() {




      onMounted(()=>{
      })

      return {

      }
    }


});
</script>

<style scoped>
  .home-container {
    background-color: #87cefa;
    display: flex;
    flex-direction: row;
    align-items: center;
  }

  .btn-col {
    width: 50%;
    text-align: center;
    margin: 0 auto;
  }

  .cus-btn {
    width: 300px;
    height: 400px;
    font-size: 60px;
    font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
  }

</style>
