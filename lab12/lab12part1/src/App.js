import './App.css';
import Books from "./pages/books";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import AddBook from "./pages/addBook";

function App() {
    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<Books/>}/>
                    <Route path='addBook' element={<AddBook/>}/>
                </Routes>
            </BrowserRouter>
        </div>

    );
}

export default App;
