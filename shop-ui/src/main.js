import Vue from 'vue'
import App from './App'
import router from './router'
import api from './http'
import i18n from './i18n'
import store from './store'
Vue.prototype.$store = store;
import axios from 'axios'
Vue.prototype.$axios = axios;
import global from '@/utils/global'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'font-awesome/css/font-awesome.min.css'
import '@/assets/iconfont/iconfont.css'
import locale from 'element-ui/lib/locale/lang/zh-CN' // lang i18n
import VCharts from 'v-charts'

// import '@/styles/index.scss' // global css

Vue.use(ElementUI)
Vue.use(api)

Vue.prototype.global = global

new Vue({
  el: '#app',
  i18n,
  router,
  store,
  render: h => h(App)
});
