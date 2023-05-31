<template>
    <div style="width: 100vw; height: 100vh; overflow: hidden;display: flex">
        <div class="el-carousel el-carousel--horizontal" style="flex:1;">
            <el-image style="width: 100%; height: 100%" fit="cover"
                      src="https://cas.paas.jmu.edu.cn/cas/file/png/bg.png"/>
        </div>
        <div style="width: 450px; background-color: white">

<!--            <router-view v-slot="{Component}">-->
                <transition name="el-fade-in-linear">
                    <router-view/>
<!--                    <component :is="Component" />-->
                </transition>
<!--            </router-view>-->


        </div>
    </div>
</template>

<script setup>
</script>

<style scoped>

</style>