import React, {useState} from "react";
import {useLocation, useNavigate} from "react-router-dom";

export const Page3 = () => {
    const [creditCardNumber, setCreditCardNumber] = useState("");
    const [type, setType] = useState("");

    const navigate = useNavigate();
    const location = useLocation();

    const firstName = location.state.userDetail.firstName
    const lastName = location.state.userDetail.lastName
    const profession = location.state.userDetail.profession
    const street = location.state.userDetail.street
    const city = location.state.userDetail.city
    const zip = location.state.userDetail.zip
    const state = location.state.userDetail.state

    const userDetail = {
        firstName: firstName,
        lastName: lastName,
        profession: profession,
        street: street,
        city: city,
        zip: zip,
        state: state,
        creditCardNumber: creditCardNumber,
        type: type
    }

    const goToNext = () => {
        navigate('/pagefour', {state: {userDetail: userDetail}});
    }

    let form = (
        <>
            <h3>Page 3</h3>
            <h3>User Detail from Page 2</h3>
            <div>Fist Name : {firstName}</div>
            <div>Last Name : {lastName}</div>
            <div>Profession : {profession}</div>
            <div>Street : {street}</div>
            <div>City : {city}</div>
            <div>Zip : {zip}</div>
            <div>State : {state}</div>
            <form>
                <div>
                    Credit Card Number :
                    <input
                        type="text"
                        placeholder="Credit Card Number"
                        value={creditCardNumber}
                        onChange={e => setCreditCardNumber(e.target.value)}
                    />
                </div>
                <div>
                    Type :
                   <input
                       type="radio"
                       value="Visa"
                       checked={type === "Visa"}
                       onChange={e => setType(e.target.value)}
                   />
                    Visa
                    <input
                        type="radio"
                        value="Mastercard"
                        checked={type === "Mastercard"}
                        onChange={e => setType(e.target.value)}
                    />
                    Mastercard
                </div>
                <div>
                    <button onClick={goToNext}>Next</button>
                </div>
            </form>
        </>
    );
    return form;
}
export default Page3;