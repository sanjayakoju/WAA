import React, {useState} from "react";
import {useLocation, useNavigate} from "react-router-dom";

export const Page2 = () => {

    const [street, setStreet] = useState("");
    const [city, setCity] = useState("");
    const [zip, setZip] = useState("");
    const [state, setState] = useState("Iowa");

    const location = useLocation();
    const firstName = location.state.userDetail.firstName
    const lastName = location.state.userDetail.lastName
    const profession = location.state.userDetail.profession

    const userDetail = {
        firstName: firstName,
        lastName: lastName,
        profession: profession,
        street: street,
        city: city,
        zip: zip,
        state: state
    }

    const navigate = useNavigate();

    const goToNext = () => {
        navigate('/pagethree', {state: {userDetail: userDetail}});
    }

    let form = (
        <>
            <h3>Page 2</h3>
            <h3>User Detail from Page 1</h3>
            <div>Fist Name : {firstName}</div>
            <div>Last Name : {lastName}</div>
            <div>Profession : {profession}</div>
            <form>
                <div>
                    Street :
                    <input
                        type="text"
                        placeholder="Street"
                        value={street}
                        onChange={e => setStreet(e.target.value)}
                    />
                </div>
                <div>
                    City :
                    <input
                        type="text"
                        placeholder="City"
                        value={city}
                        onChange={e => setCity(e.target.value)}
                    />
                </div>
                <div>
                    Zip :
                    <input
                        type="text"
                        placeholder="Zip"
                        value={zip}
                        onChange={e => setZip(e.target.value)}
                    />
                </div>
                <div>
                    <label>State</label>
                    <select
                        type="text"
                        value={state}
                        onChange={e => setState(e.target.value)}
                    >
                        <option>Iowa</option>
                        <option>California</option>
                        <option>Washington</option>
                        <option>Texas</option>
                    </select>
                </div>
                <div>
                    <button onClick={goToNext}>Next</button>
                </div>
            </form>
        </>
    );

    return form;

}

export default Page2;