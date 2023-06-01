<template>
    <div class="el-carousel el-carousel--horizontal" style="flex:1;">
      <transition name="el-fade-in-linear">
        <router-view/>
      </transition>
    </div>
<!--    <div style="width: 450px; background-color: white">-->
<!--      <transition name="el-fade-in-linear">-->
<!--        <router-view/>-->
<!--      </transition>-->
<!--    </div>-->
</template>

<script setup>
</script>

<style scoped>

</style>