import React from "react";
import {useLocation} from "react-router-dom";

export const Page4 = () => {

    const location = useLocation();

    const firstName = location.state.userDetail.firstName
    const lastName = location.state.userDetail.lastName
    const profession = location.state.userDetail.profession
    const street = location.state.userDetail.street
    const city = location.state.userDetail.city
    const zip = location.state.userDetail.zip
    const state = location.state.userDetail.state
    const creditCardNumber = location.state.userDetail.creditCardNumber
    const type = location.state.userDetail.type

    return (
        <>
            <h3>Page 4</h3>
            <h3>User Detail from Page 3</h3>
            <div>Fist Name : {firstName}</div>
            <div>Last Name : {lastName}</div>
            <div>Profession : {profession}</div>
            <div>Street : {street}</div>
            <div>City : {city}</div>
            <div>Zip : {zip}</div>
            <div>State : {state}</div>
            <div>Credit Card Number : {creditCardNumber}</div>
            <div>Type : {type}</div>
        </>
    );
}

export default Page4;