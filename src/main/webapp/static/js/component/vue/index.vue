<template>
    <div>
        <h1>vue component test - h1</h1>
        <h2 class="red_color">vue component test - h2</h2>
        <h3>vue component test - h3</h3>
    </div>
</template>

<script>
    export default {
        name: "vue-index",
        mounted() {
            console.log("vue compoent index is mounted.")
        },
    }
</script>

<style scoped>
    .red_color { color: red}
</style>