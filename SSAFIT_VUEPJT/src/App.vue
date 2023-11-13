<template>
    <Header></Header>
  <!-- <RouterLink :to="{ name: 'videoDetail' }">videoDetail</RouterLink>
  <RouterLink :to="{ name: 'reviewCreate' }">CreateReview</RouterLink> -->
  <!-- <RouterLink :to="{ name: 'reviewDetail' }">DetailReview</RouterLink> -->
  <!-- <RouterLink :to="{ name: 'reviewUpdate' }">UpdateReview</RouterLink> -->
  <RouterView></RouterView>
</template>

<script setup>
import { RouterLink, RouterView } from "vue-router";
import Header from "@/components/common/header.vue";
</script>

<style scoped></style>
