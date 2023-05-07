import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";

const Calculator = () => {

    const input = {
        num1: "",
        num2: "",
        operator: "+"
    }
    const [calInput, setCalInput] = useState(input);
    const [result, setResult] = useState();
    
    const navigate = useNavigate();

    const onFieldChange = (e) => {
        e.preventDefault()
        setCalInput({ ...calInput, [e.target.name]: e.target.value })
    }

    const onSubmit = (e) => {
        e.preventDefault()
        console.log("Submit Clicked!!")
        e.preventDefault();
        const operator = calInput.operator;
        const num1 = calInput.num1;
        const num2 = calInput.num2;
        switch (operator) {
            case '+':
                setResult(parseFloat(num1) + parseFloat(num2));
                break;
            case '-':
                setResult(parseFloat(num1) - parseFloat(num2));
                break;
            case '*':
                setResult(parseFloat(num1) * parseFloat(num2));
                break;
            case '/':
                setResult(parseFloat(num1) / parseFloat(num2));
                break;
            default:
                setResult('');
        }
    }

    useEffect(() => {
        if (result) {
            navigate('/result', {state: result});
        }
    }, [result, navigate]);

    return (
        <div>
            <h3>Calculator</h3>
            <form onSubmit={onSubmit}>
                <div>
                    Input 1 :
                    <input
                        type="number"
                        name="num1"
                        value={calInput.num1}
                        placeholder="Enter Number"
                        onChange={onFieldChange}
                    />
                </div>
                <div>
                    Input 2 :
                    <input
                        type="number"
                        name="num2"
                        value={calInput.num2}
                        placeholder="Enter Number"
                        onChange={onFieldChange}
                    />
                </div>
                <div>
                    Operator :
                    <select
                        name="operator"
                        value={calInput.operator}
                        onChange={onFieldChange}>
                        <option value="+">+</option>
                        <option value="-">-</option>
                        <option value="*">*</option>
                        <option value="/">/</option>
                    </select>
                </div>
                <div>
                    <button name="Calculate" type="submit">Calculate</button>
                </div>
            </form>
        </div>
    )
}

export default Calculator