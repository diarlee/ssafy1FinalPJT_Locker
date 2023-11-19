<template>
    <div class="userInfo-container">
        <div class="userGrade"></div>
        <RouterLink v-show="userStore.loginId == 'master'" :to="{ name: 'master' }">게시글 관리</RouterLink>
    </div>
</template>

<script setup>
import { RouterView, RouterLink } from "vue-router";
import { useUsersStore } from "@/stores/users";

const userStore = useUsersStore();

</script>

<style scoped>
.userInfo-container {
    border: solid 1px;
}
</style>