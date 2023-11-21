import { createApp } from "vue";
import { createPinia } from "pinia";

import App from "./App.vue";
import router from "./router";
import piniaPluginPersistedstate from "pinia-plugin-persistedstate"
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import MagicGrid from 'vue-magic-grid'



const app = createApp(App);
const pinia = createPinia();
pinia.use(piniaPluginPersistedstate)

app.use(createPinia());
app.use(router);
app.use(pinia)
app.use(MagicGrid)

app.mount("#app");
