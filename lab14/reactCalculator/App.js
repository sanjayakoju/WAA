import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Calculator from "./page/calculator";
import React from "react";
import Result from "./page/result";

function App() {
    return (
        <div className="container">
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Calculator/>}/>
                    <Route path="result" element={<Result/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
