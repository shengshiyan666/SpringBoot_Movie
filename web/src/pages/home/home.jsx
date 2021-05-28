import React, {Component} from 'react';
import './style.css'
import Api from "../../api/api";

export default class Home extends Component {


    constructor(props) {
        super(props)

    }


    render() {

        return (
            <div id='home-root'>

                <span className='home-btn' onClick={() => {
                    this.props.history.push('/data')
                }}>收入统计</span>
                <span className='home-btn' onClick={() => {
                    this.props.history.push('/addMovie')
                }}>上架电影</span>
                <span className='home-btn' onClick={() => {
                    this.props.history.push('/search')
                }}>电影搜索</span>
                <span className='home-btn' onClick={() => {
                    this.props.history.push('/delete')
                }}>电影管理</span>

            </div>
        )
    }
}