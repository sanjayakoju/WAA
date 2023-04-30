import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import axios from "axios";

export const BankPage = () => {

    const [accountNumber, setAccountNumber] = useState();
    const [account, setAccount] = useState();


    const navigate = useNavigate();

    const createNewAccount = () => {
        navigate('addAccount')
    }

    const findAccount = () => {
        console.log('Acc No : ',accountNumber)
        navigate('/' + accountNumber)
    }

    return (
        <div>
            <h5>Search Account Detail</h5>
            <form onSubmit={findAccount}>
                <div>
                    Account Number :
                    <input
                        type='text'
                        name='accountNumber'
                        placeholder='Account Number'
                        value={accountNumber}
                        onChange={(e) => setAccountNumber(e.target.value)}
                    />
                </div>
                <div>
                    <button type="submit">Find Account</button>
                </div>
            </form>
            <br/>
            <button onClick={createNewAccount}>Create New Account</button>
        </div>
    )
}

export default BankPage