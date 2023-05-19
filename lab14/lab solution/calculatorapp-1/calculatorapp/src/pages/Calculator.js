import React, { useState } from 'react';
import './Calculator.css'

export const Calculator = (props) => {
    const [first, setFirst] = useState(0);
    const [second, setSecond] = useState(0);

    const add = () => {
        let result = parseInt(first) + parseInt(second);
        props.history.push("/result", { result: result });
    }
    const subtract = () => {
        let result = parseInt(first) - parseInt(second);
        props.history.push("/result", { result: result });
    }
    const multiply = () => {
        let result = parseInt(first) * parseInt(second);
        props.history.push("/result", { result: result });
    }

    let calcpage = (
        <form>
            <h3>Calculator</h3>
            <table class="center">
                <tr>
                    <td>First number</td>
                    <td><input
                        id="first"
                        type="text"
                        name="first"
                        value={first}
                        onChange={e => setFirst(e.target.value)} /></td>
                </tr>
                <tr>
                    <td>Second number</td>
                    <td><input
                        id="second"
                        type="text"
                        name="second"
                        value={second}
                        onChange={e => setSecond(e.target.value)} /></td>
                </tr>
                <tr>
                    <td><button id="add" onClick={add}>+</button></td>
                    <td><button id="subtract" onClick={subtract}>-</button></td>
                    <td><button id="multiply" onClick={multiply}>*</button></td>
                </tr>
            </table>
        </form>
    );
    return calcpage;
}