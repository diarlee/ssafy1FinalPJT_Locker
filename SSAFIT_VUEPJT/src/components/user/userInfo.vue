<template>
    <div class="userInfo-container">
        <div class="userGrade">
            <div v-if="0 <= store.score <= 30">1</div>
            <div v-else-if="store.score <= 100">2</div>
            <div v-else-if="store.score <= 200">3</div>
            <div v-else-if="store.score <= 365 ">4</div>
            <div v-else>5</div>
        </div>
        <RouterLink v-show="store.loginId == 'master'" :to="{ name: 'master' }">게시글 관리</RouterLink>
        <RouterLink v-if="store.loginStatus == true && store.loginId != 'master'" type="button" :to="{name: 'articleCreate'}">인증하기</RouterLink>
    </div>
</template>

<script setup>
import { RouterView, RouterLink } from "vue-router";
import { useUsersStore } from "@/stores/users";

const store = useUsersStore();

</script>

<style scoped>
.userInfo-container {
    border: solid 1px;
}
</style>