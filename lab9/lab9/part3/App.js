import './App.css';
import React from "react";
import CounterComponent from "./component/CounterComponent";

function App() {

    return (
        <div>
            <header>
                <table>
                    <tr>
                        <td>
                            <CounterComponent num={1} countNum={7}/>
                        </td>
                        &nbsp; &nbsp;
                        <td>
                            <CounterComponent num={3} countNum={-15}/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <CounterComponent num={5} countNum={10}/>
                        </td>
                        &nbsp; &nbsp;
                        <td>
                            <CounterComponent num={8} countNum={48}/>
                        </td>
                    </tr>
                </table>
            </header>
        </div>
    );
}

export default App;
