import React, {useState} from "react";
import {useNavigate} from "react-router-dom";

export const Page1 = () => {

    const [first, setFirst] = useState("");
    const [last, setLast] = useState("");
    const [profession, setProfession] = useState("Programmer");

    const navigate = useNavigate();

    const userDetail = {
        firstName : first,
        lastName : last,
        profession : profession
    }

    const goToNext = () => {
        navigate('/pagetwo', {state: {userDetail: userDetail}});
    }

    let form = (
        <>
            <h3>page 1</h3>
            <form>
                <h3>Enter your information</h3>
                <div>
                    <label>First Name : </label>
                    <input
                        type="text"
                        placeholder="First"
                        value={first}
                        onChange={e => setFirst(e.target.value)}
                    />
                </div>
                <div>
                    <label>Last Name :</label>
                    <input
                        type="text"
                        placeholder="Last"
                        value={last}
                        onChange={e => setLast(e.target.value)}
                    />
                </div>
                <div>
                    <label>Profession</label>
                    <select
                        type="text"
                        value={profession}
                        onChange={e => setProfession(e.target.value)}
                    >
                        <option>Programmer</option>
                        <option>Manager</option>
                        <option>Tester</option>
                        <option>Architect</option>
                    </select>
                </div>
                <div>
                    <button onClick={goToNext}>Next</button>
                </div>
            </form>
        </>

    );

    return form;


    // const [name, setName] = myFunc("");
    //
    // function myFunc(initalValue) {
    //     let state = initalValue;
    //     const fun = function (newValue) {
    //         if(state !== newValue) {
    //             // rerender that part
    //
    //         }
    //         state = newValue;
    //
    //     }
    //     return {state, fun};
    // }
    //
    // setName("Sanjaya")

}

export default Page1;