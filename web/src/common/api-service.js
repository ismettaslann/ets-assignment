import axios from 'axios'
import {BASE_URL} from './config.js'

export function post (path = '', params){
    try {
        console.log("params = " + params);
        return axios.post(BASE_URL + path, params);
    } catch (err) {
        console.log(err);
        throw new Error('Http post error on api-service.js');
    }
}

export async function get(path = '') {
    return axios.get(BASE_URL + path).catch(err => {
        console.log(err);
        throw new Error('Http Get Error : api.service');
    })
}