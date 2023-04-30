import React, {useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";

export const AddAccount = () => {

    const cleanForm = {
        accountNumber: "",
        accountHolder: ""
    }
    const [accNumberError, setAccNumberError] = useState({})
    const [holderError, setHolderError] = useState({})

    const [account, setAccount] = useState(cleanForm)

    const navigate = useNavigate()

    const onFieldChange = (e) => {
        setAccount({...account, [e.target.name]: e.target.value});
    }

    const onSubmit = (e) => {
        e.preventDefault()
        const isValid = formValidation();
        if(isValid) {
            createAccount(account)
        }
    }

    const createAccount = (account) => {
        const newAcc = axios.post('http://localhost:8080/accounts?'+"accountNumber=" + account.accountNumber +"&accountHolder="+account.accountHolder)
            .then((res) => {
                console.log('Response : ', res.data)
                navigate('/'+account.accountNumber)
            })
    }

    const formValidation = () => {
        const accNoErr = {};
        const holderErr = {};
        let isValid = true;

        if(account.accountNumber.trim().length < 3) {
            accNoErr.accNoShort = "Account number is too short";
            isValid = false;
        }
        if(account.accountHolder.trim().length < 3) {
            holderErr.nameShort = "Holder name is too short";
            isValid = false;
        }

        setAccNumberError(accNoErr);
        setHolderError(holderErr);
        return isValid;

    }


    return (
        <div>
            <h5>New Account Form</h5>
            <form onSubmit={onSubmit}>
                <div>
                    Account Number:
                    <input
                        type='text'
                        name='accountNumber'
                        placeholder='Account Number'
                        value={account.accountNumber}
                        onChange={onFieldChange}
                    />
                    <div>
                        {Object.keys(accNumberError).map((key) => {
                            return <div style={{color: "red"}}>{accNumberError[key]}</div>
                        })}
                    </div>
                </div>
                <div>
                    Account Holder Name:
                    <input
                        type='text'
                        name='accountHolder'
                        placeholder='Account Holder Name'
                        value={account.accountHolder}
                        onChange={onFieldChange}
                    />
                </div>
                <div>
                    {Object.keys(holderError).map((key) => {
                        return <div style={{color: "red"}}>{holderError[key]}</div>
                    })}
                </div>
                <div>
                    <button type="submit">Create Account</button>
                </div>
            </form>
        </div>
    )
}

export default AddAccount