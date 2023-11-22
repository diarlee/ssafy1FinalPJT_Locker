<template>
    <div class="userInfo-container">
        <div class="userGrade">
            <div>
                <img v-if="0 <= store.score <= 30" src="@/assets/img/bronzeKey.png" alt="">
                <img v-else-if="store.score <= 100" src="@/assets/img/silverKey.png" alt="">
                <img v-else-if="store.score <= 500" src="@/assets/img/goldKey.png" alt="">
                <img v-else-if="store.score <= 1000" src="@/assets/img/plaKey.png" alt="">
                <img v-else src="@/assets/img/diaKey.png">
            </div>
            <div>
                <!-- <p> {{ store.loginId }} 님</p> -->
                <RouterLink class="router" v-show="store.loginId == 'master'" :to="{ name: 'master' }">게시글 관리</RouterLink>
                <RouterLink class="router" v-if="store.loginStatus == true && store.loginId != 'master'" type="button" :to="{name: 'articleCreate'}">Check In</RouterLink>
            </div>
        </div>
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
    border: solid 1.35px #52796F;
    border-radius: 2rem;
    display: flex;
    flex-direction: column;
}

.userGrade {
    padding: 5px;
    flex-grow: 9;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

img {
    width: 100px;
    height: 100px;
}

/* p {
    margin: 10px 0 0 0;
} */

.router {
    margin: 30px 0 0 0;
    text-align: right;
    text-decoration: none;
    color: #52796F;
}

a:hover {
    color: rgb(186, 41, 41);
}

</style>