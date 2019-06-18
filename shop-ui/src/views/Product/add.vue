<template> 
  <product-detail :is-edit='false'></product-detail>
</template>
<script>
  import ProductDetail from '../pms/product/components/ProductDetail'
  export default {
    name: 'addProduct',
    components: { ProductDetail }
  }
</script>
<style>
</style>
