import React, {Component} from 'react';
import './style.css'
import Api from "../../api/api";
import {Toast} from 'antd-mobile'

export default class Index extends Component {


    constructor(props) {
        super(props)
        this.state = {
            result: null
        }
    }

    async componentDidMount() {

        let id = window.util.getSearchByName("id")

        let param = {
            "id": id

        }

        let result = await Api.getMovieById(param)

        this.setState({
            result: result.data
        })
    }

    render() {

        let {result} = this.state

        return (
            <div className='movie-detail-root'>{
                result != null ?
                    <div>
                        <div id='reslut-movie-item'>

                            <span id='movie-title'>{result.movieName}</span>
                            <span id='movie-desc'>{result.movieDesc}</span>
                            <span id='movie-actor'>主演：{result.actor}</span>
                            <span id='movie-time'>上映时间：{result.startTime}</span>
                            <span id='movie-price'>票价：{result.ticketMoney}</span>
                            <img id='movie-img' src={result.movieImgUrl}></img>
                        </div>
                    </div>
                    : <div></div>
            }
            </div>
        )
    }
}