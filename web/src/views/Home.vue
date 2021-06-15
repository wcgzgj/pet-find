<template>

  <a-layout-content style="padding: 0 50px">
    <a-breadcrumb style="margin: 16px 0">
    </a-breadcrumb>
    <div :style="{ background: '#fff', padding: '24px', minHeight: '280px' }" class="card-display">



    <!--上传，还是找寻-->
      <router-link to="/find">
        <a-card hoverable style="width: 200px;margin-bottom: 20px" >
          <template #cover>
            <img alt="example" src="../assets/master_pet.jpg" />
          </template>
          <a-card-meta title="宠物找寻">
            <template #description>请宠物主人上传自己宝贝的照片</template>
          </a-card-meta>
        </a-card>
      </router-link>

      <router-link to="/upload">
        <a-card hoverable style="width: 200px">
          <template #cover>
            <img alt="example" src="../assets/lost_pet.jpg" />
          </template>
          <a-card-meta title="宠物上传">
            <template #description>看到走丢的毛孩子？尽一份力吧</template>
          </a-card-meta>
        </a-card>

      </router-link>
    </div>

  </a-layout-content>


</template>

<script lang="ts">
import { defineComponent ,ref} from 'vue';

export default defineComponent({
  name: 'Home',
  components: {
    setup() {
      return {
        selectedKeys: ref(['2']),
      };
    },
  },
});
</script>

<!--只让样式，在当前页面生效-->
<style scoped>
  .site-layout-content {
    min-height: 280px;
    padding: 24px;
    background: #fff;
  }
  #components-layout-demo-top .logo {
    float: left;
    width: 120px;
    height: 31px;
    margin: 16px 24px 16px 0;
    background: rgba(255, 255, 255, 0.3);
  }
  .ant-row-rtl #components-layout-demo-top .logo {
    float: right;
    margin: 16px 0 16px 24px;
  }

  [data-theme='dark'] .site-layout-content {
    background: #141414;
  }


  /*flex 布局*/
  .card-display {
    margin: 20px auto;
    display: flex !important;
    flex-direction: column !important;
    align-items: center !important;
  }
</style>
