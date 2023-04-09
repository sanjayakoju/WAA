import React, {useState} from "react";

export const CounterComponent = () => {
    const [val, setVal] = useState(0);

    const counterIncrement1 = () => {
        setVal(val + 1);
    }

    const counterDecrement1 = () => {
        setVal(val - 1);
    }

    const counterIncrement2 = () => {
        setVal(val + 3);
    }

    const counterDecrement2 = () => {
        setVal(val - 3);
    }

    const counterIncrement3 = () => {
        setVal(val + 5);
    }

    const counterDecrement3 = () => {
        setVal(val - 5);
    }

    const counterIncrement4 = () => {
        setVal(val + 8);
    }

    const counterDecrement4 = () => {
        setVal(val - 8);
    }
    return (
        <table>
            <tr>
                <td colSpan="2"><center><h4>{val}</h4></center></td>
            </tr>
            <tr>
                <td>
                    <center><h4>{val}</h4></center>
                </td>
                &nbsp; &nbsp;
                <td>
                    <center><h4>{val}</h4></center>
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
                    <center><h4>{val}</h4></center>
                </td>
                &nbsp; &nbsp;
                <td>
                    <center><h4>{val}</h4></center>
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