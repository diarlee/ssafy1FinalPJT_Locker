<template>
    <Header></Header>
  <RouterView></RouterView>
  <Footer></Footer>
</template>

<script setup>
import { RouterLink, RouterView } from "vue-router";
import Header from "@/components/common/header.vue";
import Footer from "@/components/common/footer.vue";
</script>

<style scoped></style>
