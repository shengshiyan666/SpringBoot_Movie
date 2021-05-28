import React, {Component} from 'react';
import './style.css'
import Api from "../../api/api";

export default class Index extends Component {


    constructor(props) {
        super(props)

        this.state = {
            result: null,
            movieGroup: []
        }
    }

    componentDidMount() {
        this.getData()
    }

    async getData() {
        let result = await Api.getThisWeekMoney()
        this.setState({
            result: result,
            movieGroup: result.movieGroup
        })

    }


    render() {
        let {result, movieGroup} = this.state

        return (
            <div id='data-root'>

                <span className='data-item'>总收入：{result == null ? 0 : result.totalMoney}元</span>
                <span className='data-item'>本周收入：{result == null ? 0 : result.thisWeekMoney}元</span>
                <span className='data-item'>详细电影销售额：</span>
                {
                    (movieGroup || []).map((item, index) => {
                        return <span className='data-item'>{item[0].movieName}:售出{this.getThisMovieMoney(item)}元</span>
                    })
                }
            </div>
        )
    }

    getThisMovieMoney(item) {

        let money = 0.0;
        for (let i = 0; i < item.length; i++) {
            let temp = item[i];
            money += temp.sellCount * temp.ticketMoney
        }
        return money;
    }
}