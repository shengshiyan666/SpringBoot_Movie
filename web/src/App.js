import React, {Component} from 'react';
import {HashRouter as Router, Route} from 'react-router-dom';
import './App.css';

import HomePage from './pages/home/home'
import LoginPage from './pages/login/login'
import AddMovie from './pages/add_movie/index'
import MoneyData from './pages/data/index'
import SearchPage from './pages/search/index'
import DetailPage from './pages/detail/index'
import DeletePage from './pages/delete/index'


class App extends Component {



    render() {
        return (
            <Router>
                <div>
                    <Route exact path="/" component={LoginPage}/>
                    <Route path="/home" component={HomePage}/>
                    <Route path="/login" component={LoginPage}/>
                    <Route path="/addMovie" component={AddMovie}/>
                    <Route path="/data" component={MoneyData}/>
                    <Route path="/search" component={SearchPage}/>
                    <Route path="/detail" component={DetailPage}/>
                    <Route path="/delete" component={DeletePage}/>
                </div>
            </Router>
        )
    }
}

export default App;
