import {get, post} from '../utils/axios/request'
import axios from "../utils/axios/AxiosInterceptors";

var baseUrl = "http://192.168.51.109:8080";



class Api {


    getAllInfoList() {
        return get(baseUrl + '/getAllInfoList');
    }

    //账号登录
    login(param) {
        return post(baseUrl + '/login',param);
    }

    insertMovieInfo(param) {
        return post(baseUrl + '/insertMovieInfo',param);
    }


    getThisWeekMoney() {
        return get(baseUrl + '/getThisWeekMoney');
    }

    getMovieByKeyWord(param) {
        return get(baseUrl + '/getMovieByKeyWord',param);
    }

    getMovieByDate(param) {
        return get(baseUrl + '/getMovieByDate',param);
    }


    getMovieById(param) {
        return get(baseUrl + '/getMovieById',param);
    }

    deleteMovieById(param) {
        return get(baseUrl + '/deleteMovieById',param);
    }



}

export default new Api()
