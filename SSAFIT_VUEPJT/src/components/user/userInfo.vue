<template>
    <div class="userInfo-container">
        <div class="card mb-3">
            <div class="row g-0">
                <div class="col-md-4" v-show="store.loginStatus">
                    <img class="img-fluid rounded-start" v-if="0 <= store.score && store.score <= 30" src="@/assets/img/bronzeKey.png" alt="">
                    <img class="img-fluid rounded-start" v-else-if="store.score <= 100" src="@/assets/img/silverKey.png" alt="">
                    <img class="img-fluid rounded-start" v-else-if="store.score <= 500" src="@/assets/img/goldKey.png" alt="">
                    <img class="img-fluid rounded-start" v-else-if="store.score <= 1000" src="@/assets/img/plaKey.png" alt="">
                    <img class="img-fluid rounded-start" v-else src="@/assets/img/diaKey.png">
                </div>
                <div class="col-md-8" >
                    <div class="card-body" style="text-align: center;">
                        <div></div>
                        <h5 class="card-title" v-show="store.loginStatus"> {{ store.username }} 님</h5>
                        <p class="card-text" v-show="store.loginStatus"> 내 점수: {{ store.score }} 점</p>
                        <!-- <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p> -->
                        <RouterLink class="router" v-show="store.loginId == 'master'" :to="{ name: 'master' }">게시글 관리</RouterLink>
                        <RouterLink class="router" v-if="store.loginStatus == true && store.loginId != 'master'" type="button" :to="{name: 'articleCreate'}">UPLOAD</RouterLink>
                    </div>
                </div>
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
    /* border: solid 1.35px #52796F; */
    /* border-radius: 2px; */
}

.row {
    display: flex;
    flex-direction: row;
}

.col-md-4 {
    width: 45%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-content: center;
    padding: 7px;
}

.col-md-8 {
    width: 55%;
}
.card-body {
    padding: 16px 0 16px 0;
}

.router {
    margin: 0 0 0 0;
    text-align: right;
    text-decoration: none;
    color: #52796F;
}

a:hover {
    color: rgb(186, 41, 41);
}

</style>