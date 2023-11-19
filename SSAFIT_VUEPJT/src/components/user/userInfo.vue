<template>
    <div class="userInfo-container">
        <div class="userGrade"></div>
        <div v-if="userStore.loginId == master"><RouterLink :to="{name: 'master'}"></RouterLink></div>
    </div>
</template>

<script setup>
import { useUsersStore } from "@/stores/users";
import { RouterView, RouterLink } from "vue-router";
const userStore = useUsersStore();

</script>

<style scoped>
.userInfo-container{
    border: solid 1px;
}

</style>