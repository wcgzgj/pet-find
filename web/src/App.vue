<template>
  <a-layout class="layout">

    <Header/>
    <router-view/>
    <Footer/>

  </a-layout>
</template>


<script lang="ts">
  import { defineComponent} from 'vue';
  import Header from '/src/components/Header.vue'
  import Footer from '/src/components/Footer.vue'

  export default defineComponent({
    name: 'Home',
    components: {
      Header,
      Footer
    },
  });
</script>

<style lang="scss">
/*#app {*/
/*  font-family: Avenir, Helvetica, Arial, sans-serif;*/
/*  -webkit-font-smoothing: antialiased;*/
/*  -moz-osx-font-smoothing: grayscale;*/
/*  text-align: center;*/
/*  color: #2c3e50;*/
/*}*/

/*#nav {*/
/*  padding: 30px;*/

/*  a {*/
/*    font-weight: bold;*/
/*    color: #2c3e50;*/

/*    &.router-link-exact-active {*/
/*      color: #42b983;*/
/*    }*/
/*  }*/
/*}*/
</style>
