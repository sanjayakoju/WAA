import './App.css';
import Todo from "./component/todo/Todo";
import Calculator from "./component/calculator/Calculator";

function App() {
    return (
        <div className="container">
            <div>
                <Todo/>
                <Calculator/>
            </div>
        </div>
    );
}

export default App;
