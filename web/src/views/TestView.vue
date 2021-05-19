<template>
    <el-container>
        <el-button
                @click.native="haha"
        >

        </el-button>
    </el-container>
</template>

<script>
    export default {
        name: "TestView",

        setup() {

            const haha = () => {
                alert("hahaha ")
            }

            return {
                haha
            }

        }
    }
</script>

<style scoped>

</style>