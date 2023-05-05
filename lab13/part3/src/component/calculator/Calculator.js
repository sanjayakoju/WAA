import React, {useState} from "react";
import {useDispatch, useSelector} from "react-redux";

const Calculator = () => {

    const dispatch = useDispatch();
    const total = useSelector(state => state.calculatorReducer.total)

    const clear = {
        x: "",
        y: "",
        operation: ""
    }
    const [input, setInput] = useState(clear)

    const onFormSubmit = (e) => {
        debugger
        e.preventDefault();
        dispatch({type: input.operation, payload: input});
        setInput(clear);
    }

    const onFIeldChange = (e) => {
        setInput({...input,[e.target.name]: e.target.value});
    }


    return (
        <div>
            <h4>Calculator</h4>
            <form onSubmit={onFormSubmit}>
                <div>
                    Enter Number:
                    <input
                        type="text"
                        name="x"
                        value={input.x}
                        placeholder="Enter Number"
                        onChange={onFIeldChange}
                    />
                </div>
                <div>
                    Enter Number:
                    <input
                        type="text"
                        name="y"
                        value={input.y}
                        placeholder="Enter Number"
                        onChange={onFIeldChange}
                    />
                </div>
                <div>
                    Operation:
                    <select
                        name="operation"
                        type="text"
                        value={input.operation}
                        defaultValue={input.operation}
                        onChange={onFIeldChange}>
                        <option value="">Select Operation</option>
                        <option value="+">+</option>
                        <option value="-">-</option>
                        <option value="*">*</option>
                        <option value="/">/</option>
                    </select>
                </div>
                <div>
                    <button type="submit">Calculate</button>
                </div>
            </form>
            <div>
                <h4>Result : {total}</h4>
            </div>
        </div>
    )
}

export default Calculator;