import React, {Component} from 'react';
import './style.css'
import Api from "../../api/api";
import {Toast} from 'antd-mobile'

export default class Home extends Component {


    constructor(props) {
        super(props)
        this.state = {}
    }


    async handleLoginClick() {
        var userName = document.getElementById('username').value
        var passWord = document.getElementById('passWord').value


        if (userName.length < 1 || passWord.length < 1) {
            Toast.fail('请输入登录信息...')
        } else {
            if (userName == "admin" && passWord == "admin") {
                Toast.loading('登陆中..', 1, () => {
                    this.props.history.replace('/home')
                });
            } else {
                Toast.fail('无权限登录...')
            }
        }

    }

    render() {

        return (
            <div id='login-root'>

                <div id='et-user-name'>
                    <span id='input-title-text'>账号</span>
                    <input id='username' placeholder='请输入账号' type='text'/>
                </div>

                <div id='et-password'>
                    <span id='input-title-text'>密码</span>
                    <input id='passWord' placeholder='请输入密码' type="password"/>
                </div>

                <span id='btn-login' onClick={() => this.handleLoginClick()}>登 录</span>

            </div>
        )
    }
}