<template>
    <Header></Header>
  <RouterView></RouterView>
</template>

<script setup>
import { RouterLink, RouterView } from "vue-router";
import Header from "@/components/common/header.vue";
</script>

<style scoped></style>
