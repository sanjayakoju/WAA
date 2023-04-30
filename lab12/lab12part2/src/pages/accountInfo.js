import React, {useEffect, useState} from "react";
import {useLocation} from "react-router-dom";
import axios from "axios";

export const AccountInfo = () => {

    const clearForm = {
        amount: "0.0",
        type: "DEPOSIT"
    }
    const [account, setAccount] = useState("")
    const [transaction, setTransaction] = useState(clearForm);
    const [transactionList, setTransactionList] = useState([]);

    const location = useLocation()

    useEffect(() => {
        let path = location.pathname
        console.log('Path : ', path)
        const accNum = path.replace("\/", "")
        getAccountDetail(accNum)
    }, [])

    const getAccountDetail = (accNumber) => {
        axios.get('http://localhost:8080/accounts/' + accNumber)
            .then((res) => {
                console.log('Reponse : ', res.data)
                setAccount(res.data)
                setTransactionList(res.data.entryList)
            }).catch((err) => {
            console.log("Error ", err)
        })
    }

    const submitTxRequest = (txData) => {
        const url = 'http://localhost:8080/accounts?' + "operation=" + txData.type + "&accountNumber=" + account.accountnumber + "&amount=" + txData.amount;
        const response = axios.post(url)
            .then((response) => {
                console.log('Reponse : ', response.data)
                const data = response.data
                getAccountDetail(account.accountnumber);
            }).catch((err) => {
                console.log('Error : ', err)
            })
    }

    const onTxSubmit = (e) => {
        e.preventDefault();
        submitTxRequest(transaction);
    }

    const onFieldChange = (e) => {
        setTransaction({...transaction, [e.target.name]: e.target.value});
    }

    return (
        <div>
            <div>
                <h5>Account Detail</h5>
                <p>Account Number : {account.accountnumber}</p>
                <p>Name : {account.accountHolder}</p>
                <p>Amount : {account.balance}</p>
                <br/>
                <form onSubmit={onTxSubmit}>
                    <div>
                        Amount :
                        <input
                            type='text'
                            name='amount'
                            placeholder="Amount"
                            value={transaction.amount}
                            onChange={onFieldChange}
                        />
                    </div>
                    <div>
                        Transaction :
                        <select name='transationType'
                                value={transaction.type}
                                onChange={onFieldChange}
                        >
                            <option value="DEPOSIT">Deposit</option>
                            <option value="WITHDRAW">Withdraw</option>
                        </select>
                    </div>
                    <div>
                        <button type="submit">Submit</button>
                    </div>
                </form>
            </div>
            <br/>
            <div>
                <h5>Transaction</h5>
            </div>
            <div>
                <table border="2">
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>Amount</th>
                        <th>Transaction Type</th>
                    </tr>
                    </thead>
                    <tbody>
                    {transactionList.map(t => (
                        <tr key={t.date}>
                            <td>{t.date}</td>
                            <td>{t.amount}</td>
                            <td>{t.description}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default AccountInfo