import React, {Component} from 'react';
import './style.css'
import Api from "../../api/api";
import {Toast, DatePicker} from "antd-mobile";

export default class Index extends Component {


    constructor(props) {
        super(props)

        this.state = {
            result: [],


        }
    }


    async handleSearchClick() {
        let value = document.getElementById("search-key-word").value


        if (value.length < 1) {
            Toast.fail("请输入关键字...", 1)
            return
        }
        let param = {
            "keyWord": value

        }
        let result = await Api.getMovieByKeyWord(param)

        this.setState({
            result: result.data
        })
    }

    async  onDateSelected(date){
        let selectedDate =this.getCurrentDate(date)


        let param = {
            "date": selectedDate

        }
        let result = await Api.getMovieByDate(param)

        this.setState({
            result: result.data
        })

    }



    /**
     * 获取当前年月日
     * @returns {number}
     */
      getCurrentDate(date) {
        // 获取当前月份
        var nowMonth = date.getMonth() + 1;

        // 获取当前是几号
        var strDate = date.getDate();

        // 添加分隔符“-”
        var seperator = "-";

        // 对月份进行处理，1-9月在前面添加一个“0”
        if (nowMonth >= 1 && nowMonth <= 9) {
            nowMonth = "0" + nowMonth;
        }

        // 对月份进行处理，1-9号在前面添加一个“0”
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }

        // 最后拼接字符串，得到一个格式为(yyyy-MM-dd)的日期
        var nowDate = date.getFullYear() + seperator + nowMonth + seperator + strDate;

        return nowDate;
    }

    render() {

        let {result} = this.state
        return (
            <div id='search-root'>
                <input id='search-key-word' placeholder='请输入关键字' type='text'/>
                <span id='btn-search' onClick={() => this.handleSearchClick()}>搜索</span>

                <DatePicker
                    mode="date"
                    title="选择日期"
                    extra="Optional"
                    onOk={date =>this.onDateSelected(date)}
                    // value={this.state.date}
                    // onChange={date => this.setState({date})}
                >
                    <span>选择时间</span>
                </DatePicker>


                {
                    (result || []).map((item, index) => {
                        return <div id='search-reslut-movie-item'>
                            <img id='search-movie-img' src={item.movieImgUrl}></img>

                            <div id='search-movie-info' onClick={()=>{
                                this.props.history.push('/detail?id='+item.id)
                            }}>
                                <span id='search-movie-title'>{item.movieName}</span>
                                <span id='search-movie-desc'>{item.movieDesc}</span>
                                <span id='search-movie-actor'>主演：{item.actor}</span>
                                <span id='search-movie-time'>上映时间：{item.startTime}</span>
                                <span id='search-movie-price'>票价：{item.ticketMoney}</span>
                            </div>
                        </div>
                    })

                }
            </div>
        )
    }
}