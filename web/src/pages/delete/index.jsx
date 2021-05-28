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

    componentDidMount() {
        this.initData();
    }


    async initData() {
        let result = await Api.getAllInfoList()

        this.setState({
            result: result.data
        })
    }

    async handleDeleteClick(id) {


        let param = {
            "id": id

        }
        let result = await Api.deleteMovieById(param)

        if (result.data == "1") {
            Toast.success("删除成功")
            this.initData();
        }
    }


    render() {

        let {result} = this.state
        return (
            <div id='delete-root'>

                {
                    (result || []).map((item, index) => {
                        return <div id='search-reslut-movie-item'>
                            <img id='search-movie-img' src={item.movieImgUrl}></img>

                            <div id='search-movie-info'>
                                <div id='search-movie-title'>
                                    <span>{item.movieName}</span>
                                    <span className='delete-movie'
                                          onClick={() => this.handleDeleteClick(item.id)}>下架</span>
                                </div>

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