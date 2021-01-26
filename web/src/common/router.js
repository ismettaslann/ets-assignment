import Vue from "vue";
import VueRouter from "vue-router";

import Home from "../components/Home";
import SignUpForm from "../components/SignUpForm";
import AllRecords from "../components/AllRecords";

Vue.use(VueRouter);

const routes = [
	{ path: "/", component: Home },
	{ path: "/signup", component: SignUpForm },
	{ path: "/all-records", component: AllRecords }
];

export const router = new VueRouter({
	mode: "history",
	routes
});