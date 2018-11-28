import Vue from "vue";
import VueIndex from "../component/vue/index.vue";

new Vue({
    el : "#vueContainer",
    name : "index-root",
    components : { VueIndex },
    data : {
        str : "test"
    },
    mounted() {
        console.log("index.js");
    }
});