import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import BankPage from "./bankPage";
import AccountInfo from "./accountInfo";
import AddAccount from "./addAccount";

export const BankApp = ()=> {

    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<BankPage/>}/>
                    <Route path='/:id' element={<AccountInfo/>}/>
                    <Route path='/addAccount' element={<AddAccount/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    )
}

export default BankApp