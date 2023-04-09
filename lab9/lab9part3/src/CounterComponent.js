import React, {useState} from "react";

export const CounterComponent = () => {

    const [val1, setVal1] = useState(0);
    const [val2, setVal2] = useState(0);
    const [val3, setVal3] = useState(0);
    const [val4, setVal4] = useState(0);

    const counterIncrement1 = () => {
        setVal1(val1 + 1);
    }

    const counterDecrement1 = () => {
        setVal1(val1 - 1);
    }

    const counterIncrement2 = () => {
        setVal2(val2 + 3);
    }

    const counterDecrement2 = () => {
        setVal2(val2 - 3);
    }

    const counterIncrement3 = () => {
        setVal3(val3 + 5);
    }

    const counterDecrement3 = () => {
        setVal3(val3 - 5);
    }

    const counterIncrement4 = () => {
        setVal4(val4 + 8);
    }

    const counterDecrement4 = () => {
        setVal4(val4 - 8);
    }
    return (
        <table>
            <tr>
                <td>
                    <center><h4>{val1}</h4></center>
                </td>
                &nbsp; &nbsp;
                <td>
                    <center><h4>{val2}</h4></center>
                </td>
            </tr>
            <tr>
                <td>
                    <button onClick={counterIncrement1}>+1</button>
                    &nbsp;
                    <button onClick={counterDecrement1}>-1</button>
                </td>
                &nbsp; &nbsp;
                <td>
                    <button onClick={counterIncrement2}>+3</button>
                    &nbsp;
                    <button onClick={counterDecrement2}>-3</button>
                </td>
            </tr>

            <tr>
                <td>
                    <center><h4>{val3}</h4></center>
                </td>
                &nbsp; &nbsp;
                <td>
                    <center><h4>{val4}</h4></center>
                </td>
            </tr>
            <tr>
                <td>
                    <button onClick={counterIncrement3}>+5</button>
                    &nbsp;
                    <button onClick={counterDecrement4}>-5</button>
                </td>
                &nbsp; &nbsp;
                <td>
                    <button onClick={counterIncrement4}>+8</button>
                    &nbsp;
                    <button onClick={counterDecrement4}>-8</button>
                </td>
            </tr>
        </table>
    );
}


export default CounterComponent;
