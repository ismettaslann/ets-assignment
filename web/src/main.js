import '@babel/polyfill'
import 'mutationobserver-shim'
import Vue from 'vue'
import './plugins/bootstrap-vue'
import App from './App.vue'
import { BootstrapVue, IconsPlugin, BLink } from 'bootstrap-vue'
import { ModalPlugin } from 'bootstrap-vue'
import { router } from "./common/router";

Vue.config.productionTip = false
Vue.use(ModalPlugin)
Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.component('b-link', BLink)

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
