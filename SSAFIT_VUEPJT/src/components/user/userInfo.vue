<template>
    <div class="userInfo-container">
        <div class="userGrade"></div>
        <div v-if="userStore.loginId == master"></div>
    </div>
</template>

<script setup>
import { useUsersStore } from "@/stores/users";
const userStore = useUsersStore();

</script>

<style scoped>
.userInfo-container{
    border: solid 1px;
}

</style>