import React, {Component} from 'react';
import './style.css'
import Api from "../../api/api";
import {DatePicker, Toast, Picker, List} from 'antd-mobile'
import {transformTime} from "../../utils/util";

let rows = [
    {
        label: 1,
        value: 1,
    },
    {
        label: 2,
        value: 2,
    }, {
        label: 3,
        value: 3,
    }, {
        label: 4,
        value: 4,
    }, {
        label: 5,
        value: 5,
    }, {
        label: 6,
        value: 6,
    }, {
        label: 7,
        value: 7,
    }

];

let colunm = [
    {
        label: 1,
        value: 1,
    },
    {
        label: 2,
        value: 2,
    }, {
        label: 3,
        value: 3,
    }, {
        label: 4,
        value: 4,
    }, {
        label: 5,
        value: 5,
    }, {
        label: 6,
        value: 6,
    }, {
        label: 7,
        value: 7,
    }, {
        label: 8,
        value: 8,
    }, {
        label: 9,
        value: 9,
    }, {
        label: 10,
        value: 10,
    }

];

export default class Index extends Component {


    constructor(props) {
        super(props)

        this.state = {
            date: "",
            columnValue:5,
            rowValue:5
        }
    }

    async handleClick() {
        let movieName = document.getElementById('movie-name').value
        let author = document.getElementById('movie-author').value
        let awards = document.getElementById('movie-awards').value
        let actor = document.getElementById('movie-actor').value
        let movieDesc = document.getElementById('movie-desc').value
        let movieImgUrl = document.getElementById('movie-img-url').value
        let movieLocation = document.getElementById('movie-location').value
        let startTime = this.state.date
        let ticketCount = document.getElementById('movie-ticket-count').value
        let ticketMoney = document.getElementById('movie-ticket-money').value
        let rowAndColumValue = this.state.rowValue+","+this.state.columnValue

        let params = {
            movieName,
            author,
            awards,
            actor,
            movieDesc,
            movieImgUrl,
            movieLocation,
            startTime,
            ticketCount,
            ticketMoney,
            rowAndColumValue
        }


        console.log(params)
        let result = await Api.insertMovieInfo(params)
        Toast.success('添加成功！')
    }


    async onDateSelected(date) {

        var time1 = transformTime(date);
        // console.log(time1);
        this.setState({
            date: time1
        })

    }


    render() {

        let {date,columnValue,rowValue} = this.state
        return (
            <div className='add-movie-root'>
                <input className='movie-item-input' id='movie-name' placeholder='请输入电影名'/>
                <input className='movie-item-input' id='movie-author' placeholder='请输入导演名'/>
                <input className='movie-item-input' id='movie-awards' placeholder='请输入电影奖项'/>
                <input className='movie-item-input' id='movie-actor' placeholder='请输入电影主演'/>
                <input className='movie-item-input' id='movie-desc' placeholder='请输入电影简介'/>
                <input className='movie-item-input' id='movie-img-url' placeholder='请输入海报宣传图（图片url）'/>
                <input className='movie-item-input' id='movie-location' placeholder='请输入电影院名称'/>

                <DatePicker
                    mode="date"
                    title="选择日期"
                    extra="Optional"
                    onOk={date => this.onDateSelected(date)}
                    // value={this.state.date}
                    // onChange={date => this.setState({date})}
                >
                    <div className='movie-item-input'>
                        <span>上映日期</span>
                        <span>{date}</span>
                    </div>

                </DatePicker>
                <input className='movie-item-input' id='movie-ticket-count' placeholder='请输入票数'/>
                <input className='movie-item-input' id='movie-ticket-money' placeholder='请输入票价'/>
                <Picker
                    data={colunm}
                    title="设置排数"
                    cols={1}
                    extra={columnValue}
                    // value={this.state.sValue}
                    // onChange={v => this.setState({sValue: v})}
                    onOk={v => this.setState({columnValue: v})}
                >
                    <List.Item arrow="horizontal">设置排数</List.Item>
                </Picker>
                <Picker
                    data={rows}
                    title="每排人数"
                    cols={1}
                    extra={rowValue}
                    // value={this.state.sValue}
                    // onChange={v => this.setState({sValue: v})}
                    onOk={v => this.setState({rowValue: v})}
                >
                    <List.Item arrow="horizontal">每排人数</List.Item>
                </Picker>
                <span className='btn-add' onClick={() => this.handleClick()}>添  加</span>
            </div>
        )
    }
}