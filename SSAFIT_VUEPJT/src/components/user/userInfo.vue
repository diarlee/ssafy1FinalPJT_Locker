<template>
    <div class="userInfo-container">
        <div class="userGrade">
            <img v-if="0 <= store.score <= 30" src="@/assets/img/bronzeKey.png" alt="">
            <img v-else-if="store.score <= 100" src="@/assets/img/silverKey.png" alt="">
            <img v-else-if="store.score <= 500" src="@/assets/img/goldKey.png" alt="">
            <img v-else-if="store.score <= 1000" src="@/assets/img/plaKey.png" alt="">
            <img v-else src="@/assets/img/diaKey.png">
        </div>
        <div></div>
        <RouterLink class="router" v-show="store.loginId == 'master'" :to="{ name: 'master' }">게시글 관리</RouterLink>
        <RouterLink class="router" v-if="store.loginStatus == true && store.loginId != 'master'" type="button" :to="{name: 'articleCreate'}">인증하기</RouterLink>
    </div>
</template>

<script setup>
import { RouterView, RouterLink } from "vue-router";
import { useUsersStore } from "@/stores/users";

const store = useUsersStore();

</script>

<style scoped>
.userInfo-container {
    width: inherit;
    border: solid 1px;
    border-radius: 2rem;
    display: flex;
    flex-direction: column;
}

.userGrade {
    flex-grow: 9;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

.router {
    text-align: right;
}

</style>