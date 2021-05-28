/**
 * 解析window.location.serch
 * @name 地址栏参数
 */
const getSearchByName = function (name) {
    var reg = new RegExp("[?|&]" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.href.match(reg);
    if (r != null) return (r[1].split('#')[0]);
    return null;
}

function setStorage(key, value) {
    localStorage.setItem(key, value)
}

function getStorage(key) {
    return localStorage.getItem(key)
}

function removeStorage(key) {
    return localStorage.removeItem(key)
}

const utils = {
    getSearchByName,
    setStorage,
    getStorage,
    removeStorage
}

// export default util
//配全局没配成，暂时导出吧
// window.getSeachByName = getSearchByName
window.util = utils


/*
* 说明：
* 一周的起始计算方式不同国家有所不同，很多其他国家将周日作为一周的开始
* 本代码使用中国习惯，将周一作为每周的开始
* 特此说明
*/
export function todayInfo() {

    var WEEKLEN = 7, // 一周7天为常量
        start = "2021/3/1", //开学第一天
        WEEKDAYS = ["日", "一", "二", "三", "四", "五", "六"],
        weekInfo = {"week": null, "day": null}, // 初始化返回信息，默认第null周，星期null
        oneDay = 24 * 60 * 60 * 1000, // 一天的毫秒时长
        weekLeave, // 开学当天所在周剩余天数
        weekStart, // 开学当天start是星期几
        today, // 今天
        dateDiff, // 今天与开学当天日期差
        sDate; //开学之日，日期对象
    var rDateStr = /\d{4}[\/-]\d{1,2}[\/-]\d{1,2}/g; // 简单的日期格式校验：2013/12/19
    if (!rDateStr.test(start)) {
        // alert("请使用合法的开学日期！！！");
        return weekInfo;
    }
    sDate = new Date(start.replace("-", "/"));
    weekStart = sDate.getDay();
    weekStart = weekStart === 0 ? 7 : weekStart; // JS中周日的索引为0，这里转换为7，方便计算

    weekLeave = WEEKLEN - weekStart;
    today = new Date();
    weekInfo.day = WEEKDAYS[today.getDay()];
    today = new Date(today.getFullYear() + "/" + (today.getMonth() + 1) + "/" + today.getDate());
    dateDiff = today - sDate;
    if (dateDiff < 0) {
        // alert("还没开学呢！！！");
        return weekInfo;
    }
    dateDiff = parseInt(dateDiff / oneDay);
    weekInfo.week = Math.ceil((dateDiff - weekLeave) / WEEKLEN) + 1;
    return weekInfo;
}

/**
 * 获取当前月份
 * @returns {number}
 */
export function getMonth() {
    return new Date().getMonth() + 1;
}


/**
 * 获取当前日期
 * @returns {string}
 */
export function getCurrentDate() {
    // 获取当前日期
    var date = new Date();

    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    var h = date.getHours();
    var minute = date.getMinutes();
    minute = minute < 10 ? ('0' + minute) : minute;
    var second = date.getSeconds();
    second = minute < 10 ? ('0' + second) : second;
    return y + '-' + m + '-' + d + ' ' + h + ':' + minute + ':' + second;
}

/**
 * 计算两个日期之间的时间差
 * @param dataStr
 * @returns {number}
 */
export function getTwoDayInterval(dataStr) {
    var dateStart = Date.parse(getCurrentDate());
    var dateEnd = Date.parse(dataStr.split(" ")[0]);
    var difValue = (dateEnd - dateStart) / (1000 * 60 * 60 * 24)

    return difValue;
}


export function transformTime(timestamp = new Date()) {
    if (timestamp) {
        var time = new Date(timestamp);
        var y = time.getFullYear();
        var M = time.getMonth() + 1;
        var d = time.getDate();
        var h = time.getHours();
        var m = time.getMinutes();
        var s = time.getSeconds();
        return y + '-' + addZero(M) + '-' + addZero(d) + ' ' + addZero(h) + ':' + addZero(m) + ':' + addZero(s);
    } else {
        return '';
    }
}

function addZero(m) {
    return m < 10 ? '0' + m : m;
}